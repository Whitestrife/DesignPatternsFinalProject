package dungeon;


public class Warrior extends Hero
{

    Warrior()
	{

		super("Warrior", 125, 4, .8, 35, 60, .2);


    }//end constructor


	public void crushingBlow(DungeonCharacter opponent)
	{
		if (Math.random() <= .4)
		{
			int blowPoints = (int)(Math.random() * 76) + 100;
			System.out.println(getName() + " lands a CRUSHING BLOW for " + blowPoints
								+ " damage!");
			opponent.adjustHitPoints(blowPoints);
		}//end blow succeeded
		else
		{
			System.out.println(getName() + " failed to land a crushing blow");
			System.out.println();
		}//blow failed

	}//end crushingBlow method

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " swings a mighty sword at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}//end override of attack method




    public void battleChoices(DungeonCharacter opponent)
	{
		int choice;

		super.battleChoices(opponent);

		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. Crushing Blow on Opponent");
		    System.out.print("Choose an option: ");
		    choice = Keyboard.readInt();

		    switch (choice)
		    {
			    case 1: attack(opponent);
			        break;
			    case 2: crushingBlow(opponent);
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

			setTurns(getTurns()-1);
			if (getTurns() > 0)
			    System.out.println("Number of turns remaining is: " + getTurns());

		} while(getTurns() > 0);

    }//end battleChoices method

}//end Hero class