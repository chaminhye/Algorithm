package codility;

import java.util.TreeSet;

public class Distinct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {-10000,-5,0,1,2,-10000,-100,-100,-101};
//		int[] A = {2,1,1,2,3,1};
		solution(A);
	}

	public static int solution(int[] A) {
		int ans =0 ;
		int len = A.length;
        
        if(len == 0){
            return 0;
        }
        
        // 중복허용 X
        TreeSet<Integer> list = new TreeSet<Integer>();
		for(int i=0;i<A.length;i++) {
			list.add(A[i]);
		}
		ans = list.size();
//		System.out.println(ans);
		return ans;
	}
}
