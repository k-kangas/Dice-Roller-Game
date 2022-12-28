/*
 * Kurt Kangas
 * CIS 2212 Java Software Development I
 * Dice Roller
 */

public class Main {

	public static void main(String[] args) {
    	// ** You do not need to change anything here. **
    	
    	// Create a new UserInterface object and call the 'go' method.
    	UserInterface ui = new UserInterface();
    	try {
        	ui.go();
    	}catch (Exception e){
    		e.getMessage();
    	}

    	System.out.println("\nGoodbye!");
	}
}
