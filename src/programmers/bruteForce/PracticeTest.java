package programmers.bruteForce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 문제 설명
		수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
		
		1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
		2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
		3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
		
		1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
		
	제한 조건
		시험은 최대 10,000 문제로 구성되어있습니다.
		문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
		가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
		
	입출력 예
		answers	     return
		[1,2,3,4,5]	  [1]
		[1,3,2,4,2]	 [1,2,3]
		
	입출력 예 설명
		입출력 예 #1
		
		수포자 1은 모든 문제를 맞혔습니다.
		수포자 2는 모든 문제를 틀렸습니다.
		수포자 3은 모든 문제를 틀렸습니다.
		따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.
		
		입출력 예 #2
		
		모든 사람이 2문제씩을 맞췄습니다.
 * */
public class PracticeTest {

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
		
		int max = 0;					// 媛��옣 留롮씠 留욎텣 臾몄젣 媛쒖닔
		
		List<Map.Entry<Integer, Integer>> resultMap =  answerMap.entrySet().stream()
		        .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
		        .collect(Collectors.toList());			// 臾몄젣 媛쒖닔 �궡由쇱감�닚�쑝濡� �젙�젹
		
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