package programmers.sort;

import java.util.Arrays;
import java.util.Comparator;

/*
	풀이 방법
		DFS로 순열 표현 ->메모리, 시간초과 (해당 문제는 DFS는 적합하지 않음)
*/
public class LargestNumber_DFS {
	static String maxStr = "";

	public static void main(String args[]) {
		int[] numbers = {3, 30, 34, 5, 9};
		System.out.println("answer : " +solution(numbers));
	}

	public static String solution(int[] numbers) {
		int len = numbers.length;
		String[] strs = new String[len];
		for(int i=0;i<len;i++){
			strs[i] = Integer.toString(numbers[i]);
		}
		boolean[] visited = new boolean[numbers.length];
		Arrays.fill(visited, false);
		for(int i=0;i<len;i++){
			permutation_dfs(strs, "", visited, i,0 );
			System.out.println("-------------------------------------");
		}
		return maxStr;
	}

	public static void permutation_dfs(String[] arr, String str, boolean[] visited, int n, int depth){
		if(depth == arr.length){
			maxStr = maxStr.compareTo(str)  > 0 ? maxStr : str ;
			System.out.println("str : "+str + " / maxStr : "+maxStr);
			return;
		}

		for(int i=0; i<arr.length; i++){
			if(!visited[i]){
				visited[i]=true;
				str += arr[i];
				System.out.println("str : "+str + " / arr["+i+"] : "+arr[i]);
				permutation_dfs(arr, str, visited, i, depth+1);
				str = str.substring(0, str.length()-arr[i].length());
				visited[i]=false;
			}
		}
	}
}
