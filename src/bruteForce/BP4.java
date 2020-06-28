package bruteForce;

import java.util.ArrayList;
import java.util.List;

public class BP4 {
	
	/**
	 * 문제 설명
			Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.
			
			carpet.png
			
			Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.
			
			Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.
		
		제한사항
			갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
			노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
			카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
		
		입출력 예
			brown	yellow	return
			10	       2	[4, 3]
			8	       1	[3, 3]
			24	      24	[8, 6]
	 * */
	
	static public void main(String args[]) {
//		int brown = 24;
//		int yellow = 24;
		int brown = 10;
		int yellow = 2;
		
		int[] answer = {0,0};
		
		int area = brown + yellow;
		answer = divisor(area, yellow);
		System.out.println(answer[0]+" / "+answer[1]);
	}
	
	public static int[] divisor(int area, int yellow ) {
		
		
		List<List<Integer>> areaList = new ArrayList<>();
		List<List<Integer>> yellowList = new ArrayList<>();
		
		int[] result = {0,0};
		
		for(int i =3; i<=area ; i++) {			// yellow가 존재하면 최소높이는 3부터 시작함	
			if(area % i == 0) {					// 전체 넓이의 약수 구하기
				if(area/i != 1 && area/i != 2) {
					List<Integer> innerList = new ArrayList<Integer>();
					innerList.add(i);
					innerList.add(area/i);
					areaList.add(innerList);
				}
			}
		}
		for(int i =1; i<=yellow ; i++) {			
			if(yellow % i == 0) {				// yellow 넓이의 약수 구하기
				List<Integer> innerList = new ArrayList<Integer>();
				innerList.add(i);
				innerList.add(yellow/i);
				yellowList.add(innerList);
			}
		}
		
		for(int i =0;i<areaList.size();i++) {			
			for(int j=0; j<yellowList.size(); j++) {

				// 총 너비 = (옐로우 너비+2) && 총 높이 = (옐로우 높이+2) 
				if(areaList.get(i).get(0) == (yellowList.get(j).get(0)+2) && areaList.get(i).get(1) == (yellowList.get(j).get(1)+2)) {
					result[0] = (int) areaList.get(i).get(0);
					result[1] = (int) areaList.get(i).get(1);
				}
			}
		}
		
		return result;
	}
}
