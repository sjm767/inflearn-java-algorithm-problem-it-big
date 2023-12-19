package inflearn.java.algorithm.problem.solving.it.big.ch5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 3. 스프링 쿨러
 */
public class SpringCooler {
  public static int solution(int n, int[] nums){
    int answer = 1;
    int[][] list = new int[n+1][2];

    for (int i = 0; i <= n; i++) {
      int s = i-nums[i] < 0 ? 0 : i-nums[i];
      int e = i+nums[i] >= n ? n : i+nums[i];

      list[i][0] = s;
      list[i][1] = e;
    }

    Arrays.sort(list, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

    int s = 0;
    int e = 0;

    for (int i = 0; i < list.length; i++) {
      if(list[i][0] > s){
        answer++;
        s=e;
      }

      if(list[i][0] > s){
        return -1;
      }

      if(list[i][1] > e){
        e = list[i][1];
      }

      if(e==n){
        break;
      }
    }



    return answer;

    //강사님 답안
//    int answer = 0;
//    int[][] line = new int[nums.length + 1][2];
//    for(int i = 0; i <= n; i++){
//      line[i][0] = Math.max(0, i - nums[i]);
//      line[i][1] = Math.min(n, i + nums[i]);
//    }
//    Arrays.sort(line, (a, b) -> a[0] - b[0]);
//    int start = 0, end = 0, i = 0;
//    while(i < line.length){
//      while(i < line.length && line[i][0] <= start){
//        end = Math.max(end, line[i][1]);
//        i++;
//      }
//      answer++;
//      if(end == n) return answer;
//      if(start == end) return -1;
//      start = end;
//    }
//    return answer;
  }

  public static void main(String[] args){
    System.out.println(solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
    System.out.println(solution(4, new int[]{1, 2, 2, 0, 0}));
    System.out.println(solution(5, new int[]{2, 0, 0, 0, 0, 2}));
    System.out.println(solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
  }

}
