package dynamic;

public class Dynamic2 {

	static int[] fibo_arr;
	public static void main(String[] args) {
		int N = 5;
		fibo_arr = new int[N+1];
		fibo(5);
//		System.out.println(fibo_arr[3]);
//		System.out.println(fibo_arr[4]);
//		System.out.println(fibo_arr[5]);
		long answer = (fibo_arr[4] + fibo_arr[5]) * 2;
		System.out.println(answer);
	}
	
	static void fibo(int num) {
		fibo_arr[0] = 1;
		fibo_arr[1] = 1;

		for(int i=2; i<=num;i++) {
			fibo_arr[i] = fibo_arr[i-2] + fibo_arr[i-1];
		}
//		return fibo(num-1) + fibo(num-2);
	}
}
