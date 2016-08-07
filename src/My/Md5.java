package My;

import java.security.MessageDigest;

public class Md5 {


    public static void main(String[] args) throws Exception {
        System.out.println(createMd5("horoshilov"));
    }


    public static String createMd5(String st) {
        try{MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(st.getBytes());
        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
            return sb.toString();
        }catch (Exception e){}
        return null;
    }
}
