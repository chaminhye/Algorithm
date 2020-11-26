package codility;

import java.util.LinkedList;
import java.util.Queue;

public class TieRopes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] A = {1,2,3,4,1,1,3};
		int[] A = {100000,1,2220,2000000,1,1,1,1,1,33,40,1,1,199,100,3000000};
		int K = 300;
		solution(K, A);
	}

	public static int solution(int K, int[] A) {
		int cnt = 0;
		int len = A.length;
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0;i<len;i++) {
			q.add(A[i]);
		}
		
		System.out.println(q);
		int pre = q.peek();
		int reminder = 0;
		
		while(!q.isEmpty()) {
			
			int sum = q.peek() + reminder;
			
			// 가장 마지막 로프
			if(q.size() == 0) {
				// 마지막 로프가 K 이상인 경우
				if(sum >= K) {
					cnt++;
				}
				break;
			}
			pre = q.poll();
			System.out.println(" pre : "+pre + " / sum : "+sum+ " / reminder : "+reminder);
			
			// 묶은 로프가 K 이상인 경우
			if(sum >= K) {
				cnt ++;
				reminder = 0;
			}else {
				reminder += pre;	
			}
			
		}
		System.out.println(cnt);
		return cnt;
	}
}
