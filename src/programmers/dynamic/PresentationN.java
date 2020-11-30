package programmers.dynamic;


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
	 	DFS 사용
	 	https://eoghks0521.tistory.com/entry/N%EC%9C%BC%EB%A1%9C-%ED%91%9C%ED%98%84%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4
	 	
 * */
public class PresentationN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5;
		int number=12;
		solution(N, number);
		System.out.println(answer);
	}

	public static int answer = -1;
	
	public static int solution(int N, int number) {
		int ans = 0;
	
		calc(N, number, 0, 0);
		return ans;
	}
	
	public static void calc(int n, int number, int count, int result) {
		int nn = n;
//		System.out.println("result : "+result);
		// 사용횟수 8 초과하는 경우 return -1
		if(count > 8) {
			answer = -1;
			return;
		}
		
		if(result == number) {
			if(answer == -1 || answer > count) {
				answer = count;
			}
			return;
		}
		
		for(int i=1;i<9-count; i++) {
			calc(n, number, count+i, result+nn);
//			System.out.println("+");
			calc(n, number, count+i, result-nn);
//			System.out.println("-");
			calc(n, number, count+i, result*nn);
//			System.out.println("*");
			calc(n, number, count+i, result/nn);
//			System.out.println("/");
			
			nn = nn * 10 + n;
		}
	}
	
}
