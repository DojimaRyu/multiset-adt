public class Tree {
    private Integer root;

    private Tree left;
    private Tree right;

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

    // TODO complete this Tree class to replicate the implementation from the Tree class in adts.py
}
