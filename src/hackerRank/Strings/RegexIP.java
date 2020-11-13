package hackerRank.Strings;

import java.util.Scanner;

class RegexIP{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }
}

//Write your code here
class MyRegex{
    String pattern =  "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])"; 
    
    MyRegex(){
        this.pattern =pattern+"."+pattern+"."+pattern+"."+pattern;
    }
    
}
