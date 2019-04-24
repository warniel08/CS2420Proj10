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
        String item;
        
        System.out.println("Welcome to the Symbol Table Checker. Enter a variable name to\n" +
                            "check against Java reserved keywords. If it's a resereved\n" +
                            "keyword, I'll let you know.");
        
        int userMenuChoice;
        String userKeyword;
        boolean again = true;
        Scanner userInput = new Scanner(System.in); // user input
        
        // display menu choices to run each part of Table class
        do {
            System.out.println("\nSymbol Table Menu:");
        } while (again);
    }
    
}
