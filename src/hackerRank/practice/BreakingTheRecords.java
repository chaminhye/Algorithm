package hackerRank.practice;

/**
 * 	문제 링크
 * 		https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign&isFullScreen=true
 * 
 *  문제 KeyPoint
 *  	최고, 최저점만 파악하면 되는 문제.
 *  	예외케이스로 처리할 부분 없음 난이도 최하
 * */
public class BreakingTheRecords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scores = {10, 5, 20, 20, 4, 5, 2, 25, 1};
		breakingRecords(scores);
	}

    public static int[] breakingRecords(int[] scores) {
        // 최소, 최대값 0번째 인덱스 값으로 초기화
    	int min = scores[0];
        int max = scores[0];
        int min_cnt=0;
        int max_cnt=0;
        
        for(int i=0;i<scores.length;i++){
            if(min > scores[i]){
                min = scores[i];
                min_cnt++;
                
            }else if(max < scores[i]){
                max = scores[i];
                max_cnt++;
            }
        }
        int[] answer = {max_cnt, min_cnt};
        return answer;
    }

}
