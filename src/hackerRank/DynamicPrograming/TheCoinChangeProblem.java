package hackerRank.DynamicPrograming;

import java.util.ArrayList;
import java.util.List;

/**
 *  문제 링크
 *  	https://www.hackerrank.com/challenges/coin-change/problem?isFullScreen=true
 * 
 * 	풀이 링크
 * 		https://www.geeksforgeeks.org/understanding-the-coin-change-problem-with-dynamic-programming/
 * 
 * 	KeyPoint
 * 		bottom-up 방식이용
 * 
 * */
public class TheCoinChangeProblem {
	public static int[] fibo = new int[11];
	public static long answer = 0;
	public static List<Long> result = new ArrayList<Long>();
	public static List<Long> _C = new ArrayList<Long>();
	public static int _N;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=10;
		int m=4;
		List<Long> c= new ArrayList<Long>();
		c.add((long)2);
		c.add((long)5);
		c.add((long)3);
		c.add((long)6);
		System.out.println("---------	getWays : "+getWays(n, c)+"	---------");
	}

	public static long getWays(int n, List<Long> c) {
		long[] dp = new long[n+1];
		dp[0]=1;
		
		for( int i=0; i< c.size(); i++) {
			for( int j=0; j< dp.length; j++) {
				if(c.get(i) <= j) {
					System.out.println("i : "+i+", j : "+j + "  //"+(int) (j -c.get(i)) + " - dp["+j+"] :" + dp[j]);
					dp[j] = dp[(int) (j -c.get(i))]+ dp[j]; 
				}				
			}
		}
		return dp[n];
		

	}
}
