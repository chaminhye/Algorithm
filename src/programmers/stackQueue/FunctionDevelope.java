package programmers.stackQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;


/**
 * 문제 설명
		프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
		
		또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
		
		먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
		
	제한 사항
		작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
		작업 진도는 100 미만의 자연수입니다.
		작업 속도는 100 이하의 자연수입니다.
		배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
	
	입출력 예
		progresses	                  speeds	           return
		[93, 30, 55]	              [1, 30, 5]	       [2, 1]
		[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	  [1, 3, 2]
	
	입출력 예 설명
		입출력 예 #1
		첫 번째 기능은 93% 완료되어 있고 하루에 1%씩 작업이 가능하므로 7일간 작업 후 배포가 가능합니다.
		두 번째 기능은 30%가 완료되어 있고 하루에 30%씩 작업이 가능하므로 3일간 작업 후 배포가 가능합니다. 하지만 이전 첫 번째 기능이 아직 완성된 상태가 아니기 때문에 첫 번째 기능이 배포되는 7일째 배포됩니다.
		세 번째 기능은 55%가 완료되어 있고 하루에 5%씩 작업이 가능하므로 9일간 작업 후 배포가 가능합니다.
		
		따라서 7일째에 2개의 기능, 9일째에 1개의 기능이 배포됩니다.
		
		입출력 예 #2
		모든 기능이 하루에 1%씩 작업이 가능하므로, 작업이 끝나기까지 남은 일수는 각각 5일, 10일, 1일, 1일, 20일, 1일입니다. 어떤 기능이 먼저 완성되었더라도 앞에 있는 모든 기능이 완성되지 않으면 배포가 불가능합니다.
		
		따라서 5일째에 1개의 기능, 10일째에 3개의 기능, 20일째에 2개의 기능이 배포됩니다.
	
	문제풀이 참고	
		https://jaebworld.tistory.com/41
 * */
public class FunctionDevelope {

	public static void main(String args[]) {
		int[] progresses = {93,30,55};
		int[] speeds = {1,30,5};
//		int[] progresses = {56, 40, 20, 80};
//		int[] speeds = {10, 20, 5, 25};
//		int[] progresses = {40, 93, 30, 55, 60, 65};
//		int[] speeds = {60, 1, 30, 5 , 10, 7};
		int[] workingDay = solution(progresses, speeds);
		
    }
	
	public static int[] solution(int[] progresses, int[] speeds) {
		List<Integer> list = new ArrayList<>();
		Queue<Integer> q = new ConcurrentLinkedQueue<>();			// ConcurrentLinkedQueue -> https://sungjk.github.io/2016/11/02/Queue.html
		
		for(int i=0;i<progresses.length;i++) {
			int workingDay = ((100 - progresses[i]) % speeds[i]) == 0 ? ((100 - progresses[i]) / speeds[i]) : ((100 - progresses[i]) / speeds[i]) +1; 
			q.offer(workingDay);
		}

		int first = q.poll();
		int cnt = 1;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			
			if(first >= current) {
				cnt ++;
			}else {
				list.add(cnt);
				cnt = 1;
				first = current;			// queue all element peek
			}
		}
		list.add(cnt);
		int[] answer = new int[list.size()];
		for(int i=0;i<list.size();i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
	
	
	/**
	 * 
	    int[] dayOfend = new int[100];
	    int day = -1;
	    for(int i=0; i<progresses.length; i++) {
	        while(progresses[i] + (day*speeds[i]) < 100) {
	            day++;
	        }
	        dayOfend[day]++;
	    }
	    return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
	
	*/
}