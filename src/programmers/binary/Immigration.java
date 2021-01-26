package programmers.binary;

import java.util.Arrays;
/**
 *  문제 풀이 참고
 *      https://woongsin94.tistory.com/185
 *  문제 풀이
 *      https://velog.io/@ming/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%9E%85%EA%B5%AD%EC%8B%AC%EC%82%ACLevel-3
 * */
public class Immigration {
    public static void main(String args[]){
        System.out.println( " answer : "+solution(6, new int[]{7,10}));
    }

    /**
     * 추정시간 / 각 심사관별 심사시간 = 심사관당 맡을수 있는 입국자 수
     */
    public static long solution(int n, int[] times) {
        int len = times.length;
        long min = 0;                           // 최소값
        long max = new Long(times[len-1])*n;    // max : times의 최대값 * n명
        long answer = max;

        while(min <= max){                      // 최소값이 최대값보다 작을때까지만 반복
            long mid = (min+max) /2 ;
            long sum = 0;
            for(int i=0;i<len;i++){
                sum += mid / times[i];
                // sum > n보다 커지면, 더 이상 sum+= 계산 할 필요가 없음
                if(sum > n){
                    break;
                }
            }
//            System.out.println("sum : "+sum + " mid : "+mid + "/ min : "+min + " max : "+max) ;

            if(n > sum){        // 최대값 범위를 줄여야 함
                min = mid +1;
            }else{              // 최소값 범위를 늘려야하는 경우
                max = mid -1;
//                if(sum == n){
                answer = Math.min(answer, mid);     // 28,29 둘다 답이 될수 있으므로, Math.min값 처리
//                }
            }
        }
        return answer;
    }

}
