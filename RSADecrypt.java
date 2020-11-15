import java.math.BigInteger;
import java.util.Scanner;

public class RSADecrypt {
	static BigInteger fermat(BigInteger a, BigInteger m)//Fermat's Theroem 
    { //Finding Inverse modulo of primes
       return a.modPow(m.subtract(BigInteger.valueOf(2)), m);
    } 
          
  
    static BigInteger CRT(BigInteger num[], BigInteger rem[])//Chinese Remainder Theroem
    {  
        BigInteger prod = BigInteger.ONE; 
        for (int i = 0; i < 2; i++) 
            prod = prod.multiply(num[i]); 
      
        BigInteger result = BigInteger.ZERO; 
      
        for (int i = 0; i < 2; i++) 
        { 
            BigInteger pp = prod.divide(num[i]); 
            result = result.add(rem[i].multiply(fermat(pp, num[i])).multiply(pp)); 
        } 
      
        return result.mod(prod); 
    } 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Hello Bob");
		System.out.println("Enter Encrypted number You want to decrypt: ");
		BigInteger s = in.nextBigInteger();
		System.out.println("Enter 1st prime number p: ");
		BigInteger p = in.nextBigInteger();
		System.out.println("Enter 2nd prime number p: ");
		BigInteger q = in.nextBigInteger();
		System.out.println("Enter Private Key(i.e, d): ");
		int d = in.nextInt();
	    BigInteger k = s.pow(d);
		BigInteger num[] = {p,q};
		BigInteger rem[] = {k,k};
		System.out.println("Your Message is: "+CRT(num,rem));
	}
	
}
