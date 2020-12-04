package programmers.dynamic;

/**
 * 문제 설명
	
	         7
	       3  8
	      8  1  0
	     2  7  4  4
	    
	    4  5 2  6  5  	
		위와 같은 삼각형의 꼭대기에서 바닥까지 이어지는 경로 중, 거쳐간 숫자의 합이 가장 큰 경우를 찾아보려고 합니다. 아래 칸으로 이동할 때는 대각선 방향으로 한 칸 오른쪽 또는 왼쪽으로만 이동 가능합니다. 예를 들어 3에서는 그 아래칸의 8 또는 1로만 이동이 가능합니다.
		
		삼각형의 정보가 담긴 배열 triangle이 매개변수로 주어질 때, 거쳐간 숫자의 최댓값을 return 하도록 solution 함수를 완성하세요.
		
	제한사항
		삼각형의 높이는 1 이상 500 이하입니다.
		삼각형을 이루고 있는 숫자는 0 이상 9,999 이하의 정수입니다.
		
	입출력 예
		triangle	                                                result
		[[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]	      30
		
	문제 풀이 참고
		https://lkhlkh23.tistory.com/117
		
		★★ 동적계획법 Point
		  -> 중복계산을 피해라
	  
  	요약 
  		int[][] dp 배열을 이용하여 거처간 합을 저장한다.
  		아래의 두가지 식으로, 계산을 진행
  		1. dp[i][0] = dp[i-1][0] + triangle[i][0];		-> dp[i][0] 0번째 열은 모두 계산을 할 필요가 없다. 제외해도 무방
		2. 우선적으로 초기화 진행 dp[i][i] = dp[i-1][i-1] + triangle[i][i];
			2-1. 어떤 값이 더 큰지 비교하여 계산
			     dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i-1][j]) + triangle[i][j];
			
*/

public class IntegerTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] triangle = {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
		int ans = solution(triangle);
        System.out.println(ans);
    	// 완전탐색 풀이법        
//		int answer = dfs(triangle,0,0);
//        System.out.println(answer);
	}

	// DP 풀이법
    public static int solution(int[][] triangle) {
        // 길이
        int len = triangle.length;
        int[][] dp = new int[len][len];
        
        // 무조건 최상위 노드로 설정
        dp[0][0] = triangle[0][0];
        
        // 1. 초기화
        // 우선 dp[i][i] =  dp[i-1][i-1] + dp[i][i]으로만 초기화
        for(int i=1;i<len;i++){
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
        }
        
        // 2. 동적계획법(선택이 가능한 2depth 부터 시작)
        // dp[i][0]은 변하지 않음,
        // 둘중에 더 큰 값을 선택하는 과정 dp[i-1][j-1] , dp[i-1][j]
        for(int i=2;i<len;i++){
            for(int j=1;j<i;j++){
                dp[i][j] = Math.max(dp[i-1][j-1] , dp[i-1][j]) + triangle[i][j];
            }
        }
        
        // 3. 최대값 구하기
        int max = 0;
        for(int i=0;i<len;i++){
            max = Math.max(max,dp[len-1][i]);
            
        }
        
        return max;
    }
    
    
    // 완전탐색 풀이법 -> 효율성 fail
    public static int dfs(int[][] triangle, int index, int depth) {
		if(depth >= triangle.length) {
			return 0;
		}
    	return triangle[depth][index] +  Math.max(dfs(triangle, index, depth + 1), dfs(triangle, index + 1,depth + 1));
    }

}
