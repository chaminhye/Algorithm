package programmers.greedy;

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
		https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%81%B0-%EC%88%98-%EB%A7%8C%EB%93%A4%EA%B8%B0-Java
 * */
public class MakingBigNumber {
	public static void main(String args[]) {
		String number = "1231234";
		int k = 3;
//		String number = "1924";
//		int k = 2;
		
		solution(number, k);
				
	}
	
	public static String solution(String number, int k) {
		StringBuilder sb = new StringBuilder();
	    
		int len = number.length();
		// 자리수
		int cnt = len - k;
        int left = 0;
        int right = len - cnt;
        int max = -1;
        int idx = 0;
        
        while(cnt > 0) {
        	 max = -1;
        	 // left ~ right 번째 까지 중의 가장 큰수를 찾는다.
             for(int j = left ; j <= right ; ++j){
                 int num = number.charAt(j) - '0';
//                 System.out.println("num : "+num +"/ max : "+max);
                 if(num > max){
                     idx = j;
                     max = num;
                 }
             }
             
             // 가장 큰수의 idx로 sb.append
             sb.append(number.charAt(idx));
             // left는  idx 보다 다음 숫자
             left = idx + 1;
             // right도 범위를 -1 씩 줄여준다.
             right = number.length() - --cnt;
//             System.out.println("idx : "+ idx +", sb : "+sb.toString());
        }

        return sb.toString();
	}

	// 출처  : https://programmers.co.kr/learn/courses/30/lessons/42883/solution_groups?language=java
	// 다른사람 풀이 Stack을 이용함, 조건식 중요!
	public static String solution_another(String number, int k) {
	       char[] result = new char[number.length() - k];
	        Stack<Character> stack = new Stack<>();

	        for (int i=0; i<number.length(); i++) {
	            char c = number.charAt(i);
	            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
	                stack.pop();
	            }
	            stack.push(c);
	        }
	        for (int i=0; i<result.length; i++) {
	            result[i] = stack.get(i);
	        }
	        return new String(result);
	}
}
