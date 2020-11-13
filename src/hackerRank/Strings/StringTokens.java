package hackerRank.Strings;

import java.util.Scanner;

public class StringTokens {
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        // 공백제거
        s = s.trim();
        
        String[] arr = s.split("[\\s!,?._'@\"]+");
        
        if(s.length() == 0 || s.length() > 400000){
            System.out.println(0);
            return;    
        }else{
            System.out.println(arr.length);
            for(String str : arr){
                System.out.println(str);
            }
        }
        scan.close();
    }
}
