public class NodoCB {
    NodoCB parent; //El padre
    NodoCB sibling; //El Hermano
    NodoCB child; //El Hijo
    int key; //El dato
    short degree; //El grado

    //Constructor
    public NodoCB(NodoCB parent, NodoCB sibling, NodoCB child, int key, short degree){
        this.parent = parent;
        this.sibling = sibling;
        this.child = child;
        this.key = key;
        this.degree = degree;
    }

    //Une dos arboles binomiales
    public void BinomialLink(NodoCB z){
        parent = z;
        sibling = z.child;
        z.child = this;
        z.degree++;
    }

    public int compareTo(NodoCB other){
        return this.key.compareTo(other.key);
    }
    

    
}
