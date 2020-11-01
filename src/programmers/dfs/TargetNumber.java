package programmers.dfs;

/**
 * 
 * 문제 설명
		n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
		
		-1+1+1+1+1 = 3
		+1-1+1+1+1 = 3
		+1+1-1+1+1 = 3
		+1+1+1-1+1 = 3
		+1+1+1+1-1 = 3
		사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.
		
	제한사항
		주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
		각 숫자는 1 이상 50 이하인 자연수입니다.
		타겟 넘버는 1 이상 1000 이하인 자연수입니다.
		
	입출력 예
		numbers	         target	 return
		[1, 1, 1, 1, 1]	    3	   5
		
	문제풀이 참고 : https://lkhlkh23.tistory.com/74
	    
		DFS : Root Node 혹은 다른 임의의 Node에서 다음 분기(Branch)로 넘어가기 전에 해당 분기를 완벽하게 탐색하는 방법이다.
		      ★ Stack 혹은 재귀함수(Recursion)으로 구현된다.
		(개념참고 : https://developer-mac.tistory.com/64)      
		
		- 경로를 탐색할 때 한 방향으로 갈 수 있을 때까지 계속 가다가 더 이상 갈 수 없게되면 다른 방향으로 다시 탐색을 진행
		- 모든 노드를 방문하는 경우에 이 방법을 사용한다.
		
*/


public class TargetNumber {

	public static void main(String args[]) {
		int numbers[] = {1,1,1,1,1};
		int target = 3;
		int answer = 0;
		answer = dfs(numbers, 0,0,target);
		System.out.println(answer);
		
	}
	
	public static int dfs(int[] numbers, int node, int sum, int target) {
//		System.out.println("node :"+node +" / sum : "+sum);
		// 종료조건은 모든 깊이 즉, 배열에 모든 요소를 접근했을 때이다.
		if(node == numbers.length) {
			if(sum == target) {
//				System.out.println("here");
				return 1;
			}else {
				return 0;
			}
		}
		
		// 그렇지 않은 경우 , 인덱스를 더할지 뺄지 모든 경우를 구함
		return dfs(numbers, node+1, sum+numbers[node], target) + dfs(numbers, node+1, sum - numbers[node], target);
		
	}
}
