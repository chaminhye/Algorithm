package programmers.dfs;

import java.util.ArrayList;
import java.util.List;

public class Ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
//		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"},{"JFK", "HND"}};
		solution(tickets);
	}

	public static boolean visited[];
	public static List<String> list = new ArrayList<>();
	
	public static String[] solution(String[][] tickets) {
		String[] ans = new String[10000];
		visited = new boolean[tickets.length];
		
		String first = "ICN";
		String second = "";
		int start = 0;
		// 시작은 무조건 ICN
		for(int i=0;i<tickets.length;i++) {
			if(first.equals(tickets[i][0])) {
				second = tickets[i][1].compareTo(second) > 0 ? tickets[i][1] : second;
				start = tickets[i][1].compareTo(second) > 0 ? i : start;
			}
		}
		visited[start] = true;
		list.add(first);
		System.out.println(list.size());
		dfs(tickets, second, 1);
		// list to array
		for(int i =0;i<list.size();i++) {
			ans[i] = list.get(i);
			System.out.println(ans[i]);
		}
		
		return ans;
	}
	
	public static void dfs(String[][] tickets, String arrival, int cnt) {
		if(cnt == tickets.length) {
			list.add(arrival);
		}
		
		for(int i=0;i<tickets.length;i++) {
			if(tickets[i][0].equals(arrival) && !visited[i]){
				visited[i] = true;
				list.add(arrival);
				dfs(tickets, tickets[i][1], cnt+1);
				visited[i]=false;
			}
		}
	}
}
