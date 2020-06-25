package bruteForce;

import java.util.HashMap;
import java.util.Map;

public class BP4 {
	static public void main(String args[]) {
		int brown = 24;
		int yellow = 24;
		int[] answer = {0,0};
		
		int area = brown + yellow;
		answer = divisor(area, yellow);
		System.out.println(answer[0]);
	}
	
	public static int[] divisor(int area, int yellow ) {
		Map<Integer, Integer> areaMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> yellowMap = new HashMap<Integer, Integer>();
		
		int[] result = {0,0};
		
		for(int i =3; i<=area/2 ; i++) {
			if(area % i == 0) {
				if(i!=1 && i!=2 && i!= area/2) {
					areaMap.put(i, area/i);
				}
			}
			areaMap.remove(area/i, i);
		}
		
		for(int i =1; i<=yellow/2 ; i++) {
			if(yellow % i == 0) {
				if(i!=1 && i!= yellow/2) {
					yellowMap.put(i, yellow/i);
				}
			}
			yellowMap.remove(yellow/i, i);
		}
System.out.println("areaMap : "+areaMap);		
System.out.println("yellowMap : "+yellowMap);		
		for(int i =0;i<areaMap.size();i++) {
			for(int j=0; j<yellowMap.size(); j++) {
			System.out.println(areaMap.keySet() +" / "+ yellowMap.get(i));	
				if(areaMap.get(i) >= yellowMap.get(i)+2 && areaMap.get(i).intValue() >=  yellowMap.get(i).intValue()+2) {
					result[0] = areaMap.get(i);
					result[1] = areaMap.get(i).intValue();
				}
			}
		}
		return result;
		
	}
}
