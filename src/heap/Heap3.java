package heap;

import java.util.PriorityQueue;

public class Heap3 {

	static public void main(String args[]) {
//		int[][] jobs = {{0,3},{4,3},{10,3}};
		int[][] jobs = {{0,10},{4,10},{5,11},{15,2}};
//		int[][] jobs = {{0,3},{1,9},{2,6}};
		
        PriorityQueue<Job> priorityQueue = new PriorityQueue<>();
        int nothing = 0; 		// 일하기 않는 시간
		for(int i=0; i<jobs.length; i++) {
			if(i+1 < jobs.length) {
				if(i + jobs[i][1] < jobs[i+1][0]) {
					System.out.println(" i  : "+  i + " / jobs[i][1] :  " +jobs[i][1] +"  / jobs[i+1][0] : "+ jobs[i+1][0]);
					nothing = jobs[i+1][0] - (jobs[i][0] + jobs[i][1]);
				}else {
					System.out.println("======");
					nothing = i;
				}
			}
			System.out.println("nothing : "+nothing);
			priorityQueue.offer(new Job(nothing, jobs[i][1]));
			
			
		}
        
        int time = 0;
		int totalTime = 0;
		int processTime = 0;
		
        while(!priorityQueue.isEmpty()) {
			time =  priorityQueue.peek().process + time;
			processTime = time - priorityQueue.peek().second;
			totalTime += processTime;
			System.out.println("priorityQueue.peek().process : " +  priorityQueue.peek().process + " / " + "priorityQueue.peek().second : "+priorityQueue.peek().second);
			System.out.println("time : " +  time + " / " + "totalTime : "+totalTime);
			priorityQueue.poll();
		}
        
		System.out.println((int)totalTime / jobs.length);
	}
	
	static class Job implements Comparable<Job>{
		int second;
		int process;
		
		public Job(int second, int process) {
			this.second = second;
			this.process = process;
		}
		
		@Override
		public int compareTo(Job target) {
			return this.process >= target.process ? 1 : -1;
		}
	}
	
}
