package Server.utility;

import Clients.Chef.mediator.Burger;

public class Queue implements BlockingQueue {
    private ListADT<Burger> list;
    private int maxBurgerAmount = 20;

    public Queue() {
        this.list = new ArrayList();
    }

    @Override
    public synchronized void enqueue(Burger element) {
        while (list.size() >= maxBurgerAmount){
            try {
                wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        if(null == element) throw new IllegalArgumentException("Cannot enqueue null");
        list.add(element);
        notifyAll();
    }

    @Override
    public synchronized Burger dequeue() {
        while (list.size() <= 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
        return list.remove(0);
    }

    @Override
    public synchronized int size() {
        return list.size();
    }
}



