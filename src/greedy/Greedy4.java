package greedy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
		int[] people = {40, 40, 40};
		int limit = 120;
//		int[] people = {70, 50, 80, 50};
	//	int limit = 100;
		int totalWeight = 0;
		int answer = people.length;
		
		Arrays.sort(people);
		List<Integer> list = Arrays.stream(people).boxed().collect(Collectors.toList());

		for(int i=0; i< list.size(); i++) {
			int together = 0;
			if(i < list.size() -1 ) {
				totalWeight = list.get(i) + list.get(i+1);
				
				if(totalWeight <= limit) {
					System.out.println("i : "+i+"totalWeight : " + totalWeight+" / "+list.get(i) + " / "+list.get(i+1));
					if(i+2 <= list.size()-1) {
						System.out.println("here");
						totalWeight = totalWeight + list.get(i+2);
						together ++;
					}
				}else {
					together = 0;
				}
			}
			answer -= together;
			System.out.println("together : "+together+"/	answer : " + answer);
		}
		
		/*
		for(int i=0;i< people.length;i++) {
			System.out.println("list : "+list);
			int together = 0;							// ���� Ż �� �ִ� �ο�
			int remainder = limit - people[i];			// ��Ʈ�� Ż �� �ִ� ����
			
			System.out.println("	Ÿ�� ��� : "+people[i]+"	Ż �� �ִ� ���� : "+remainder);
			if(list.size() >= 1) {
				if(remainder >= 40) {
					
					list.remove((Object)people[i]);						

					for(int j=0; j<list.size(); j++) {
						if(list.get(j) <= remainder) {		// ����Ʈ �Բ� Ż �� ���� 
							System.out.println("	 :  "+list.get(j));
							remainder = remainder - list.get(j);
							list.remove(list.get(j));
							together ++;
						}
						
						if(remainder >= 40) {
							list.remove(list.get(j+1));
							together ++;
						}
					}	
				}
			}
			answer -= together;
			System.out.println("	together : "+together+"	answer : "+answer);
		}
		 */
	}
}
