package com.zlzc.modules.upload;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.util.Pair;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zlzc.common.annotation.RespTime;
import com.zlzc.common.utils.FileUpload;
import com.zlzc.common.utils.Result;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "后台-文件上传", tags = { "V1.0 upload：后台-文件上传操作相关接口" })
@RestController
public class UploadController {

	@RespTime("/uploadPic")
	@ApiOperation(value = "upload-1 上传图片")
	@PostMapping("/uploadPic")
	public Result uploadPic(@ApiParam(value = "文件") @RequestParam(value = "files") MultipartFile[] files, Model model,
			HttpServletRequest request) {
		//@formatter:off
		// 上传图片
		Pair<List<File>, List<MultipartFile>> rs = FileUpload.webFileUploader(files, FileUpload.UP_PATH + "/pic");
		if (rs == null) {
			return Result.error(-1, "文件上传失败，请联系后台管理员。");
		}
		
		List<File> successUpPics = rs.getFirst();
		List<String> successPicPath = new ArrayList<>();
		for (File file : successUpPics) {
			successPicPath.add("/zlzc_file/pic/" + file.getName());
		}
		
		return Result.ok()
				.put("code", 1)
				.put("msg", "图片上传成功")
				.put("rs", successPicPath);
		//@formatter:on
	}

}
