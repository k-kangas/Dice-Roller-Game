/*
 * Kurt Kangas
 * CIS 2212 Java Software Development I
 * Dice Roller
 */

public class DiceFactory {

	// Declare an instance variable for the number of dice that were rolled.
	// We need this for the getResults method.
	private int myNumberOfDice;
	//TODO: Declare an array variable to store the totals.  Make it 'private' like we did above.
	private int[] storeTotals;


	//TODO: Write the rollDice method, saving the results in the array declared above.
	/**
	 * The rollDice method simulates rolling numberOfDice with numberOfSides the numberOfRolls times.
	 * The method doesn't return anything.
	 * @param int numberOfRolls - the number of times the dice are to be rolled.
	 * @param int numberOfSides - the number of sides for each die.
	 * @param int numberOfDice - the number of dice to be rolled.
	 */
	public void rollDice(int numberOfRolls, int numberOfSides, int numberOfDice)
	{
		int max = numberOfSides * numberOfDice;
		int min = numberOfDice;
		int range = max - min + 1;
		storeTotals = new int [numberOfRolls];
		for (int i = 0; i < numberOfRolls; i++)
		{
			int random_roll = (int)(Math.random()*(range)+min);
			storeTotals[i] = random_roll;
		}
		myNumberOfDice = 0;
		myNumberOfDice = max;
	}

	//TODO: Write the getResults method that builds a String with the results stored in the array from the last simulation.
	//      The method does not need parameters.
	//      If the array is null, which means getResults was called before rollDice, then assign an error message to the
	//      return String.
	/**
	 * The getResults method builds a String showing the results of the simulation.
	 * @return - the String containing the results of the simulation.
	 */
	public String getResults()
	{
		String results = "";
		int temp;
		for (int i = 0; i < storeTotals.length - 1; i++)
		{
			if(storeTotals[i] > storeTotals[i+1])
			{
				temp = storeTotals[i];
				storeTotals[i] = storeTotals[i+1];
				storeTotals[i+1]=temp;
				i=-1;
			}
		}
		temp = 0;
		for (int i = 2; i <= myNumberOfDice; i++)
		{
			results += "\n" + i + ") ";
			for (int items : storeTotals)
			{
				if (items == i)
				{	
					items = (items / items);
					temp += items;
				}
			}
			results += temp;
			temp = 0;
		}	
		return results;
	}
}
