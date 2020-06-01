package _tgsKSJ;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import java.util.Scanner;

public class TripleDES {
	
    String key;

    public TripleDES(String myEncryptionKey) {
        key = myEncryptionKey;
        System.out.print("Masukkan string: ");
        Scanner input = new Scanner(System.in);
        String naise = input.nextLine();
        input.close();
        try {
        	System.out.println("Hasil Enkripsi: "+harden(naise));
        	System.out.println("Hasil Dekripsi: "+soften(harden(naise)));
        }catch(Exception e) {
        	
        }
    }
    
    public String harden(String unencryptedString) throws NoSuchAlgorithmException, UnsupportedEncodingException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        MessageDigest md = MessageDigest.getInstance("md5");
        byte[] digestOfPassword = md.digest(key.getBytes("utf-8"));
        byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

        for (int j = 0, k = 16; j < 8;) {
            keyBytes[k++] = keyBytes[j++];
        }

        SecretKey secretKey = new SecretKeySpec(keyBytes, "DESede");
        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] plainTextBytes = unencryptedString.getBytes("utf-8");
        byte[] buf = cipher.doFinal(plainTextBytes);
        byte[] base64Bytes = Base64.encodeBase64(buf);
        String base64EncryptedString = new String(base64Bytes);

        return base64EncryptedString;
    }
    
    public String soften(String encryptedString) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        if(encryptedString == null)
        {
            return "";
        }
        byte[] message = Base64.decodeBase64(encryptedString.getBytes("utf-8"));

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digestOfPassword = md.digest(key.getBytes("utf-8"));
        byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
        
        for (int j = 0, k = 16; j < 8;) {
            keyBytes[k++] = keyBytes[j++];
        }
        
        SecretKey secretKey = new SecretKeySpec(keyBytes, "DESede");

        Cipher decipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        decipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] plainText = decipher.doFinal(message);

        return new String(plainText, "UTF-8");
    }
    
    public static void main(String[] args) {
    	TripleDES tes = new TripleDES("inikuncinya");
    	System.out.println("Kunci kamu: "+tes.key);
    }
}