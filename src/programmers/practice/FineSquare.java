package programmers.practice;


/**
 * 	문제 풀이 링크
 * 		https://programmers.co.kr/learn/courses/30/lessons/62048
 * 	
 * 	문제 KeyPoint
 * 		1. 가로와 세로의 비율로 먼저 접근해서 부분영역으로 생각해봄.
 *  	2. 최대공약수라는 힌트를 얻었지만, 그래서,,,그 다음은 뭐..지?
 *      3. 제거 해야되는 사각형의 규칙을 구하자!! (아래 블로그 참고)
 *      	https://m.blog.naver.com/tlstjd436/221849619470
 * */
public class FineSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution(8,12);
	}
	
	public static long solution(int w, int h) {
		long answer = 1;
		
        if(w == 1 || h == 1){		// 가로 또는 세로의 길이가 1인경우 사각형의 개수 0
            return 0;
        }
        if(w == h){					// 가로= 세로 길이가 같은 정사각형 인 경우 가로갯수만큼만 제외하면 됨
            return (w*h) - w ;
        }
        
        long r = gcd((long)w,(long)h);
        
        answer = w*h  - ((w/r) + (h/r) -1 ) * r;
        
		return answer;
	}
	
    public static long gcd(long w, long h){
        while(h!=0){
            long r= w%h;
            w=h;
            h=r;
        }
        return w;
    }
}
