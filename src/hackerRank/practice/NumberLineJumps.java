package hackerRank.practice;


/**
 * 문제 풀이 링크
 * 	-> https://www.hackerrank.com/challenges/kangaroo/problem?isFullScreen=true
 * 
 * 	문제 KeyPoint
 * 		1. 캥거루1, 캥거루2가 무조건 같은 n번 점프를 해야하므로, 
 *          계산식은   x1 + (v1 * n) = x2 + (v2 *n)
 *      2. n 번의 횟수를 찾는것은 비효율적이다.( 점프횟수 제한이 있는것도 아니고, 될때까지 찾기에는 계산이 낭비적임)
 *          1번의 계산식을 잘 활용해보면    n = (x2-x1) / (v1-v2) 
 *      3. 2번의 계산식에 나머지 연산을 적용해보면, 결국 나머지는 0이 된다.  
 *          고로 나머지가 0이 된다면, YES   
 *   예외처리       
 *      1. 문제에서 x2>x1 && v2>v1 은 NO라고 예외상황이 나와있다.
 *      2. 0으로는 나눌수가 없다. 고로 v1 ==v2가 같은경우는 "NO"
 * 
 */
public class NumberLineJumps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(kangaroo(0, 2, 5, 3));		// NO
		System.out.println(kangaroo(0, 3, 4, 2));		// YES
	}

	public static String kangaroo(int x1, int v1, int x2, int v2) {
        String ans = "";
        if(x2>x1 && v2>v1){
            return "NO";
        }
        if((x2-x1) % (v1-v2) == 0){
            ans = "YES";
        }else{
            ans = "NO";
        }
        return ans;
    }
}
