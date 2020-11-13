package hackerRank.Strings;


import java.util.Scanner;

public class StringCompare {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0,k);
        String largest = s.substring(0,k);
        String current = "";
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        for(int i=1;i<=s.length()-k;i++){
            current = s.substring(i,i+k);
            // System.out.println(current);
            if( smallest.compareTo(current) > 0){
                // System.out.println(1);
                smallest = current;
            }else {
                if(largest.compareTo(current) <= 0){
                    // System.out.println(2); 
                    largest = current;    
                }
                
            }
            // System.out.println("smallest : "+smallest + " / largest : "+largest);
        }
        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}