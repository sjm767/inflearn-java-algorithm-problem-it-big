package inflearn.java.algorithm.problem.solving.it.big.ch5;

import java.util.Arrays;

/**
 * 2. 이동 횟수
 */
public class MoveCount {
  public static int solution(int[] nums){
    int answer = 0;
    Arrays.sort(nums);
    int left = 0;
    int right = nums.length-1;
    while(left <= right){
      if(nums[left] + nums[right] <= 5){
        answer++;
        left++;
        right--;
      }
      else{
        answer++;
        right--;
      }
    }
    return answer;
  }

  public static void main(String[] args){
    System.out.println(solution(new int[]{2, 5, 3, 4, 2, 3}));
    System.out.println(solution(new int[]{2, 3, 4, 5}));
    System.out.println(solution(new int[]{3, 3, 3, 3, 3}));
  }
}
