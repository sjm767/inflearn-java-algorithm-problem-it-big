package inflearn.java.algorithm.problem.solving.it.big.ch4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 5. 모임 장소
 */
public class MeetingPlace {
  public static int solution(int[][] board){
    int answer=0;
    int n = board.length;
    List<Integer> x = new ArrayList<>();
    List<Integer> y = new ArrayList<>();

    int xTarget = 0, yTarget = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if(board[i][j] == 1){
          x.add(i);
          y.add(j);
        }
      }
    }

    Collections.sort(x);
    Collections.sort(y);

    xTarget = x.get(x.size() / 2);
    yTarget = y.get(y.size() / 2);

    for (int i = 0; i < x.size(); i++) {
      int xx = Math.abs(xTarget - x.get(i));
      int yy = Math.abs(yTarget - y.get(i));

      answer += (xx + yy);
    }

    return answer;
  }

  public static void main(String[] args){
    System.out.println(solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
    System.out.println(solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
    System.out.println(solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
  }
}
