package bruteForce;

import java.util.ArrayList;
import java.util.List;

public class BP3 {
	
	/**
	 * ���� ����
			���� �߱� �����̶� 2���� ���ΰ� ������ ���ڸ� ���ߴ� �����Դϴ�. �����غ���
			
			���� ���� �ٸ� 1~9���� 3�ڸ� ������ ���ڸ� ���� �� ���ο��� 3�ڸ��� ���ڸ� �ҷ��� ����� Ȯ���մϴ�. �׸��� �� ����� ���� ��밡 ���� ���ڸ� ������ �� �����ϴ�.
			
			* ���ڴ� ������, ��ġ�� Ʋ���� ���� ��
			* ���ڿ� ��ġ�� ��� ���� ���� ��Ʈ����ũ
			* ���ڿ� ��ġ�� ��� Ʋ���� ���� �ƿ�
			���� ���, �Ʒ��� ��찡 ������
			
			A : 123
			B : 1��Ʈ����ũ 1��.
			A : 356
			B : 1��Ʈ����ũ 0��.
			A : 327
			B : 2��Ʈ����ũ 0��.
			A : 489
			B : 0��Ʈ����ũ 1��.
			�̶� ������ ���� 324�� 328 �� �����Դϴ�.
			
			������ �� �ڸ��� ��, ��Ʈ����ũ�� ��, ���� ���� ���� 2���� �迭 baseball�� �Ű������� �־��� ��, ������ ���� ������ return �ϵ��� solution �Լ��� �ۼ����ּ���.

		���ѻ���
			������ ���� 1 �̻� 100 ������ �ڿ����Դϴ�.
			baseball�� �� ���� [�� �ڸ��� ��, ��Ʈ����ũ�� ��, ���� ��] �� ��� �ֽ��ϴ�.
		����� ��
			baseball	                                          return
			[[123, 1, 1], [356, 1, 0], [327, 2, 0], [489, 0, 1]]	2
	 * */
	static public void main(String args[]) {
        int answer = 0;
        int[][] baseball = {{123,1,1}, {356,1,0}, {327,2,0},{489,0,1}};
        
		List<Integer> firstNum = new ArrayList<>();  
		List<Integer> secondNum = new ArrayList<>();  
		List<Integer> thirdNum = new ArrayList<>();
		
		//�� �ڸ����� ��밡���� ���ڸ� list�� ����
		for(int i=1; i<10; i++) {
			firstNum.add(i);
			secondNum.add(i);
			thirdNum.add(i);
		}
		
		String number = "";
		for(int i=0;i<baseball.length;i++) {
			for(int j=0;j<baseball[i].length;j++) {
				//System.out.println(i +" : "+j+" : "+baseball[i][j]);
				if(j == 0) {
					number = Integer.toString(baseball[i][j]);
				}
				if(j==1 && baseball[i][j] == 0) {		// strike = 0
					firstNum.remove(number.substring(0, 1));
					secondNum.remove(number.substring(1, 2));
					thirdNum.remove(number.substring(2, 3));
				}
			}
		}
		
		
		
		answer = firstNum.size() * secondNum.size() * thirdNum.size();
		System.out.println(answer);
		
	}
}
