/*
 *  Warner Nielsen
 *  4/23/19
 *  CS2420
 *  Proj10
 *  Garth Sorenson
 */

/*
 *  Main driver for Table class. This driver is menu driven
 *  to give the user repeated chances to add items, remove
 *  items, and print the items found in the table.
 */
package nielwarnproj10;

import java.util.Scanner;

public class NielWarnProj10 {
    public static void main(String[] args) {
        Table<String> symbolTable = new Table<>();
        String[] symbolArray = {"abstract", "assert", "boolean", "break",
                                "byte", "case", "catch", "char",
                                "class", "const", "continue", "default",
                                "do", "double", "else", "enum",
                                "extends", "final", "finally", "float",
                                "for", "goto", "if", "implements",
                                "import", "instanceof", "int", "interface",
                                "long", "native", "new", "package",
                                "private", "protected", "public", "return",
                                "short", "static", "strictfp", "super",
                                "switch", "synchronized", "this", "throw",
                                "throws", "transient", "try", "void",
                                "volatile", "while", "true", "false", "null"};
        char[] validIdent = {'$', '_', 'a', 'b', 'c', 'd',
                                'e', 'f', 'g', 'h', 'i', 'j',
                                'k', 'l', 'm', 'n', 'o', 'p',
                                'q', 'r', 's', 't', 'u', 'v',
                                'w', 'x', 'y', 'z'};
        
        String item;
        
        System.out.println("Welcome to the Symbol Table Checker. Enter a variable name to\n" +
                            "check against Java reserved keywords. If it's a resereved\n" +
                            "keyword, I'll let you know.");
        
        int userMenuChoice;
        String userKeyword, deletedKeyword;
        boolean again = true;
        boolean valid;
        Scanner userInput = new Scanner(System.in); // user input
        
        // display menu choices to run each part of Table class
        do {
            System.out.println("\nSymbol Table Menu:");
            System.out.println("\t1 - Insert an item");
            System.out.println("\t2 - Remove an item");
            System.out.println("\t3 - Display all items");
            System.out.println("\t4 - Quit");
            
            System.out.print("\nEnter a choice: ");
            userMenuChoice = userInput.nextInt();
            
            // switch statement for menu choices
            switch (userMenuChoice) {
                case 1:
                    System.out.print("Please enter a string to enter into the symbol table: ");
                    userKeyword = userInput.next();
                    valid = validSymbol(symbolArray, userKeyword);
                    if (valid) {
                        System.out.println("Cannot use key word '" + userKeyword + "'");
                    } else {
                        symbolTable.insert(userKeyword);
                        System.out.println("Key word '" + userKeyword + "' entered into symbol table");
                    }
                    break;
                case 2:
                    System.out.print("Please enter a string to remove from symbol table: ");
                    userKeyword = userInput.next();
                    deletedKeyword = symbolTable.delete(userKeyword);
                    if (deletedKeyword != null) {
                        System.out.println("'" + deletedKeyword + "' removed from table");
                    } else {
                        System.out.println("'" + userKeyword + "' is not in the table, not removed from table");
                    }
                    break;
                case 3:
                    symbolTable.viewItems();
                    break;
                case 4:
                    again = false;
                    break;
                default:
                        System.out.println("Invalid choice, please try again...");
            }
        } while (again);
    }
    
    public static boolean validSymbol(String[] symbolArr, String key) {
        boolean valid = false;
        for (String item : symbolArr) {
            if (item.compareTo(key) == 0) {
                valid = true;
            }
        }
        return valid;
    }
}
