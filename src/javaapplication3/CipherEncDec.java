/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.util.Scanner;


/**
 *
 * @author kapil bhatt
 */
public class CipherEncDec {
    
    public static String ceaserdec(String cipher , int shift)
    {
        /*int shift;
	String cipher;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the text to be decrypted");
        cipher = in.nextLine();
	System.out.println("Provide a key");
	shift = in.nextInt();*/
        System.out.println(cipher);
        char[] cipherChar = cipher.toCharArray();
        System.out.println(cipherChar);
	int num = cipher.length();
        for (int i=0; i < num; i++)
        {
            if(cipher.charAt(i) >= 'A' && cipher.charAt(i) <= 'Z')
            {
                cipherChar[i] = ((char)(((cipher.charAt(i) - shift - 'A' + 26) % 26) + 'A'));
            }
            else if (cipher.charAt(i) >= 'a' && cipher.charAt(i) <= 'z')
            {
                cipherChar[i] = ((char)(((cipher.charAt(i) - shift - 'a' + 26) % 26) + 'a') );
            }

        }
        cipher = String.valueOf(cipherChar);
        System.out.println("Decrypted text is ....." + cipher);
        System.out.println(shift + 10);
        return cipher;
    }



    public static String ceaserenc(String cipher, int key)
    {
	/*int key;
	String cipher;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the text to be encrypted");
        cipher = in.nextLine();
	System.out.println("Provide a key"); 
	key = in.nextInt();*/
        System.out.println(cipher);
        char[] cipherChar = cipher.toCharArray();
        System.out.println(cipherChar);
        int i = 0, len = cipher.length();
        for (i = 0; i < len; i++)
        {
            if(Character.isLetter(cipher.charAt(i)))
            {
                if(Character.isUpperCase(cipher.charAt(i)))
                {
                    cipherChar[i] = ((char)('A' + (cipher.charAt(i) + key - 65) % 26));
                }
                else if(Character.isLowerCase(cipher.charAt(i)))
                {
                    cipherChar[i] = ((char)('a' + (cipher.charAt(i) + key - 97) % 26));
                    
                }
            }
        }
        cipher = String.valueOf(cipherChar);
        System.out.println("Encrypted text is .... " + cipher);
        System.out.println(key + 10);
        return cipher;
    }
    
    /*public void start(){
        Scanner in = new Scanner(System.in);
        int opt;
        System.out.println("\t \t \t1. To Encrypt The Text ");
	System.out.println("\t \t \t2. To Decrypt The Text ");
	System.out.println("\t \t \tEnter Your Option : ");
	opt = in.nextInt();
	/*if(opt == 1)
		ceaserenc();
	else if(opt == 2)
		ceaserdec();
               
    }*/
}
