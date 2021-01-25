package concept.search;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {31,18,5,4,19,35,1,13,30,21};
		System.out.println(binarySearch_loop(arr, 31));
		System.out.println(binarySearch_recursive(arr, 0, arr.length-1, 31));
	}

	public static int binarySearch_loop(int[] arr, int target) {
		Arrays.sort(arr);		// 0번 과정 : 오름차순 정렬
		
		int low = 0;
		int high = arr.length-1;
		int mid = 0;			
		
		// 제일 작은수가 큰수보다 커지면 탐색 종료
		while(low <= high) {
			mid = (low + high) /2;		// 1번 과정 : 중앙값 찾기 
			System.out.println("low : "+low + " mid : "+mid+" high : "+high);
			if(arr[mid] == target) {
				return mid;
			}else if(arr[mid] > target) {	// 현재의 중앙값보다 작으면, 
				high = mid-1;				// 왼쪽요소를 선택하기 위해 high = mid -1로 설정
			}else {
				low = mid+1;				// 현재의 중앙값보다 크면, 오른쪽 요소를 선택하기 위해 low = mid+1로 설정
			}
		}
		// 탐색해도 결과가 없는 경우
		return -1;
		
	}
	
	public static int binarySearch_recursive(int[] arr, int low, int high, int target) {
		Arrays.sort(arr);		// 0번 과정 : 오름차순 정렬
		
		if(low > high) {
			return -1;
		}
		
		int mid = (low + high) /2;		// 1번 과정 : 중앙값 찾기
		if(arr[mid] == target) {
			return mid;
		}else if(arr[mid] > target) {
			return binarySearch_recursive(arr, low, mid-1, target);
		}else {
			return binarySearch_recursive(arr, mid+1, high, target);
		}
	}
}
