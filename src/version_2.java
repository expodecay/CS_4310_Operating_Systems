/**
 * Spring 2021
 * CS 4310
 * Version 2 requires no dynamic memory management. The links are distributed over the PCBs such that each instance
 * points to the immediate younger and older sibling.
 * @author Rick Ramirez
 * */

public class version_2 implements processInterface
{
    OsSystem myOS= new OsSystem();
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
    public version_2 create(int newEntry) {

        int Older_sibling = this.get_index_of_youngest_child();
        version_2 newPCB = new version_2(newEntry);
        newPCB.parent = newEntry;
        newPCB.set_older_sibling(Older_sibling);

       myOS.put_nonLinkedPCB(newPCB,OsSystem.get_free_slot_nonLinked());

        if(this.firstChild == Integer.MIN_VALUE){
        this.set_first_child(OsSystem.get_index_of(newPCB));
        }
        this.set_first_child(OsSystem.get_index_of(newPCB));

        OsSystem.get_nonLinkedPCB_at_index(this.get_index_of_youngest_child()).set_younger_sibling(OsSystem.get_index_of(newPCB));
        return newPCB;
    }

    /**
     * Recursively destroys all descendents of the calling process
     *
     * @param anEntry the parent to be removed
     * @return true if the removal was successful, or false if not
     */
    public void destroy(version_2 anEntry) {
        while(anEntry.get_first_child()!= Integer.MIN_VALUE){
           // anEntry.destroy(anEntry.get_younger_sibling());
        }
    }

    public int get_index_of_youngest_child(){
        if(this.firstChild == Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        }
        else{
            int index_of_child=this.firstChild;
            while(index_of_child != Integer.MAX_VALUE){
                if(OsSystem.get_nonLinkedPCB_at_index(index_of_child).get_younger_sibling() == Integer.MIN_VALUE){
                    return  index_of_child;
                }
                else
                    index_of_child = OsSystem.get_nonLinkedPCB_at_index(index_of_child).get_younger_sibling();
            }
            return index_of_child;
        }
    }

}

