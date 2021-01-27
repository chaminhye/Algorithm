package programmers.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/**
 *  문제 풀이 참조
 *      https://iamheesoo.github.io/blog/algo-prog49191
 *      https://mungto.tistory.com/58 (C++)
 *
 *  플로이드 와샬 알고리즘
 *      https://blog.naver.com/ndb796/221234427842
 * */
public class Ranking_ex {
    public static void main(String[] args) {
//        solution(5, new int[][]{{4,3}, {4,2}, {3,2}, {1,2}, {2,5}});
        System.out.println("answer : "+solution2(5, new int[][]{{4,3}, {4,2}, {3,2}, {1,2}, {2,5}}));
    }

    public static int solution(int n, int[][] results){
        int answer = 0;
        boolean[] visited = new boolean[n];
        LinkedList<Integer>[] adj = new LinkedList[n];           // 인접리스트 생성

        for(int i=0;i<n;i++){
            adj[i] = new LinkedList<Integer>();
        }

        // 간선을 인접리스트로 표현
        for(int i=0;i<results.length;i++){
            int start = results[i][0]-1;       // 0번째 인덱스부터 맞춰주기 위한 작업
            int end = results[i][1]-1;

            adj[start].add(end);
            adj[end].add(start);
        }
        for(int i=0;i<adj.length;i++){
            System.out.println(adj[i]);
        }
        System.out.println("---------------------------------");
        Queue<Integer> q= new LinkedList<>();
        q.offer(0);
        visited[0] = true;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int v = q.poll();
                for(int j=0;j<adj[v].size();j++){
                    int node = adj[v].get(j);

                }
            }
        }
        return answer;
    }

    public static int solution1(int n, int[][] results) {
        int[][] rank = new int[n][n];
        int cnt = 0;
        for(int k=0;k<results.length;k++){
            for(int i=0;i<results.length;i++) {
                for (int j = 0; j < results.length; j++) {
                    if(results[i][k]+results[k][j]< results[i][j]){
                        rank[i][j] = results[i][k]+results[k][j];
                        cnt++;
                    }
                }
            }
        }
        return cnt == n-1 ? n : cnt;
    }

    // 플로이드 와샬 알고리즘 적용
    // 이 문제는 결국 모든 선수와의 비교를 다 진행해야한다.
    // 0. 모든 선수와 대결은 한다고 가정
    // 1. 이긴경우는 단방향으로 표시한 뒤
    // 2. 플로리다 와샬 알고리즘 적용
    // 3. 승패가 확실한 경우 count = 인원 -1 , 모든 경기 판단가능하므로 answer ++
    public static int solution2(int n, int[][] results){
        int len = results.length;
        int infinite = 1000000000;        // 무한대 ( 방문불가)

        int[][] rank = new int[n+1][n+1];
        // 본인노드 방문 제외하고 모두 무한대로 초기 셋팅 ( index 1부터 시작하기 위함)
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if( i == j){
                    rank[i][j] = 0;
                }else{
                    rank[i][j] = infinite;
                }
                System.out.print(rank[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("*************************************************");

        // results결과에 따라 이긴 경우를 1로 설정 (단방향으로만 설정해야 한다.)
        for(int[] result:results){
            rank[result[0]][result[1]] = 1;
        }
        for(int[] r :rank){
            System.out.println(Arrays.toString(r));
        }
        System.out.println("*************************************************");
        // 플로이드 와샬 알고리즘에 따라 rank[][] 배열 값 최단거리 설정
        for(int k=1;k<n+1;k++){
            for(int i=1;i<n+1;i++) {
                for (int j =1; j <n+1; j++) {
                    if(rank[i][j] > rank[i][k] + rank[k][j]){
                        rank[i][j] = rank[i][k] + rank[k][j];
                    }
                }
            }
        }
        for(int[] r :rank){
            System.out.println(Arrays.toString(r));
        }
        System.out.println("*************************************************");


        // 대결한적 있는지 확인
        boolean[] flag = new boolean[n+1];
        Arrays.fill(flag, true);
        for(int i=1; i<n+1;i++){        // 나
            for(int j=1; j<n+1;j++){        // 상대
                if(i == j){
                    continue;       // 나와 나자신은 대결 X
                }
                if(rank[i][j] == infinite && rank[j][i] == infinite ){    // 경기를 하지 않은 경우
                    flag[i] = false;
                    break;
                }
            }

        }

        // 순위를 판단 가능한 경우, 곧 모두와 경기를 한 경우
        int answer=0;
        for(int i=1;i<n+1;i++){
            if(flag[i]){
                answer ++;
            }
        }
        return answer;
    }
}
