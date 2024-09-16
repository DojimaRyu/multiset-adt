import java.util.ArrayList;

public class Tree {
    private Integer root;

    private ArrayList<Tree> subtrees;

    public Tree(Integer root) {
        if (root != null) { 
            this.root = root;
            this.subtrees = new ArrayList<>();
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

    public String str() {
        return this.strIndented();
    }

    public String strIndented() {
        if (this.isEmpty()) {
            return "";
        }

        else {
            String s = this.root + "\n";
            for (Tree t : subtrees) {
                s += t.strIndented(1);
            }
            return s;
        }
    }

    public String strIndented(int depth) {
        if (this.isEmpty()) {
            return "";
        }

        else {
            String s = " ".repeat(depth) + this.root + "\n";
            for (Tree t : subtrees) {
                depth += 1;
                s += t.strIndented(depth);
            }
            return s;
        }
    }

    public boolean eq(Tree other) {
        if (this.isEmpty() && other.isEmpty()) {
            return true;
        }

        else if (this.isEmpty() || other.isEmpty()) {
            return false;
        }

        else {
            if (this.root.compareTo(other.root) != 0) {
                return false;
            }

            if (this.len() != other.len()) {
                return false;
            }

            return this.subtrees.equals(other.subtrees);
        }
    }

    public boolean contains(int item) {
        if (this.isEmpty()) {
            return false;
        }

        if (this.root.equals(item)) {
            return true;
        }

        else {
            for (Tree t : subtrees) {
                if (t.contains(item)) {
                    return true;
                }
            }

            return false;
        }
    }


    // TODO complete this Tree class to replicate the implementation from the Tree class in adts.py
}
