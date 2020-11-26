package codility;

public class CycleRotation {
	static public void main(String args[]) {
//		int[] A = {-3,-80, 90, 7, 7, 1, 2, -9, 6, 3};
//		           0   1    2  3  4  5  6  7   8  9
//		int[] A = {3,-3,-80, 90, 7, 7, 1, 2, -9, 6};
//		int[] A = {6,3,-3,-80, 90, 7, 7, 1, 2, -9};
//		int[] A = {-9,6,3,-3,-80, 90, 7, 7, 1, 2};
//	                7 8 9   0  1  2   3  4  5  6  	
		int[] A = {};
		int K = 3;
//		int[] A = {3,8,9,7,6};
		int[] answer = new int[A.length];
		
		if(A.length == 0) {
		    answer = new int[0];
		    System.out.println("return : answer");
		}
		if(K % A.length == 0) {
			System.out.println("return : A");
		}

		// 인덱스 계산하기
		int idx = 0;
		for(int i =0;i<A.length; i++) {
			idx = (i+K) % A.length;
			answer[idx] = A[i];
		}

		for(int i :answer) {
			
			System.out.println(i);
		}
	}
}
