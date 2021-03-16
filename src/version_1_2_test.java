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
    	
    	
    	
    	//start of testing version_1 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
    	for (int j=0 ; j<1000000; j++) {
    	
    	
    	myOS.put_LinkedPCB(new version_1(-1),0);
    	
    	//creating first child for pcb0 at pcb1
    	myOS.put_LinkedPCB(myOS.get_LinkedPCB_at_index(0).create(0),myOS.get_free_slot_linked());
    	
    	//creating 50 children for pcb1
    	for (int i=0; i<50; i++) {
    		myOS.put_LinkedPCB(myOS.get_LinkedPCB_at_index(1).create(1),myOS.get_free_slot_linked());
    	}
    	
    	//destroying pcb1 which will consequently destroy all pcb1's 50 children too
    	myOS.get_LinkedPCB_at_index(0).destroy(myOS.get_LinkedPCB_at_index(1));
    	
    	
    	
    	}//End of testing version_1 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
    	
    	
    	System.out.print("first finished\n\n\n");
    	
    	
    	//start of testing version_2 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
    	for (int j=0; j<1000000; j++) {
    		
    		//creating the first pcb at 0
    		myOS.put_nonLinkedPCB(new version_2(-1), 0);
    		
    		
    		//creating first child of pcb o at pcb1
    		myOS.get_nonLinkedPCB_at_index(0).create(0);
    		
    		//creating 50 children for pcb1
    		
    			myOS.get_nonLinkedPCB_at_index(1).create(1);
    			myOS.get_nonLinkedPCB_at_index(1).create(1);
    			
    			for (int i=0; i<50; i++) {
    				myOS.get_nonLinkedPCB_at_index(1).create(1);
    			}
    		
    		
    		
    		
    		//destroying pcb1 which will consequently destroy all pcb1's 50 children too
    		myOS.get_nonLinkedPCB_at_index(0).destroy(myOS.get_nonLinkedPCB_at_index(1));
    		

    		
    	}//End of testing version_1 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ 
    	
    	
    	
    	System.out.print("second finished");
    	
    	
    	
    	
    

    }
}
