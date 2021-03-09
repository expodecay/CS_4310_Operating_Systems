/**
 * Spring 2021
 * CS 4310
 * Version 2 requires no dynamic memory management. The links are distributed over the PCBs such that each instance
 * points to the immediate younger and older sibling.
 * @author Rick Ramirez
 * */

public class version_2 implements processInterface
{
    private int parent;
    private int firstChild;
    private int youngerSibling;
    private int olderSibling;

    public version_2(int id) {
        this.parent         = id;
        this.firstChild     = Integer.MIN_VALUE;
        this.youngerSibling = Integer.MIN_VALUE;
        this.olderSibling   = Integer.MIN_VALUE;
    }

    public int get_parent() {
        return this.parent;
    }

    public int get_first_child() {
        return this.firstChild;
    }

    public int get_older_sibling() {
        return this.olderSibling;
    }

    public int get_younger_sibling() {
        return this.youngerSibling;
    }

    public int set_parent(int parentID) {
        return this.parent = parentID;
    }

    public int set_first_child(int firstChild) {
        return this.firstChild = firstChild;
    }

    public int set_younger_sibling(int youngerSibling) {
        return this.youngerSibling = youngerSibling;
    }

    public int set_older_sibling(int olderSibling) {
        return this.olderSibling = olderSibling;
    }

    /**
     * Creates a new child of the calling process
     *
     * @param newEntry the object to be added as a new entry
     * @return true if the creation is successful
     */

    public boolean create(int newEntry) {
        return false;
    }

    /**
     * Recursively destroys all descendents of the calling process
     *
     * @param anEntry the parent to be removed
     * @return true if the removal was successful, or false if not
     */
    public static boolean destroy(int anEntry) {
        return false;
    }
}

