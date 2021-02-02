package programmers.bruteForce;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

/**
	문제 풀이 참고
		https://codevang.tistory.com/299?category=827588
 * */

public class PrimeNumber_ex {
	
	public static TreeSet<String> set = new TreeSet();
	public static int count =0;

	public static void main(String args[]) {
		String numbers="011";
//		String numbers="17";

		// 순서가 있으므로, 순열 알고리즘을 사용해야함
		System.out.println(solution(numbers));
		System.out.println(solution2(numbers));
	}
	
	public static int solution(String numbers) {
		int answer =0 ;
		
		int size = numbers.length();
		
		List<Character> list = new ArrayList<>();
		
		// list에 각 숫자 담기
		for(int i=0; i< size; i++) {
			list.add(numbers.charAt(i));
			System.out.println("list : "+list.get(i));
		}
		
		List<Character> resultList = new ArrayList<>();
		
		//nPr에서 r을 늘려가면서 순열 알고리즘 재귀 호출
		for(int i =0; i< size; i++) {
//System.out.println("    solution-call before");
			permutation(list, resultList, size, i+1);
//System.out.println("    solution-call after");
		}
		return count;
	}
	
	/**
	 * 순열 알고리즘
	 * 
	 * @param list : 원본 리스트 
	 * @param resultList : 결과 리스트
	 * @param n : 전채 갯수 
	 * @param r : 선택할 갯수
	 * */
	public static void permutation(List<Character> list, List<Character> resultList, int n, int r) {
		
//System.out.println("	r :"+r);
		if(r == 0) {
			// 0으로 시작하는 부분집합은 제외
			if(resultList.get(0) != '0') {
				String str = "";
				int size = resultList.size();

				for(int i=0; i< size; i++) {
					System.out.print("	resultList :"+resultList.get(i));
					str += resultList.get(i);
				}
				System.out.println();
				System.out.println("	str : "+str);
				
				int num = 0;
				
				// 중복값을 제거 하기 위함
				if(!set.contains(str)) {
					num = Integer.parseInt(str);
					set.add(str);
					
					//소수 판별
					if(isPrime(num)) {
						count ++;
					}
				}
			}
			return;
		}
		
		for(int i=0; i < n; i++) {
			
			resultList.add(list.remove(i));
System.out.println("--- 	permutaion before i :"+i);
			permutation(list, resultList, n-1, r-1);
System.out.println("---		permutaion after i : "+i);
			list.add(i, resultList.remove(resultList.size()-1));
System.out.println("#                  : "+list.get(i));
			
		}
		
	}
	
	/**
	 *  소수 판별
	 *  
	 *  @param n : 판별할 숫자
	 *  @return true, false
	 * */
	public static boolean isPrime(int n) {
		
		int i;
		int sqrt = (int)Math.sqrt(n);
		
		// 2는 유일한 짝수소수
		if(n == 2) {
			return true;
		}
		
		// 짝수와 1은 소수에서 제외
		if( n==1 || n%2 ==0) {
			return false;
		}
		
		// 제곱근까지만 홀수로 나눠서 소수 판단
		for(i =3; i<= sqrt; i+=2) {
			if( n%i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	
	/////////////////////////   추가 참조 풀이  //////////////////////////////////
	
	public static int solution2(String numbers) {
		int count = 0;
		
		HashSet<Integer> set = new HashSet<>();
		purmutation2("", numbers, set);
		
		while(set.iterator().hasNext()) {
			int a = set.iterator().next();
			set.remove(a);
			
			// 2에 대한 소수 판단은 먼저 처리후, 소수 판단처리
			if(a==2) {
				count ++;
			}
			if(a%2 == 0 && isPrime2(a)) {
				count ++;
			}
		}
		return count;
	}
	
	public static void purmutation2(String prefix, String str, HashSet<Integer> set) {
		int n = str.length();
		
		
		if(!prefix.equals("")) {
			set.add(Integer.valueOf(prefix));
		}
		for(int i=0; i<n; i++) {
			purmutation2(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);
		}
	}
	
	public static boolean isPrime2(int n) {
		if(n == 0 || n == 1) {
			return false;
		}
		
		for(int i=3; i<(int)Math.sqrt(n); i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
}
