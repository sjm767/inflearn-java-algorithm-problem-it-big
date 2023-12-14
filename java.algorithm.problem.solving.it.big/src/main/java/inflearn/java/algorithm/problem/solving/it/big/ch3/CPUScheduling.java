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
    int min = Integer.MAX_VALUE;
    int idx = 0;
    int[] answer = new int[n];

    Map<Integer, List<Task>> taskMap = new HashMap<>();
    Map<Task, Integer> taskIdx = new HashMap<>();
    for (int i = 0; i < n; i++) {
      List<Task> taskList = taskMap.getOrDefault(tasks[i][0], new ArrayList<>());
      Task task = new Task(tasks[i][0], tasks[i][1]);
      taskList.add(task);
      taskIdx.put(task, i);

      taskMap.put(tasks[i][0], taskList);
      min = Math.min(min, task.startTime);
    }

    int time = min ;
    int ft = min;
    Queue<Task> queue = new PriorityQueue<>();
    for (;; time++) {
      List<Task> taskList = taskMap.get(time);

      if(taskList != null){
        for (Task t : taskList) {
          queue.add(t);
        }
      }

      if(taskIdx.size() == 0){
        time = ft;
        if (queue.isEmpty()) {
          break;
        }
      }
      if(ft < time){
        ft = time;
      }

      if(ft == time && !queue.isEmpty()){
        Task t = queue.poll();
        ft += t.processTime;

        answer[idx++] = taskIdx.get(t);
        taskIdx.remove(t);
      }
    }

//    while (!queue.isEmpty()) {
//      Task task = queue.poll();
//      System.out.println(task.startTime+","+task.processTime);
//    }

    return answer;
  }

  public static void main(String[] args){
    System.out.println(Arrays.toString(solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
    System.out.println(Arrays.toString(solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
    System.out.println(Arrays.toString(solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
    System.out.println(Arrays.toString(solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
  }
}
