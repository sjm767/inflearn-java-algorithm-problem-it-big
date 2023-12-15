package inflearn.java.algorithm.problem.solving.it.big.ch3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 6. CPU 스케쥴링
 */
public class CPUScheduling{
  static class Task implements Comparable<Task>{
    int startTime;
    int processTime;

    public Task(int startTime, int processTime) {
      this.startTime = startTime;
      this.processTime = processTime;
    }

    @Override
    public int compareTo(Task o) {
      if(this.processTime == o.processTime){
        return this.startTime - o.startTime;
      }
      return this.processTime - o.processTime;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Task task = (Task) o;
      return startTime == task.startTime && processTime == task.processTime;
    }

    @Override
    public int hashCode() {
      return Objects.hash(startTime, processTime);
    }
  }
  public static int[] solution(int[][] tasks){
    int n = tasks.length;
    int[] answer = new int[n];
    LinkedList<int[]> programs = new LinkedList<>();
    for(int i = 0; i < n; i++){
      programs.add(new int[]{tasks[i][0], tasks[i][1], i});
    }
    programs.sort((a, b) -> a[0] - b[0]);
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
    int fT = 0, idx = 0;
    while(!programs.isEmpty() || !pq.isEmpty()){
      if(pq.isEmpty()) fT = Math.max(fT, programs.peek()[0]);
      while(!programs.isEmpty() && programs.peek()[0] <= fT){
        int[] x = programs.pollFirst();
        pq.add(new int[]{x[1], x[2]});
      }
      int[] ex = pq.poll();
      fT = fT + ex[0];
      answer[idx++] = ex[1];
    }
    return answer;
  }

  public static void main(String[] args){
    System.out.println(Arrays.toString(solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
    System.out.println(Arrays.toString(solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
    System.out.println(Arrays.toString(solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
    System.out.println(Arrays.toString(solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
  }
}
