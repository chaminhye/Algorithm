package bruteForce;

import java.util.ArrayList;
import java.util.List;

public class BP4 {
	
	/**
	 * ���� ����
			Leo�� ī���� �緯 ���ٰ� �Ʒ� �׸��� ���� �߾ӿ��� ��������� ĥ���� �ְ� �׵θ� 1���� �������� ĥ���� �ִ� ���� ��� ī���� �ý��ϴ�.
			
			carpet.png
			
			Leo�� ������ ���ƿͼ� �Ʊ� �� ī���� ������� �������� ��ĥ�� ������ ������ ���������, ��ü ī���� ũ��� ������� ���߽��ϴ�.
			
			Leo�� �� ī�꿡�� ���� ������ �� brown, ����� ������ �� yellow�� �Ű������� �־��� �� ī���� ����, ���� ũ�⸦ ������� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
		
		���ѻ���
			���� ������ �� brown�� 8 �̻� 5,000 ������ �ڿ����Դϴ�.
			����� ������ �� yellow�� 1 �̻� 2,000,000 ������ �ڿ����Դϴ�.
			ī���� ���� ���̴� ���� ���̿� ���ų�, ���� ���̺��� ��ϴ�.
		
		����� ��
			brown	yellow	return
			10	       2	[4, 3]
			8	       1	[3, 3]
			24	      24	[8, 6]
	 * */
	
	static public void main(String args[]) {
//		int brown = 24;
//		int yellow = 24;
		int brown = 10;
		int yellow = 2;
		
		int[] answer = {0,0};
		
		int area = brown + yellow;
		answer = divisor(area, yellow);
		System.out.println(answer[0]+" / "+answer[1]);
	}
	
	public static int[] divisor(int area, int yellow ) {
		
		
		List<List<Integer>> areaList = new ArrayList<>();
		List<List<Integer>> yellowList = new ArrayList<>();
		
		int[] result = {0,0};
		
		for(int i =3; i<=area ; i++) {			// yellow�� �����ϸ� �ּҳ��̴� 3���� ������	
			if(area % i == 0) {					// ��ü ������ ��� ���ϱ�
				if(area/i != 1 && area/i != 2) {
					List<Integer> innerList = new ArrayList<Integer>();
					innerList.add(i);
					innerList.add(area/i);
					areaList.add(innerList);
				}
			}
		}
		for(int i =1; i<=yellow ; i++) {			
			if(yellow % i == 0) {				// yellow ������ ��� ���ϱ�
				List<Integer> innerList = new ArrayList<Integer>();
				innerList.add(i);
				innerList.add(yellow/i);
				yellowList.add(innerList);
			}
		}
		
		for(int i =0;i<areaList.size();i++) {			
			for(int j=0; j<yellowList.size(); j++) {

				// �� �ʺ� = (���ο� �ʺ�+2) && �� ���� = (���ο� ����+2) 
				if(areaList.get(i).get(0) == (yellowList.get(j).get(0)+2) && areaList.get(i).get(1) == (yellowList.get(j).get(1)+2)) {
					result[0] = (int) areaList.get(i).get(0);
					result[1] = (int) areaList.get(i).get(1);
				}
			}
		}
		
		return result;
	}
}
