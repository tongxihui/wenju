package com.kddyzn.wenju.util;

import java.util.Random;

public class RandomUtil {

    /**
     * 生成随机字符串
     * @param size
     * @return
     */
    public static String generateRandomString(int size) {
        String originString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < size; i++) {
            stringBuffer.append(originString.charAt(random.nextInt(62)));
        }
        return stringBuffer.toString();
    }
}
