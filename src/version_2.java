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
    public version_2 create(int newEntry) {
        
    	int older_sibling = this.get_index_of_youngest_child();
    	
    	version_2 newPCB = new version_2(newEntry);
    	newPCB.set_first_child(Integer.MIN_VALUE);
    	newPCB.set_younger_sibling(Integer.MIN_VALUE);
    	newPCB.set_older_sibling(older_sibling);
    	
    	
    	OsSystem.put_nonLinkedPCB(newPCB, OsSystem.get_free_slot_nonLinked());
    	
    	if (this.firstChild == Integer.MIN_VALUE)
    		this.set_first_child(OsSystem.get_index_of(newPCB));
    	
    	//setting the younger sibling of the older sibling to index of new PCB
    	if (older_sibling>= 0 && older_sibling<=100)
    		OsSystem.get_nonLinkedPCB_at_index(older_sibling).set_younger_sibling(OsSystem.get_index_of(newPCB));
    	
    	return newPCB;
    	
    	
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
    
    
   
    
    //returns the index of the youngest child
    public int get_index_of_youngest_child() {
    	
    	if (firstChild==Integer.MIN_VALUE)
    		return Integer.MIN_VALUE;
    
    
    else {
    	int index_of_child=this.firstChild;
    	while (index_of_child != Integer.MIN_VALUE) {
    		if (OsSystem.get_nonLinkedPCB_at_index(index_of_child).get_younger_sibling()==Integer.MIN_VALUE)
    			return index_of_child;
    		else
    			index_of_child = OsSystem.get_nonLinkedPCB_at_index(index_of_child).get_younger_sibling();
    		
    	}
    	
    	return index_of_child;
    
    
    } //end of else
    	


    }//end of get_index_of
}

