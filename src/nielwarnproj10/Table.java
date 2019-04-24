/*
 *  Warner Nielsen
 *  4/23/19
 *  CS2420
 *  Proj10
 *  Garth Sorenson
 */

/*
 *  The table class contains methods to insert, delete and view
 *  all items in a string array. It also contains hash methods to help
 *  with minimizing collisions. The hash methods also implement
 *  Horner's rule to help with developing the correct index.
 */
package nielwarnproj10;

public class Table<T extends Comparable<? super T>> {
    final int MAX_SIZE = 11;
    final int HASH_SIZE_2 = 7;
    private int size; // keep track of items array size
    private final boolean[] usedArray; // array to hold if index has been used
    private final String[] items; // array called items
    
    // default constructor
    public Table() {
        items = new String[MAX_SIZE];
        usedArray = new boolean[MAX_SIZE];
    }
    
    // method to insert an item into the table as long
    // as there is an empty slot to receive it
    public void insert(String newItem) {
        int hash1 = hashOne(newItem);
        int hash2 = hashTwo(newItem);
        
        // check is size is equal to max size and if it is
        // it returns a statement stating that it is full
        if (size == MAX_SIZE) {
            System.out.println("Table is full");
            return;
        }
        
        // if the first hash index is not null then this will
        // combine the first with the second and mod array size
        while (items[hash1] != null) {
            hash1 = (hash1 + hash2) % MAX_SIZE;
        }
        
        // assigns the new item to the proper index
        items[hash1] = newItem;
        // sets the usedArray to true for that index
        usedArray[hash1] = true;
        size++; // increment size of array
    }
    
    // method to delete an item from the items array by passing in
    // a key to be searched for in the array
    public String delete(String key) {
        int hash1 = hashOne(key);
        int hash2 = hashTwo(key);
        String value;
        
        // if array size is zero the print a message and get out of method
        if (size == 0) {
            System.out.println("Table is empty");
            return "";
        }
        
        // while if items in hash1 is not null then return 
        // not items sub hash1 equals key else return true
        // AND usedArray sub hash1 is true
        while (((items[hash1] != null ? (!items[hash1].equals(key)) : true) && usedArray[hash1] == true)) {
            hash1 += hash2; // add hash1 and hash2
            hash1 %= MAX_SIZE; // mod hash1 to table size
        }
        // assign items sub has1 to value
        value = items[hash1];
        items[hash1] = null; // delete the item
        size--; // decrement size
        return value; // return the value
    }
    
    // method to view all the items in the array and print the index
    // number that the item corresponds to
    public void viewItems() {
        for (int i = 0; i < items.length; i++) {
            // if item at index i is null print empty string
            if (items[i] == null) { 
                System.out.println(i + "");
            // otherwise print index number and the item
            } else {
                System.out.println(i + " " + items[i]);
            }
        } 
    }
    
    // hash function that obtains the original index location in the array
    private int hashOne(String key) {
        int hashVal = 0;
        int letter = 0;
        for (int i = 0; i < key.length(); i++) {
            // for lowercase letters takes char at i and subtracts 96 to get
            // its place in the alphabet equivalent
            if ((key.charAt(i) - 96) > 0) {
                letter = key.charAt(i) - 96; 
            // for upper case letters, takes char at i and subtracts 38 to get
            // its place in alphabet after first 26 letters, so 'A' starts at 27
            } else if ((key.charAt(i) - 38 > 0)) {
                letter = key.charAt(i) - 38; 
            }
            // use Horner's rule 
            hashVal = (hashVal * 32 + letter) % MAX_SIZE; 
        }
        return hashVal;
    }
    
    // the second hash function returns how many indexes to add to the
    // first number returned by hash one to help avoid collisions
    private int hashTwo(String key) {
        int hashVal = 0;
        int letter = 0;
        for (int i = 0; i < key.length(); i++) {
            // for lowercase letters takes char at i and subtracts 96 to get
            // its place in the alphabet equivalent
            if ((key.charAt(i) - 96) > 0) {
                letter = key.charAt(i) - 96; 
            // for upper case letters, takes char at i and subtracts 38 to get
            // its place in alphabet after first 26 letters, so 'A' starts at 27
            } else if ((key.charAt(i) - 38 > 0)) {
                letter = key.charAt(i) - 38;
            }
            // use Horner's rule 
            hashVal = HASH_SIZE_2 - (hashVal * 32 + letter) % HASH_SIZE_2; 
        }
        return hashVal;
    }
}
