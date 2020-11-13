package hackerRank.Strings;

import java.util.Scanner;

public class StringReverse {
	public static void main(String[] args) {
	        
	        Scanner sc=new Scanner(System.in);
	        String A=sc.next();
	        /* Enter your code here. Print output to STDOUT. */
	        
	        int len = A.length() %2 == 0 ? A.length() /2 : (A.length() /2) +1;
	        String forward ="";
	        String backward ="";
	        for(int i=0;i<len;i++){
	            forward += A.charAt(i);
	        }
	        for(int i=A.length()-1;i>=len-1;i--){
	            backward += A.charAt(i);
	        }
	        if(forward.length ()!= backward.length()){
	            backward = backward.substring(0, backward.length()-1);
	        }
	    //    System.out.print("forward : "+forward); 
	    //    System.out.print("backward : "+backward); 
	        if(forward.equals(backward)){
	            System.out.print("Yes");
	        }else{
	            System.out.print("No");
	        }
	    }
}
