package inflearn.java.algorithm.problem.solving.it.big.ch1;

import java.util.Arrays;

/**
 * 8. 회의실 만남
 */
public class MeetingRoom {
  public static int[] solution(int[] enter, int[] exit){
    int n = enter.length;
    int[] answer = new int[n];


    int[] enterIdx = new int[n];
    int[] enterTime = new int[n];
    int[] exitTime = new int[n];
    int[] ch = new int[n];

    for (int i = 0; i < n; i++) {
      enter[i] = enter[i]-1;
      exit[i] = exit[i]-1;
    }

    for (int i = 0; i < n; i++) {
      enterIdx[enter[i]] = i;
    }

    int j = 0;
    int time = 0;
    for (int i = 0; i < n; i++) {
      int e = exit[i];

      if(ch[e] == 0){
        for(;j<n;j++){
          enterTime[enter[j]] = time;
          ch[enter[j]] = 1;
          time++;
          if(enter[j] == e){
            j++;
            break;
          }
        }
      }
      exitTime[e] = time++;
    }
    for(int i = 0; i < n; i++){
      for(j = i + 1; j < n; j++){
        //서로 만나는 조건
        if(!(exitTime[i] < enterTime[j] || exitTime[j] < enterTime[i])){
          answer[i]++;
          answer[j]++;
        }
      }
    }
    return answer;
  }

  public static void main(String[] args){
    System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
    System.out.println(Arrays.toString(solution(new int[]{1, 2, 5, 3, 4}, new int[]{2, 3, 1, 4, 5})));
    System.out.println(Arrays.toString(solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7})));
    System.out.println(Arrays.toString(solution(new int[]{1, 4, 7, 2, 3, 5, 6}, new int[]{5, 2, 6, 1, 7, 3, 4})));
    System.out.println(Arrays.toString(solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 4, 3})));
  }
}
