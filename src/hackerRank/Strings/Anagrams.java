package hackerRank.Strings;

import java.util.Scanner;

public class Anagrams {

	public static void main(String[] args) {
		
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
	}

    static boolean isAnagram(String a, String b) {
        // Complete the function\
        // 두개의 단어가 같은 경우
        if(a.equals(b)){
            return true;
        }
    
        // 두개의 단어가 다른 경우
        char[] arrA = a.toLowerCase().toCharArray();
        char[] arrB = b.toLowerCase().toCharArray();
        java.util.Arrays.sort(arrA);
        java.util.Arrays.sort(arrB);
        
        String sortA = new String(arrA);
        String sortB = new String(arrB);
        // System.out.println("sortA : "+sortA);
        // System.out.println("sortB : "+sortB);
        if(sortA.equals(sortB)){
            return true;
        }else{
            return false;    
        }
        
    }


}
