package programmers.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class Ex2 {

	static boolean visited[][] ;
	static boolean visited_bfs[] ;
	static int line = 0;
	public static void main(String args[]) {
//		int result = solution(3,new int[][] {{1,1,0},{1,1,0},{0,0,1}});
//		System.out.println(result);
		int result1 = solution1(3,new int[][] {{1,1,0},{1,1,0},{0,0,1}});
		System.out.println(result1);
	}
	
	public static int solution(int n, int[][] computers) {
		if(n==1) {
			return 1;
		}

		int answer=0;
		visited = new boolean[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				// i==j는 무조건 1이므로 패스
				if(!visited[i][j] ) {
					System.out.println("sol :: i : "+i +" / j : "+j);
					answer++;
					dfs(computers, i ,j);
				}
			}
		}
		dfs(computers, 0,0);
		return answer;
	}

	public static void dfs(int[][] computers, int s, int e) {
		// 인접행렬은 대칭이므로, true 처리
		visited[s][e]=visited[e][s]=true;
		int len = computers.length;

		// s와 e가 연결된 간선이라 생각하여, 아직 방문하지 않은 e,i점으로 시작하는 방문점을 찾는다. 
		for(int i=0;i<len;i++) {
			if(computers[e][i] == 1 && !visited[e][i] ){
				System.out.println("	call :: s : "+e +"  e : "+i);
				dfs(computers, e, i);
			}
		}
	}
	////////////////////////////////////////////////////////////////////
	
	
	public static int solution1(int n, int[][] computers) {
		if(n==1) {
			return 1;
		}
		
		int answer=0;
		visited = new boolean[n][n];
/*		
		for(int i=0;i<n;i++) {
			// 시작점은 (0,0) ... (n,n)
			if(!visited[i][i]) {
				System.out.println("====================================");
				dfs1(computers, i);
				answer++;			// 한번 호출하는 경우, 네트워크수 +1 증가한다고 봐야함.
									// 왜냐하면, 다 연결되어 있다면 , for문이 더 이상 반복되지 않기 때문	
			}
		}
		*/
		
		visited_bfs = new boolean[n];
		for(int i=0;i<n;i++) {
			// 시작점은 (0,0) ... (n,n)
			if(!visited_bfs[i]) {
				System.out.println("====================================");
				bfs(computers, i);
				answer++;			// 한번 호출하는 경우, 네트워크수 +1 증가한다고 봐야함.
				// 왜냐하면, 다 연결되어 있다면 , for문이 더 이상 반복되지 않기 때문	
			}
		}
		return answer;
	}
	
	public static void dfs1(int[][] computers, int s) {
		int len = computers.length;
		
		for(int i=0;i<len;i++) {
			if(computers[s][i] == 1 && !visited[s][i] ){
				visited[s][i]=visited[i][s]=true;
				System.out.println("s : "+s+ "/ i : "+i);
				dfs1(computers, i);
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
					System.out.println("s : "+v+ "/ i : "+i);
					q.offer(i);
					visited_bfs[i] = true;
				}
			}
		}
		
	}
}
