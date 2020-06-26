package bruteForce;

import java.util.ArrayList;
import java.util.List;

public class BP4 {
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
