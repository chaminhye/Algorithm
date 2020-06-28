package greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Greedy4 {
	/**
	 * 문제 설명
			무인도에 갇힌 사람들을 구명보트를 이용하여 구출하려고 합니다. 구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한도 있습니다.
			
			예를 들어, 사람들의 몸무게가 [70kg, 50kg, 80kg, 50kg]이고 구명보트의 무게 제한이 100kg이라면 2번째 사람과 4번째 사람은 같이 탈 수 있지만 1번째 사람과 3번째 사람의 무게의 합은 150kg이므로 구명보트의 무게 제한을 초과하여 같이 탈 수 없습니다.
			
			구명보트를 최대한 적게 사용하여 모든 사람을 구출하려고 합니다.
			
			사람들의 몸무게를 담은 배열 people과 구명보트의 무게 제한 limit가 매개변수로 주어질 때, 모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return 하도록 solution 함수를 작성해주세요.
		
		제한사항
			무인도에 갇힌 사람은 1명 이상 50,000명 이하입니다.
			각 사람의 몸무게는 40kg 이상 240kg 이하입니다.
			구명보트의 무게 제한은 40kg 이상 240kg 이하입니다.
			구명보트의 무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어지므로 사람들을 구출할 수 없는 경우는 없습니다.
		
		입출력 예
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
			
			int remainder = limit - man;				// 현재 사람이 보트에 타고 남은 무게
			System.out.println("man : "+man+" / "+"remainder : "+remainder);
			
			if(remainder >= (int)queue.peek()) {		// 다음사람이 보트에 탈 수 있음
				
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
				System.out.println("	타는 사람 : "+people[i]+"	탈 수 있는 무게 : "+remainder[i]+"/ 가능한 사람 :	"+list.get(j));
				if(list.get(j) <= remainder[i]) {		// 구명보트 함께 탈 수 있음 
//					list.remove(remainder[i]);
					list.remove(j);
					cnt ++;
					break;
				}else {									// 구명보트 혼자 타야함
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
