package bruteForce;

import java.util.ArrayList;
import java.util.List;

public class BP3 {
	
	/**
	 * 문제 설명
			숫자 야구 게임이란 2명이 서로가 생각한 숫자를 맞추는 게임입니다. 게임해보기
			
			각자 서로 다른 1~9까지 3자리 임의의 숫자를 정한 뒤 서로에게 3자리의 숫자를 불러서 결과를 확인합니다. 그리고 그 결과를 토대로 상대가 정한 숫자를 예상한 뒤 맞힙니다.
			
			* 숫자는 맞지만, 위치가 틀렸을 때는 볼
			* 숫자와 위치가 모두 맞을 때는 스트라이크
			* 숫자와 위치가 모두 틀렸을 때는 아웃
			예를 들어, 아래의 경우가 있으면
			
			A : 123
			B : 1스트라이크 1볼.
			A : 356
			B : 1스트라이크 0볼.
			A : 327
			B : 2스트라이크 0볼.
			A : 489
			B : 0스트라이크 1볼.
			이때 가능한 답은 324와 328 두 가지입니다.
			
			질문한 세 자리의 수, 스트라이크의 수, 볼의 수를 담은 2차원 배열 baseball이 매개변수로 주어질 때, 가능한 답의 개수를 return 하도록 solution 함수를 작성해주세요.

		제한사항
			질문의 수는 1 이상 100 이하의 자연수입니다.
			baseball의 각 행은 [세 자리의 수, 스트라이크의 수, 볼의 수] 를 담고 있습니다.
		입출력 예
			baseball	                                          return
			[[123, 1, 1], [356, 1, 0], [327, 2, 0], [489, 0, 1]]	2
	 * */
	static public void main(String args[]) {
        int answer = 0;
        int[][] baseball = {{123,1,1}, {356,1,0}, {327,2,0},{489,0,1}};
        
		List<Integer> firstNum = new ArrayList<>();  
		List<Integer> secondNum = new ArrayList<>();  
		List<Integer> thirdNum = new ArrayList<>();
		
		//각 자리마다 허용가능한 숫자를 list에 저장
		for(int i=1; i<10; i++) {
			firstNum.add(i);
			secondNum.add(i);
			thirdNum.add(i);
		}
		
		String number = "";
		for(int i=0;i<baseball.length;i++) {
			for(int j=0;j<baseball[i].length;j++) {
				//System.out.println(i +" : "+j+" : "+baseball[i][j]);
				if(j == 0) {
					number = Integer.toString(baseball[i][j]);
				}
				if(j==1 && baseball[i][j] == 0) {		// strike = 0
					firstNum.remove(number.substring(0, 1));
					secondNum.remove(number.substring(1, 2));
					thirdNum.remove(number.substring(2, 3));
				}
			}
		}
		
		
		
		answer = firstNum.size() * secondNum.size() * thirdNum.size();
		System.out.println(answer);
		
	}
}
