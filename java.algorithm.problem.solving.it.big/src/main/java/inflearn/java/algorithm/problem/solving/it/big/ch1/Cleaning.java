package inflearn.java.algorithm.problem.solving.it.big.ch1;

import java.util.*;

/**
 * 2. 청소
 */
public class Cleaning {

  public static int[] solution(int[][] board, int k) {
    int[] answer = new int[2];
    int n = board.length;
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    int d = 1;

    int ct = 0;
    int x = 0;
    int y = 0;
    while (ct < k) {
      ct++;

      int nx = x + dx[d];
      int ny = y + dy[d];

      if (nx >= 0 && ny >= 0 && nx <= n - 1 && ny <= n - 1 && board[nx][ny] == 0) {
        x = nx;
        y = ny;
      } else {
        d = (d +1) % 4;
      }
    }

    answer[0] = x;
    answer[1] = y;

    return answer;
  }

  public static void main(String[] args) {
    int[][] arr1 = {{0, 0, 0, 0, 0},
        {0, 1, 1, 0, 0},
        {0, 0, 0, 0, 0},
        {1, 0, 1, 0, 1},
        {0, 0, 0, 0, 0}};
    System.out.println(Arrays.toString(solution(arr1, 10)));
    int[][] arr2 = {{0, 0, 0, 1, 0, 1},
        {0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 1},
        {1, 1, 0, 0, 1, 0},
        {0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0}};
    System.out.println(Arrays.toString(solution(arr2, 20)));
    int[][] arr3 = {{0, 0, 1, 0, 0},
        {0, 1, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {1, 0, 0, 0, 1},
        {0, 0, 0, 0, 0}};
    System.out.println(Arrays.toString(solution(arr3, 25)));

  }

}
