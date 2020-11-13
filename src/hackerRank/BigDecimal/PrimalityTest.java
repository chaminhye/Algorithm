package hackerRank.BigDecimal;

import java.math.BigInteger;
import java.util.Scanner;

public class PrimalityTest {
	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String n = scanner.nextLine();

        scanner.close();
        
        BigInteger b = new BigInteger(n);
        Boolean b1,b2,b3;
        b1 = b.isProbablePrime(-1);
        b2 = b.isProbablePrime(0);
        b3 = b.isProbablePrime(1);
        
        if(b1 == true && b2 == true && b3 == true){
            System.out.println("prime");
        }
        else{
            System.out.println("not prime");
        }
    }
}
