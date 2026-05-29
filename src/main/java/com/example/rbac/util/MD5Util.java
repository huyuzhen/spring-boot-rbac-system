package com.example.rbac.util;

import java.security.MessageDigest;

/**
 * MD5 Encryption Utility
 */
public class MD5Util {

    private static final String SALT = "rbac_system_salt_2024";

    public static String encrypt(String input) {
        return encrypt(input, SALT);
    }

    public static String encrypt(String input, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest((input + salt).getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException("MD5 encryption failed", e);
        }
    }

    public static boolean verify(String input, String encrypted) {
        return encrypt(input).equals(encrypted);
    }
}
