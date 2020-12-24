package hackerRank.practice;


/**
 * /**
 * 문제 풀이 링크
 * 	-> https://www.hackerrank.com/challenges/apple-and-orange/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign&isFullScreen=true
 */
public class AppleAndOrange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countApplesAndOranges(7,11,5,15,new int[] {-2,2,1}, new int[] {5,-6});
	}
	
	public static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int cnt = 0;
        for(int i=0;i<apples.length;i++){
            apples[i] +=a;
            // 사과 개수
            if(apples[i] >= s && apples[i] <=t){
                cnt++;
            }
        }
        System.out.println(cnt);
        
        cnt = 0;
        for(int i=0;i<oranges.length;i++){
            oranges[i] +=b;
            // 오렌지 개수	
            if(oranges[i] >= s && oranges[i] <=t){
                cnt++;
            }
        }
        System.out.println(cnt);
	}

}
