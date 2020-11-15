import java.util.Scanner;
import java.math.BigInteger;

class RSAEncrypt{
	 static BigInteger phi(BigInteger n) 
	    {  //This Method is used to find Euler's Totient Function For non-prime Numbers
	        BigInteger result = BigInteger.ONE; 
	        for (BigInteger i = BigInteger.valueOf(2); i.compareTo(n)<0; i=i.add(BigInteger.ONE)) 
	            if (n.gcd(i).compareTo(BigInteger.ONE)==0)
	                result=result.add(BigInteger.ONE); 
	        return result; 
	    } 
        
        static long euler(long a, long b) {//Euler's Theroem
        	//This Method is used to find Inverse Modulo for non-primes
        	//This Method is very inefficient for RSA
        	BigInteger e = BigInteger.valueOf(a);  
        	BigInteger n = BigInteger.valueOf(b); 
        	BigInteger d = e.modPow(phi(n).subtract(BigInteger.ONE), n);
        	return d.longValue();
        } 

    static long gcd(long a, long b){ 	//A recursive Approach to GCD
        if (a == 0)
          return b;
        if (b == 0)
          return a;
        if (a == b)
            return a;
        if (a > b)
            return gcd(a-b, b);
        return gcd(a, b-a);
    }

    public static void main(String[] ar){
        Scanner in = new Scanner(System.in);
        System.out.println("Hello Alice");
        System.out.println("Enter the Number You Want To Encrypt: ");
        long s =in.nextLong();
        System.out.println("Enter the First prime number p: ");
        long p = in.nextLong();
        System.out.println("Enter the second prime number q: ");
        long q = in.nextLong();
        long n = p*q;
        long pi = (p-1)*(q-1); 
        long e = 2;
         for(long i=2;i<pi;i++){//Iterative Approach To find e
        	//gcd(pi,e)= 0 and 1<e<pi
         if(gcd(i,pi)==1) {
        	 e = i;
            break;
        }
        }
      System.out.println("The value of e(i.e,Public Key) is: "+e); 
      long d = euler(e,pi);
      System.out.println("The value of d(i.e,Private Key) is: "+d);
      long c=(long) ((Math.pow(s,e))%n);
      System.out.println("Encrypted message is : "+c);  

    }
}