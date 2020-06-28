package greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Greedy4 {
	/**
	 * ���� ����
			���ε��� ���� ������� ����Ʈ�� �̿��Ͽ� �����Ϸ��� �մϴ�. ����Ʈ�� �۾Ƽ� �� ���� �ִ� 2�� �ۿ� Ż �� ����, ���� ���ѵ� �ֽ��ϴ�.
			
			���� ���, ������� �����԰� [70kg, 50kg, 80kg, 50kg]�̰� ����Ʈ�� ���� ������ 100kg�̶�� 2��° ����� 4��° ����� ���� Ż �� ������ 1��° ����� 3��° ����� ������ ���� 150kg�̹Ƿ� ����Ʈ�� ���� ������ �ʰ��Ͽ� ���� Ż �� �����ϴ�.
			
			����Ʈ�� �ִ��� ���� ����Ͽ� ��� ����� �����Ϸ��� �մϴ�.
			
			������� �����Ը� ���� �迭 people�� ����Ʈ�� ���� ���� limit�� �Ű������� �־��� ��, ��� ����� �����ϱ� ���� �ʿ��� ����Ʈ ������ �ּڰ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
		
		���ѻ���
			���ε��� ���� ����� 1�� �̻� 50,000�� �����Դϴ�.
			�� ����� �����Դ� 40kg �̻� 240kg �����Դϴ�.
			����Ʈ�� ���� ������ 40kg �̻� 240kg �����Դϴ�.
			����Ʈ�� ���� ������ �׻� ������� ������ �� �ִ񰪺��� ũ�� �־����Ƿ� ������� ������ �� ���� ���� �����ϴ�.
		
		����� ��
			people	           limit	return
			[70, 50, 80, 50]	100	      3
			[70, 80, 50]	    100	      3
	 * */
	static public void main(String args[]) {
		int[] people = {70, 50, 80, 50};
		int limit = 100;
		int answer = 0;
		
		Arrays.sort(people);
		Queue<Object> queue = new LinkedList<>(Arrays.asList(people));
		
		int totalWeight = 0;

		while(!queue.isEmpty()) {
			System.out.println((int)queue.peek());
			if(queue.size() == 1) {
				answer += 1;
				break;
			}
			int man = (int)queue.poll();
			int duplicate = 0;
			
			int remainder = limit - man;				// ���� ����� ��Ʈ�� Ÿ�� ���� ����
			System.out.println("man : "+man+" / "+"remainder : "+remainder);
			
			if(remainder >= (int)queue.peek()) {		// ��������� ��Ʈ�� Ż �� ����
				
				queue.poll();
				duplicate++;
				System.out.println("duplicate : "+duplicate);
				
				while(remainder >= (int)queue.peek()) {
					queue.poll();
					duplicate++;
				}
			}
			System.out.println("duplicate : "+duplicate);
		}
		
	}
}
/**
 		int boatCnt = people.length;
		int[] remainder = new int[people.length];
		List<Integer> list = Arrays.stream(people).boxed().collect(Collectors.toList());
		//Collections.sort(list);
		
		for(int i=0;i< people.length;i++) {
			double cnt = 0;
			System.out.println("list : "+list);
			remainder[i] = limit - people[i];
			
			for(int j=0; j<list.size(); j++) {
				System.out.println("	Ÿ�� ��� : "+people[i]+"	Ż �� �ִ� ���� : "+remainder[i]+"/ ������ ��� :	"+list.get(j));
				if(list.get(j) <= remainder[i]) {		// ����Ʈ �Բ� Ż �� ���� 
//					list.remove(remainder[i]);
					list.remove(j);
					cnt ++;
					break;
				}else {									// ����Ʈ ȥ�� Ÿ����
					cnt = 0;
				}
			}	
			if(cnt > 0) {
				System.out.println("cnt is not equal 0");
				boatCnt -= 0.5;
			}
			System.out.println("	cnt : "+cnt+"	boatCnt : "+boatCnt);
			
		}
		answer = (int)boatCnt;
		System.out.println(answer);

 * 
 * */
