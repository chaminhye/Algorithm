package programmers.greedy;

import java.util.HashMap;
import java.util.Map;

public class Joystick_ex {
	/***
	 * 문제 설명
			조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
			ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA
		
			조이스틱을 각 방향으로 움직이면 아래와 같습니다.
		
			▲ - 다음 알파벳
			▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
			◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
			▶ - 커서를 오른쪽으로 이동
			예를 들어 아래의 방법으로 JAZ를 만들 수 있습니다.
		
			- 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
			- 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
			- 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
			따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
			만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.
		
		제한 사항
			name은 알파벳 대문자로만 이루어져 있습니다.
			name의 길이는 1 이상 20 이하입니다.
			
		입출력 예
			name	return
			JEROEN	 56
			JAN	     23
		
		문제풀이 참고
	 		https://keepgoing0328.tistory.com/71
	*/
	static public void main(String args[]) {
		String name = "JEROEN";

		System.out.println(solution(name));
	}
	
	public static int solution(String name) {
		int answer =0 ;
		
		// * Key Point ->>  위/아래 , 좌/우를 분리하여 접근
		// 위, 아래 최소이동
		for(int i=0; i <name.length(); i++) {
			if(name.charAt(i) != 'A') {
				int up = name.charAt(i) - 'A';
				int down = 1 + 'Z' -name.charAt(i);
				answer += (up < down) ? up : down;
//				System.out.println("answer :"+answer);
			}
		}
		
		// 무조건 왼->오른쪽으로 가는경우 계산
		int minMove = name.length() -1;

		// A가 아닌 모든 문자를 돌릴수 있는 최소 좌우이동
		// 모든 오->왼 역으로 돌아가는 경우  계산
		for(int i=0; i<name.length(); i++) {
			int next = i+1;
			
			// 첫번째 문자
			while(next < name.length() && name.charAt(next) == 'A'){
				next++;
			}
//			System.out.println("next : "+next);
			
			// 역으로 움직이는 경우 계산하므로 i *2 를 계산해줌
			int move = (2 * i) + name.length() - next;
//			System.out.println("move : "+move);		
			minMove = Math.min(move, minMove);
		}
		
		return answer + minMove;
	}
	
}