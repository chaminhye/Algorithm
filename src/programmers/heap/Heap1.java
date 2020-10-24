package programmers.heap;

import java.util.PriorityQueue;

public class Heap1 {
	
	public static int solution(int[] scoville, int K) {
		int answer =0 ;
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		
		// 우선순위큐에 scoville 담기
		for(int i : scoville) {
			priorityQueue.offer(i);
		}
		
		int firstScoville = 0;					// 가장 맵지 않은 스코빌 지수
		int secondScoville = 0;					// 두번째로 맵지 않은 스코빌 지수
		int mixScoville = 0;
		
		// 스코빌 지수 0이면 return 1
		if(K == 0) {	
			return -1;
		}
		
		while(priorityQueue.size() > 1) {
			
			firstScoville = priorityQueue.poll();
			secondScoville = priorityQueue.poll() ;

			// 모든 음식의 스코빌지수가  0인경우
			if(firstScoville == 0 && secondScoville == 0) {
				answer = -1;
				break;
			}
			// 모든 음식의 스코빌 지수가 K보다 큰 경우
			if(firstScoville >= K && secondScoville >= K) {
				break;
			}
			
			// 스코빌 계산	
			mixScoville = firstScoville + (secondScoville*2);
			answer++;

			// 계산된 스코빌 queue에 담기
			priorityQueue.offer(mixScoville);
		}
		
		// 최종 스코빌이 K보다 작은 경우
		if(mixScoville < K && answer > 0) {
			answer = -1;
		}
		
		/**
		 *   문제풀이 참고
		 *   
		 *   ★ 조건 : 우선순위큐의 사이즈가 최소2개는 잇어야 계산이 가능하며, 가장 맵지않은 스코빌지수가 K보다 작은경우 
		 *          -> 위의 35-61라인을 아래처럼 3줄로 요약가능
              while (pqScov.size() > 1 && pqScov.peek() < K) {
             	pqScov.add(pqScov.remove() + pqScov.remove() * 2);
             	cnt++;
         	  }
		 * */
		
		return answer;
		
	}
	
	public static void main(String args[]) {
//		int[] scoville = {1,1,1,1}; 
//		int K = 10;
//		int[] scoville = {3,5}; 
//		int K = 3;
		int[] scoville = {1, 3, 7, 8, 15}; 
		int K = 2000;
//		int[] scoville = {1,2,3,9,10,12}; 
//		int K = 7;
		
		System.out.println(solution(scoville, K));
		
	}
	
}