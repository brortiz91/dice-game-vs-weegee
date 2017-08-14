//determines whose roll contains a higher value when rolling 2, 3, 4, or 5 of a kind
public class FiveDice3
{
	public static void main(String[] args)
	{
		final int NUM = 5;
		Dice[] comp = new Dice[NUM];
		Dice[] player = new Dice[NUM];
		int x;
		
		//Rolling the 5 dice and adding the values to the arrays
		for(x = 0; x < NUM; ++x)
		{
			comp[x] = new Dice();
			player[x] = new Dice();
		}
		
		//game mechanics
		int compMatch;
		int playerMatch;
		int compHigh;
		int playerHigh;
		String computerName = "Luigi";
		String playerName = "Bryan";
		display(computerName, comp, NUM);
		display(playerName, player, NUM);
		compMatch = howManySame(comp, NUM);
		playerMatch = howManySame(player, NUM);
		compHigh = compMatch / 10;
		playerHigh = playerMatch / 10;
		compMatch = compMatch % 10;
		playerMatch = playerMatch % 10;
		
		if(compMatch == 1)
			System.out.println(computerName + " has NOTHING!");
		else
			System.out.println(computerName + " has " + compMatch + " of a kind.");
		if(playerMatch == 1)
			System.out.println(playerName + " has NOTHING!");
		else
			System.out.println(playerName + " has " + playerMatch + " of a kind.");
		
		if(compMatch > playerMatch)
			System.out.println(computerName + " has won! FEAR THE WEEGEE!");
		else
			if(compMatch < playerMatch)
				System.out.println(playerName + " has TAKEN DOWN WEEGEE!");
			else
			{
				if(compHigh > playerHigh)
					System.out.println(computerName + "'s values are higher! " + computerName + " has won! FEAR THE WEEGEE!");
				else
					if(compHigh < playerHigh)
						System.out.println(playerName + "'s values are higher! " + playerName + " has TAKEN DOWN WEEGEE!");
					else
						System.out.println("WELP! WE GOT A TIE!");
			}
	}
	
	public static void display(String who, Dice[] die, int num)
	{
		int x;
		String dice = "";
		
		for(x = 0; x < num; ++x)
			dice = dice + die[x].getValue() + " ";
		System.out.println(who + " rolled: " + dice);
	}
	public static int howManySame(Dice[] die, int num)
	{
		int[] same = new int[num];
		int x;
		int y;
		int highest;
		int highValue = 0;
		
		for(x = 0; x < num; ++x)
			same[x] = 1; //Every Die matches itself
		for(x = 0; x < num - 1; ++x)
		{
			for(y = x + 1; y < num; ++y)
				if(die[x].getValue() == die[y].getValue())
				{
					same[x]++;
					if(die[x].getValue() > highValue)
						highValue = die[x].getValue();
				}
		}
		highest = same[0];
		for(x = 1; x < num; ++x)
			if(same[x] > highest)
				highest = same[x];
			highest = highest + 10 * highValue;
			return highest;
	}
}