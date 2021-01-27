package concept.dp;

import java.util.Arrays;

public class FloydWarshall {
    public static void main(String args[]){
    int inf = 1000000;
    int[][] matrix = { {0, inf, 7 ,10},
                       {3, 0, 12 , inf},
                       {inf, inf, 0, 5},
                       {8, 5, 9, 0}};
    int n = matrix.length;

    // 플로리드 와샬 알고리즘
    // k : 거쳐가는 노드
    for(int k=0;k<n;k++){
        // i : 시작하는 노드
        for(int i=0;i<n;i++){
            // j : 도착하는 노드
            for(int j=0;j<n;j++){
                if(matrix[i][j] > matrix[i][k]+matrix[k][j]){
                    matrix[i][j] = matrix[i][k]+matrix[k][j];
                }
            }
        }
    }

        // print
        for(int[] row : matrix ){
            System.out.println(Arrays.toString(row));
        }
    }
}
