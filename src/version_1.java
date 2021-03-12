/**
 * Spring 2021
 * CS 4310
 * Version 2 requires dynamic memory management. Each PCB maintains a linked list whose entries point to its children.
 * @author Rick Ramirez
 * */

import java.util.LinkedList;

public class version_1 implements processInterface
{
    private int parent;
    private LinkedList<Integer> children;

    public version_1(int id){
        this.parent   = id;
        this.children = new LinkedList<>();
    }

    public int get_parent() {
        return this.parent;
    }

    public int get_first_child() {
        return Integer.MIN_VALUE;
    }

    public int get_older_sibling() {
        return Integer.MIN_VALUE;
    }

    public int get_younger_sibling() {
        return Integer.MIN_VALUE;
    }

    public int set_parent(int parentID) {
        return this.parent = parentID;
    }

    public int set_first_child(int firstChild) {
        return Integer.MIN_VALUE;
    }

    public int set_younger_sibling(int youngerSibling) {
        return Integer.MIN_VALUE;
    }

    public int set_older_sibling(int olderSibling) {
        return Integer.MIN_VALUE;
    }

    /**
     * Creates a new child of the calling process
     *
     * @param newEntry the object to be added as a new entry
     * @return true if the creation is successful
     */

    public static boolean create(int newEntry) {
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
