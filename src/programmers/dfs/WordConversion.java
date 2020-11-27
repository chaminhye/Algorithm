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
 * 
 * */
public class WordConversion {
	static int answer = 0;
	static boolean[] used;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"});
		System.out.println(result);
	}
	
	public static int solution(String begin, String target, String[] words) {
		answer = words.length+1;			// words에 맞는 단어가 없는 것을 체크하기 위해  words.length+1로 셋팅	
		used = new boolean[words.length];	// 모두 false로 초기화
		dfs(begin, target, 0, words);
		
		return answer == words.length+1 ? 0 : answer;
	}

	public static void dfs(String word, String target, int count, String[] words) {
		// 현재 단어와 target이 같으면 return
		if(word.equals(target)) {
			answer = Math.min(answer , count);
			return;
		}

		// 탐색한 글자중 하나만 차이나고 , 탐색되지 않은 경우 dfs 호출
		for(int i=0; i<words.length;i++) {
			if(!used[i] && spellCheck(word, words[i])) {
				used[i] = true;
//				System.out.println("	words["+i+"] : "+words[i] + "- count : "+count);
				dfs(words[i], target, count+1, words);
				used[i] = false;
			}
		}
	}
	
	// 한번에 한글자만 바꾸는 것이 가능하므로, 현재 단어와 다음 단어가 하나만 다른지 체크
	public static boolean spellCheck(String word, String nextWord) {
		int count = 0;
		for(int i=0;i<word.length();i++) {
			// word.length == nextWord.length 같은수 밖에 없으므로,
			if(word.charAt(i) != nextWord.charAt(i)) {
				count++;
			}
		}
		return count==1 ? true : false;
	}
}
