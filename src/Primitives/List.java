
package Primitives;

/*
* made by: gabo2105MS
*/

import Worker.Worker;
import javax.swing.JOptionPane;

public class List {

    private Node pFirst;
    private Node pLast;
    private int size;

    /**
     * Default constructor for an empty List.
     */
    public List() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    /**
     * Constructs a List with an initial Node.
     */
    public List(Node pFirst) {
        this.pFirst = pFirst;
        this.pLast = pFirst;
        this.size = 1;
    }

    /**
     * Checks if the list is empty.
     */
    public boolean isEmpty() {
        return pFirst == null;
    }

    /**
     * Empties the list.
     */
    public void empty() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    /**
     * Adds a new worker to the end of the list.
     */
    public void addToList(Worker data) {
        Node pNew = new Node(data);
        if (this.isEmpty()) {
            this.pFirst = pNew;
            this.pLast = pNew;
        } 
        else {
            this.pLast.setpNext(pNew);
            this.pLast = pNew;
        }
        this.size++;
        pNew.getData().start();

    }

    /**
     * Removes the last worker from the list.
     */
    public boolean removeLast() {
            if (this.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se puede quitar mas trabajadores de este tipo debido a que no hay");
                return false;
            } 
            else {
                if (this.size == 1) {
                    this.pFirst.getData().setHired(false);
                    this.empty();
                    
                    return true;
                } 
                else {
                    Node pAux = this.pFirst;
                    for (int i = 0; i < this.size; i++) {
                        if (pAux.getpNext().equals(this.pLast)) {
                            this.pLast.getData().setHired(false);
                            this.pLast = pAux;
                            this.size--;
                            return true;
                        }
                        pAux = pAux.getpNext();
                    }
                }
            }

        return false;
    }

    /**
     * Gets the first node of the list.
     */
    public Node getpFirst() {
        return pFirst;
    }
    
    /**
     * Gets the node at the specified index.
     * @return The node at the given index, or null if the index is out of bounds.
     */
    public Node getNode(int index){
        if(index>= this.size)
            return null;
        Node node = this.getpFirst();
        for(int i=0; i < index; i++){
            node = node.getpNext();
        }
        return node;
    }

    /**
     * Sets the first node of the list.
     */
    public void setpFirst(Node pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * Gets the last node of the list.
     */
    public Node getpLast() {
        return pLast;
    }

    /**
     * Sets the last node of the list.
     */
    public void setpLast(Node pLast) {
        this.pLast = pLast;
    }

    /**
     * Gets the size of the list.
     * @return The number of nodes in the list.
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets the size of the list.
     */
    public void setSize(int size) {
        this.size = size;
    }

}
