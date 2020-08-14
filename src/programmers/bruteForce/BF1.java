package programmers.bruteForce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BF1 {

	/**
	 * 臾몄젣 �꽕紐�
			�닔�룷�옄�뒗 �닔�븰�쓣 �룷湲고븳 �궗�엺�쓽 以�留먯엯�땲�떎. �닔�룷�옄 �궪�씤諛⑹� 紐⑥쓽怨좎궗�뿉 �닔�븰 臾몄젣瑜� �쟾遺� 李띿쑝�젮 �빀�땲�떎. �닔�룷�옄�뒗 1踰� 臾몄젣遺��꽣 留덉�留� 臾몄젣源뚯� �떎�쓬怨� 媛숈씠 李띿뒿�땲�떎.
			
			1踰� �닔�룷�옄媛� 李띾뒗 諛⑹떇: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
			2踰� �닔�룷�옄媛� 李띾뒗 諛⑹떇: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
			3踰� �닔�룷�옄媛� 李띾뒗 諛⑹떇: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
			
			1踰� 臾몄젣遺��꽣 留덉�留� 臾몄젣源뚯��쓽 �젙�떟�씠 �닚�꽌��濡� �뱾�� 諛곗뿴 answers媛� 二쇱뼱議뚯쓣 �븣, 媛��옣 留롮� 臾몄젣瑜� 留욏엺 �궗�엺�씠 �늻援ъ씤吏� 諛곗뿴�뿉 �떞�븘 return �븯�룄濡� solution �븿�닔瑜� �옉�꽦�빐二쇱꽭�슂.
		
		�젣�븳 議곌굔
			�떆�뿕�� 理쒕� 10,000 臾몄젣濡� 援ъ꽦�릺�뼱�엳�뒿�땲�떎.
			臾몄젣�쓽 �젙�떟�� 1, 2, 3, 4, 5以� �븯�굹�엯�땲�떎.
			媛��옣 �넂�� �젏�닔瑜� 諛쏆� �궗�엺�씠 �뿬�읉�씪 寃쎌슦, return�븯�뒗 媛믪쓣 �삤由꾩감�닚 �젙�젹�빐二쇱꽭�슂.
		
		�엯異쒕젰 �삁
			answers	       return
			[1,2,3,4,5] 	[1]
			[1,3,2,4,2]	   [1,2,3]
		
		�엯異쒕젰 �삁 �꽕紐�
			�엯異쒕젰 �삁 #1
			
			�닔�룷�옄 1�� 紐⑤뱺 臾몄젣瑜� 留욏삍�뒿�땲�떎.
			�닔�룷�옄 2�뒗 紐⑤뱺 臾몄젣瑜� ���졇�뒿�땲�떎.
			�닔�룷�옄 3�� 紐⑤뱺 臾몄젣瑜� ���졇�뒿�땲�떎.
			�뵲�씪�꽌 媛��옣 臾몄젣瑜� 留롮씠 留욏엺 �궗�엺�� �닔�룷�옄 1�엯�땲�떎.
			
			�엯異쒕젰 �삁 #2
			
			紐⑤뱺 �궗�엺�씠 2臾몄젣�뵫�쓣 留욎톬�뒿�땲�떎.
	 * */
	static public void main(String args[]) {
		int[] answers = {3, 3, 1, 1, 2, 2, 4, 4, 5};
//		int[] answers = {1,3,2,4,2};
//		int[] answers = {1,2,3,4,5};
		Map<Integer, Integer> answerMap = new HashMap<Integer,Integer>();
		answerMap.put(1, 0);
		answerMap.put(2, 0);
		answerMap.put(3, 0);
		List<Integer> answerlist = new ArrayList<>();
		
		List<Integer> patternList1 = Arrays.asList(1,2,3,4,5);
		List<Integer> patternList2 = Arrays.asList(2,1,2,3,2,4,2,5);
		List<Integer> patternList3 = Arrays.asList(3,3,1,1,2,2,4,4,5,5);

		for(int i = 0 ; i<answers.length; i++) {
			if(answers[i] == patternList1.get(i % (patternList1.size()))) {
				answerMap.put(1, answerMap.get(1)+1);
			}
			if(answers[i] == patternList2.get(i % (patternList2.size()))) {
				answerMap.put(2, answerMap.get(2)+1);
			}
			if(answers[i] == patternList3.get(i % (patternList3.size()))) {
				answerMap.put(3, answerMap.get(3)+1);
			}
		}
		
		int max = 0;					// 媛��옣 留롮씠 留욎텣 臾몄젣 媛쒖닔
		
		List<Map.Entry<Integer, Integer>> resultMap =  answerMap.entrySet().stream()
		        .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
		        .collect(Collectors.toList());			// 臾몄젣 媛쒖닔 �궡由쇱감�닚�쑝濡� �젙�젹
		
		max = resultMap.get(0).getValue();
		System.out.println("max : "+max);
		for (Map.Entry<Integer, Integer> entry : resultMap) {
//		    System.out.println("Key: " + entry.getKey() + ", " + "Value: " + entry.getValue());
		    if(max <= entry.getValue()) {
		    	answerlist.add(entry.getKey());
		    }
		}
		
		int[] resultArr = new int[answerlist.size() ==0 ? 3:answerlist.size()];

		if(answerlist.size() == 0) {		// 留욏엺 �궗�엺�씠 �뾾�뒗 寃쎌슦
			resultArr[0] = 1;
			resultArr[1] = 2;
			resultArr[2] = 3;
		}else {
			System.out.println(answerlist.size());
			for(int i=0; i< answerlist.size();i++) {
				resultArr[i]=answerlist.get(i);
				System.out.println("resultArr["+i+"] : "+resultArr[i]);
			}
		}
		
	}
	
}