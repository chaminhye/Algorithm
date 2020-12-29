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
 *      4. long 타입.........주의 모든 w*h계산식엔 다 long 타입변환!!
 *      
 *  자세한 문제 풀이 내용은   
 *  	-> https://velog.io/@ming/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%A9%80%EC%A9%A1%ED%95%9C-%EC%82%AC%EA%B0%81%ED%98%95Level-2
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
        long wl = (long) w;			// 모든 계산을 long타입으로 하기 위해 미리 형변환
        long hl = (long) h;
        
        if(wl == hl){				// 가로= 세로 길이가 같은 정사각형 인 경우 가로갯수만큼만 제외하면 됨
            return (wl*hl) - wl ;
        }
        
        long r = gcd(wl,hl);		// 최대공약수
        
        // 직사각형(w*h)의 넓이 - (제거할 사각형의 개수 * 최대공약수 개수)
        answer = wl*hl  - ((wl/r) + (hl/r) -1 ) * r;
        
		return answer;
	}
	
	/** 유클리드 호제법 - 최대공약수 구하기 */
    public static long gcd(long w, long h){
        while(h!=0){
            long r= w%h;
            w=h;
            h=r;
        }
        return w;
    }
}
