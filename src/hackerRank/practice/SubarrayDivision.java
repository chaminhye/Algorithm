package hackerRank.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 	문제 링크
 * 		https://www.hackerrank.com/challenges/the-birthday-bar/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign&isFullScreen=true&h_r=next-challenge&h_v=zen
 * 	
 * 문제 KeyPoint
 * 		이중for문 사용법만 알면 바로 풀이 가능! 난이도 최하
 * */
public class SubarrayDivision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> s = new ArrayList<Integer>();
		s.add(1);
		s.add(2);
		s.add(1);
		s.add(3);
		s.add(2);

		int d = 3;
		int m = 2;
		System.out.println(birthday(s, d, m));
	}

	static int birthday(List<Integer> s, int d, int m) {

		int sum =0 ;
		int answer = 0;
		
		for(int i=0;i<s.size()-m+1;i++){

			for(int j=i;j<m+i;j++){
				sum+= s.get(j);
			}
			if(sum==d) {
				answer++;
			}
			sum =0 ;
		}

		return answer;
	}
}
