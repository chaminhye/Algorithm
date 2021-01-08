package hackerRank.Greedy;

/**
 * 
 * 문제 링크
 * 	https://www.hackerrank.com/challenges/candies/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign&isFullScreen=true
 * 
 * 문제 풀이
 * 	https://velog.io/@ming/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98Dynamic-Programing
 *
 */
public class Candies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int n = 7;
//		int[] arr = {1,2,3,4,3,2,1};
		//		int n = 6;
		//		int[] arr = {1,1,1,1,1,1};
				int n = 10;
				int[] arr = {2,4,2,6,1,7,8,9,2,1};
		candies(n, arr);
	}

	public static long candies(int n, int[] arr) {
		long answer = n;

		int[] num = new int[n];
		
		// i는 0부터 n-1까지 , 다음수가 크면 num[i+1] =num[i]+1
		for(int i=0;i<n-1;i++){
			if(arr[i+1]>arr[i]){
				num[i+1] = num[i]+1;
			}
		}
		
		// i는 n-1부터 0까지, 이전수가 크면 num[i]+1와 num[i-1]중의 큰수를 선택
		for(int i=n-1;i>=1;i--) {
			if(arr[i] < arr[i-1]) {
				num[i-1] = Math.max(num[i]+1, num[i-1]);
			}
		}
		for(int i : num) {
//			System.out.println(i);
			answer +=i;
		}
//		System.out.println("answer : "+answer);
		return answer;

	}
}
