package heap;

import java.util.PriorityQueue;

public class Heap4 {
	
	static public void main(String args[]) {
		String[] operations = {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"}; 
//		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
//		String[] operations = {"I 16","I 6", "D 1","I 160"};
		int[] answer = new int[2];
		
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int max = 0;
        int min = 0;
        int number = 0;
        int temp = 0;
		for(String str : operations) {
			number = Integer.parseInt(str.substring(2, str.length()));
			
			if(str.contains("I")) {				// I : 큐에 주어진 숫자를 삽입	
				queue.offer(number);
				if( number > max) {
					temp = min;
					//min = number;
					max = number;
				}else {
					temp = min;
					min = number;
					//max = temp;
				}
				System.out.println("min : "+min+ " / max : " + max+ " / number : " + number);
			}else if(str.contains("D -1")){		// D -1 : 큐에서 최솟값 삭제 
				System.out.println("	min : "+ min);
				if(!queue.isEmpty()) {
					queue.remove(min);
					min = max;
				}
			}else if(str.contains("D 1")){								// D 1 : 큐에서 최댓값 삭제
				System.out.println("	max : "+ max);
				if(!queue.isEmpty()) {
					queue.remove(max);
					max = min;
				}
			}
			
			if(queue.isEmpty()) {				// 큐가 비어 있는 경우
				queue.offer(0);
			}
		}
		System.out.println("queue cnt : "+queue.size());
		System.out.println("queue : "+queue);
		
		if(queue.size() == 0) {
			answer[0] = 0;
			answer[1] = 0;
		}else {		
			answer[1] = queue.poll();
			while(!queue.isEmpty()) {
				queue.poll();
				if(queue.size() == 1) {
					answer[0] = queue.poll();
				}				
			}
			
			System.out.println(answer[0]);
			System.out.println(answer[1]);
		}
		
//        Queue<Operation> queue = new LinkedList<>();
//        PriorityQueue<Integer> priorityQ = new PriorityQueue<>();
//        
//		for(String str : operations) {
//			queue.offer(str);
//		}
//		System.out.println(queue);
//		
//		while(!queue.isEmpty()) {
//			
//		}
		
	}
	
}