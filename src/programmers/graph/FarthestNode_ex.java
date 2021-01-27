package programmers.graph;

import java.util.*;

/*
*   문제풀이 참고
*       https://in-intuition.tistory.com/23 (인접행렬로 접근)
* */
public class FarthestNode_ex {
    static LinkedList<Integer>[] adjList;
    static int depth=0;
    static int count=0;
    static int[] answers;
    static String answer = "";
    static boolean[] visited;

    public static void main(String args[]){
//        solution0(6, new int[][]{{3,6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2}});
//        solution1(6, new int[][]{{3,6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2}});
        solution2(6, new int[][]{{3,6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2}});
    }

    public static int solution0(int n, int[][] edge ){
        visited = new boolean[edge.length];
        visited[0] = true;
        adjList = new LinkedList[n+1];
        answers = new int[n+1];
        for(int i=0;i<n+1;i++){
            adjList[i] = new LinkedList<>();
        }

        for(int i=0;i<edge.length;i++){
            int start = edge[i][0];
            int end = edge[i][1];

            adjList[start].add(end);
            adjList[end].add(start);
        }
        for(int i=1;i<adjList.length;i++){
            System.out.println(adjList[i]);
        }

        for(int i=2;i<adjList.length;i++){
//            bfs(1,i);
//            System.out.println("answers : "+answers[i]);
        }
        System.out.println("*****************************");
        for(int i:answers){
            System.out.println("answers["+i+"] : "+answers[i]);
        }
        return count;
    }

    /**
     bfs로 탐색을 진행,
     1에서 시작하면, 2,3   -> 2, 3에서 자식을 찾아서
     */
    public static void bfs(int start, int end){
        Queue<Integer> q= new LinkedList<>();
        visited[start] = true;
        q.add(start);
        int cnt =0;

        while(!q.isEmpty()){
            start= q.poll();
            cnt ++;
            answer += start+ " ";
            Iterator<Integer> it = adjList[start].listIterator();
            int z = 0;
            while(it.hasNext()){
                int w = it.next();
                System.out.println("w : "+w);
                answer += w+" ";
                if(w == end){
                    z=w;
                    break;
                }
                if(!visited[w]){
                    visited[w]=true;
                    q.add(w);
                    cnt++;
                }
            }
            if(z == end){
                answers[start] = cnt;
                answer="";
                break;
            }
            System.out.println("------------------------------");
        }

    }

    // 인접행렬로 접근
    public static int solution1(int n, int[][] edge ){
        boolean[] visited = new boolean[n];     // 방문여부 확인
        boolean[][] matrix= new boolean[n][n];  // 인접행렬로 표시
        Queue<Integer> q = new LinkedList<>();

        // 인접행렬로 표시 , 배열의 인덱스 0부터 시작하기 위한 작업
        for(int i=0;i<edge.length;i++){
            matrix[edge[i][0]-1][edge[i][1]-1] = matrix[edge[i][1]-1][edge[i][0]-1] = true;
        }
        // 문제에서 1부터 시작한다고 하였으니, 인덱스0부터 q에 담고 탐색을 시작한다.(1depth 생성)
        visited[0] = true;
        q.add(0);

        int ans=0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int node = q.poll();
                // 방문해야하는 정점이면서 , 아직 방문하지 않은 경우를 찾는다
                // 0으로 시작하는 경우, return 1,2
                // q에 1,2를 담는다 (2depth)
                for(int j=0;j<n;j++){
                    if(matrix[j][node] && !visited[j]){
                        visited[j]=true;
                        q.add(j);
                    }
                }
            }
            System.out.println("q : "+q);
            // 위의 for문을 반복하면, 마지막 depth를 찾을 수 있다.
            ans = size;
        }
        return ans;
    }


    // 인접리스트로 접근
    public static int solution2(int n, int[][] edge ){
        int ans=0;
        boolean[] checked = new boolean[n+1];
        LinkedList<Integer>[] adj = new LinkedList[n+1];           // 인접리스트 생성

        for(int i=0;i<n+1;i++){
            adj[i] = new LinkedList<Integer>();
        }
        for(int i=0;i<edge.length;i++){
            int start = edge[i][0]-1;
            int end = edge[i][1]-1;

            adj[start].add(end);
            adj[end].add(start);
        }
        for(int i=0;i<n;i++){
            System.out.println(adj[i]);
        }

        Queue<Integer> q= new LinkedList<>();
        q.add(0);
        checked[0]=true;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int v = q.poll();
                System.out.println("v : "+v);
                for(int j=0;j<adj[v].size();j++){
                    int node = adj[v].get(j);
                    System.out.println("adj[v] : "+adj[v]+" /  :: "+adj[v].get(j));
                    if(!checked[node]){
                        checked[node]=true;
                        q.add(node);
                    }
                }
            }
            System.out.println("q : "+q+" / size : "+size);
            System.out.println("=============================================================");
            ans = size;
        }
        return ans;
    }

}
