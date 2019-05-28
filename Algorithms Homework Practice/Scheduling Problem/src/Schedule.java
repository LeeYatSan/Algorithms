import java.util.HashSet;

public class Schedule {

    private Job[] jobs;

    Schedule(Job[] jobs){
        this.jobs = jobs;
    }

    public void getTheSchedule(){
        HeapSort heapSort = new HeapSort(jobs);
        int len = jobs.length;
        int currWait = jobs[0].getTime()*(-1);
        int totalWait = 0;
        for(int i = 0; i < len; ++i){
            Job curr = heapSort.getMin();
            currWait += curr.getTime();
            totalWait += currWait;
            System.out.print(curr.getJobNO() + " ");
        }
        System.out.println("\nAverage time: " + totalWait/jobs.length);
    }


    public static void main(String[] args){

        int[] jobTime = {15, 8, 3, 10};
        int len = jobTime.length;
        if(len == 0){
            return;
        }
        Job[] jobs = new Job[len];
        for(int i = 0; i < len; ++i){
            jobs[i] = new Job(i, jobTime[i]);
        }

        long startTime = System.nanoTime();
        (new Schedule(jobs)).getTheSchedule();
        long endTime = System.nanoTime();
        System.out.println("Executing Time: " + (endTime-startTime));
    }
}


class Job{

    private int JobNO;
    private int time;

    public Job(int jobNO, int time) {
        JobNO = jobNO;
        this.time = time;
    }

    public int getJobNO() {
        return JobNO;
    }

    public void setJobNO(int jobNO) {
        JobNO = jobNO;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}

class HeapSort{

    Job[] jobs;
    int len;

    HeapSort(Job[] jobs){
        if(jobs == null || jobs.length == 0){
            return;
        }
        this.jobs = jobs;
        this.len = jobs.length;
        buildMinHeap();
    }

    public Job getMin(){

        Job result = jobs[0];
        jobs[0] = new Job(0,0);
        swap(0, len-1);
        --len;
        heapify(0);
        return result;
    }

    private void buildMinHeap(){

        for(int i = len/2-1; i >=0; --i){
            heapify(i);
        }
    }

    private void heapify(int currIndex){

        int currVal = jobs[currIndex].getTime();
        int left = currIndex*2+1;
        int right= currIndex*2+2;
        int minIndex = currIndex;
        if(left < len && jobs[minIndex].getTime() > jobs[left].getTime()){
            minIndex = left;
        }
        if(right < len && jobs[minIndex].getTime() > jobs[right].getTime()){
            minIndex = right;
        }
        if(currVal != jobs[minIndex].getTime()){
            swap(currIndex, minIndex);
            heapify(minIndex);
        }
    }

    private void swap(int indexA, int indexB){
        Job temp = jobs[indexA];
        jobs[indexA] = jobs[indexB];
        jobs[indexB] = temp;
    }
}