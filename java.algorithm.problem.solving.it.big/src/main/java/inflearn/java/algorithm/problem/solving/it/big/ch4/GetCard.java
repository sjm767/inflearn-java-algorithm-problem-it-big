package inflearn.java.algorithm.problem.solving.it.big.ch4;


import java.util.Arrays;
import java.util.Collections;

/**
 * 3. 카드 가져가기
 */
public class GetCard {
  public static int solution(int[] nums, int k){
    int answer = 0;
    Integer[] integerArray = Arrays.stream(nums)
        .boxed()
        .toArray(Integer[]::new);
    Arrays.sort(integerArray, Collections.reverseOrder());

    Integer[] diff = new Integer[nums.length/2];
    int score = 0;
    int idx = 0;

    for (int i = 1; i < nums.length; i+=2) {
      score+=integerArray[i];
      diff[idx++] = integerArray[i-1] - integerArray[i];
    }

    Arrays.sort(diff, Collections.reverseOrder());

    for (int i = 0; i < k; i++) {
      score+=diff[i];
    }

    return score;
  }

  public static void main(String[] args){
    System.out.println(solution(new int[]{7, 8, 5, 12, 3, 1, 3, 1, 1, 12}, 2));
    System.out.println(solution(new int[]{8, 2, 12, 12, 12, 12, 2, 2}, 2));
    System.out.println(solution(new int[]{3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7}, 3));
    System.out.println(solution(new int[]{12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12}, 3));
    System.out.println(solution(new int[]{14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19}, 3));
  }
}
