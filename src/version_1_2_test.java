import java.util.LinkedList;

/**
 * Spring 2021
 * CS 4310
 * Test version 1 against version 2.
 * @author Rick Ramirez, Rafi Keshishian
 * */

public class version_1_2_test
{

    public static void main(String[] args) {

        //creating an OsSystem object
        OsSystem myOS= new OsSystem();

        //adding first version_1 PCB into the linkedPCB array
        myOS.put_LinkedPCB(new version_1(-1),0);

        //adding a child to PCB[0]
        myOS.put_LinkedPCB(myOS.get_LinkedPCB_at_index(0).create(0),myOS.get_free_slot_linked());
        System.out.println("creates first child of PCB0 at "+(myOS.get_free_slot_linked()-1));

        //adding second child to PCB[0]
        myOS.put_LinkedPCB(myOS.get_LinkedPCB_at_index(0).create(0),myOS.get_free_slot_linked());
        System.out.println("creates first child of PCB0 at "+(myOS.get_free_slot_linked()-1));






        System.out.println(myOS.get_LinkedPCB_at_index(0).get_parent()+ "   "+myOS.get_LinkedPCB_at_index(0).get_children());
        System.out.println(myOS.get_LinkedPCB_at_index(1).get_parent()+ "   "+myOS.get_LinkedPCB_at_index(1).get_children());
        System.out.println(myOS.get_LinkedPCB_at_index(2).get_parent()+ "   "+myOS.get_LinkedPCB_at_index(2).get_children());





        myOS.put_nonLinkedPCB(new version_2(-1),0);


       // myOS.get_nonLinkedPCB_at_index(0).create(0);

        System.out.println(myOS.get_nonLinkedPCB_at_index(0).get_parent()+ "   "+myOS.get_nonLinkedPCB_at_index(0).get_first_child()+"   "+myOS.get_nonLinkedPCB_at_index(0).get_younger_sibling()+"   "+myOS.get_nonLinkedPCB_at_index(0).get_older_sibling());

        myOS.put_nonLinkedPCB(myOS.get_nonLinkedPCB_at_index(0).create(1), myOS.get_free_slot_nonLinked());

        System.out.println(myOS.get_nonLinkedPCB_at_index(0).get_parent()+ "   "+myOS.get_nonLinkedPCB_at_index(0).get_first_child()+"   "+myOS.get_nonLinkedPCB_at_index(0).get_younger_sibling()+"   "+myOS.get_nonLinkedPCB_at_index(0).get_older_sibling());

        myOS.printpcbs();
    }
}
