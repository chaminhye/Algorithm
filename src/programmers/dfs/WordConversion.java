package programmers.dfs;

/**
 * 문제 설명
		두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.
		
		1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
		2. words에 있는 단어로만 변환할 수 있습니다.
		예를 들어 begin이 hit, target가 cog, words가 [hot,dot,dog,lot,log,cog]라면 hit -> hot -> dot -> dog -> cog와 같이 4단계를 거쳐 변환할 수 있습니다.
		
		두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.
		
	제한사항
		각 단어는 알파벳 소문자로만 이루어져 있습니다.
		각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
		words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
		begin과 target은 같지 않습니다.
		변환할 수 없는 경우에는 0를 return 합니다.

	입출력 예
		begin	target	            words	                return
		hit	     cog	  [hot, dot, dog, lot, log, cog]	   4
		hit	     cog	  [hot, dot, dog, lot, log]	           0

	입출력 예 설명
		예제 #1
		문제에 나온 예와 같습니다.
		
		예제 #2
		target인 cog는 words 안에 없기 때문에 변환할 수 없습니다.
	
	문제 풀이
		https://velog.io/@ming/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%8B%A8%EC%96%B4%EB%B3%80%ED%99%98Level-3
 * 
 * */
public class WordConversion {
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
