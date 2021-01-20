package programmers.dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * 문제 설명
		네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다. 
		예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고, 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다. 따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.
		
		컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.
		
     제한사항
		컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다.
		각 컴퓨터는 0부터 n-1인 정수로 표현합니다.
		i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
		computer[i][i]는 항상 1입니다.
     
     입출력 예
		n	           computers	           return
		3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	 2
		3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	 1
		
    문제풀이 참고
    	dfs 알고리즘 사용
    	https://jayrightthere.tistory.com/entry/DFSJAVA-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC
    	
    문제풀이 설명
        https://velog.io/@ming/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%ACLevel-3

 * */

public class Network {
	static boolean[][] visited;
	static boolean visited_bfs[];
	
	public static void main(String args[]) {
		int dfs = solution_dfs(3,new int[][] {{1,1,0},{1,1,0},{0,0,1}});
		int bfs = solution_bfs(3,new int[][] {{1,1,0},{1,1,0},{0,0,1}});
		System.out.println("dfs : "+dfs);
		System.out.println("bfs : "+bfs);
	}
	
	
	public static int solution_dfs(int n, int[][] computers) {
		if(n==1) {return 1;}
		
		int answer=0;
		visited = new boolean[n][n];
		
		for(int i=0;i<n;i++) {
			// 시작점은 (0,0) ... (n,n)
			if(!visited[i][i]) {
//				System.out.println("====================================");
				dfs(computers, i);
				answer++;			// 한번 호출하는 경우, 네트워크수 +1 증가한다고 봐야함.
									// 왜냐하면, 다 연결되어 있다면 , for문이 더 이상 반복되지 않기 때문	
			}
		}
		
		return answer;
	}
	public static int solution_bfs(int n, int[][] computers) {
		if(n==1) {return 1;}
		
		int answer=0;
		visited_bfs = new boolean[n];
		
		for(int i=0;i<n;i++) {
			// 시작점은 (0,0) ... (n,n)
			if(!visited_bfs[i]) {
//				System.out.println("====================================");
				bfs(computers, i);
				answer++;			// 한번 호출하는 경우, 네트워크수 +1 증가한다고 봐야함.
				// 왜냐하면, 다 연결되어 있다면 , for문이 더 이상 반복되지 않기 때문	
			}
		}
		return answer;
	}
	
	public static void dfs(int[][] computers, int s) {
		int len = computers.length;
		
		for(int i=0;i<len;i++) {
			if(computers[s][i] == 1 && !visited[s][i] ){
				visited[s][i]=visited[i][s]=true;
//				System.out.println("s : "+s+ "/ i : "+i);
				dfs(computers, i);
			}
		}
	}
	
	public static void bfs(int[][] computers, int s) {
		int len = computers.length;
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(s);
		visited_bfs[s] = true;
		
		while(!q.isEmpty()) {
			int v = q.poll();
			
			for(int i=0;i<len;i++) {
				if(computers[v][i] ==1 && !visited_bfs[i]) {
//					System.out.println("s : "+v+ "/ i : "+i);
					q.offer(i);
					visited_bfs[i] = true;
				}
			}
		}
		
	}
}
