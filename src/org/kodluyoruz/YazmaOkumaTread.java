package org.kodluyoruz;

import java.util.concurrent.Semaphore;

class YazmaOkumaTread<T> implements Runnable{
    private boolean ekleme;
    private BlockQueue<T> kuyruk;
    private T[] value;
    private boolean peek;
    private Semaphore semaphore;
    private boolean fullPoll;
    public YazmaOkumaTread(boolean ekleme,BlockQueue<T> kuyruk,T[] value,Semaphore semaphore){
        this.ekleme=ekleme;
        this.kuyruk=kuyruk;
        this.value=value;
        this.semaphore=semaphore;
    }
    public YazmaOkumaTread(boolean ekleme,BlockQueue<T> kuyruk,boolean peek,Semaphore semaphore){
        this.ekleme=ekleme;
        this.kuyruk=kuyruk;
        this.peek=peek;
        this.semaphore=semaphore;
    }
    public YazmaOkumaTread(boolean ekleme,BlockQueue<T> kuyruk,boolean peek,Semaphore semaphore,boolean fullPoll){
        this.ekleme=ekleme;
        this.kuyruk=kuyruk;
        this.peek=peek;
        this.semaphore=semaphore;
        this.fullPoll=fullPoll;
    }

    @Override
    public void run() {
        try{
            semaphore.acquire();
            if(ekleme){
                for(T t:value){
                    kuyruk.add(t);
                    System.out.println("Add işlemi yapan thread: "+t+" değeri eklendi.");
                    Thread.sleep(10);
                }
            }else{
                if(peek) System.out.println("Peek işlemi yapan thread çalıştı: "+kuyruk.peek());
                else{
                    if(fullPoll){
                        while (kuyruk.getHead() != null)
                            System.out.println("Full Poll işlemi yapan thread çalıştı: "+kuyruk.poll());
                    }else{
                        System.out.println("Poll işlemi yapan thread çalıştı: "+kuyruk.poll());
                    }

                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        semaphore.release();

    }
}
