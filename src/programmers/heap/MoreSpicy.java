package programmers.heap;

import java.util.PriorityQueue;


/**
 * 문제 설명
		매운 것을 좋아하는 Leo는 모든 음식의 스코빌 지수를 K 이상으로 만들고 싶습니다. 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 Leo는 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
		
		섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
		Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
		Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때, 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.
		
	제한 사항
		scoville의 길이는 2 이상 1,000,000 이하입니다.
		K는 0 이상 1,000,000,000 이하입니다.
		scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
		모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
	
	입출력 예
		scoville	           K	return
		[1, 2, 3, 9, 10, 12]	7	  2

	입출력 예 설명
		스코빌 지수가 1인 음식과 2인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
		새로운 음식의 스코빌 지수 = 1 + (2 * 2) = 5
		가진 음식의 스코빌 지수 = [5, 3, 9, 10, 12]
		
		스코빌 지수가 3인 음식과 5인 음식을 섞으면 음식의 스코빌 지수가 아래와 같이 됩니다.
		새로운 음식의 스코빌 지수 = 3 + (5 * 2) = 13
		가진 음식의 스코빌 지수 = [13, 9, 10, 12]
		
		모든 음식의 스코빌 지수가 7 이상이 되었고 이때 섞은 횟수는 2회입니다.
 * 
 * */
public class MoreSpicy {
	
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