
package nielwarnproj10;

public class NielWarnProj10 {
    public static void main(String[] args) {
        Table<String> symbolTable = new Table<>();
        String item;
        
        symbolTable.insert("hello");
        symbolTable.insert("goodbye");
        symbolTable.insert("test");
        symbolTable.insert("variable");
        symbolTable.insert("tree");
        symbolTable.insert("baseball");
        symbolTable.insert("friend");
        symbolTable.insert("house");
        symbolTable.insert("trampoline");
        symbolTable.insert("beach");
        symbolTable.insert("five");
        symbolTable.insert("operation");
        symbolTable.insert("keyboard");
        symbolTable.insert("palm");
        symbolTable.insert("franchise");
        symbolTable.insert("store");
        symbolTable.insert("dog");
        symbolTable.insert("computer");
        symbolTable.insert("furniture");
//        symbolTable.insert("a");
//        symbolTable.insert("of");
//        symbolTable.insert("island");
//        symbolTable.insert("book");
//        symbolTable.insert("rapport");
        symbolTable.viewItems();
        item = symbolTable.delete("operation");
        System.out.println("Deleted item: " + item);
//        symbolTable.viewItems();
        item = symbolTable.delete("franchise");
        System.out.println("Deleted item: " + item);
        item = symbolTable.delete("houses");
        System.out.println("Deleted item: " + item);
        item = symbolTable.delete("hello");
        System.out.println("Deleted item: " + item);
//        item = symbolTable.delete("variable");
//        System.out.println("Deleted item: " + item);
//        item = symbolTable.delete("dog");
//        System.out.println("Deleted item: " + item);
        symbolTable.viewItems();
        item = symbolTable.delete("hellos");
        System.out.println("Deleted item: " + item);
    }
    
}
