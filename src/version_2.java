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
     * @param rootPCB the parent to be removed
     */
    public void destroy(version_2 rootPCB) {
       // OsSystem.free_nonlinkedPCB(rootPCB);

        System.out.println("parent: " + rootPCB.parent);
        System.out.println("first child:" + rootPCB.firstChild);
        System.out.println("younger sibling: " + rootPCB.youngerSibling);
        System.out.println("older sinling: " + rootPCB.olderSibling);

        // Base case: parent with no children
        if(rootPCB.get_first_child() == Integer.MIN_VALUE && rootPCB.get_younger_sibling() == Integer.MIN_VALUE){
            System.out.println("here:  Kill the node, set parent's first child to MIN_VALUE");
            OsSystem.get_nonLinkedPCB_at_index(rootPCB.get_parent()).set_first_child(Integer.MIN_VALUE);
            OsSystem.free_nonlinkedPCB(rootPCB);
        }
        else {
            // Jump to the first child and check if it has children
            if(rootPCB.get_first_child() != Integer.MIN_VALUE) {
                System.out.println("here1");
                destroy(OsSystem.get_nonLinkedPCB_at_index(rootPCB.get_first_child()));

                // set caller's first child to the second in line
                OsSystem.get_nonLinkedPCB_at_index(rootPCB.get_parent()).set_first_child(rootPCB.youngerSibling);
                OsSystem.free_nonlinkedPCB(rootPCB);
            }
            else{
                while (rootPCB.get_younger_sibling() != Integer.MIN_VALUE) {
                    System.out.println("here2");
                    destroy(OsSystem.get_nonLinkedPCB_at_index(rootPCB.get_younger_sibling()));
                    OsSystem.free_nonlinkedPCB((rootPCB));
                    OsSystem.get_nonLinkedPCB_at_index(rootPCB.get_older_sibling()).set_younger_sibling(Integer.MIN_VALUE);

                }
            }
        }
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

