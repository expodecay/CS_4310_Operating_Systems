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

        System.out.println("Creating two empty PCB arrays of size 100.");
        //creating an OsSystem object
        OsSystem myOS= new OsSystem();

        System.out.println("Iterating 100 times...");
        long LinkedStart1 = System.nanoTime();
        //start of testing version_1 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
        for (int j=0 ; j<100; j++) {
            myOS.put_LinkedPCB(new version_1(-1),0);

            //creating first child for pcb0 at pcb1
            myOS.put_LinkedPCB(myOS.get_LinkedPCB_at_index(0).create(0),myOS.get_free_slot_linked());

            //creating 25 children for pcb1
            for (int i=0; i<25; i++) {
                myOS.put_LinkedPCB(myOS.get_LinkedPCB_at_index(1).create(1),myOS.get_free_slot_linked());
            }
            //creating 25 children for pcb3
            for (int i=0; i<25; i++) {
                myOS.put_LinkedPCB(myOS.get_LinkedPCB_at_index(3).create(3),myOS.get_free_slot_linked());
            }

            //destroying pcb1 which will consequently destroy all pcb3's 50 children too
            myOS.get_LinkedPCB_at_index(0).destroy(myOS.get_LinkedPCB_at_index(3));

            //destroying pcb1 which will consequently destroy all pcb1's 50 children too
            myOS.get_LinkedPCB_at_index(0).destroy(myOS.get_LinkedPCB_at_index(1));

        }//End of testing version_1 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
        long LinkedEnd1 = System.nanoTime();
        long LinkedTime1 =  LinkedEnd1 - LinkedStart1;

        //start of testing version_2 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
        long nonLinkedStart1 = System.nanoTime();
        for (int j=0; j<100; j++) {
            //creating the first pcb at 0
            myOS.put_nonLinkedPCB(new version_2(-1), 0);

            //creating first child of pcb o at pcb1
            myOS.get_nonLinkedPCB_at_index(0).create(0);

            //creating 25 children for pcb1
            for (int i=0; i<25; i++) {
                myOS.get_nonLinkedPCB_at_index(1).create(1);
            }
            //creating 25 children for pcb3
            for (int i=0; i<25; i++) {
                myOS.get_nonLinkedPCB_at_index(3).create(3);
            }

            //destroying pcb1 which will consequently destroy all pcb3's 50 children too
            myOS.get_nonLinkedPCB_at_index(0).destroy(myOS.get_nonLinkedPCB_at_index(3));

            //destroying pcb1 which will consequently destroy all pcb1's 50 children too
            myOS.get_nonLinkedPCB_at_index(0).destroy(myOS.get_nonLinkedPCB_at_index(1));

        }//End of testing version_1 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
        long nonLinkedEnd1 = System.nanoTime();
        long nonLinkedTime1 = nonLinkedEnd1 - nonLinkedStart1;

        System.out.println("Time to complete Version_1: " + LinkedTime1);
        System.out.println("Time to complete Version_2: " + nonLinkedTime1 + "\n");

        /***************************************************************************************************************/

        System.out.println("Iterating 1000 times...");
        long LinkedStart2 = System.nanoTime();
        //start of testing version_1 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
        for (int j=0 ; j<1000; j++) {
            myOS.put_LinkedPCB(new version_1(-1),0);

            //creating first child for pcb0 at pcb1
            myOS.put_LinkedPCB(myOS.get_LinkedPCB_at_index(0).create(0),myOS.get_free_slot_linked());

            //creating 25 children for pcb1
            for (int i=0; i<25; i++) {
                myOS.put_LinkedPCB(myOS.get_LinkedPCB_at_index(1).create(1),myOS.get_free_slot_linked());
            }
            //creating 25 children for pcb3
            for (int i=0; i<25; i++) {
                myOS.put_LinkedPCB(myOS.get_LinkedPCB_at_index(3).create(3),myOS.get_free_slot_linked());
            }

            //destroying pcb1 which will consequently destroy all pcb3's 50 children too
            myOS.get_LinkedPCB_at_index(0).destroy(myOS.get_LinkedPCB_at_index(3));

            //destroying pcb1 which will consequently destroy all pcb1's 50 children too
            myOS.get_LinkedPCB_at_index(0).destroy(myOS.get_LinkedPCB_at_index(1));

        }//End of testing version_1 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
        long LinkedEnd2 = System.nanoTime();
        long LinkedTime2 =  LinkedEnd2 - LinkedStart2;

        //start of testing version_2 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
        long nonLinkedStart2 = System.nanoTime();
        for (int j=0; j<1000; j++) {
            //creating the first pcb at 0
            myOS.put_nonLinkedPCB(new version_2(-1), 0);

            //creating first child of pcb o at pcb1
            myOS.get_nonLinkedPCB_at_index(0).create(0);

            //creating 25 children for pcb1
            for (int i=0; i<25; i++) {
                myOS.get_nonLinkedPCB_at_index(1).create(1);
            }
            //creating 25 children for pcb3
            for (int i=0; i<25; i++) {
                myOS.get_nonLinkedPCB_at_index(3).create(3);
            }

            //destroying pcb1 which will consequently destroy all pcb3's 50 children too
            myOS.get_nonLinkedPCB_at_index(0).destroy(myOS.get_nonLinkedPCB_at_index(3));

            //destroying pcb1 which will consequently destroy all pcb1's 50 children too
            myOS.get_nonLinkedPCB_at_index(0).destroy(myOS.get_nonLinkedPCB_at_index(1));

        }//End of testing version_1 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
        long nonLinkedEnd2 = System.nanoTime();
        long nonLinkedTime2 = nonLinkedEnd2 - nonLinkedStart2;

        System.out.println("Time to complete Version_1: " + LinkedTime2);
        System.out.println("Time to complete Version_2: " + nonLinkedTime2 + "\n");

        /***************************************************************************************************************/

        System.out.println("Iterating 10000 times...");
        long LinkedStart3 = System.nanoTime();
        //start of testing version_1 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
        for (int j=0 ; j<10000; j++) {
            myOS.put_LinkedPCB(new version_1(-1),0);

            //creating first child for pcb0 at pcb1
            myOS.put_LinkedPCB(myOS.get_LinkedPCB_at_index(0).create(0),myOS.get_free_slot_linked());

            //creating 25 children for pcb1
            for (int i=0; i<25; i++) {
                myOS.put_LinkedPCB(myOS.get_LinkedPCB_at_index(1).create(1),myOS.get_free_slot_linked());
            }
            //creating 25 children for pcb3
            for (int i=0; i<25; i++) {
                myOS.put_LinkedPCB(myOS.get_LinkedPCB_at_index(3).create(3),myOS.get_free_slot_linked());
            }

            //destroying pcb1 which will consequently destroy all pcb3's 50 children too
            myOS.get_LinkedPCB_at_index(0).destroy(myOS.get_LinkedPCB_at_index(3));

            //destroying pcb1 which will consequently destroy all pcb1's 50 children too
            myOS.get_LinkedPCB_at_index(0).destroy(myOS.get_LinkedPCB_at_index(1));

        }//End of testing version_1 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
        long LinkedEnd3 = System.nanoTime();
        long LinkedTime3 =  LinkedEnd3 - LinkedStart3;

        //start of testing version_2 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
        long nonLinkedStart3 = System.nanoTime();
        for (int j=0; j<10000; j++) {
            //creating the first pcb at 0
            myOS.put_nonLinkedPCB(new version_2(-1), 0);

            //creating first child of pcb o at pcb1
            myOS.get_nonLinkedPCB_at_index(0).create(0);

            //creating 25 children for pcb1
            for (int i=0; i<25; i++) {
                myOS.get_nonLinkedPCB_at_index(1).create(1);
            }
            //creating 25 children for pcb3
            for (int i=0; i<25; i++) {
                myOS.get_nonLinkedPCB_at_index(3).create(3);
            }

            //destroying pcb1 which will consequently destroy all pcb3's 50 children too
            myOS.get_nonLinkedPCB_at_index(0).destroy(myOS.get_nonLinkedPCB_at_index(3));

            //destroying pcb1 which will consequently destroy all pcb1's 50 children too
            myOS.get_nonLinkedPCB_at_index(0).destroy(myOS.get_nonLinkedPCB_at_index(1));

        }//End of testing version_1 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
        long nonLinkedEnd3 = System.nanoTime();
        long nonLinkedTime3 = nonLinkedEnd3 - nonLinkedStart3;

        System.out.println("Time to complete Version_1: " + LinkedTime3);
        System.out.println("Time to complete Version_2: " + nonLinkedTime3 + "\n");

        /***************************************************************************************************************/

        System.out.println("Iterating 100000 times...");
        long LinkedStart4 = System.nanoTime();
        //start of testing version_1 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
        for (int j=0 ; j<100000; j++) {
            myOS.put_LinkedPCB(new version_1(-1),0);

            //creating first child for pcb0 at pcb1
            myOS.put_LinkedPCB(myOS.get_LinkedPCB_at_index(0).create(0),myOS.get_free_slot_linked());

            //creating 25 children for pcb1
            for (int i=0; i<25; i++) {
                myOS.put_LinkedPCB(myOS.get_LinkedPCB_at_index(1).create(1),myOS.get_free_slot_linked());
            }
            //creating 25 children for pcb3
            for (int i=0; i<25; i++) {
                myOS.put_LinkedPCB(myOS.get_LinkedPCB_at_index(3).create(3),myOS.get_free_slot_linked());
            }

            //destroying pcb1 which will consequently destroy all pcb3's 50 children too
            myOS.get_LinkedPCB_at_index(0).destroy(myOS.get_LinkedPCB_at_index(3));

            //destroying pcb1 which will consequently destroy all pcb1's 50 children too
            myOS.get_LinkedPCB_at_index(0).destroy(myOS.get_LinkedPCB_at_index(1));

        }//End of testing version_1 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
        long LinkedEnd4 = System.nanoTime();
        long LinkedTime4 =  LinkedEnd4 - LinkedStart4;

        //start of testing version_2 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
        long nonLinkedStart4 = System.nanoTime();
        for (int j=0; j<100000; j++) {
            //creating the first pcb at 0
            myOS.put_nonLinkedPCB(new version_2(-1), 0);

            //creating first child of pcb o at pcb1
            myOS.get_nonLinkedPCB_at_index(0).create(0);

            //creating 25 children for pcb1
            for (int i=0; i<25; i++) {
                myOS.get_nonLinkedPCB_at_index(1).create(1);
            }
            //creating 25 children for pcb3
            for (int i=0; i<25; i++) {
                myOS.get_nonLinkedPCB_at_index(3).create(3);
            }

            //destroying pcb1 which will consequently destroy all pcb3's 50 children too
            myOS.get_nonLinkedPCB_at_index(0).destroy(myOS.get_nonLinkedPCB_at_index(3));

            //destroying pcb1 which will consequently destroy all pcb1's 50 children too
            myOS.get_nonLinkedPCB_at_index(0).destroy(myOS.get_nonLinkedPCB_at_index(1));

        }//End of testing version_1 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
        long nonLinkedEnd4 = System.nanoTime();
        long nonLinkedTime4 = nonLinkedEnd4 - nonLinkedStart4;

        System.out.println("Time to complete Version_1: " + LinkedTime4);
        System.out.println("Time to complete Version_2: " + nonLinkedTime4 + "\n");

        /***************************************************************************************************************/

        System.out.println("Iterating 1000000 times...");
        long LinkedStart5 = System.nanoTime();
        //start of testing version_1 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
        for (int j=0 ; j<1000000; j++) {
            myOS.put_LinkedPCB(new version_1(-1),0);

            //creating first child for pcb0 at pcb1
            myOS.put_LinkedPCB(myOS.get_LinkedPCB_at_index(0).create(0),myOS.get_free_slot_linked());

            //creating 25 children for pcb1
            for (int i=0; i<25; i++) {
                myOS.put_LinkedPCB(myOS.get_LinkedPCB_at_index(1).create(1),myOS.get_free_slot_linked());
            }
            //creating 25 children for pcb3
            for (int i=0; i<25; i++) {
                myOS.put_LinkedPCB(myOS.get_LinkedPCB_at_index(3).create(3),myOS.get_free_slot_linked());
            }

            //destroying pcb1 which will consequently destroy all pcb3's 50 children too
            myOS.get_LinkedPCB_at_index(0).destroy(myOS.get_LinkedPCB_at_index(3));

            //destroying pcb1 which will consequently destroy all pcb1's 50 children too
            myOS.get_LinkedPCB_at_index(0).destroy(myOS.get_LinkedPCB_at_index(1));

        }//End of testing version_1 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
        long LinkedEnd5 = System.nanoTime();
        long LinkedTime5 =  LinkedEnd5 - LinkedStart5;

        //start of testing version_2 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
        long nonLinkedStart5 = System.nanoTime();
        for (int j=0; j<1000000; j++) {
            //creating the first pcb at 0
            myOS.put_nonLinkedPCB(new version_2(-1), 0);

            //creating first child of pcb o at pcb1
            myOS.get_nonLinkedPCB_at_index(0).create(0);

            //creating 25 children for pcb1
            for (int i=0; i<25; i++) {
                myOS.get_nonLinkedPCB_at_index(1).create(1);
            }
            //creating 25 children for pcb3
            for (int i=0; i<25; i++) {
                myOS.get_nonLinkedPCB_at_index(3).create(3);
            }

            //destroying pcb1 which will consequently destroy all pcb3's 50 children too
            myOS.get_nonLinkedPCB_at_index(0).destroy(myOS.get_nonLinkedPCB_at_index(3));

            //destroying pcb1 which will consequently destroy all pcb1's 50 children too
            myOS.get_nonLinkedPCB_at_index(0).destroy(myOS.get_nonLinkedPCB_at_index(1));

        }//End of testing version_1 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
        long nonLinkedEnd5 = System.nanoTime();
        long nonLinkedTime5 = nonLinkedEnd5 - nonLinkedStart5;

        System.out.println("Time to complete Version_1: " + LinkedTime5);
        System.out.println("Time to complete Version_2: " + nonLinkedTime5 + "\n");
    }
}