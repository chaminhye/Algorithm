package programmers.practice;
/**
 * 	문제 풀이 링크
 * 		https://programmers.co.kr/learn/courses/30/lessons/12909
 *
 * 	문제 KeyPoint
 * 		1. 괄호를 쌍으로 갯수 체크  '('  : +1, '(' : -1
 * 	    2. 	')'로 먼저 시작되는 경우 false로 체크
 *
 * */

public class CorrectParenthesis {

    public static void main(String[] args){
        solution("()))((()");
    }
    public static boolean solution(String s) {
        boolean answer = true;
        int num = 0;

        // (는 +1, ) -1로 계산
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                ++num;
            }else{
                --num;
                if(i == 0){         // 처음 문자가 )로 시작하면 무조건 false
                    return false;
                }
            }
            // )가 먼저 시작되는 경우 return false
            if(num < 0){
                return false;
            }
        }

        // ()의 짝이 안맞는 경우
        if(num != 0){
            return false;
        }
        return answer;
    }
}
