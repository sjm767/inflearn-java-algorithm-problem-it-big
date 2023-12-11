package inflearn.java.algorithm.problem.solving.it.big.ch3;

import java.util.Set;
import java.util.TreeSet;

/**
 * 1. 최대 길이 연속 수열
 */
public class MaxLengthProgression {
  public static int solution(int[] nums){
    int answer = 1;
    Integer[] uniqueNums;
    Set<Integer> set = new TreeSet<>();


    for (Integer n : nums) {
      set.add(n);
    }
    uniqueNums = set.toArray(new Integer[0]);
    int lastNum = uniqueNums[0];

    for (int i = 1; i < uniqueNums.length; i++) {
      int current = uniqueNums[i];
      if(current - lastNum != 1){
        break;
      }else{
        answer++;
        lastNum = current;
      }
    }


    return answer;
  }

  public static void main(String[] args){
    System.out.println(solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
    System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
    System.out.println(solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
    System.out.println(solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
    System.out.println(solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
  }
}
