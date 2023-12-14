package inflearn.java.algorithm.problem.solving.it.big.ch4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1. 이진수 정렬
 */
public class BinarySorting {

  public static String getBinaryNum(int n){
    StringBuilder sb = new StringBuilder();

    while(n/2 !=0){
      sb.insert(0,n%2);
      n=n/2;
    }

    sb.insert(0, n % 2);

    return sb.toString();
  }

  static class Number implements Comparable<Number>{
    int orgNum;
    int binaryCount;

    public Number(int orgNum, int binaryCount) {
      this.orgNum = orgNum;
      this.binaryCount = binaryCount;
    }

    @Override
    public int compareTo(Number o) {
      if (this.binaryCount == o.binaryCount) {
        return this.orgNum - o.orgNum;
      }
      return this.binaryCount - o.binaryCount;
    }
  }
  public static int[] solution(int[] nums){
    int[] answer = new int[nums.length];
    List<String> binaryList = new ArrayList<>();
    List<Number> numList = new ArrayList<>();

    for (int n : nums) {
      binaryList.add(Integer.toBinaryString(n));
    }

    for (int i=0;i<binaryList.size();i++) {
      int c = 0;
      for (Character cc : binaryList.get(i).toCharArray()) {
        if(cc == '1'){
          c++;
        }
      }

      numList.add(new Number(nums[i], c));
    }

    Collections.sort(numList);

    for (int i = 0; i < numList.size(); i++) {
      answer[i] = numList.get(i).orgNum;
    }
    return answer;
  }

  public static void main(String[] args){
    System.out.println(Arrays.toString(solution(new int[]{5, 6, 7, 8, 9})));
    System.out.println(Arrays.toString(solution(new int[]{5, 4, 3, 2, 1})));
    System.out.println(Arrays.toString(solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
  }
}
