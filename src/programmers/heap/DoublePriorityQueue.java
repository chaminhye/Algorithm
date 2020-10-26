package programmers.heap;

import java.util.Comparator;
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

public class DoublePriorityQueue {
	
	public static int[] solution(String[] operations) {
		int[] answer = new int[2];

		// Key Point
		// 최소 우선순위큐, 최대 우선순위큐를 사용하여 , 각각의 최대 ,최소값을 추출한다.
		PriorityQueue<Integer> minQ = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>(Comparator.reverseOrder());
		
		// operations 배열을 돌면서, I가 포함된 경우 queue에 삽입, D 가 들어간 경우 최소,최대 큐 동시에 삭제
		for(String str : operations) {
			if(str.contains("I")) {		// insert minQ, maxQ
				minQ.offer(Integer.parseInt(str.replace("I ", "")));
				maxQ.offer(Integer.parseInt(str.replace("I ", "")));
			}else if(str.contains("D 1")) {		
				if(!maxQ.isEmpty()) {
					minQ.remove(maxQ.peek());
					maxQ.poll();
				}
			}else if(str.contains("D -1")) {
				if(!minQ.isEmpty()) {
					maxQ.remove(minQ.peek());
					minQ.poll();
				}
			}
//			System.out.println("str : "+str +" / minQ : "+minQ + " / maxQ :"+maxQ);
			
		}
		
		if(!maxQ.isEmpty() && !minQ.isEmpty()) {
			answer[0] = maxQ.peek();
			answer[1] = minQ.peek();
		}else {
			answer[0] = 0;
			answer[1] = 0;
		}
		
		return answer;
	}
	
	public static void main(String args[]) {
		String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}; 
//		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
//		String[] operations = {"I 16","I 6", "D 1","I 160"};

		System.out.println(solution(operations));
	}
	
}