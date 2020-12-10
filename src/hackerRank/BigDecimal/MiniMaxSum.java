package hackerRank.BigDecimal;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class MiniMaxSum {

	private static final Scanner scanner = new Scanner(System.in);

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
	}
	
	/* 	point. 쉬운 문제인데,
	* 			범위조건이  1<= arr[i] <= 10의9승 
	* 			int타입으로 해결하는 경우 overflow오류 발생, BigDecimal 타입으로 해결
	*/
	public static void miniMaxSum(int[] arr) {
	        
	        Arrays.sort(arr);

	        BigDecimal minSum = BigDecimal.ZERO;
	        BigDecimal maxSum = BigDecimal.ZERO;
	        BigDecimal num = BigDecimal.ZERO;
	        Integer len = arr.length;

	        for(int j=0;j<len;j++){
	            num = new BigDecimal(arr[j]);
	            if(j == 0){
	                minSum=minSum.add(num);
	            }else if(j == len-1){
	                maxSum=maxSum.add(num);
	            }else{
	                minSum=minSum.add(num);
	                maxSum=maxSum.add(num);
	            }

	        }
	        System.out.print(minSum +" "+ maxSum);
	    }

}
