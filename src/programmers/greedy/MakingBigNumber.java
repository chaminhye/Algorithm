package programmers.greedy;

import java.util.Arrays;
import java.util.Stack;

/**
 * 
 	큰 수 만들기
		문제 설명
		어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
		
		예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.
		
		문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
	
	제한 조건
		number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
		k는 1 이상 number의 자릿수 미만인 자연수입니다.
	
	입출력 예
		number	      k	    return
		1924	      2	      94
		1231234	      3	     3234
		4177252841	  4	    775841
		
	풀이 참고
 		https://geehye.github.io/programmers-greedy-02/#

 	문제 풀이
 		https://velog.io/@ming/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%81%B0-%EC%88%98-%EB%A7%8C%EB%93%A4%EA%B8%B0Level-3
 * */
public class MakingBigNumber {
	public static void main(String args[]) {
//		String number = "1231234";
//		int k = 3;
		String number = "1924";
		int k = 2;
		System.out.println(solution(number, k));
	}

	public static String solution(String number, int k){
		StringBuilder sb = new StringBuilder();		// 9,10 번 예외 케이스 때문에 StringBuilder 사용

		int len = number.length();
		int idx = 0; 		// 현재 위치

		// i, 숫자 len-k개를 뽑기위해 반복
		for(int i=0; i<len-k ; i++){
			char max = '0';
			// j, 시작은 idx ,
			// 범위는 k+i까지 ( k크기에다가 i는 뽑은 숫자만큼 늘려준다.)
			// 첫번째 숫자는 0~k index 사이에 존재함.
			for(int j=idx; j<=k+i; j++){
				// 현재 숫자가 가장 크다면, idx + 1 을 하여
				// 그 다음숫자부터 탐색하게 설정
				if(max < number.charAt(j)){
					max = number.charAt(j);
					idx = j+1;
				}
			}
			sb.append(max);
		}
		return sb.toString();
	}
}
