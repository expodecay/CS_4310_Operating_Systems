/**
 * Spring 2021
 * CS 4310
 * Version 2 requires no dynamic memory management. The links are distributed over the PCBs such that each instance
 * points to the immediate younger and older sibling.
 * @author Rick Ramirez
 * */

public class version_2 implements processInterface
{
    public int get_parent() {
        return 0;
    }

    @Override
    public int get_first_child() {
        return 0;
    }

    @Override
    public int get_older_sibling() {
        return 0;
    }

    @Override
    public int get_younger_sibling() {
        return 0;
    }

    @Override
    public int set_parent(int parentID) {
        return 0;
    }

    @Override
    public int set_first_child(int firstChild) {
        return 0;
    }

    @Override
    public int set_younger_sibling(int youngerSibling) {
        return 0;
    }

    @Override
    public int set_older_sibling(int olderSibling) {
        return 0;
    }

    /**
     * Creates a new child of the calling process
     *
     * @param newEntry the object to be added as a new entry
     * @return true if the creation is successful
     */
    @Override
    public boolean create(int newEntry) {
        return false;
    }

    /**
     * Recursively destroys all descendents of the calling process
     *
     * @param anEntry the parent to be removed
     * @return true if the removal was successful, or false if not
     */
    @Override
    public boolean destroy(int anEntry) {
        return false;
    }
}

