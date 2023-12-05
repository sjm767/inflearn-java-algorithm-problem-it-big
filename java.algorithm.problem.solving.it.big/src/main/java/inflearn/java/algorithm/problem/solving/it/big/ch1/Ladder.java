package inflearn.java.algorithm.problem.solving.it.big.ch1;

import java.util.*;

/**
 * 1. 사다리 타기
 */
public class Ladder {

  public static char[] solution(int n, int[][] ladder){
    char[] answer = new char[n];

    for (int i = 0; i < n; i++) {
      answer[i] = (char) ('A' + i);
    }

    for (int i = 0; i < ladder.length; i++) {
      for (int j = 0; j < ladder[i].length; j++) {
        int a = ladder[i][j];
        int b = ladder[i][j]+1;

        char tmp=answer[a-1];
        answer[a-1] = answer[b-1];
        answer[b-1]=tmp;
      }
    }


    return answer;
  }

  public static void main(String[] args){
    System.out.println(Arrays.toString(solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
    System.out.println(Arrays.toString(solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
    System.out.println(Arrays.toString(solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
    System.out.println(Arrays.toString(solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
  }

}
