package programmers.bruteForce;

import java.util.*;

/**
     문제 설명
         한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

         각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

     제한사항
         numbers는 길이 1 이상 7 이하인 문자열입니다.
         numbers는 0~9까지 숫자만으로 이루어져 있습니다.
         013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.

     입출력 예
         numbers	  return
         17	        3
         011	        2

     입출력 예 설명
         예제 #1
         [1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.

         예제 #2
         [0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.

         11과 011은 같은 숫자로 취급합니다.

     문제 풀이
        https://velog.io/@ming/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4%EC%86%8C%EC%88%98-%EC%B0%BE%EA%B8%B0Level2
 * */

public class PrimeNumber {
    public static TreeSet<Integer> set = new TreeSet<>();       // 중복값 제거하기 위해 set사용

    public static void main(String arsg[]){
        String numbers = "12310";
        System.out.println(solution(numbers));
//        System.out.println(isPrime(752));
    }

    public static int solution(String numbers){
        int len = numbers.length();
        // String 배열로 숫자 하나씩 담아주기
        String[] str = new String[len];
        for(int i=0;i<len;i++){
            str[i] = Character.toString(numbers.charAt(i));
        }
        boolean[] visited = new boolean[len];
        Arrays.fill(visited, false);

        // 1개부터 배열의 개수만큼 순열만들기
        for(int i=0;i<len;i++) {
            permutation_dfs(str, visited, "", i+1, 0);
//            System.out.println("--------------------------------------");
        }
        return set == null ? 0 : set.size();
    }

    /**
     *  dfs를 이용하여 순열 만들기
     *
     *  @param arr : 숫자가 담긴 String 배열
     *  @param visited : 방문여부 판단
     *  @param str : 소수 판단할 수
     *  @param r : 순열을 만들 갯수
     *  @param depth : 순열 개수 체크
     * */
    public static void permutation_dfs(String[] arr, boolean[] visited, String str, int r, int depth){
        //
        if(depth == r){
            int n = Integer.parseInt(str);
            // 소수이면서, set에 없는 숫자만 담는다.
            if(isPrime(n) && !set.contains(n)){
//                System.out.println(" n : "+n);
                set.add(n);
            }
            return;
        }

        for(int i=0;i<arr.length;i++){
            // 방문하지 않은 경우
            if(!visited[i]){
                visited[i] = true;
                str += arr[i];
//                System.out.println(" ::     str : "+str + " / arr[i] : "+arr[i]);
                permutation_dfs(arr, visited, str, r, depth+1);
                // 현재 숫자말고 다른 숫자를 선택하는 경우 str에서 위에서 방문한 숫자 지워주기
                str = str.substring(0, str.length() - 1);
                visited[i] = false;

            }
        }
    }

    // 소수체크 ( 0,1은 소수 아님 , 2,3은 소수)
    // 제곱근까지 나누면서 나눠지는지 체크
    public static boolean isPrime(int n) {
        if(n <= 1) {
            return false;
        }

        if( n == 2 || n == 3){
            return true;
        }

        for(int i=2; i<=(int)Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
