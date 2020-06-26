package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Greedy1 {
	
	public static void main(String args[]) {
		int n = 5;
		int[] lost = {2,4};
		int[] reserve = {1,3,5};
		
//		List<Integer> lostList = new ArrayList<Integer>(Arrays.asList(lost));
		List<Integer> reserveList = new ArrayList<>();
		List<Integer> studentList = new ArrayList<>();
		for(int i=1; i<= n; i++) {
			studentList.add(i);
		}

		for(int i=0; i<lost.length; i++) {
			for(int j=0; j<reserve.length;j++) {
				if(lost[i] == reserve[j] +1 || lost[i] == reserve[j] -1) {
					
				}
			}
		}
		
	}
}
