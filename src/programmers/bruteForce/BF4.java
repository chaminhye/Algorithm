package programmers.bruteForce;

import java.util.ArrayList;
import java.util.List;

public class BF4 {
	
	/**
	 * 臾몄젣 �꽕紐�
			Leo�뒗 移댄렖�쓣 �궗�윭 媛붾떎媛� �븘�옒 洹몃┝怨� 媛숈씠 以묒븰�뿉�뒗 �끂���깋�쑝濡� 移좏빐�졇 �엳怨� �뀒�몢由� 1以꾩� 媛덉깋�쑝濡� 移좏빐�졇 �엳�뒗 寃⑹옄 紐⑥뼇 移댄렖�쓣 遊ㅼ뒿�땲�떎.
			
			carpet.png
			
			Leo�뒗 吏묒쑝濡� �룎�븘���꽌 �븘源� 蹂� 移댄렖�쓽 �끂���깋怨� 媛덉깋�쑝濡� �깋移좊맂 寃⑹옄�쓽 媛쒖닔�뒗 湲곗뼲�뻽吏�留�, �쟾泥� 移댄렖�쓽 �겕湲곕뒗 湲곗뼲�븯吏� 紐삵뻽�뒿�땲�떎.
			
			Leo媛� 蹂� 移댄렖�뿉�꽌 媛덉깋 寃⑹옄�쓽 �닔 brown, �끂���깋 寃⑹옄�쓽 �닔 yellow媛� 留ㅺ컻蹂��닔濡� 二쇱뼱吏� �븣 移댄렖�쓽 媛�濡�, �꽭濡� �겕湲곕�� �닚�꽌��濡� 諛곗뿴�뿉 �떞�븘 return �븯�룄濡� solution �븿�닔瑜� �옉�꽦�빐二쇱꽭�슂.
		
		�젣�븳�궗�빆
			媛덉깋 寃⑹옄�쓽 �닔 brown�� 8 �씠�긽 5,000 �씠�븯�씤 �옄�뿰�닔�엯�땲�떎.
			�끂���깋 寃⑹옄�쓽 �닔 yellow�뒗 1 �씠�긽 2,000,000 �씠�븯�씤 �옄�뿰�닔�엯�땲�떎.
			移댄렖�쓽 媛�濡� 湲몄씠�뒗 �꽭濡� 湲몄씠�� 媛숆굅�굹, �꽭濡� 湲몄씠蹂대떎 源곷땲�떎.
		
		�엯異쒕젰 �삁
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
		
		for(int i =3; i<=area ; i++) {			// yellow媛� 議댁옱�븯硫� 理쒖냼�넂�씠�뒗 3遺��꽣 �떆�옉�븿	
			if(area % i == 0) {					// �쟾泥� �꼻�씠�쓽 �빟�닔 援ы븯湲�
				if(area/i != 1 && area/i != 2) {
					List<Integer> innerList = new ArrayList<Integer>();
					innerList.add(i);
					innerList.add(area/i);
					areaList.add(innerList);
				}
			}
		}
		for(int i =1; i<=yellow ; i++) {			
			if(yellow % i == 0) {				// yellow �꼻�씠�쓽 �빟�닔 援ы븯湲�
				List<Integer> innerList = new ArrayList<Integer>();
				innerList.add(i);
				innerList.add(yellow/i);
				yellowList.add(innerList);
			}
		}
		
		for(int i =0;i<areaList.size();i++) {			
			for(int j=0; j<yellowList.size(); j++) {

				// 珥� �꼫鍮� = (�삉濡쒖슦 �꼫鍮�+2) && 珥� �넂�씠 = (�삉濡쒖슦 �넂�씠+2) 
				if(areaList.get(i).get(0) == (yellowList.get(j).get(0)+2) && areaList.get(i).get(1) == (yellowList.get(j).get(1)+2)) {
					result[0] = (int) areaList.get(i).get(0);
					result[1] = (int) areaList.get(i).get(1);
				}
			}
		}
		
		return result;
	}
}