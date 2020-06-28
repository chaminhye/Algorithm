package greedy;

import java.util.HashMap;
import java.util.Map;

public class Greedy3 {
	/***
	 * ���� ����
			���̽�ƽ���� ���ĺ� �̸��� �ϼ��ϼ���. �� ó���� A�θ� �̷���� �ֽ��ϴ�.
			ex) �ϼ��ؾ� �ϴ� �̸��� �� ���ڸ� AAA, �� ���ڸ� AAAA
		
			���̽�ƽ�� �� �������� �����̸� �Ʒ��� �����ϴ�.
		
			�� - ���� ���ĺ�
			�� - ���� ���ĺ� (A���� �Ʒ������� �̵��ϸ� Z��)
			�� - Ŀ���� �������� �̵� (ù ��° ��ġ���� �������� �̵��ϸ� ������ ���ڿ� Ŀ��)
			�� - Ŀ���� ���������� �̵�
			���� ��� �Ʒ��� ������� JAZ�� ���� �� �ֽ��ϴ�.
		
			- ù ��° ��ġ���� ���̽�ƽ�� ���� 9�� �����Ͽ� J�� �ϼ��մϴ�.
			- ���̽�ƽ�� �������� 1�� �����Ͽ� Ŀ���� ������ ���� ��ġ�� �̵���ŵ�ϴ�.
			- ������ ��ġ���� ���̽�ƽ�� �Ʒ��� 1�� �����Ͽ� Z�� �ϼ��մϴ�.
			���� 11�� �̵����� "JAZ"�� ���� �� �ְ�, �̶��� �ּ� �̵��Դϴ�.
			������� �ϴ� �̸� name�� �Ű������� �־��� ��, �̸��� ���� ���̽�ƽ ���� Ƚ���� �ּڰ��� return �ϵ��� solution �Լ��� ���弼��.
		
		���� ����
			name�� ���ĺ� �빮�ڷθ� �̷���� �ֽ��ϴ�.
			name�� ���̴� 1 �̻� 20 �����Դϴ�.

		����� ��
			name	return
			JEROEN	 56
			JAN	     23
	*/
	static public void main(String args[]) {
		String name = "JEROEN";
		int answer = 0;
		
		int[] nameIdxArr = new int[name.length()];
		int[] answerIdxArr = new int[name.length()];
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		int idx =0;
		for(char c='A';c<='Z';++c) {					// map��  ABCD , 0123 �ε��� ���
			map.put(Character.toString(c), idx);
			idx ++;
		}
System.out.println(map);	
		String next, prev = "";							// ���� ���ĺ�(��), ���� ���ĺ�(��)
		int lastIdx = map.size();
		int midIdx = 12;								// �߰� idx
		for(int i =0;i<nameIdxArr.length;i++) {			// �־��� name�� ���� �ε��� ã��
			int cnt = 0;									// ������ Ƚ��
			nameIdxArr[i] = map.get(Character.toString(name.charAt(i)));
//			System.out.println(nameIdxArr[i]);
			if(nameIdxArr[i] != 0) {
				if(i==0) {								// ù��° ����
					answerIdxArr[i] = nameIdxArr[i]; 
				}else {
					if(nameIdxArr[i] > midIdx) { 		// Z ����������� ���� ���ĺ�
						answerIdxArr[i] = (lastIdx - nameIdxArr[i]) + 1; 
					}else {								// A ����������� ���� ���ĺ�
						answerIdxArr[i] = nameIdxArr[i] + 1; 
					}
				}
			}else {										// idx = 0 �� ���, ������ �ʿ� X
				answerIdxArr[i] = 0; 
			}
			
			
		}
		
		for(int i=0; i<answerIdxArr.length; i++) {
			answer += answerIdxArr[i];
		}

		System.out.println(answer);
		System.out.println(answerIdxArr[1]);
		System.out.println(answerIdxArr[2]);
		System.out.println(answerIdxArr[3]);
		System.out.println(answerIdxArr[4]);
		System.out.println(answerIdxArr[5]);
	}
	
}

