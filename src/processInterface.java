public interface processInterface {

    //* Getter Methods *//

    static int get_parent() {
        return 0;
    }

    static int get_first_child() {
        return 0;
    }

    static int get_older_sibling() {
        return 0;
    }

    static int get_younger_sibling() {
        return 0;
    }


    //* Setter Methods *//

    static int set_parent(int parentID) {
        return 0;
    }

    static int set_first_child(int firstChild) {
        return 0;
    }

    static int set_younger_sibling(int youngerSibling) {
        return 0;
    }

    static int set_older_sibling(int olderSibling) {
        return 0;
    }


    /**
     * Creates a new child of the calling process
     * @param newEntry  the object to be added as a new entry
     * @return true if the creation is successful
     * */
    static boolean create(int newEntry){
        return false;
    };

    /**
     * Recursively destroys all descendents of the calling process
     * @param anEntry  the parent to be removed
     * @return true if the removal was successful, or false if not
     * */
    static boolean destroy(int anEntry){
        return false;
    }
}
