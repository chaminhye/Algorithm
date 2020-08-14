package programmers.stackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Stack1 {

	public static void main(String args[]) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7,4,5,6};
		//		int bridge_length = 100;
		//		int weight = 100;
		//		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
		int answer = 0;
		int time = 0;

		Queue<Integer> waitQ = new LinkedList<>();
		Queue<Integer> bridgeQ = new LinkedList<>();

		// 모든 트럭을 queue에 담기
		for(int i: truck_weights) {
			waitQ.offer(i);
		}

		// 다리 길이만큼  0으로 queue에 담기
		for(int j=0; j <bridge_length; j++) {
			bridgeQ.offer(0);
		}

		//int time = 0;           // 시간

		while(!(waitQ.isEmpty() && bridgeQ.isEmpty())) {

			int totalWeight = 0;    // 다리위에 있는 차 무게의 총합

			if(!bridgeQ.isEmpty()) {				
				bridgeQ.poll();			// 시간이 지나면 차는 1칸씩 이동
			}

			// 현재 다리위의 무게 확인
			if(!bridgeQ.isEmpty()) {
				for(int car : bridgeQ) {
					totalWeight += car;
				}
			}

			// 다리위의 총 차의 합 + 현재 지나갈차의 무게 <= 다리가 버티는 총 무게
			if(!waitQ.isEmpty()) {
				if(totalWeight + waitQ.peek() <= weight) {
					bridgeQ.offer(waitQ.poll());
				}else {
					bridgeQ.offer(0);
				}
			}

			time++;
		}
		
		System.out.println("time : "+time);
	}

}