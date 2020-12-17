package hackerRank.Strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class TimeConversion {

    /*
     * Complete the timeConversion function below.
     * 
     * 문제 링크 : https://www.hackerrank.com/challenges/time-conversion/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign&isFullScreen=true
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        String ans = "";
        
        if(s.contains("PM")){		// PM : hh +12
            s = s.replace("PM", "");
            int hour =Integer.parseInt(s.substring(0,2))+12;
            if(hour<24){						
               ans = (hour) + s.substring(2,8);
            }else{							// 12PM인 경우 +12시간 더하지 않음
                ans = s.substring(0,8);
            }
            
        }else{						// AM : hh 그대로
            ans = s.replace("AM","");
            if(Integer.parseInt(s.substring(0,2)) == 12 ){		//// 12AM인 경우 00시로 표시
                ans = "00" +s.substring(2,8);
            }
            
        }
        return ans;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}