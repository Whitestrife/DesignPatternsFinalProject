package dungeon;

import java.util.Scanner;

public class Dungeon
{
	static Scanner scan = new Scanner(System.in);
	
    public static void main(String[] args)
	{

		Hero theHero;
		Monster theMonster;
		
		do
		{
		    theHero = HeroFactory.createHero();
		    theMonster = MonsterFactory.CreateMonster();
			Battle.battle(theHero, theMonster);

		} while (playAgain());

    }//end main method

/*-------------------------------------------------------------------
playAgain allows gets choice from user to play another game.  It returns
true if the user chooses to continue, false otherwise.
---------------------------------------------------------------------*/
	public static boolean playAgain()
	{
		char again[];

		System.out.println("Play again (y/n)?");
		again = scan.next().toCharArray();

		return (again[0] == 'Y' || again[0] == 'y');
	}//end playAgain method

	public static Scanner getscanner()
	{
		return scan;
	}
}//end Dungeon class