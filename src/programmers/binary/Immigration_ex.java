package programmers.binary;

import java.util.Arrays;

public class Immigration_ex {
    public static void main(String args[]){
//        System.out.println( " answer : "+solution(6, new int[]{7,10}));
//        System.out.println( " answer : "+solution2(6, new int[]{7,10}));
        System.out.println( " answer : "+solution3(6, new int[]{7,10}));
    }

    /**
     * 추정시간 / 각 심사관별 심사시간 = 심사관당 맡을수 있는 입국자 수
     */
    public static long solution(int n, int[] times) {
        Arrays.sort(times);     // 오름차순 정렬

        int len = times.length;
        long min = 0;                    // min : 0
        long max = new Long(times[len-1] * n);     // max : times의 최대값 * n명
        long answer = max;

        while(min <= max){
            long mid = (min + max) / 2;
            long sum = 0;

            for(int i=0;i<len;i++){
                sum += mid/times[i];      //  한 심사관당 맡을 수 있는 입국자 수
            }
            System.out.println("sum : "+sum);

            if(sum > n ){
                max = mid -1;
            }else if(sum < n){
                min = mid +1;
            }else{
                answer = mid;
                break;
            }
        }
        return answer;
    }

    // 문제풀이 참조
    // https://yubh1017.tistory.com/30
    public static long solution2(int n, int[] times) {
        // 모든 사람이 심사를 받는데 걸리는 시간의 최솟값
        long answer = Long.MAX_VALUE;

        Arrays.sort(times);

        long start, mid, end;
        start = 0;
        end = Long.MAX_VALUE;
        long sum;
        // 모든 사람이 심사 받는데 걸리는 시간 이분 탐색
        // mid : 심사를 받는데 주어진 시간
        // sum : 주어진 시간(mid)동안 심사를 받을 수 있는 사람 수
        while(start <= end){

            mid = (start + end) / 2;

            sum = 0;
            // 주어진 시간동안 몇명 검사 할 수 있는지 누적합
            for(int i=0; i<times.length; i++){
                sum += mid / times[i];

                if(sum >= n)
                    break;
            }

            // 비교 대상(사람 수)
            // 검사 다 못할 때(시간 부족)
            if(n > sum){
                start = mid + 1;
            }
            // 검사 다 했을 때 (시간이 남음)
            // 최소 시간 찾아야함
            else{
                end = mid - 1;
                answer = Math.min(answer, mid);
            }
        }

        return answer;
    }

    public static long solution3(int n, int[] times) {
        int len = times.length;
        long min = 0;                           // 최소값
        long max = new Long(times[len-1])*n;    // max : times의 최대값 * n명

        long answer = max;
        while(min <= max){
            long mid = (min+max) /2 ;
            long sum = 0;
            for(int i=0;i<len;i++){
                sum += mid / times[i];
                // sum > n보다 커지면, 더 이상 sum+= 계산 할 필요가 없음
                if(sum > n){
                    break;
                }
            }
            System.out.println("sum : "+sum + " mid : "+mid + "/ min : "+min + " max : "+max) ;

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
