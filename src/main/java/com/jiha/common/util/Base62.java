package com.jiha.common.util;

public class Base62 {
    /**
     * Base62 Character Table
     */
    static final char[] BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /**
     * long -> String(62진법)
     *
     * @param value 변환 대상
     */
    public static String encode(long value) {
        final StringBuilder sb = new StringBuilder();
        do {
            int i = (int)(value % 62);
            sb.append(BASE62[i]);
            value /= 62;
        } while (value > 0);
        if(sb.length() > 8) try {
            throw new Exception("Shortening Key 생성 오류입니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * String(62진법) -> long
     * @param value 변환대상
     */
    public static long decode(String value) {
        long result = 0;
        long power = 1;
        for (int i = 0; i < value.length(); i++) {
            int digit = new String(BASE62).indexOf(value.charAt(i));
            result += digit * power;
            power *= 62;
        }
        return result;
    }

}
