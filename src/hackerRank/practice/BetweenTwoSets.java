package hackerRank.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 	문제 풀이 링크
 * 	->	https://www.hackerrank.com/challenges/between-two-sets/problem?isFullScreen=true
 * 	
 * 	문제 KeyPoint
 * 		문제 자체를 이해하는데 집중해야함★☆ (문제 이해하는게 너무 힘들었던 문제)
 * 		a는 최소공배수를 구하고, b에서는 최대공약수를 구하여
 * 			a의 배수이면서 b의 약수인 개수를 구하는 문제이다.
 * 	예외처리
 * 		100 이하의 수만 가능하다점.
 * 
 * */
public class BetweenTwoSets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> a = new ArrayList<Integer>();
		a.add(2);
		a.add(4);
		List<Integer> b = new ArrayList<Integer>();
		b.add(16);
		b.add(32);
		b.add(96);
		getTotalX(a,b);
	}
	
	public static int getTotalX(List<Integer> a, List<Integer> b) {
        int lcm_a = a.get(0);
        int gcd_b = b.get(0);
        
        for(int i=0;i<a.size() && lcm_a <= 100;i++){		// lcm_b가 100 이하의 값이라는 제약조건 필수 -> runtime error 발생
            lcm_a = lcm(lcm_a, a.get(i));
        }
        
        for(int i=0;i<b.size();i++){
            gcd_b = gcd(gcd_b, b.get(i));
        }
        int cnt = 0;
        
        // 최대공약수가 100보다 크거나,  최소공배수가 0이거나, 최소공배수가 최대공약수보다 큰 경우 return 0 
        if(lcm_a > 100 || gcd_b ==0 || (lcm_a>gcd_b)){
            return 0;
        }
        
        
        for(int i=lcm_a;i<=gcd_b;i=i++){
            if((gcd_b % i == 0) && (i % lcm_a == 0)){
                cnt++;
            }
        }
        // System.out.print(lcm_a + "/ "+gcd_b);
        return cnt;
	}
	
	// 유클라드 호제법 이용
	// 최대 공약수 구하기
    public static int gcd(int a, int b){
        while(b!=0){
            int r =a%b;
            a=b;
            b=r;
        }
        return a;
    }
    
    // 최소공배수 구하기
    public static int lcm(int a, int b){
        return a*b/gcd(a,b);
    }
}
