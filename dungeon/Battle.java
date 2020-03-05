package dungeon;

public class Battle {
	
	 public static void battleChoices(Hero theHero, DungeonCharacter opponent)
		{
			int choice;

			theHero.setTurns(theHero.getAttackSpeed()/opponent.getAttackSpeed());

			if (theHero.getTurns() == 0)
				theHero.setTurns(1);

			System.out.println("Number of turns this round is: " + theHero.getTurns());

			do
			{
			    System.out.println("1. Attack Opponent");
			    System.out.println("2. Use Special Ability");
			    System.out.print("Choose an option: ");
			    choice = Dungeon.getscanner().nextInt();

			    switch (choice)
			    {
				    case 1: theHero.attack(opponent);
				        break;
				    case 2: theHero.special(opponent);
				        break;
				    default:
				        System.out.println("invalid choice!");
			    }//end switch

				theHero.setTurns(theHero.getTurns()-1);
				if (theHero.getTurns() > 0)
				    System.out.println("Number of turns remaining is: " + theHero.getTurns());

			} while(theHero.getTurns() > 0 && theHero.getHitPoints() > 0 && opponent.getHitPoints() > 0);

	    }
	
	public static void battle(Hero theHero, Monster theMonster)
	{
		String pause = "p";
		System.out.println(theHero.getName() + " battles " +
							theMonster.getName());
		System.out.println("---------------------------------------------");

		//do battle
		while (theHero.isAlive() && theMonster.isAlive() && pause.charAt(0) != 'q')
		{
		    //hero goes first
			battleChoices(theHero, theMonster);

			//monster's turn (provided it's still alive!)
			if (theMonster.isAlive())
			    theMonster.attack(theHero);

			//let the player bail out if desired
			System.out.print("\n-->q to quit, anything else to continue: ");
			pause = Dungeon.getscanner().next();

		}//end battle loop

		if (!theMonster.isAlive())
		    System.out.println(theHero.getName() + " was victorious!");
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated :-(");
		else//both are alive so user quit the game
			System.out.println("Quitters never win ;-)");

	}//end battle method


}
