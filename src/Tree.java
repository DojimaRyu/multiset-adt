import java.util.ArrayList;
import java.util.Objects;

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
        return this.root == null;
    }

    public Integer len() {
        if (this.isEmpty()) {
            return 0;
        }

        else {
            Integer size = 1;
            for (Tree t : subtrees) {
                size += t.len();
            }

            return size;

        }
    }

    public Integer count(Integer item) {
        if (this.isEmpty()) {
            return 0;
        }

        else {
            Integer num = 0;
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
            StringBuilder s = new StringBuilder(this.root + "\n");
            for (Tree t : subtrees) {
                s.append(t.strIndented(1));
            }
            return s.toString();
        }
    }

    public String strIndented(Integer depth) {
        if (this.isEmpty()) {
            return "";
        }

        else {
            StringBuilder s = new StringBuilder(" ".repeat(depth) + this.root + "\n");
            for (Tree t : subtrees) {
                depth += 1;
                s.append(t.strIndented(depth));
            }
            return s.toString();
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

            if (!Objects.equals(this.len(), other.len())) {
                return false;
            }

            return this.subtrees.equals(other.subtrees);
        }
    }

    public boolean contains(Integer item) {
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


    public Integer extract_leaf() {
        if (this.subtrees.isEmpty()) {
            Integer oldRoot = this.root;
            this.root = null;
            return oldRoot;
        }

        else {
            Integer leaf = this.subtrees.getFirst().extract_leaf();

            if (this.subtrees.getFirst().isEmpty()) {
                this.subtrees.removeFirst();
            }

            return leaf;
        }
    }

    public void insert(Integer item) {
        if (this.isEmpty()) {
            this.root = item;
        }

        else if (!this.subtrees.isEmpty()) {
            Tree t = new Tree(item);
            this.subtrees.add(t);
        }

        else {
            double test = Math.floor(3 * Math.random()) + 1;

            if (test == 3.0) {
                this.subtrees.add(new Tree(item));
            }

            else {
                int length = this.subtrees.size();
                double subtreeIndex = Math.floor(length * Math.random());
                this.subtrees.get((int)subtreeIndex).insert(item);
            }


        }
    }

    public boolean insertChild(Integer item, Integer parent) {
        if (this.isEmpty()) {
            return false;
        }

        else if (Objects.equals(this.root, parent)) {
            this.subtrees.add(new Tree(item));
            return true;
        }

        else {
            for (Tree t : subtrees) {
                if (t.insertChild(item, parent)) {
                    return true;
                }
            }
            return false;
        }
    }

    // TODO complete this Tree class to replicate the implementation from the Tree class in adts.py
}
