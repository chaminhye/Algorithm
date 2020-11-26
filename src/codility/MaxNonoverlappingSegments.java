package codility;

/**
 * Lesson16 - Greedy algorithms
 */
public class MaxNonoverlappingSegments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,3,7,9,9};
		int[] B = {5,6,8,9,10};
		solution(A,B);
	}
	
	public static int solution(int[] A, int[] B) {
		int ans = 1;
		int len = B.length;
		
		// 배열 사이즈 0인 경우
		if(A.length == 0) {
			return 0;
		}
		
		int end = B[0];
		// idx=0을 무조건 선택한 경우
		for(int i=1;i<len;i++) {
			if(end < A[i]) {
				ans ++;
				end = B[i];
//				System.out.println("end : "+end);
			}
		}
//		System.out.println(ans);
		return ans;
	}

}
