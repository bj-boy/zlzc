package com.zlzc.common.utils;


import javax.xml.stream.events.StartDocument;
import java.beans.Encoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Random;

/**
 * 订单 商品 快递 编码码生成器，生成32位数字编码，
 *
 * @author jiwengjian
 * @生成规则 1位单号类型+17位时间戳+14位(用户id加密&随机数)
 * Date:2017年9月8日上午10:05:19
 */
public class CodeFactory {

    /**
     * 订单类别头
     */
    private static final String ORDER_CODE = "DD";
    /**
     * 退货类别头
     */
    private static final String RETURN_ORDER = "TH";
    /**
     * 退款类别头
     */
    private static final String REFUND_ORDER = "TK";
    /**
     * 未付款重新支付别头
     */
    private static final String AGAIN_ORDER = "WZF";
    /**
     * 商品编号
     */
    private static final String COMMDITY_CODE ="HP";
    /**
     * 物流编号
     */
    private static final String  LOGISTICS_CODE  ="WL";
    /**
     * 随即编码
     */
    private static final int[] r = new int[]{7, 9, 6, 2, 8, 1, 3, 0, 5, 4};
    /**
     * 用户id和随机数总长度
     */
    private static final int maxLength = 14;

    /**
     * 更具id进行加密+加随机数组成固定长度编码
     *      
     */
    private  String toCode(Long id) {
        String idStr = id.toString();
        StringBuilder idsbs = new StringBuilder();
        for (int i = idStr.length() - 1; i >= 0; i--) {
            idsbs.append(r[idStr.charAt(i) - '0']);
        }
        return idsbs.append(getRandom(maxLength - idStr.length())).toString();
    }

    /**
     * 生成时间戳
     *      
     */
    private  String getDateTime() {
        DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(new Date());
    }

    /**
     * 生成固定长度随机码
     * @param n    长度
     *      
     */
    private  long getRandom(long n) {
        long min = 1, max = 9;
        for (int i = 1; i < n; i++) {
            min *= 10;
            max *= 10;
        }
        long rangeLong = (((long) (new Random().nextDouble() * (max - min)))) + min;
        return rangeLong;
    }

    /**
     *      * 生成不带类别标头的编码
     *      * @param userId
     *      
     */
    private  synchronized String getCode(Long userId) {
        userId = userId == null ? 10000 : userId;
        return getDateTime() + toCode(userId);
    }


    /**
     *      * 生成商品编号
     *      * @param userId
     *      
     */
    public  String getCommdityCode(Long userId) {
        synchronized(this) {
            return COMMDITY_CODE + getCode(userId);
        }
    }

    /**
     *      * 生成物流编号
     *      * @param userId
     *      
     */
    public  String getLogisticsCode(Long userId) {
        synchronized(this) {
            return LOGISTICS_CODE + getCode(userId);
        }
    }

    /**
     * 生成订单单号编码
     *  @param userId
     *      
     */
    public  String getOrderCode(Long userId) {
         synchronized(this){
            return ORDER_CODE + getCode(userId);
        }
    }

    /**
     *      * 生成退货单号编码
     *      * @param userId
     *      
     */
    public  String getReturnCode(Long userId) {
        synchronized(this) {
            return RETURN_ORDER + getCode(userId);
        }
    }


    /**
     *      * 生成退款单号编码
     *      * @param userId
     *      
     */
    public  String getRefundCode(Long userId) {
        synchronized(this) {
            return REFUND_ORDER + getCode(userId);
        }
    }

    /**
     *      * 未付款重新支付
     *      * @param userId
     *      
     */
    public  String getAgainCode(Long userId) {
        synchronized(this) {
            return AGAIN_ORDER + getCode(userId);
        }
    }


}



