/**
 * Spring 2021
 * CS 4310
 * Version 2 requires dynamic memory management. Each PCB maintains a linked list whose entries point to its children.
 * @author Rick Ramirez
 * */

import java.util.LinkedList;

public class version_1 implements processInterface
{

    //an integer which holds the index of the parent
    private int parent;
    //a linked list that holds all the children of this process
    private LinkedList<version_1> children;


    //constructor
    public version_1(int id){
        this.parent = id;
        this.children = new LinkedList<version_1>();
    }//end of constructor


    //returns index of thisPCB's parent
    public int get_parent() {
        return this.parent;
    }

    //returns the  children of this PCB
    public LinkedList<version_1> get_children(){
        return children;
    }



    //creates a new PCB and adds it to the children of this pcb
    public  version_1 create(int newEntry) {
        version_1 newPCB=new version_1(newEntry);
        this.children.add(newPCB);
        return newPCB;

    }


    //destroys process q and all its children
    public void  destroy(version_1 q) {

        //recursively calling the function
        while(!(q.get_children().isEmpty())) {
            q.destroy(q.get_children().getFirst());
        }

        //removing q from the children
        this.children.remove(q);

        //removing the PCB from the OS array
        OsSystem.free_linkedPCB(q);


    }//end of destroy()


    //determines if to PCBs are equal
    public boolean isEqual(version_1 pcb) {

        if(this.parent==pcb.get_parent()  && this.children==pcb.get_children())
            return true;

        return false;
    }//end of isEqual;

}
