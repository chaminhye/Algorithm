package codility.sorting;

import java.util.Arrays;

/**
 * Lesson6 - Sorting 
 */
public class MaxProductOfThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] A = {-3,1,2,-2,5,6};
//		int[] A = {-10,-2,-4};
		int[] A = {-10000,-10,2,-2,5,6};
		solution(A);
	}
	
	public static int solution(int[] A) {
		int ans = Integer.MIN_VALUE;
		int len = A.length;
		Arrays.sort(A);
		
		// 모두 다 음수인 경우
		if(A[len-1] < 0) {
			ans = A[len-1] * A[len-2] * A[len-3];
		}
		
		// 두번째로 큰수가 음수인 경우, 양수 1개 * 가장 작은수 * 두번째로 작은수
		if(A[len-2] < 0 || A[len-3] < 0) {
			ans = A[len-1] * A[0] * A[1];
		}
		
		int num1 = A[len-1] * A[len-2] * A[len-3];
		int num2 =  A[len-1] * A[0] * A[1];
		
		ans = Math.max(num1, num2);
//		System.out.println(ans);
		return ans;
	}

}
