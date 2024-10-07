package Primitives;

/*
* made by: gabo2105MS
*/

import Worker.Worker;

public class Node {
    
    private Worker data;
    private Node pNext;

    /**
     * Constructs a Node with the specified Worker data.
     */
    public Node(Worker data) {
        this.data = data;
    }

    /**
     * Getters & Setters.
     */
    public Worker getData() {
        return data;
    }
    
    public void setData(Worker data) {
        this.data = data;
    }

    public Node getpNext() {
        return pNext;
    }

    public void setpNext(Node pNext) {
        this.pNext = pNext;
    }
    
    
    
}