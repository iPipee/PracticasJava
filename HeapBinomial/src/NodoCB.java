public class NodoCB {
    NodoCB parent; //El padre
    NodoCB sibling; //El Hermano
    NodoCB child; //El Hijo
    Integer key; //El dato
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
    public void binomialLink(NodoCB z){
        parent = z;
        sibling = z.child;
        z.child = this;
        z.degree++;
    }

    public int compareTo(NodoCB other){
        return this.key.compareTo(other.key);
    }

    public void print(int level){
        NodoCB curr = this;
        while(curr != null){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < level; i++) {
                sb.append("    ");
            }
            sb.append(curr.key.toString());
            System.out.println(sb.toString());
            if(curr.child != null){
                curr.child.print(level + 1);
            }
            curr = curr.sibling;
        }
    }
    

    
}
