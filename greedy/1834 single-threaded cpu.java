/*
https://leetcode.com/problems/single-threaded-cpu/description/

enumerate tasks and sort by runtime -> add first enqueued tasks -> poll fastest task off heap -> advance clock w/ each task and add to output list -> add enqueued tasks to heap -> repeat
if clock doesn't advance enough during execution, skip to next enqueue time -> otherwise CPU.doTask() should add enough time to clock to enqueue more tasks

time: O(n log n) -> sorting tasks by time O(n log n) -> heap gradually built O(n log n) -> heap replacement O(log n)
space: O(n) -> min heap for tasks O(n) -> output task ordering O(n)
*/

class CPU {
    private int[][] tasks;
    private PriorityQueue<Pair<Integer, Integer>> queue;
    private int taskNum;
    private int clock;

    public CPU(int[][] tasks) {
        this.tasks = tasks;
        this.queue = new PriorityQueue<>((a, b) -> ((int) a.getValue() != (int) b.getValue()) ? 
                                                        a.getValue() - b.getValue() : 
                                                        a.getKey() - b.getKey());
        this.taskNum = 0;
        this.clock = tasks[0][0];
    }

    public Pair<Integer, Integer> doTask() {
        Pair<Integer, Integer> out = new Pair<>(0, 0);
        if (!this.queue.isEmpty()) {
            out = this.queue.poll();
            this.clock += out.getValue();
        } else {
            this.safeClockSkip();
            this.queueTasks();
            out = this.doTask();
        }

        return out;
    }

    public void queueTasks() {
        while (this.taskNum < this.tasks.length && this.tasks[taskNum][0] <= this.clock) {
            Pair<Integer, Integer> task = new Pair<>(this.tasks[taskNum][2], this.tasks[taskNum][1]);
            this.queue.offer(task);
            this.taskNum++;
        }
    }

    private void safeClockSkip() {
        if (this.taskNum < this.tasks.length && this.clock < this.tasks[taskNum][0]) {
            this.clock = this.tasks[taskNum][0];
        }
    }
}

class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int i = 0;

        int[] out = new int[n];
        
        int[][] arr = new int[n][3];
        for (int j = 0; j < n; j++) {
            arr[j] = new int[] {tasks[j][0], tasks[j][1], j};
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        CPU cpu = new CPU(arr);

        while (i < n) {
            cpu.queueTasks();
            Pair<Integer, Integer> cpuTask = cpu.doTask();

            out[i] = cpuTask.getKey();
            i++;
        }

        return out;
    }
}
