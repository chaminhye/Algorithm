package programmers.dfs;

public class Ex3_1 {

	static boolean[] visited;		// 방문 여부 체크
	static int answer;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String begin="hit";
		String target="cog";
//		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		String[] words = {"hot", "dot", "dog", "lot", "log"};
		System.out.println("sol : "+solution(begin,target,words));
	}
	
	public static int solution(String begin, String target, String[] words) {
		visited = new boolean[words.length];
		answer = words.length;			// 단어 변환이 불가능한 경우를 생각하여, words 배열 크기만큼 초기화
		dfs(words, begin, target, 0);
//		System.out.println("::  / answer : "+answer);
//		System.out.println("::  /  words.length : "+ words.length);
		return answer == words.length ? 0 : answer;
	}
	
	public static void dfs(String[] words, String begin, String target, int count) {
		// 종료시점은 begin , target이 같은 경우( 단어변환이 불가능한 경우, 재귀호출이 종료된다)
		if(begin.equals(target)) {
			answer = Math.min(answer, count);
			return;
		}
		
		for(int i=0;i<words.length;i++) {
			if(wordCheck(begin, words[i]) && !visited[i]) {
				visited[i] = true;
				System.out.println("	  i : "+i+" :: begin : "+begin+" / words: "+  words[i]);
				dfs(words, words[i], target, count+1); 
				// 현재 단어로 dfs를 탐색했다면, 방문여부를  false로 처리해준다. 
				visited[i]=false;
			}
		}
	}
	
	// 한 글자만 다른지 체크
	public static boolean wordCheck(String a, String b) {
		int cnt = 0;
		for(int i=0;i<a.length();i++) {
			if(a.charAt(i) != b.charAt(i)) cnt++;
		}
		return cnt==1 ? true : false;
	}
}
