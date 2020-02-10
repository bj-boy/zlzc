package com.zlzc.modules.randomNumber;

import java.security.SecureRandom;
import java.util.Random;

/**
 * 功能描述:
 *
 * @ProjectName: shop-platform
 * @Package: com.zlzc.modules.randomNumber
 * @ClassName: GenerateRandomNumber
 * @Author: LBB
 * @E-mail: biaobiao999@163.com
 * @Date: 2020/1/17 14:08
 * @Version: 1.0
 */
public class GenerateRandomNumber {
    /**
     * 生成16位不重复的随机数，含数字+大小写
     *
     * @return
     */
    public static String getGUID() {
        StringBuilder uid = new StringBuilder();
        //产生16位的强随机数
        Random rd = new SecureRandom();
        for (int i = 0; i < 16; i++) {
            //产生0-2的3位随机数
            int type = rd.nextInt(3);
            switch (type) {
                case 0:
                    //0-9的随机数
                    uid.append(rd.nextInt(10));
                    break;
                case 1:
                    //ASCII在65-90之间为大写,获取大写随机
                    uid.append((char) (rd.nextInt(25) + 65));
                    break;
                case 2:
                    //ASCII在97-122之间为小写，获取小写随机
                    uid.append((char) (rd.nextInt(25) + 97));
                    break;
                default:
                    break;
            }
        }
        return uid.toString();
    }
}
