package inflearn.java.algorithm.problem.solving.it.big.ch1;

/**
 * 3. 잃어버린 강아지
 */
public class MissingPuppy {

  public static int solution(int[][] board) {
    int answer = 0;
    int n = 10;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    int d1 = 0, d2 = 0;
    int x1 = 0;
    int y1 = 0;
    int x2 = 0;
    int y2 = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == 2) {
          x1 = i;
          y1 = j;
        }
        if (board[i][j] == 3) {
          x2 = i;
          y2 = j;
        }
      }
    }

    int ct = 0;
    while (ct < 10000) {
      ct++;

      int nx1 = x1 + dx[d1];
      int ny1 = y1 + dy[d1];
      int nx2 = x2 + dx[d2];
      int ny2 = y2 + dy[d2];

      boolean flag1 = true, flag2 = true;

      if (nx1 < 0 || nx1 >= n || ny1 < 0 || ny1 >= n || board[nx1][ny1] == 1) {
        d1 = (d1 + 1) % 4;
        flag1 = false;
      }

      if (nx2 < 0 || nx2 >= n || ny2 < 0 || ny2 >= n || board[nx2][ny2] == 1) {
        d2 = (d2 + 1) % 4;
        flag2 = false;
      }

      if(flag1 == true){
        x1 = nx1;
        y1 = ny1;
      }
      if(flag2 == true){
        x2 = nx2;
        y2 = ny2;
      }
      if(x1 == x2 && y1 == y2) break;

    }
    if (ct >= 10000) {
      return 0;
    }

    return ct;
  }

  public static void main(String[] args) {
    int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
        {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
        {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
        {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
    System.out.println(solution(arr1));
    int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
        {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
        {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
        {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
        {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
    System.out.println(solution(arr2));
  }
}
