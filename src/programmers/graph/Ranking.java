package programmers.graph;

import java.util.Arrays;
/**
 *  문제 풀이
 *      https://velog.io/@ming/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4%EC%88%9C%EC%9C%84Level-3
 * */
public class Ranking {

    public static void main(String args[]){
        System.out.println("answer : "+solution(5, new int[][]{{4,3}, {4,2}, {3,2}, {1,2}, {2,5}}));
    }

    public static int solution(int n, int[][] results) {
        int[][] rank = new int[n+1][n+1];       // 인덱스 1부터 시작하려고
        int inf = 1000000;                      // 방문 불가능한 경우

        // 자기 자신과 싸우는 경우만 0으로 설정, 나머지는 inf로 초기화
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(i==j)    rank[i][j] = 0;
                else        rank[i][j] = inf;
            }
        }

        // 상대 전적이 있는 경우 check
        // 단 방향으로만 체크해야한다. 승패가 정해져 있기 때문에
        for(int i=0 ; i< results.length; i++){
            rank[results[i][0]][results[i][1]] = 1;
        }

        for(int[] row : rank){
            System.out.println(Arrays.toString(row));
        }
        // 플로리다 와샬 알고리즘으로 승부가 가능한 지 확인
        // k는 거쳐가는 사람
        for(int k=1;k<n+1;k++){
            // i는 나
            for(int i=1;i<n+1;i++){
                // j는 상대
                for(int j=1;j<n+1;j++){
                    if(rank[i][j] > rank[i][k] + rank[k][j]){
                        rank[i][j] = rank[i][k] + rank[k][j];
                    }
                }
            }
        }
        System.out.println("------------------------------");
        for(int[] row : rank){
            System.out.println(Arrays.toString(row));
        }
        System.out.println("------------------------------");
        // 경기를 했는지 여부 체크
        boolean[] check = new boolean[n+1];
        // 모두 경기했다고 초기 설정
        Arrays.fill(check, true);
        // i는 나
        for(int i=1;i<n+1;i++){
            // j는 상대방
            for(int j=1;j<n+1;j++){
                // 나 자신과의 싸움이 아니면서, 서로 싸움을 한 전적이 없는 경우 false로 체크
                if(i != j && rank[i][j] == inf && rank[j][i] == inf){
                    check[i] = false;
                    break;              // 한 명이라도 싸움을 안했다면, i는 순위를 매길수 없기에 break문으로 빠져나옴
                }
            }
        }

        int answer=0;
        // 싸운적이 있는 사람만 count
        for(int i=1;i<n+1;i++){
            if(check[i])   answer++;
        }
        return answer;
    }
}
