package org.kodluyoruz;

public class Hucre<T>{
    private T value;
    private Hucre<T> next;

    public Hucre(T value){
        this.value=value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setNext(Hucre<T> next) {
        this.next = next;
    }


    public void setNextHucre(Hucre<T> next){this.next=next;}
    public Hucre<T> getNextHucre(){ return next; }

}
