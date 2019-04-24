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
                                'w', 'x', 'y', 'z', 'A', 'B',
                                'C', 'D', 'E', 'F', 'G', 'H',
                                'I', 'J', 'K', 'L', 'M', 'N',
                                'O', 'P', 'Q', 'R', 'S', 'T',
                                'U', 'V', 'W', 'X', 'Y', 'Z'};
        
        String item;
        
        System.out.println("Welcome to the Symbol Table Checker. Enter a variable name to\n" +
                            "check against Java reserved keywords. If it's a resereved\n" +
                            "keyword, I'll let you know.");
        
        int userMenuChoice;
        String userKeyword, deletedKeyword; 
        boolean again = true; // boolean for do-while loop
        boolean invalid; // true or false value returned from validSymbol checker function 
        boolean invalidLetter; // true or false value returned from validIdentifier checker function
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
                    invalid = validSymbol(symbolArray, userKeyword);
                    invalidLetter = validIdentifier(validIdent, userKeyword);
                    
                    if (!invalidLetter) {
                        System.out.println("Cannot use key word '" + userKeyword + "'");
                        System.out.println("Must begin identifier with letter, '$', or '_'");
                        break;
                    }
                    
                    if (invalid) {
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
                    
                    // check if the deleted value is empty string or null
                    if (deletedKeyword.equals("")) {
                        System.out.println("Nothing in table to delete");
                    } else if (deletedKeyword != null) {
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
    
    // method to compare value from symbolArr to the key, if they are the same
    // it returns true and tells user it cannot be saved
    public static boolean validSymbol(String[] symbolArr, String key) {
        boolean invalid = false;
        // loop through the symbolArray to compare with key
        for (String item : symbolArr) {
            if (item.compareTo(key) == 0) {
                invalid = true;
            }
        }
        return invalid;
    }
    
    public static boolean validIdentifier(char[] charArr, String key) {
        boolean invalid = false;
        char firstLetter = key.charAt(0);
        // loop through the charArray to compare with the key
        for (char letter : charArr) {
            if (letter == firstLetter) {
                invalid = true;
            }
        }
        return invalid;
    }
}
