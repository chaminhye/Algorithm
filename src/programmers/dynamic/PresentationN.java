package programmers.dynamic;

import java.util.TreeSet;

/**
 * 문제 설명
		아래와 같이 5와 사칙연산만으로 12를 표현할 수 있습니다.
		
		12 = 5 + 5 + (5 / 5) + (5 / 5)
		12 = 55 / 5 + 5 / 5
		12 = (55 + 5) / 5
		
		5를 사용한 횟수는 각각 6,5,4 입니다. 그리고 이중 가장 작은 경우는 4입니다.
		이처럼 숫자 N과 number가 주어질 때, N과 사칙연산만 사용해서 표현 할 수 있는 방법 중 N 사용횟수의 최솟값을 return 하도록 solution 함수를 작성하세요.
		
	제한사항
		N은 1 이상 9 이하입니다.
		number는 1 이상 32,000 이하입니다.
		수식에는 괄호와 사칙연산만 가능하며 나누기 연산에서 나머지는 무시합니다.
		최솟값이 8보다 크면 -1을 return 합니다.
	
	입출력 예
		N	number	return
		5	 12	      4
		2	 11	      3
	
	입출력 예 설명
		예제 #1
		문제에 나온 예와 같습니다.
		
		예제 #2
		11 = 22 / 2와 같이 2를 3번만 사용하여 표현할 수 있습니다.
		
	출처
	 	https://itchallenger.tistory.com/32
	 	
 	요약
 		N을 1번 사용 ,  무조건 한자리수
 		N을 2번 사용,   NN, 사칙연산한 경우의 수
 		N을 2번 사용,   NNN , N을 2번 사용한 결과 + 사칙연산한 경우의 수
 		... 반복
 		
 		결과적으로 이미 연산된 식을 반복해서 사용하지 않으려면 , 
 		DP를 이용하여 d[n] = d[n-i] + d[i]라는 수식으로 풀이할 수 있다.
	 	
 * */
public class PresentationN {

	static int _N;
	static TreeSet<Integer>[] dynamic;		// 결과를 담을 배열 선언, d[n] = d[n-i] + d[i]
    
	public static void main(String[] args) {
		int N = 5;
		int number=12;
		int num = 0;
        
		int ans = solution(N, number);
		System.out.println("answer : "+ans);
		
	}

	public static int solution(int N, int number) {
		_N = N;
		dynamic = new TreeSet[10];			// N을 최대 9번 곱해봣자 NNNNNNNNN이하의 결과가 나오기 때문에 10으로 크기 설정

		if(N == number) {					// N과 number가 같은경우 무조건 return 1
			return 1;
		}
		
		for(int i =0;i<=8;i++) {			// N을 사용하는 횟수가 8보다 크면 -1이므로
			solve(i);
//			System.out.println("dynamic : "+dynamic[i]);

			// 연산결과 number와 값이 일치하면 return
			if(dynamic[i].contains(number)) {
				return i;
			}
//			System.out.println("===================================================================================");
		}
		return -1;
	}
	
	
	public static TreeSet<Integer> solve(int n) {
		if((dynamic[n]!= null) && !dynamic[n].isEmpty()) {		// 이미 존재하는 값인지 판단하여, 존재하면 return
			return dynamic[n];
		}
		
		// N을 이어서 붙인 NN...N 값 만들기
		int numN=0;
		for(int i=0;i<n;i++) {		
			numN = (10*numN) + _N;
		}
		
		TreeSet<Integer> temp = new TreeSet<>();
		temp.add(numN);			// temp에 numN값 담기
		
		
		// d[n] = d[n-i] + d[i]
		for(int i=1;i<n;i++) {
			int j=n-i;
			TreeSet<Integer> from = solve(i);		// i 번째까지 구한 집합
			TreeSet<Integer> to = solve(j);			// j 번째까지 구한 집합
			
			for(int n1:from) {
				for(int n2:to) {			
//					System.out.println("		n1 : "+n1 +"/ n2 : "+n2);
					
					temp.add(n1+n2);
					temp.add(n1-n2);
					temp.add(n1*n2);
					if(n2 !=0) temp.add(n1/n2);
				}
			}
		}
		
//		System.out.println("	n :"+n+" / temp : "+temp);
		return dynamic[n] = temp;
	}
	
	
}
