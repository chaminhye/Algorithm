package heap;

import java.util.PriorityQueue;

public class Heap1 {
	static public void main(String args[]) {
		int[] scoville = {1,1,1,1}; 
		int K = 10;
//		int[] scoville = {1,2}; 
//		int K = 3;
//		int[] scoville = {1, 3, 7, 8, 15}; 
//		int K = 200;
//		int[] scoville = {1,2,3,9,10,12}; 
//		int K = 7;
		
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		
		// ¿ì¼±¼øÀ§Å¥¿¡ scoville ´ã±â
		for(int i : scoville) {
			priorityQueue.offer(i);
		}
		
		int firstScoville = 0;
		int secondScoville = 0;
		int mixScoville = 0;
		int answer = 0 ;

		while(priorityQueue.size() >= 1) {
			firstScoville = priorityQueue.poll();
//System.out.println("firstScoville : "+firstScoville);
			if(K == 0) {
				answer = 0;
				break;
			}

			if(priorityQueue.isEmpty()) {
				if(firstScoville < K) {
					answer = -1 ;
				}
			}else {
				secondScoville = priorityQueue.poll() *2 ;
//				System.out.println("secondScoville : "+secondScoville);			
				mixScoville = firstScoville + secondScoville;
//				System.out.println("mixScoville : "+mixScoville);			
				
				if(mixScoville < K) {
					answer++;
					priorityQueue.offer(mixScoville);
//					System.out.println(" priorityQueue : "+priorityQueue);
				}else {
					answer++;
					break;
				}
			}
		}
		
		System.out.println(answer);
	}
}