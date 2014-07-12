
package br.com.testeproject.util;

import java.security.MessageDigest;

public class EncryptationUtil {

    public static String encrypt(String str) {
        try{
            if( str == null || str.equals("") ) {
                return "";
            }

            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] hash = md.digest(str.getBytes());

            StringBuilder sb = new StringBuilder();

            for(int i = 0 ; i < hash.length ; i++) {
                String tmp = "0" + Integer.toHexString((0xff & hash[i]));
                sb.append(tmp.substring(tmp.length() - 2));
            }

            return sb.toString();
        }
        catch (Exception e){
            throw new RuntimeException(e.getMessage(), e);
        }
    }

}
