package hackerRank.practice;

/**
 * 	문제 링크
 * 		https://www.hackerrank.com/challenges/day-of-the-programmer/problem?isFullScreen=true
 * 
 * 	KeyPoint
 * 		지문을 잘 이해해라!
 * 		1. 1700 ~ 1917 : 율리우스 (4년마다 윤달)
 *      2. 1918 : 26.09.1918로 정해져 잇음
 *      3. 1919 ~ : 그레고리력 ( 400년마다 또는 4로 나눈 나머지 0이면서, 100으로 나눈 나머지가 0이 아닌 년이 윤달)
 * 		
 * */
public class DayoftheProgrammer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(dayOfProgrammer(2016));
		
	}

   static String dayOfProgrammer(int year) {
	   String month = "";
	   String day = "";
	   
	   if(year == 1918) {
		   return "26.09."+year;
	   }else {
		   if((year>1918 && year % 400 == 0) || 
				   (year >1918 && year % 400 == 0 )|| 
				   (year > 1918 && year % 4 ==0 && year % 100 != 0) ||
				   (year <1918 && year % 4 ==0)) {
			   return "12.09."+year;
		   }else {
			   return "13.09."+year;
			   
		   }
	   }
   }

}
