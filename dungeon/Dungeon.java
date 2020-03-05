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
		    theHero = HeroFactory.CreateHero();
		    theMonster = MonsterFactory.CreateMonster();
			Battle.battle(theHero, theMonster);

		} while (playAgain());

    }

    
	public static boolean playAgain()
	{
		char again;

		System.out.println("Play again (y/n)?");
		again = scan.nextLine();

		return (again == 'Y' || again == 'y');
	}

	
	public static Scanner getscanner()
	{
		return scan;
	}
}