package hackerRank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 문제 풀이 링크
 * 	-> https://www.hackerrank.com/challenges/grading/problem?isFullScreen=false
 */

public class GradingStudents {

	public static void main(String[] args) throws IOException {
        List<Integer> grades = new ArrayList<Integer>();
        grades.add(75);
        grades.add(67);
        grades.add(40);
        grades.add(33);
        gradingStudents(grades);
	}
	
	public static List<Integer> gradingStudents(List<Integer> grades) {
		// Write your code here
		int len = grades.size();
		List<Integer> ans = new ArrayList<Integer>();
		
		// 주어진 수보다 큰 5의 배수 찾기 (ex : 73 이면, 75 / 75면 80을 찾도록)
		for(int i=0;i<len;i++){
			int num = grades.get(i);
			
			if(num <= 37){      // 낙제점 거르기
				ans.add(num);
			}else{
				int remainder = num % 10;           // 일의 자리수
				int diff = remainder >=5 ? Math.abs(10-remainder) :Math.abs(5-remainder);   // 5이상인지 아닌지 체크
				
				if(diff <= 2){                       
					ans.add(num+diff);
				}else{
					ans.add(num);
				}
			}
		}
//		System.out.println(ans.get(0));
//		System.out.println(ans.get(1));
//		System.out.println(ans.get(2));
//		System.out.println(ans.get(3));
		return ans;
	}
}

