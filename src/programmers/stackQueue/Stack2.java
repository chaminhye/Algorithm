package programmers.stackQueue;

import java.util.Arrays;
import java.util.Stack;

public class Stack2 {
	public static void main(String args[]) {
		int[] heights = {1,5,3,6,7,6,5};
		int[] result = new int[heights.length];

		// height array copy
		int[] tempHeights = Arrays.copyOfRange(heights, 0, heights.length);
		Stack<Integer> st = new Stack();
		int j = 0;
		for(int i=heights.length-1 ; i > 0;i--) {
			j = i-1;
			
			// 송신하는 탑 < 수신하는 탑 인 경우 해당 idx 스택에 담기 
			if(compareTo(heights[i], tempHeights[j])){
				st.push(j+1);
			}else {
			// 송신하는 탑 > 수신하는 탑 인 경우, 받을수 있는 수신탑 찾기
				if(j >= 1) {
					for(int k=j-1; k > -1 ; k--) {
						if(compareTo(heights[i], tempHeights[k])){
							st.push(k+1);
							break;
						// 송신하는 탑이 제일 큰 경우, 수신할 탑이 없음	
						}else if(k == 0) {
							st.push(0);
							break;
						}
					}
				}else {
					st.push(0);
				}
			}
		}
		// 맨 왼쪽 탑은 송신할 탑이 없음
		st.push(0);
		
		for(int i=0; i<heights.length; i++) {
			if(!st.isEmpty()) {
				result[i] = st.pop();
			}
			System.out.println(result[i]);
		}

	}
	
	
	public static Boolean compareTo(int a, int b) {
		if(a > b) {
			return false;
		}else if (a < b) {
			return true;
		}else {
			return false;
		}
	}
}	