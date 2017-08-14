public class Dice
{
	private int randomValue;
	private static final int HIGHEST_DIE_VALUE = 6;
	private static final int LOWEST_DIE_VALUE = 1;
	
	public Dice()
	{
		randomValue = ((int)(Math.random() * 100) % HIGHEST_DIE_VALUE + LOWEST_DIE_VALUE);
	}
	
	public int getValue()
	{
		return randomValue;
	}
}