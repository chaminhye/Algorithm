package stackQueue;

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

		// ��� Ʈ���� queue�� ���
		for(int i: truck_weights) {
			waitQ.offer(i);
		}

		// �ٸ� ���̸�ŭ  0���� queue�� ���
		for(int j=0; j <bridge_length; j++) {
			bridgeQ.offer(0);
		}

		//int time = 0;           // �ð�

		while(!(waitQ.isEmpty() && bridgeQ.isEmpty())) {

			int totalWeight = 0;    // �ٸ����� �ִ� �� ������ ����

			if(!bridgeQ.isEmpty()) {				
				bridgeQ.poll();			// �ð��� ������ ���� 1ĭ�� �̵�
			}

			// ���� �ٸ����� ���� Ȯ��
			if(!bridgeQ.isEmpty()) {
				for(int car : bridgeQ) {
					totalWeight += car;
				}
			}

			// �ٸ����� �� ���� �� + ���� ���������� ���� <= �ٸ��� ��Ƽ�� �� ����
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