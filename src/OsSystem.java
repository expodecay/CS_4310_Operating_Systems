//this class simulates the OS
public class OsSystem {
	
	//a constant which holds the total number of each type of PCBs in OS
	private static final int NUMBER_OF_PCBs=100;
	
	//an array which hold all of the PCBs of version_1 in the OS
	public static version_1[] LinkedPCB_array= new version_1[NUMBER_OF_PCBs];
	//an array which holds all of the PCBs of version_2 in the OS
	private static version_2[] nonLinkedPCB_array = new version_2[NUMBER_OF_PCBs];
	
	
	
	//constructor
	public OsSystem() {
		
		//initializing the PCB array to NULL
		for(int i=0;i<NUMBER_OF_PCBs;i++) {
			LinkedPCB_array[i]=null;
			nonLinkedPCB_array[i]=null;
		}
		
	}//end of constructor
	
	
	
	
	
	//function which returns the first free slot in LinkedPCB array
	public int get_free_slot_linked() {
		int  result=-1;
		int counter=0;
		while (counter<NUMBER_OF_PCBs) {
			if (LinkedPCB_array[counter]==null) {
				result=counter;
				counter=NUMBER_OF_PCBs;
			}
			counter++;
		}
		return result;
	}//end of get_free_slot_linked
	
	//function which returns the first free slot in LinkedPCB array
	public static int get_free_slot_nonLinked() {
		int  result=-1;
		int counter=0;
		while (counter<NUMBER_OF_PCBs) {
			if (nonLinkedPCB_array[counter]==null) {
				result=counter;
				counter=100;
			}
			counter++;
		}
		
		return result;
	}//end of get_free_slot_nonLinked
	
	
	
	
	
	//puts a version_1 PCB in the array
	public void put_LinkedPCB(version_1 pcb , int i) {
		LinkedPCB_array[i]=pcb;	
	}//end of put_LinkedPCB()
	
	//removes a version_1 PCB from array
	public void remove_LinkedPCB(int i) {
		LinkedPCB_array[i]=null;
	}//end of remove_LinkedPCB
	//returning the PCB at index i
	public version_1 get_LinkedPCB_at_index(int i) {
		return LinkedPCB_array[i];
	}//end og get_PCB_at_index
	
	
	//puts a version2 PCB into the array
	public static void put_nonLinkedPCB(version_2 pcb, int i) {
		nonLinkedPCB_array[i]=pcb;
	}//end of put_nonLinkedPCB()
	
	//remove a version2 PCB from the array
	public void remove_nonLinkedPCB(int i) {
		nonLinkedPCB_array[i]=null;
	}
	
	//returning the PCB at index i
	
	public static version_2 get_nonLinkedPCB_at_index(int i) {
		return nonLinkedPCB_array[i];
	}//end of get_nonLinkedPCB_array_at_index()
	
	
	
	//deletes the pointer to a destroyed PCB
	public static void free_linkedPCB(version_1 pcb) {
		for (int i=0 ; i<NUMBER_OF_PCBs; i++) {
			if (LinkedPCB_array[i]== pcb )
				LinkedPCB_array[i]=null;
		}
	}
	
	//deletes the pointer to a destroyed PCB
	public static void free_linkedPCB(version_2 pcb) {
		for (int i=0 ; i<NUMBER_OF_PCBs; i++) {
			if (nonLinkedPCB_array[i]==(pcb))
				nonLinkedPCB_array[i]=null;
		}
	}
	
	public static int get_index_of(version_2 pcb) {
		
		for (int i=0; i<NUMBER_OF_PCBs; i++) {
			if (nonLinkedPCB_array[i]==pcb)
					return i;
		}
		
		return Integer.MIN_VALUE;
	}
	
	


	
	

}//end of OSSystem class
