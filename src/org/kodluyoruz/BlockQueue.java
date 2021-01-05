package org.kodluyoruz;


public class BlockQueue<T>{
    private Hucre<T> head;
    private Hucre<T> tail;

    public void add(T value){
       Hucre<T> hucre=new Hucre<>(value);
        if(head == null){
            head=hucre;
            tail=hucre;
        }else{
            tail.setNextHucre(hucre);
            tail=hucre;
        }

    }
    public T peek(){
        return head != null ? head.getValue() : null;
    }

    public T poll(){
        if(head != null){

            T temp= head.getValue();
            head=head.getNextHucre();
            return temp;
        }
        return null;
    }

    public Hucre<T> getHead() {
        return head;
    }

}
