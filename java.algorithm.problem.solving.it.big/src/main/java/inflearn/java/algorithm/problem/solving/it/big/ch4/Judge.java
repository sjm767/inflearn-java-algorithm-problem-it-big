package inflearn.java.algorithm.problem.solving.it.big.ch4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 4. 심사위원
 */
public class Judge {

  public static int solution(int[] score, int k){
    Arrays.sort(score);

    int start = 0, end = 0;
    for (int i = 0; i < score.length; i++) {
      if(score[i+k-1] - 10 <= score[i]){
        start = i;
        end = i+k-1;
        break;
      }
    }

    int sum = 0;
    for (int i = start; i <= end; i++) {
      sum+=score[i];
    }

    return sum / k;
  }

  public static void main(String[] args){
    System.out.println(solution(new int[]{99, 97, 80, 91, 85, 95, 92}, 3));
    System.out.println(solution(new int[]{92, 90, 77, 91, 70, 83, 89, 76, 95, 92}, 4));
    System.out.println(solution(new int[]{77, 88, 78, 80, 78, 99, 98, 92, 93, 89}, 5));
    System.out.println(solution(new int[]{88, 99, 91, 89, 90, 72, 75, 94, 95, 100}, 5));
  }
}
