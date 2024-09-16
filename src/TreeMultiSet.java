public class TreeMultiSet extends MultiSet {
    private Tree tree;
    // TODO add a Tree object as a private instance variable for this class.
    /**
     * Add the given item to this multiset.
     *
     * @param item the item to add
     */
    @Override
    public void add(Integer item) {
        this.tree.insert(item);
    }

    public void remove(Integer item) {
        return;
        //TODO: Add this.tree.delete(item);
    }

    public boolean contains(Integer item) {
        return this.tree.contains(item);
    }

    public boolean isEmpty() {
        return this.tree.isEmpty();
    }

    public Integer count(Integer item) {
        return this.tree.count(item);
    }

    public Integer size() {
        return this.tree.len();
    }


    // TODO write the rest of the implementation for this class so that it uses its private Tree
    //      object to provide the MultiSet functionality.
}
