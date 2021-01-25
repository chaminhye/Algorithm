package hackerRank.practice;

import java.util.Arrays;
import java.util.Collections;

/**
 * 	문제 링크
 * 		https://www.hackerrank.com/challenges/electronics-shop/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
 * */
public class ElectronicsShop {

	public static void main(String arg[]) {
		int[] keyboards = {3,1};
		int[] drives = {5,2,8};
		int b=10;
//		int[] keyboards = {40,50,60};
//		int[] drives = {5,8,12};
//		int b=60;
		System.out.println(getMoneySpent(keyboards, drives, b));
	}
	
	static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        /*
         * Write your code here.
         */
        int answer = -1;
        Integer[] keys = Arrays.stream(keyboards).boxed().toArray(Integer[] :: new);
        Integer[] usb = Arrays.stream(drives).boxed().toArray(Integer[] :: new);
        
        Arrays.sort(keys, Collections.reverseOrder());
        Arrays.sort(usb, Collections.reverseOrder());
        int sum = -1;
        for(int i=0;i<keys.length ;i++){
        	for(int j=0;j<usb.length;j++) {
        		if(keys[i]+usb[j] <= b) {
        			sum = keys[i]+usb[j];
        		}
        		answer = Math.max(sum, answer);
        	}
//            System.out.print(i);
        }
        return answer;
    }


}
