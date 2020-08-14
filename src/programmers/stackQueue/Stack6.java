package programmers.stackQueue;

public class Stack6 {

	static public void main(String args[]) {
//		int[] prices = {2, 5, 6, 1, 3};
		int[] prices = {1,2,3,2,3};
		int[] answer = new int[prices.length];
		
        int time = 0;
        
		for(int i=0; i < prices.length; i++) {
			for(int j=i+1; j < prices.length; j++) {

				//System.out.println("prices["+i+"] :" +prices[i] + " / prices["+j+"] : " + prices[j]);				
				if(prices[i] <= prices[j]) {
					time = j-i;
				}else {
					time = j-i;
					break;
				}
				//System.out.println("time : " + time + " / j-i "+ j-i);
			}
			if(i == prices.length-1) {
				answer[i] = 0;
			}else {
				answer[i] = time;
			}

		}
		
		for(int i : answer) {
			System.out.println(i);
		}
	}
}
