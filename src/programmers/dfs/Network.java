package programmers.dfs;

/**
 * 
 * 문제 설명
		네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다. 예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고, 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다. 따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.
		
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
    	https://beaniejoy.tistory.com/41
 * */

public class Network {
	static boolean[][] visited;
	
	public static void main(String args[]) {
		int result = solution(3,new int[][] {{1,1,0},{1,1,0},{0,0,1}});
		System.out.println(result);
	}
	
	public static int solution(int n, int[][] computers) {
		int answer = 0;
		visited = new boolean[n][n];		// false로 초기화, 인접행렬로 접근
		
		for(int i=0; i<n; i++) {
			// 방문하지 않은 노드가 있다면, dfs 호출과 동시에 네트워크 수 +1 증가
			if(!visited[i][i]) {
//				System.out.println("solution "+ i);
				dfs(i, n ,computers);
				answer ++;
			}
		}
		return answer;
	}
	
	public static void dfs(int start, int n, int[][] computers) {

		for(int i=0;i<n;i++) {
			// 조건 1. computers[][] == 1
			// 조건 2. 방문하지 않은 노드
			if(computers[start][i] == 1 && !visited[start][i]) {
				visited[start][i] = visited[i][start] = true;
//				System.out.println("		visited["+start+"]["+i+"] : "+visited[start][i]);
				dfs(i, n ,computers);
			}
		}
	}
}
