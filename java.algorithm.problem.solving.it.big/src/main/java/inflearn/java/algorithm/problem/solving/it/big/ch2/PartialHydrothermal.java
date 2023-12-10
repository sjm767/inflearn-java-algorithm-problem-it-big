package inflearn.java.algorithm.problem.solving.it.big.ch2;

/**
 * 4. 음수가 있는 부분 수열
 */
public class PartialHydrothermal {
  public static int solution(int[] nums, int m){
    int answer = 0;
    int n = nums.length;

    int lt = 0;
    int rt = 1;
    int sum = 0;

    sum += nums[lt];
    while(lt <= rt){
      sum+=nums[rt];

      if(sum == m){
        answer++;
        rt++;
      }else if(sum < m){
        rt++;
      }else{
        while(sum > m){
          sum-=nums[lt++];
        }
      }
    }



    return answer;
  }

  public static void main(String[] args){
    System.out.println(solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
//    System.out.println(solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
//    System.out.println(solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
//    System.out.println(solution(new int[]{-1, 0, 1}, 0));
//    System.out.println(solution(new int[]{-1, -1, -1, 1}, 0));
  }
}
