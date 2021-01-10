package org.kodluyoruz;

import java.util.concurrent.Semaphore;

public class Main {
    // public YazmaOkumaTread(boolean ekleme,BlockQueue<T> kuyruk,boolean peek,Semaphore semaphore)
    //public YazmaOkumaTread(boolean ekleme,BlockQueue<T> kuyruk,T[] value,Semaphore semaphore){
    public static void main(String[] args) throws InterruptedException {

        BlockQueue<Integer> kuyruk= new BlockQueue<>();
        Integer intArr[]= {3,5,6,7,8,10,11};
        Semaphore semaphore=new Semaphore(1,true);
        YazmaOkumaTread<Integer> ekleme=new YazmaOkumaTread<>(true,kuyruk,intArr,semaphore);
        YazmaOkumaTread<Integer> peekOkuma=new YazmaOkumaTread<>(false,kuyruk,true,semaphore);
        YazmaOkumaTread<Integer> pollOkuma=new YazmaOkumaTread<>(false,kuyruk,false,semaphore,false);
        YazmaOkumaTread<Integer> fullPollOkuma=new YazmaOkumaTread<>(false,kuyruk,false,semaphore,true);

        Thread t1=new Thread(ekleme);
        Thread t2=new Thread(peekOkuma);
        Thread t3=new Thread(pollOkuma);
        Thread t4=new Thread(fullPollOkuma);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

    }
}
