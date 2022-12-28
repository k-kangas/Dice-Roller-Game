/*
 * Kurt Kangas
 * CIS 2212 Java Software Development I
 * Dice Roller
 */

import java.util.Scanner;

public class UserInterface {
    // Use these values for the quick roll option.
    final int ROLLS = 20;
    final int DICE = 2;
    final int SIDES = 6;

    // Setup our colors.
    final String MENU_COLOR = "\u001B[36m";     // Cyan
    final String PROMPT_COLOR = "\u001B[34m";   // Blue
    final String INPUT_COLOR = "\u001B[32m";    // Green
    final String ERROR_COLOR = "\u001B[31m";    // Red
    final String RESULTS_COLOR = "\u001B[33m";  // Yellow
    final String BACKGROUND_COLOR = "\u001B[47m";   // White
    final String CLEAR = "\033[H\033[2J";      // Clear the screen

    // Instance variables
    private DiceFactory df;
    private Scanner input;

    /**
     * Construct a Scanner and a new DiceFactory object.
     */
    public UserInterface()
    {
        input = new Scanner(System.in);
        df = new DiceFactory();
    }

    /**
     * Launch the Dice Roller program menu.
     */
    public void go()
    {
    	//TODO: Display the menu and get the user's menu choice.
    	
    	//TODO: Write a switch statement to process the user's menu choice.
    	//      Choice 0 (Quit) - break out of the menu loop so that the program exits.
    	//      Choice 1 (Quick roll) - call the rollDice method and send the constants declared above.
    	//      Choice 2 (Custom roll) - input the number of rolls, number of dice, and number of sides using the inputInt method.
    	
    	//TODO: Do all of the above in the context of the appropriate loop statement until the user chooses to quit.
    	
    	int choice = -1;
    	do {
        	displayMenu();
        	System.out.println();
        	choice = inputInt("Enter your choice: ", 0, 2, PROMPT_COLOR, INPUT_COLOR, ERROR_COLOR);
        	System.out.println();
        	switch (choice)
        	{
        	case 0: 
        		System.out.println("End of program!!");
        		displayResults();
        		choice = 0;
        		break;
        	case 1: 
        		df.rollDice(ROLLS, SIDES, DICE);
        		displayResults();
        		break;
        	case 2:
        		int rolls = inputInt("Enter the number of times you want to roll the dice: ", 0, 1000, PROMPT_COLOR, INPUT_COLOR, ERROR_COLOR);
        		int sides = inputInt("Enter the number of sides on each die: ", 0, 1000, PROMPT_COLOR, INPUT_COLOR, ERROR_COLOR);
        		int dice = inputInt("Enter the number of dice you want to roll each time: ", 0, 1000, PROMPT_COLOR, INPUT_COLOR, ERROR_COLOR);
        		df.rollDice(rolls, sides, dice);
        		displayResults();
        		break;
        	default:
        		System.out.println("Choice default was selected, but haven't done anything yet.");
        		choice = 0;
        		break;
        	}
        	
    	} while(choice != 0);

    	

    	
    }

    /**
     * Private helper method that displays the menu.
     * Call this method from the 'go' method above by entering:  displayMenu();
     */
    private void displayMenu()
    {
        System.out.println(CLEAR);
        System.out.flush();
        System.out.print(MENU_COLOR);
        System.out.println("Welcome to Dice Roller.\n");
        System.out.println("Here's the menu of choices -");
        System.out.println("0) Quit");
        System.out.printf("1) Quick roll with the default values (rolls = %d, dice = %d, sides = %d)\n", ROLLS, DICE, SIDES);
        System.out.println("2) Custom dice rolling (You enter the number of rolls, dice and sides.)");
    }

    /**
     * Private helper method that gets and displays the simulation results.
     * Call this method from the 'go' method above by entering:  displayResults();
    */
    private void displayResults()
    {
        String results = df.getResults();
        System.out.print(RESULTS_COLOR);
        System.out.println("\n" + results);
        System.out.print(PROMPT_COLOR);
        System.out.print("\nPress <Enter> to continue. ");
        input.nextLine(); 
    }

    /**
     * (Mostly) error-proof method to get an int from the user.
     * @param prompt - the message to be displayed for the input prompt.
     * @param min - the smallest number allowed.
     * @param max - the largest number allowed.
     * @param promptColor
     * @param inputColor
     * @param errorColor
     * @return the int entered by the user.
     * Call this method from the 'go' method above by entering something like this:  
     *     int num = inputInt("Enter a number: ", 0, 100, PROMPT_COLOR, INPUT_COLOR, ERROR_COLOR);
     */
    private int inputInt(String prompt, int min, int max,
                         String promptColor, String inputColor, String errorColor)
    {
        int number = -1;    // -1 Just to make the compiler happy.
        boolean wrong = true;
        do
        {
            try
            {
                System.out.print(promptColor);
                System.out.print(prompt);
                System.out.print(inputColor);
                number = Integer.parseInt(input.nextLine());

                if (number > max || number < min)
                {
                    System.out.print(errorColor);
                    System.out.printf("That number is out of range [%d to %d].  Try again.\n",
                            min, max);
                }
                else    // good input
                {
                    wrong = false;
                }

            }
            catch (NumberFormatException e)
            {
                System.out.print(errorColor);
                System.out.println("Make sure you enter an integer.  Try again.");
            }
        } while (wrong);

        return number;
    }
}
