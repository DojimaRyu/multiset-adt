import java.util.ArrayList;

public class Tree {
    private Integer root;

    private ArrayList<Tree> subtrees;

    public Tree(Integer root) {
        if (root != null) { 
            this.root = root;
            left = new Tree();
            right = new Tree();
        }

    }

    /**
     * Alternate constructor, so we don't have to explicitly pass in null.
     */
    public Tree() {
        this(null);
    }

    public boolean isEmpty() {
        if (this.root == null) {
            return true;
        }

        return false;
    }

    public int len() {
        if (this.isEmpty()) {
            return 0;
        }

        else {
            int size = 1;
            for (Tree t : subtrees) {
                size += t.len();
            }

            return size;

        }
    }

    public int count(int item) {
        if (this.isEmpty()) {
            return 0;
        }

        else {
            int num = 0;
            if (this.root.equals(item)) {
                num += 1;
            }

            for (Tree t : subtrees) {
                num += t.count(item);
            }

            return num;
        }
    }


    // TODO complete this Tree class to replicate the implementation from the Tree class in adts.py
}
