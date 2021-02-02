package programmers.sort;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 문제 설명
		0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

		예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

		0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

	제한 사항
		numbers의 길이는 1 이상 100,000 이하입니다.
		numbers의 원소는 0 이상 1,000 이하입니다.
		정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.

	입출력 예
		numbers	            return
		[6, 10, 2]	         6210
		[3, 30, 34, 5, 9]	9534330

	문제 풀이
		https://velog.io/@ming/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4%EA%B0%80%EC%9E%A5-%ED%81%B0-%EC%88%98Level2
*/
public class LargestNumber {

	public static void main(String args[]) {
		int[] numbers = {3, 30, 34, 5, 9};
		System.out.println("answer : " +solution(numbers));
	}

	public static String solution(int[] numbers) {
		String answer = "";
		int len = numbers.length;
		// 1. int형 배열을 String배열로 변환
		String[] strs = new String[len];
		for(int i=0;i<len;i++){
			strs[i] = Integer.toString(numbers[i]);
		}

		// 2. String 으로 정렬한다. (s1 + s2) , (s2 + s1)를 비교했을때 사전적으로 더 큰 순으로 정렬
		Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return ((s2+s1).compareTo(s1+s2));
			}
		});

		// 2-1. lamda식으로 표현
		Arrays.sort(strs, (s1, s2) -> (s2+s1).compareTo(s1+s2));

		// 예외케이스
		// 모두 0 인 경우
		if("0".equals(strs[0])){
			return "0";
		}
		for(String st : strs){
			answer += st;
		}
		return answer;
	}

}
