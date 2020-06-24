package bruteForce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BP1 {

	static public void main(String args[]) {
		int[] answers = {3, 3, 1, 1, 2, 2, 4, 4, 5};
//		int[] answers = {1,3,2,4,2};
//		int[] answers = {1,2,3,4,5};
		Map<Integer, Integer> answerMap = new HashMap<Integer,Integer>();
		answerMap.put(1, 0);
		answerMap.put(2, 0);
		answerMap.put(3, 0);
		List<Integer> answerlist = new ArrayList<>();
		
		List<Integer> patternList1 = Arrays.asList(1,2,3,4,5);
		List<Integer> patternList2 = Arrays.asList(2,1,2,3,2,4,2,5);
		List<Integer> patternList3 = Arrays.asList(3,3,1,1,2,2,4,4,5,5);

		for(int i = 0 ; i<answers.length; i++) {
			if(answers[i] == patternList1.get(i % (patternList1.size()))) {
				answerMap.put(1, answerMap.get(1)+1);
			}
			if(answers[i] == patternList2.get(i % (patternList2.size()))) {
				answerMap.put(2, answerMap.get(2)+1);
			}
			if(answers[i] == patternList3.get(i % (patternList3.size()))) {
				answerMap.put(3, answerMap.get(3)+1);
			}
		}
		
		int max = 0;					// 가장 많이 맞춘 문제 개수
		
		List<Map.Entry<Integer, Integer>> resultMap =  answerMap.entrySet().stream()
		        .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
		        .collect(Collectors.toList());			// 문제 개수 내림차순으로 정렬
		
		max = resultMap.get(0).getValue();
		System.out.println("max : "+max);
		for (Map.Entry<Integer, Integer> entry : resultMap) {
//		    System.out.println("Key: " + entry.getKey() + ", " + "Value: " + entry.getValue());
		    if(max <= entry.getValue()) {
		    	answerlist.add(entry.getKey());
		    }
		}
		
		int[] resultArr = new int[answerlist.size() ==0 ? 3:answerlist.size()];

		if(answerlist.size() == 0) {		// 맞힌 사람이 없는 경우
			resultArr[0] = 1;
			resultArr[1] = 2;
			resultArr[2] = 3;
		}else {
			System.out.println(answerlist.size());
			for(int i=0; i< answerlist.size();i++) {
				resultArr[i]=answerlist.get(i);
				System.out.println("resultArr["+i+"] : "+resultArr[i]);
			}
		}
		
	}
	
}
