package inflearn.java.algorithm.problem.solving.it.big.ch1;

import java.util.Arrays;

/**
 * 4. 좌석번호
 */
public class Seat {

  public static int[] solution(int c, int r, int k) {
    int[] answer = new int[2];
    int[][] seat = new int[c][r];

    if(k > c*r){
      return answer;
    }

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int d = 1;

    int x = 0, y = 0;
    int ct =1;
    while(ct < k){
      int nx = x + dx[d];
      int ny = y + dy[d];

      if(nx < 0 || nx >= c || ny < 0 || ny >= r || seat[nx][ny] != 0){
        d = (d+1) % 4;
        continue;
      }
      seat[x][y] = ct;
      ct++;

      x = nx;
      y = ny;
    }

    answer[0] = x+1;
    answer[1] = y+1;
    return answer;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(solution(6, 5, 12)));
    System.out.println(Arrays.toString(solution(6, 5, 20)));
    System.out.println(Arrays.toString(solution(6, 5, 30)));
    System.out.println(Arrays.toString(solution(6, 5, 31)));
  }

}
