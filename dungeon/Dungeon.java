package dungeon;


public class Dungeon
{
    public static void main(String[] args)
	{

		Hero theHero;
		Monster theMonster;

		do
		{
		    theHero = HeroFactory.chooseHero();
		    theMonster = MonsterFactory.generateMonster();
			Battle.battle(theHero, theMonster);

		} while (playAgain());

    }//end main method

/*-------------------------------------------------------------------
playAgain allows gets choice from user to play another game.  It returns
true if the user chooses to continue, false otherwise.
---------------------------------------------------------------------*/
	public static boolean playAgain()
	{
		char again;

		System.out.println("Play again (y/n)?");
		again = Keyboard.readChar();

		return (again == 'Y' || again == 'y');
	}//end playAgain method

}//end Dungeon class