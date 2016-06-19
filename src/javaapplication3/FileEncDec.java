package javaapplication3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
//import java.io.File;
//import java.io.*;
//import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class FileEncDec {


    //private int check;
    
    public String startEnc(String a, String b, String key) {
		try {
                        System.out.println(a);
                        System.out.println(b);
                        System.out.println(key);
			//String key = "squirrel123"; // needs to be at least 8 characters for DES
                        //Scanner in = new Scanner(System.in);
                        //System.out.println("Enter the path of the file with plain text :");
                        //String f1 =in.nextLine();
                        //File file1 = new File(a);
			FileInputStream fis = new FileInputStream(a);
                        //System.out.println("Enter the path of the encrypted file :");
                        //String f2 =in.nextLine();
                        //File file2 = new File(b);
			FileOutputStream fos = new FileOutputStream(b);
			encrypt(key, fis, fos);
                        //System.out.println("Enter the path of the file to be decrypted :");
                        //String f3 =in.nextLine();
                        //File file3 = new File(c);
			//FileInputStream fis2 = new FileInputStream(file2);
			//FileOutputStream fos2 = new FileOutputStream(file3);
			//decrypt(key, fis2, fos2);
		} catch (Throwable e) {
                    return "Error while encrypting";                        
		}
            return "File Encrypted";
                
	}
        
	public String startDec(String a, String b, String key) {
		try {
			System.out.println(a);
                        System.out.println(b);
                        System.out.println(key);
                        //String key = "squirrel123"; // needs to be at least 8 characters for DES
                        //Scanner in = new Scanner(System.in);
                        //System.out.println("Enter the path of the file with plain text :");
                        //String f1 =in.nextLine();
                        //File file1 = new File(a);
			//FileInputStream fis = new FileInputStream(file1);
                        //System.out.println("Enter the path of the encrypted file :");
                        //String f2 =in.nextLine();
                        //File file2 = new File(a);
			//FileOutputStream fos = new FileOutputStream(a);
			//encrypt(key, fis, fos);
                        //System.out.println("Enter the path of the file to be decrypted :");
                        //String f3 =in.nextLine();
                        //File file3 = new File(b);
			FileInputStream fis2 = new FileInputStream(a);
			FileOutputStream fos2 = new FileOutputStream(b);
			decrypt(key, fis2, fos2);
		} catch (Throwable e){
                        return "Error while decrypting";
		}
            return "File Decrypted";
	}
        
        
        public static void encrypt(String key, InputStream is, OutputStream os) throws Throwable {
		encryptOrDecrypt(key, Cipher.ENCRYPT_MODE, is, os);
	}

	public static void decrypt(String key, InputStream is, OutputStream os) throws Throwable {
		encryptOrDecrypt(key, Cipher.DECRYPT_MODE, is, os);
	}

	public static void encryptOrDecrypt(String key, int mode, InputStream is, OutputStream os) throws Throwable {

		DESKeySpec dks = new DESKeySpec(key.getBytes());
		SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
		SecretKey desKey = skf.generateSecret(dks);
		Cipher cipher = Cipher.getInstance("DES"); 

		if (mode == Cipher.ENCRYPT_MODE) {
			cipher.init(Cipher.ENCRYPT_MODE, desKey);
			CipherInputStream cis = new CipherInputStream(is, cipher);
			doCopy(cis, os);
		} else if (mode == Cipher.DECRYPT_MODE) {
			cipher.init(Cipher.DECRYPT_MODE, desKey);
			CipherOutputStream cos = new CipherOutputStream(os, cipher);
			doCopy(is, cos);
		}
	}

        
	public static void doCopy(InputStream is, OutputStream os) throws IOException {
		byte[] bytes = new byte[64];
		int numBytes;
		while ((numBytes = is.read(bytes)) != -1) {
			os.write(bytes, 0, numBytes);
		}
		os.flush();
		os.close();
		is.close();
	}
}