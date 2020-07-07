package greedy;

import java.util.HashMap;
import java.util.Map;

public class Greedy3 {
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
	*/
	static public void main(String args[]) {
		String name = "JEROEN";
		int answer = 0;
		
		int[] nameIdxArr = new int[name.length()];
		int[] answerIdxArr = new int[name.length()];
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		int idx =0;
		for(char c='A';c<='Z';++c) {					// map에  ABCD , 0123 인덱스 담기
			map.put(Character.toString(c), idx);
			idx ++;
		}
System.out.println(map);	
		String next, prev = "";							// 다음 알파벳(▲), 이전 알파벳(▼)
		int lastIdx = map.size();
		int midIdx = 12;								// 중간 idx
		for(int i =0;i<nameIdxArr.length;i++) {			// 주어진 name에 대한 인덱스 찾기
			int cnt = 0;									// 움직인 횟수
			nameIdxArr[i] = map.get(Character.toString(name.charAt(i)));
//			System.out.println(nameIdxArr[i]);
			if(nameIdxArr[i] != 0) {
				if(i==0) {								// 첫번째 글자
					answerIdxArr[i] = nameIdxArr[i]; 
				}else {
					if(nameIdxArr[i] > midIdx) { 		// Z 방향기준으로 이전 알파벳
						answerIdxArr[i] = (lastIdx - nameIdxArr[i]) + 1; 
					}else {								// A 방향기준으로 다음 알파벳
						answerIdxArr[i] = nameIdxArr[i] + 1; 
					}
				}
			}else {										// idx = 0 인 경우, 움직일 필요 X
				answerIdxArr[i] = 0; 
			}
			
			
		}
		
		for(int i=0; i<answerIdxArr.length; i++) {
			answer += answerIdxArr[i];
		}

		System.out.println(answer);
	}
	
}