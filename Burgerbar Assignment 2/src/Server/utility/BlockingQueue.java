package Server.utility;

import Clients.Chef.mediator.Burger;

public interface BlockingQueue {
    void enqueue(Burger element);
    Burger dequeue();
    int size();
}
