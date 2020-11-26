package codility;

public class BinaryGap {
	static public void main(String args[]) {
//		int N = 33;
		int N = 1041;
//		int N = 32;
		
		String binary = Integer.toBinaryString(N);
		int answer = 0;
		int zeroCnt = 0;
		
		System.out.println("binary : "+binary); 

		for(int i=1;i<binary.length();i++) {
			if(binary.charAt(i) == '1') {
				if(zeroCnt > answer)
				{
					answer = zeroCnt;
				}
				zeroCnt = 0;		// 1을 만나면 0 카운트 초기화
			}else {
				zeroCnt ++;
			}
		}
		System.out.println("answer : "+answer);
	}
}


