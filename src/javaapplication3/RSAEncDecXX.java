/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;
/**
 *
 * @author kapil bhatt
 */
public class RSAEncDecXX {

    private int phi,M,n,e,d,C,FLAG;
    
    
    public int start1(int p, int q)
    {
        int s,opt;
        //Scanner in = new Scanner(System.in);
        //System.out.println("Enter Two Relatively Prime Numbers\t: ");
	//p = in.nextInt();
        //q = in.nextInt();
	n = p*q;
	phi=(p-1)*(q-1);
	//System.out.println("\n\tF(n)\t= "  + phi);
        return phi;
    }
    
    public boolean start2(int e){
	do
	{
        	//System.out.println("Enter e:   ");
		//e = in.nextInt();
		check();
	}while(FLAG==1);
        
        if(FLAG == 0)
            return true;
        else
            return false;
    }
    
    public void start3(){
        
        int s;
        d = 1;
	do
	{
		s = (d*e)%phi;
		d++;
	}while(s!=1);
	d = d-1;
    }
    
    public String publickey4(){
        return ("(" + e + " , " + n + ")");
    }
    
    public String privatekey5(){
        return ("(" + d + " , " + n + ")");
    }
    
    public int step6(int x){
        //System.out.println("\n\nEnter The Plain Text\t: ");
	M = x;
	return encrypt();
	//System.out.println();
    }
    
    public int step7(int x){
        //System.out.println("Do you want to decrypt it(1/0)");
        //opt = in.nextInt();
	//if(opt == 1)
	//{
		//System.out.println("\n\nEnter the Cipher text\t: ");
		C = x;
		return decrypt();
		//System.out.println();
	//}
    }
    
    public void check()
	{
		int i;
		for( i=3; ((e%i==0)&&phi%i==0); i=i+2)
		{
			FLAG = 1;
	//		return 0;
		}
		FLAG = 0;
	}
	
    public int encrypt()
	{
		int i;
		C = 1;
		for(i=0;i< e;i++)
		C=C*M%n;
		C = C%n;
		//System.out.println("Encrypted kesyword : " + C);
                return C;
	}
	
    public int decrypt()
	{
		int i;
		M = 1;
		for(i=0;i< d;i++)
		M=M*C%n;
		M = M%n;
		return M;
	}


}
