package programmers.stackQueue;

import java.util.ArrayList;
import java.util.List;

public class Stack3 {

	public static void main(String args[]) {
//		int[] progresses = {93,30,55};
//		int[] speeds = {1,30,5};
//		int[] progresses = {56, 40, 20, 80};
//		int[] speeds = {10, 20, 5, 25};
		int[] progresses = {40, 93, 30, 55, 60, 65};
		int[] speeds = {60, 1, 30, 5 , 10, 7};
		int[] workingDay = new int[progresses.length];
		int working= 0;

        List<Integer> list = new ArrayList<Integer>();
        

     // progresses 별 필요한 작업일수
		for(int i=0; i< progresses.length; i++) {
			working = (100 - progresses[i]) ;
			workingDay[i] = working % speeds[i] == 0? working / speeds[i] : (working / speeds[i]) +1;
			System.out.println("workingDay["+i+"] : "+workingDay[i]);
		}

		int cnt = 0;

		for(int i=0; i<workingDay.length; i++) {
			if(i==0) {
				cnt = 1;
			}
			for(int j =i+1; j<workingDay.length; j++) {
				if(workingDay[i] >= workingDay[j]) {
					System.out.println("if : workingDay["+i+"] : "+ workingDay[i] + "/ workingDay["+j+"] : "+workingDay[j]);
					cnt += 1;
					if(j == workingDay.length-1) {
						list.add(cnt);
					}
					break;
				}else {
					System.out.println("else : workingDay["+i+"] : "+ workingDay[i] + "/ workingDay["+j+"] : "+workingDay[j]);
					list.add(cnt);
					System.out.println("else cnt : "+ cnt);
					cnt = 1;
					if(j == workingDay.length-1) {
						list.add(1);
					}
					break;
				}
			}
		}
		int[] answer = new int[list.size()];
System.out.println(list);
		for(int i=0; i<list.size(); i++) {
			answer[i]=list.get(i);
			System.out.println(answer[i]);
		}
		
    }
}