package programmers.binary;

import java.util.Arrays;
/**
 *  문제 풀이 참조
 *      https://in-intuition.tistory.com/21
 *      https://taesan94.tistory.com/154
 * */
public class SteppingStone_ex {
    public static void main(String args[]){

//        System.out.println(solution(25, new int[]{2,14,11,21,17}, 2));        // 한개만 정답임,  차이를 가지고 있는 배열은 틀린거
        System.out.println(solution2(25, new int[]{2,14,11,21,17}, 2));
    }

    public static int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        Arrays.sort(rocks);     // 오름차순 정렬
        int[] dis = new int[rocks.length];      // 각 바위 차이를 구한 배열
        for(int i=0; i<rocks.length; i++){
            if(i==0){
                dis[i] = rocks[i];
            }else if(i==rocks.length-1){
                dis[i]=distance-rocks[i];
            }else{
                dis[i]=rocks[i]-rocks[i-1];
            }
            System.out.println("dis["+i+"] : "+dis[i]);
        }
        Arrays.sort(dis);

        int min =0;
        int max = distance;
        while(min <= max){
            int mid = (min+max)/2;
            int cnt = 0;
            for(int i=0;i<dis.length;i++){
                if(dis[i] < mid){
                    cnt++;
                }
                if(cnt > n){
                    break;
                }
            }
            System.out.println("min : "+ min + " max : "+max + " cnt : "+cnt);
            if(cnt > n){
                max = mid-1;
            }else{
                min = mid+1;
                answer = Math.max(mid, answer);
            }
        }
        return answer;
    }

    public static int solution2(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);     // 오름차순 정렬

        int answer =0 ;
        int min =0;
        int max = distance;

        while(min <= max){
            int mid = (min + max) /2;
            int prev = 0;       // 이전 돌의 위치
            int cnt = 0;        // 제거할 돌의 개수
            for(int i=0; i<rocks.length;i++){
                if(rocks[i]-prev < mid){
                    cnt++;
                    if(cnt > n){    // cnt의 개수가 n보다 커지면, 더이상 cnt를 늘려줄 필요가 없다.
                        break;
                    }
                }else{
                    prev = rocks[i];
                }
            }
            System.out.println("prev : "+prev+" cnt : "+cnt+" mid : "+mid);
            // 마지막 거리 체크 (distance와의 비교를 위함)
            if(distance-prev < mid){
                cnt ++;
            }
            if(cnt <= n){
                min = mid+1;
                answer = Math.max(mid, answer);
            }else{
                max = mid-1;
            }
        }
        return answer;
    }
}
