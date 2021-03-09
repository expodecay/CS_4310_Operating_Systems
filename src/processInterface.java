public interface processInterface {

    //* Getter Methods *//

    int get_parent();

    int get_first_child();

    int get_older_sibling();


    int get_younger_sibling();


    //* Setter Methods *//

    int set_parent(int parentID);


    int set_first_child(int firstChild);


    int set_younger_sibling(int youngerSibling);


    int set_older_sibling(int olderSibling);


    /**
     * Creates a new child of the calling process
     * @param newEntry  the object to be added as a new entry
     * @return true if the creation is successful
     * */
    boolean create(int newEntry);

    /**
     * Recursively destroys all descendents of the calling process
     * @param anEntry  the parent to be removed
     * @return true if the removal was successful, or false if not
     * */
    boolean destroy(int anEntry);
}
