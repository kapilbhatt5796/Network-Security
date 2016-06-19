/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.security.*;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;

public class JavaDESEncryption {
 

    private static Cipher encrypt;

    private static Cipher decrypt;

 

    private static final byte[] initialization_vector = { 22, 33, 11, 44, 55, 99, 66, 77 };

public static boolean start(String clearFile,String encryptedFile,String decryptedFile) {

        /*String clearFile = DESEncryptFrame.getPf();
        String encryptedFile = DESEncryptFrame.getEf();
        String decryptedFile = JavaDESDecryption.getDf();*/
        try {
            SecretKey secret_key = KeyGenerator.getInstance("DES").generateKey();
            AlgorithmParameterSpec alogrithm_specs = new IvParameterSpec(initialization_vector);
            // set encryption mode ...
            encrypt = Cipher.getInstance("DES/CBC/PKCS5Padding");
           encrypt.init(Cipher.ENCRYPT_MODE, secret_key, alogrithm_specs);
            // set decryption mode
            decrypt = Cipher.getInstance("DES/CBC/PKCS5Padding");
            decrypt.init(Cipher.DECRYPT_MODE, secret_key, alogrithm_specs);
            // encrypt file
            if(encryptedFile.compareTo(" ") != 0)
                encrypt(new FileInputStream(clearFile), new FileOutputStream(encryptedFile));
            // decrypt file
            if(decryptedFile.compareTo(" ") != 0)
                decrypt(new FileInputStream(encryptedFile), new FileOutputStream(decryptedFile));
            System.out.println("End of Encryption/Decryption procedure!");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException
                | InvalidKeyException | InvalidAlgorithmParameterException
                | IOException e) {
      return false;
        }
    }
 

    private static void encrypt(InputStream input, OutputStream output)

            throws IOException {

 

        output = new CipherOutputStream(output, encrypt);

        writeBytes(input, output);

    }

 

    private static void decrypt(InputStream input, OutputStream output)

            throws IOException {

 

        input = new CipherInputStream(input, decrypt);

        writeBytes(input, output);

    }

 

    private static void writeBytes(InputStream input, OutputStream output)

            throws IOException {

        byte[] writeBuffer = new byte[512];

        int readBytes = 0;

 

        while ((readBytes = input.read(writeBuffer)) >= 0) {

            output.write(writeBuffer, 0, readBytes);

        }

 

        output.close();

        input.close();

    }

 

}
