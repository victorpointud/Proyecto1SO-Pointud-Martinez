
package Primitives;

/*
* made by: gabo2105MS
*/

import Worker.Worker;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class List {

    private Node pFirst;
    private Node pLast;
    private int size;

    public List() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

    public List(Node pFirst) {
        this.pFirst = pFirst;
        this.pLast = pFirst;
        this.size = 1;
    }

    public boolean isEmpty() {
        return pFirst == null;
    }

    public void empty() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }

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

    public Node getpFirst() {
        return pFirst;
    }
    
    public Node getNode(int index){
        if(index>= this.size)
            return null;
        Node node = this.getpFirst();
        for(int i=0; i < index; i++){
            node = node.getpNext();
        }
        return node;
    }

    public void setpFirst(Node pFirst) {
        this.pFirst = pFirst;
    }

    public Node getpLast() {
        return pLast;
    }

    public void setpLast(Node pLast) {
        this.pLast = pLast;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
