package nielwarnproj10;

public class Table<T extends Comparable<? super T>> {
    final int MAX_SIZE = 23;
    final int HASH_SIZE_2 = 19;
    private int size;
    private final boolean[] usedArray; // array to hold if index has been used
    private final String[] items; // array called items
    
    // default constructor
    public Table() {
        items = new String[MAX_SIZE];
        usedArray = new boolean[MAX_SIZE];
    }
    
    // method to insert an item into the table
    public void insert(String newItem) {
        int hash1 = hashOne(newItem);
        int hash2 = hashTwo(newItem);
        
        if (size == MAX_SIZE) {
            System.out.println("Table is full");
            return;
        }
        
        while (items[hash1] != null) {
            hash1 = (hash1 + hash2) % MAX_SIZE;
        }
        
        items[hash1] = newItem;
        usedArray[hash1] = true;
        size++;
    }
    
    public String delete(String key) {
        int hash1 = hashOne(key);
        int hash2 = hashTwo(key);
        String value;
        
        if (size == 0) {
            System.out.println("Table is empty");
            return "";
        }
        
        while (items[hash1] != null) {
            hash1 = (hash1 + hash2) % MAX_SIZE;
        }
        
        value = items[hash1];
        items[hash1] = null;
        size--;
        return value;
    }
    
    public void viewItems() {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                System.out.println(i + "");
            } else {
                System.out.println(i + " " + items[i]);
            }
        } 
    }
    
    private int hashOne(String key) {
        int hashVal = 0;
        for (int i = 0; i < key.length(); i++) {
            // For small letters.
            int letter = key.charAt(i) - 96; 
            hashVal = (hashVal * 32 + letter) % MAX_SIZE; 
        }
        return hashVal;
    }
    
    private int hashTwo(String key) {
        int hashVal = 0;
        for (int i = 0; i < key.length(); i++) {
            // For small letters.
            int letter = key.charAt(i) - 96; 
            hashVal = HASH_SIZE_2 - (hashVal * 32 + letter) % HASH_SIZE_2; 
        }
        return hashVal;
        
    }
}
