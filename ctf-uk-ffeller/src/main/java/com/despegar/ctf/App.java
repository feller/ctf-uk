package com.despegar.ctf;

import java.nio.charset.Charset;

/**
 * Hello world!
 *
 */
public class App 
{
    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static void main( String[] args )
    {
        String op1 = args[0];
        String op2 = args[1];
        byte[] op1b = hexStringToByteArray(op1);
        byte[] op2b = hexStringToByteArray(op2);
        byte[] result = new byte[op1b.length];
        for (int i = 0; i < op1b.length; i ++) {
            result[i] = (byte) (op1b[i] ^ op2b[i]);
        }

        String resultStr = bytesToHex(result);
        System.out.println(resultStr);

    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}
