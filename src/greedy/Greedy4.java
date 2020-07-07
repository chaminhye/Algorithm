package greedy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
		int[] people = {40, 40, 40};
		int limit = 120;
//		int[] people = {70, 50, 80, 50};
	//	int limit = 100;
		int totalWeight = 0;
		int answer = people.length;

		// 무게순으로 정렬
		Arrays.sort(people);
		List<Integer> list = Arrays.stream(people).boxed().collect(Collectors.toList());

		System.out.println("##### list : "+list);			
		int minIdx = 0;
		for(int i=list.size()-1; i >= 0; i--) {			// 가장 가벼운 사람 + 가장 무거운 사람 조합으로 동승 여부 체크
System.out.println("##### : "+list.get(i));			
			if(list.get(minIdx) != 1 && list.get(minIdx) != 2) {
				if(list.get(i)+list.get(minIdx) <= limit) {			// 보트에 같이 탈 수 있는 경우
					list.set(i, 2);					// 보트 탑승 하면, set 0
					list.set(minIdx, 2);
					minIdx ++;			
				}else {												// 보트에 같이 탈 수 없는 경우
					list.set(i, 1);
				}
			}
						
		}
		System.out.println("list  : "+list.get(0));
		System.out.println("list  : "+list.get(1));
		System.out.println("list  : "+list.get(2));
		
	}
}