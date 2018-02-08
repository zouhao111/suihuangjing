package com.erich.easyframe.util;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {

    private static byte[] getBytesUtf8(String hashMe) {
        return StringUtils.getBytesUtf8(hashMe);
    }

    public static String getMD5String(String value) {
        if (org.apache.commons.lang.StringUtils.isBlank(value))
            return null;
        else
            return DigestUtils.md5Hex(getBytesUtf8(value));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        MD5Util md5Util = new MD5Util();
        // e10adc3949ba59abbe56e057f20f883e
        System.out.println(md5Util.getMD5String("123456"));
    }
}