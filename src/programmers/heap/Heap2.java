package programmers.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 문제 설명
		하드디스크는 한 번에 하나의 작업만 수행할 수 있습니다. 디스크 컨트롤러를 구현하는 방법은 여러 가지가 있습니다. 가장 일반적인 방법은 요청이 들어온 순서대로 처리하는 것입니다.
		
		예를들어
		
		- 0ms 시점에 3ms가 소요되는 A작업 요청
		- 1ms 시점에 9ms가 소요되는 B작업 요청
		- 2ms 시점에 6ms가 소요되는 C작업 요청
		와 같은 요청이 들어왔습니다. 이를 그림으로 표현하면 아래와 같습니다.
		Screen Shot 2018-09-13 at 6.34.58 PM.png
		
		한 번에 하나의 요청만을 수행할 수 있기 때문에 각각의 작업을 요청받은 순서대로 처리하면 다음과 같이 처리 됩니다.
		Screen Shot 2018-09-13 at 6.38.52 PM.png -> FIFO: First In First Out, A -> B -> C
		
		- A: 3ms 시점에 작업 완료 (요청에서 종료까지 : 3ms)
		- B: 1ms부터 대기하다가, 3ms 시점에 작업을 시작해서 12ms 시점에 작업 완료(요청에서 종료까지 : 11ms)
		- C: 2ms부터 대기하다가, 12ms 시점에 작업을 시작해서 18ms 시점에 작업 완료(요청에서 종료까지 : 16ms)
		이 때 각 작업의 요청부터 종료까지 걸린 시간의 평균은 10ms(= (3 + 11 + 16) / 3)가 됩니다.
		
		하지만 A → C → B 순서대로 처리하면
		Screen Shot 2018-09-13 at 6.41.42 PM.png -> 하드디스크 작업이 끝난 후 가장 짧은 작업 먼저 처리할 경우(SJF: Short Job First, A -> C -> B)
		
		- A: 3ms 시점에 작업 완료(요청에서 종료까지 : 3ms)
		- C: 2ms부터 대기하다가, 3ms 시점에 작업을 시작해서 9ms 시점에 작업 완료(요청에서 종료까지 : 7ms)
		- B: 1ms부터 대기하다가, 9ms 시점에 작업을 시작해서 18ms 시점에 작업 완료(요청에서 종료까지 : 17ms)
		이렇게 A → C → B의 순서로 처리하면 각 작업의 요청부터 종료까지 걸린 시간의 평균은 9ms(= (3 + 7 + 17) / 3)가 됩니다.
		
		각 작업에 대해 [작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 배열 jobs가 매개변수로 주어질 때, 작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면 평균이 얼마가 되는지 return 하도록 solution 함수를 작성해주세요. (단, 소수점 이하의 수는 버립니다)
		
	제한 사항
		jobs의 길이는 1 이상 500 이하입니다.
		jobs의 각 행은 하나의 작업에 대한 [작업이 요청되는 시점, 작업의 소요시간] 입니다.
		각 작업에 대해 작업이 요청되는 시간은 0 이상 1,000 이하입니다.
		각 작업에 대해 작업의 소요시간은 1 이상 1,000 이하입니다.
		하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터 처리합니다.
		
	입출력 예
		jobs	                  return
		[[0, 3], [1, 9], [2, 6]]	9
		
	입출력 예 설명
		문제에 주어진 예와 같습니다.
		
		0ms 시점에 3ms 걸리는 작업 요청이 들어옵니다.
		1ms 시점에 9ms 걸리는 작업 요청이 들어옵니다.
		2ms 시점에 6ms 걸리는 작업 요청이 들어옵니다.
 */

public class Heap2 {
	public static int solution(int[][] jobs) {
		int answer = 0;

		/**
		 *  Check Point
			- 일반 Queue : FIFO (First In First Out)
			- PriorityQueue : 우선순위가 높은 엘리먼트가 먼저 나가는 자료구조.
				 1.디스크가 작업을 수행하지 않으면 무조건 들어온 순서대로!
				 2.디스크가 작업을 수행중이라면, 작업시간이 적은순대로 일처리를 해야한다.
				 
			풀이 참고 :	 https://junboom.tistory.com/24
		 */
		
		int length = jobs.length;
		int time = 0;
		int idx = 0;
		
		// 작업 처리시간을 오름차순으로 정렬하는 우선순위큐 생성
		// ★ Queue를 int[] 배열 값으로 생성가능
		Queue<int[]> q = new PriorityQueue<>((o1,o2)-> o1[1] - o2[1]);

		// 요청 시간 순대로 정렬
		Arrays.sort(jobs, (o1,o2) -> o1[0] - o2[0]);
		
		// jobs의 길이만큼 , q가 비어있지 않는 조건
		while(idx < length || !q.isEmpty()) {
			// 현재 디스크가 작업가능한 경우, q에 jobs[] 데이터 담기
			while(idx < length && jobs[idx][0] <= time) {
				q.offer(jobs[idx]);
				idx++;
//				System.out.println(q.peek()[0] + "/ "+q.peek()[1]);
			}
//			System.out.println("--------------------------------------");
			
			if(q.isEmpty()) {
				time = jobs[idx][0];
			}else {
				int[] job = q.poll();
				answer += time - job[0] + job[1];			//job[0] : 요청시간 / job[1] : 수행시간
				time += job[1];
			}
		}
		
		return answer / length;
	}
	
	static public void main(String args[]) {
		int[][] jobs = {{0,3},{1,9},{2,6}};
		int result = 0;
		
		System.out.println(solution(jobs));
		
	}
	
	// ------------------------------------------------------------------------
	public static int solution_ing(int[][] jobs) {
		
       PriorityQueue<Job> priorityQueue = new PriorityQueue<>();
        int nothing = 0; 		
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
        
		return (int)totalTime / jobs.length;
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










