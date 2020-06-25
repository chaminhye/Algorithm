package bruteForce;

import java.util.ArrayList;
import java.util.List;

public class BP3 {
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
