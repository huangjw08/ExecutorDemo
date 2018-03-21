package demo;

import java.util.concurrent.Callable;

public class LiftOff implements Callable<String> {
    private int countDown=3;
    private static int taskCount=0;
    private int id=taskCount;
    //private Launch launch;

    public LiftOff() {
        taskCount++;
       // this.launch=launch;
    }

//    public void run() {
//        while(countDown>=0){
//            System.out.println("线程编号"+id+"--倒计时"+countDown);
//            countDown--;
//            if (countDown<0){
//                launch.callBack();
//            }
//            Thread.yield();
//        }
//    }

    public String call() {
        while (countDown>=0){
            System.out.println("线程编号"+id+"--倒计时"+countDown);
            countDown--;
        }
        return "线程编号"+id+"--结束";
    }
}
