package com.kddyzn.wenju.util;

import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Component
public class HmacSha1Util {

    private static final String ENCODING = "UTF-8";
    private static final String HMACSHA1 = "HmacSHA1";
    private static final String SECRETKEY = "3.1415926fuckyourmotheronthetree";
    private static final long EXPIRE_TIME = 1000 * 60 * 60;

    /**
     * 生成用户ID的TOKEN
     * @param userId
     * @return
     * @throws UnsupportedEncodingException
     */
    public String encryptUserId(String userId) throws UnsupportedEncodingException {
        String timestamp = Long.toString(System.currentTimeMillis() + EXPIRE_TIME);
        String nonce = RandomUtil.generateRandomString(16);
        String data = userId + timestamp + nonce;
        String sign = encrypt(data);
        return URLEncoder.encode(userId + "|" + timestamp + "|" + nonce + "|" + sign, "utf-8");
    }

    /**
     * 用户密码加密
     * @param passwordSalt
     * @param password
     * @return
     */
    public String encryptPassword(String passwordSalt, String password) {
        return encrypt(passwordSalt + password);
    }

    /**
     * hmacSHA1
     *
     * @param encryptText 待hash文本
     * @return 40字节hash字符串
     */
    private String encrypt(String encryptText) {

        try {
            SecretKeySpec signingKey = new SecretKeySpec(SECRETKEY.getBytes(ENCODING), HMACSHA1);
            Mac hmacSHA1 = Mac.getInstance(HMACSHA1);
            hmacSHA1.init(signingKey);
            return Hex.encodeHexString(hmacSHA1.doFinal(encryptText.getBytes(ENCODING)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
