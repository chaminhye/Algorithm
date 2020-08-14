package programmers.stackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Stack4 {

	public static void main(String[] args) {
		
//		int[] priorities = {2, 1, 3, 2};
//		int location = 2;
//		int[] priorities = {1, 1, 9, 1, 1, 1};
//		int location = 5;
		int[] priorities = {1, 2, 3};
		int location = 0;
		int[] printArr = new int[priorities.length];
		int answer = 0;
		
		Queue<Integer> q = new LinkedList<>();
/*		int maxNum = priorities[0];
		int maxIdx = 0;
		for(int i=0; i<priorities.length; i ++) {
			if(priorities[i] > maxNum) {			
				//maxNum = priorities[i];
				maxIdx = i;
				q.offer(priorities[i]);
			}
			
			if(i > maxIdx && maxIdx > 0) {			
				q.offer(priorities[i]);
			}
		}
		*/
		int maxIdx = getMaxIdx(priorities);				// 중요도 최대값 구하기
		
		for(int i=maxIdx; i<priorities.length; i++) {	// 최대값부터 Queue에 담기		
			q.offer(priorities[i]);
		}
		for(int i =0; i< maxIdx; i++) {					// 대기목록에 마지막으로 밀린 문서 Queue에 담기
			q.offer(priorities[i]);
		}
System.out.println("q : "+q);		
System.out.println("maxIdx : "+maxIdx);		

		// 중요도 1 
		printArr[0] = q.poll();
		
		
		for(int i : printArr) {							// queue -> array convert
			printArr[i] = q.poll();
		}

		int print = 0;
		while(!q.isEmpty()) {
			for(int i=0;i<printArr.length;i++) {
				printArr[i] = q.poll();
			}
		}
		System.out.println(printArr[0]);
		System.out.println(printArr[1]);
		System.out.println(printArr[2]);
		System.out.println(printArr[3]);
		int result = printArr[location];			// find array value 
		for(int i : printArr) {
			if(printArr[i] == result) {
				answer ++ ;
			}
		}
		
		System.out.println(answer);
	}
	
	static int getMaxIdx(int[] arr) {
		int maxNum = arr[0];
		int maxIdx = 0;
		for(int i=0; i<arr.length; i ++) {
			if(arr[i] > maxNum) {			// 중요도 최대값 구하기
				//maxNum = priorities[i];
				maxIdx = i;
			}
			/*
			if(i > maxIdx && maxIdx > 0) {			// 최대값부터 Queue에 담기
				q.offer(arr[i]);
			}
			*/
		}
		
		return maxIdx;
		
	}
}