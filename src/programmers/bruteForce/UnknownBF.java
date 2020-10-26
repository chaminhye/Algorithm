package programmers.bruteForce;

import java.util.ArrayList;
import java.util.List;

public class UnknownBF {
	
	/**
	 * 臾몄젣 �꽕紐�
			�닽�옄 �빞援� 寃뚯엫�씠�� 2紐낆씠 �꽌濡쒓� �깮媛곹븳 �닽�옄瑜� 留욎텛�뒗 寃뚯엫�엯�땲�떎. 寃뚯엫�빐蹂닿린
			
			媛곸옄 �꽌濡� �떎瑜� 1~9源뚯� 3�옄由� �엫�쓽�쓽 �닽�옄瑜� �젙�븳 �뮘 �꽌濡쒖뿉寃� 3�옄由ъ쓽 �닽�옄瑜� 遺덈윭�꽌 寃곌낵瑜� �솗�씤�빀�땲�떎. 洹몃━怨� 洹� 寃곌낵瑜� �넗��濡� �긽��媛� �젙�븳 �닽�옄瑜� �삁�긽�븳 �뮘 留욏옓�땲�떎.
			
			* �닽�옄�뒗 留욎�留�, �쐞移섍� ���졇�쓣 �븣�뒗 蹂�
			* �닽�옄�� �쐞移섍� 紐⑤몢 留욎쓣 �븣�뒗 �뒪�듃�씪�씠�겕
			* �닽�옄�� �쐞移섍� 紐⑤몢 ���졇�쓣 �븣�뒗 �븘�썐
			�삁瑜� �뱾�뼱, �븘�옒�쓽 寃쎌슦媛� �엳�쑝硫�
			
			A : 123
			B : 1�뒪�듃�씪�씠�겕 1蹂�.
			A : 356
			B : 1�뒪�듃�씪�씠�겕 0蹂�.
			A : 327
			B : 2�뒪�듃�씪�씠�겕 0蹂�.
			A : 489
			B : 0�뒪�듃�씪�씠�겕 1蹂�.
			�씠�븣 媛��뒫�븳 �떟�� 324�� 328 �몢 媛�吏��엯�땲�떎.
			
			吏덈Ц�븳 �꽭 �옄由ъ쓽 �닔, �뒪�듃�씪�씠�겕�쓽 �닔, 蹂쇱쓽 �닔瑜� �떞�� 2李⑥썝 諛곗뿴 baseball�씠 留ㅺ컻蹂��닔濡� 二쇱뼱吏� �븣, 媛��뒫�븳 �떟�쓽 媛쒖닔瑜� return �븯�룄濡� solution �븿�닔瑜� �옉�꽦�빐二쇱꽭�슂.
		�젣�븳�궗�빆
			吏덈Ц�쓽 �닔�뒗 1 �씠�긽 100 �씠�븯�쓽 �옄�뿰�닔�엯�땲�떎.
			baseball�쓽 媛� �뻾�� [�꽭 �옄由ъ쓽 �닔, �뒪�듃�씪�씠�겕�쓽 �닔, 蹂쇱쓽 �닔] 瑜� �떞怨� �엳�뒿�땲�떎.
		�엯異쒕젰 �삁
			baseball	                                          return
			[[123, 1, 1], [356, 1, 0], [327, 2, 0], [489, 0, 1]]	2
	 * */
	static public void main(String args[]) {
        int answer = 0;
        int[][] baseball = {{123,1,1}, {356,1,0}, {327,2,0},{489,0,1}};
        
		List<Integer> firstNum = new ArrayList<>();  
		List<Integer> secondNum = new ArrayList<>();  
		List<Integer> thirdNum = new ArrayList<>();
		
		//媛� �옄由щ쭏�떎 �뿀�슜媛��뒫�븳 �닽�옄瑜� list�뿉 ���옣
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