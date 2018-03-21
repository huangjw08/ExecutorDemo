package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Launch {

    public static void main(String[] args) {
        ExecutorService executor= Executors.newCachedThreadPool();
        List<Future<String>> results=new ArrayList<>();

        for(int i=0;i<3;i++){
            final int finalI = i;
            Future<String> future=executor.submit(new Runnable() {
                @Override
                public void run() {
                    int countDown=3;
                    while(countDown>0){
                        System.out.println("编号"+ finalI +"倒计时--"+countDown);
                        countDown--;
                    }
                }
            },"编号"+i+"结束");
            //Future<String> future=executor.submit(new LiftOff());
            results.add(future);
        }

        for(Future<String> result:results){
            try {
                String s=result.get();
                System.out.println(s);
            }catch (InterruptedException | ExecutionException e){
                e.printStackTrace();
            }
        }

        System.out.println("发射！！");
    }
}
