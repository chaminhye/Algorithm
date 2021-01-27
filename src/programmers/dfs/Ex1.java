package programmers.dfs;

public class Ex1 {

	static boolean[][] visited =null;
	static int[][] arr =null;
	static int answer = 0;
	static int n =0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		
		n = numbers.length;
		arr = new int[n][(int)Math.pow(2,n)];
		visited = new boolean[n][n];
		
		solution(numbers, target);
//		solution2(numbers, target);
	}

	public static int solution(int[] numbers, int target) {
		arr[0][0] = 1;
		for(int i=1;i<n;i++) {
			for(int j=0;j<Math.pow(2, i);j++) {
				if(j % 2==0) {
					arr[i][j]=-1;
				}else {
					arr[i][j]=1;
				}
				System.out.print("arr["+i+"]["+j+"] : "+arr[i][j]+ "   ");
			}
			System.out.println();
		}
		dfs(0,0, 0);
		return answer;
	}
	
	// 인접행렬로 구현하는 dfs
	public static void dfs(int v, int w, int sum) {
		visited[v][w] = true;
		sum = arr[v][w];
		
		for(int i=v;i<n;i++) {
			for(int j=w;j<n;j++) {
				sum = arr[v][w];
				dfs(v+1, w, sum);
			}
		}
		
	}
	
}
