package com.zlzc.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.Pair;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class FileUpload {

	public final static String UP_PATH = "F:/zlzc-up/";

	/**
	 * 小文件上传(可批量)
	 */
	@SuppressWarnings("unused")
	public static Pair<List<File>, List<MultipartFile>> webFileUploader(MultipartFile[] files, String filePath) {
		// 失败文件列表
		List<MultipartFile> failureUpList = new ArrayList<>();
		// 预备上传列表
		List<Pair<MultipartFile, File>> preUpList = new ArrayList<>();
		// 上传成功文件列表
		List<File> successUpList = new ArrayList<>();
		// 判断文件是否为空
		if (Objects.isNull(files) || files.length < 1) {
			log.error("=========> 上传文件列表为空。");
			return null;
		}
		// 上传路径是否以 / 结尾
		filePath = filePath.endsWith("/") ? filePath : (filePath + "/");
		// 遍历要上传文件
		for (MultipartFile file : files) {
			if (file.isEmpty()) {
				failureUpList.add(file);
				log.error("=========> 上传文件【" + file.getOriginalFilename() + "】为空。");
				continue;
			}
			String fileName = file.getOriginalFilename(); // 文件名
			String suffixName = fileName.substring(fileName.lastIndexOf(".")); // 后缀名
			File dest = new File(filePath + fileName); // 上传路径
			preUpList.add(Pair.<MultipartFile, File>of(file, dest));
		}
		// 上传
		for (Pair<MultipartFile, File> pair : preUpList) {
			MultipartFile file = pair.getFirst();
			File dest = pair.getSecond();
			// 判断文件父目录是否存在
			if (!dest.getParentFile().exists()) {
				dest.getParentFile().mkdirs();
			}
			// 判断目标文件是否存在
			if (dest.exists()) {
				failureUpList.add(file);
				log.error("=========> 上传文件已经存在。");
				continue;
			}
			// 执行文件上传。
			try {
				file.transferTo(dest);
				successUpList.add(dest);
			} catch (IOException e) {
				e.printStackTrace();
				log.error("=========> 上传文件【" + file.getOriginalFilename() + "】失败: " + e.getMessage());
				failureUpList.add(file);
			}
		}
		return Pair.<List<File>, List<MultipartFile>>of(successUpList, failureUpList);
	}

}
