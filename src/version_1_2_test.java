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

        //adding a child to PCB[1]
        myOS.put_LinkedPCB(myOS.get_LinkedPCB_at_index(1).create(1),myOS.get_free_slot_linked());






        System.out.println(myOS.get_LinkedPCB_at_index(0).get_parent()+ "   "+myOS.get_LinkedPCB_at_index(0).get_children());
        System.out.println(myOS.get_LinkedPCB_at_index(1).get_parent()+ "   "+myOS.get_LinkedPCB_at_index(1).get_children());
        System.out.println(myOS.get_LinkedPCB_at_index(2).get_parent()+ "   "+myOS.get_LinkedPCB_at_index(2).get_children());
        System.out.println(myOS.get_LinkedPCB_at_index(3).get_parent()+ "   "+myOS.get_LinkedPCB_at_index(2).get_children());



        //testing for version2
        myOS.put_nonLinkedPCB(new version_2(-1), 0);

        myOS.get_nonLinkedPCB_at_index(0).create(0);
        myOS.get_nonLinkedPCB_at_index(1).create(1);
        myOS.get_nonLinkedPCB_at_index(0).create(0);



        System.out.println(myOS.get_nonLinkedPCB_at_index(0).get_parent()+ "   "+myOS.get_nonLinkedPCB_at_index(0).get_first_child()
                +"   "+myOS.get_nonLinkedPCB_at_index(0).get_older_sibling()+"   "+myOS.get_nonLinkedPCB_at_index(0).get_younger_sibling());

        System.out.println(myOS.get_nonLinkedPCB_at_index(1).get_parent()+ "   "+myOS.get_nonLinkedPCB_at_index(1).get_first_child()
                +"   "+myOS.get_nonLinkedPCB_at_index(1).get_older_sibling()+"   "+myOS.get_nonLinkedPCB_at_index(1).get_younger_sibling());

        System.out.println(myOS.get_nonLinkedPCB_at_index(2).get_parent()+ "   "+myOS.get_nonLinkedPCB_at_index(2).get_first_child()
                +"   "+myOS.get_nonLinkedPCB_at_index(2).get_older_sibling()+"   "+myOS.get_nonLinkedPCB_at_index(2).get_younger_sibling());

        System.out.println(myOS.get_nonLinkedPCB_at_index(3).get_parent()+ "   "+myOS.get_nonLinkedPCB_at_index(3).get_first_child()
                +"   "+myOS.get_nonLinkedPCB_at_index(3).get_older_sibling()+"   "+myOS.get_nonLinkedPCB_at_index(3).get_younger_sibling());

        System.out.println("#########################################");

        myOS.printPCB();

        myOS.get_nonLinkedPCB_at_index(0).destroy(myOS.get_nonLinkedPCB_at_index(0));

        //########
        myOS.printPCB();

        //myOS.get_nonLinkedPCB_at_index(1).destroy(myOS.get_nonLinkedPCB_at_index(1));
        //PCB[0]'s first child is now node 3
        //System.out.println(myOS.get_nonLinkedPCB_at_index(0).get_first_child());
    }
}
