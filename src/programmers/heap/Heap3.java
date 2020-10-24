package programmers.heap;

import java.util.PriorityQueue;

/**
 * 문제 설명
		이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말합니다.
		
		명령어	수신 탑(높이)
		I 숫자	큐에 주어진 숫자를 삽입합니다.
		D 1	       큐에서 최댓값을 삭제합니다.
		D -1	큐에서 최솟값을 삭제합니다.
		
		이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.
		
	제한사항
		operations는 길이가 1 이상 1,000,000 이하인 문자열 배열입니다.
		operations의 원소는 큐가 수행할 연산을 나타냅니다.
		원소는 “명령어 데이터” 형식으로 주어집니다.- 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제합니다.
		빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.
	
	입출력 예
		operations	          return
		[I 16,D 1]	           [0,0]
		[I 7,I 5,I -5,D -1]	   [7,5]
		
	입출력 예 설명
		16을 삽입 후 최댓값을 삭제합니다. 비어있으므로 [0,0]을 반환합니다.
		7,5,-5를 삽입 후 최솟값을 삭제합니다. 최대값 7, 최소값 5를 반환합니다.
 * */

public class Heap3 {
	
	public static int[] solution(String[] operations) {
		int[] answer = new int[2];
		
		PriorityQueue<Integer> queue = new PriorityQueue<>();
        int max = 0;
        int min = 0;
        int number = 0;
        int temp = 0;
		for(String str : operations) {
			number = Integer.parseInt(str.substring(2, str.length()));
			
			if(str.contains("I")) {				// I : 큐에 주어진 숫자를 삽입	
				queue.offer(number);
				if( number > max) {
					temp = min;
					//min = number;
					max = number;
				}else {
					temp = min;
					min = number;
					//max = temp;
				}
				System.out.println("min : "+min+ " / max : " + max+ " / number : " + number);
			}else if(str.contains("D -1")){		// D -1 : 큐에서 최솟값 삭제 
				System.out.println("	min : "+ min);
				if(!queue.isEmpty()) {
					queue.remove(min);
					min = max;
				}
			}else if(str.contains("D 1")){								// D 1 : 큐에서 최댓값 삭제
				System.out.println("	max : "+ max);
				if(!queue.isEmpty()) {
					queue.remove(max);
					max = min;
				}
			}
			
			if(queue.isEmpty()) {				// 큐가 비어 있는 경우
				queue.offer(0);
			}
		}
		System.out.println("queue cnt : "+queue.size());
		System.out.println("queue : "+queue);
		
		if(queue.size() == 0) {
			answer[0] = 0;
			answer[1] = 0;
		}else {		
			answer[1] = queue.poll();
			while(!queue.isEmpty()) {
				queue.poll();
				if(queue.size() == 1) {
					answer[0] = queue.poll();
				}				
			}
			
			System.out.println(answer[0]);
			System.out.println(answer[1]);
		}	
		
		return answer;
	}
	
	public static void main(String args[]) {
		String[] operations = {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"}; 
//		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
//		String[] operations = {"I 16","I 6", "D 1","I 160"};

		System.out.println(solution(operations));
	}
	
}