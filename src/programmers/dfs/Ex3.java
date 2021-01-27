package programmers.dfs;

public class Ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String begin="hit";
		String target="cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		solution(begin,target,words);
	}
    
	public static boolean[] visited ;
	public static int cnt ;
	
	public static int solution(String begin, String target, String[] words) {
    	visited = new boolean[words.length];
    	
    	for(int i=0;i<words.length;i++) {
    		// 방문한적 없고, target과 일치하지 않는 경우
    		if(!visited[i] && !words[i].equals(target)) {
    			dfs(words, begin, target, words[i], i);
    		}
    	}
    	
    	// 변환 불가능 한 경우
    	if(cnt == words.length) {
    		return 0;
    	}
    	System.out.println(cnt);
    	return cnt;
    }
    public static void dfs(String[] words, String begin, String target, String word, int idx) {
    	
    	// 한글자만 다른지 체크
    	int change = 0;
    	for(int i=0;i<begin.length();i++) {
    		if(word.charAt(i) != begin.charAt(i))	
    			change ++;
    	}
    	
    	// 변경이 가능한 경우
    	if(change == 1 && !visited[idx]) {
    		cnt ++;
    		visited[idx] = true;
    		dfs(words, word, target, words[idx+1], idx+1);
    		
    	}
    	
    }
    
}
