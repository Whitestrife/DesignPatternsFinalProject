package dungeon;

public class SpellPool {
	
	private static Hero theHero;
	
	public static void setHero(Hero theHero) {
		SpellPool.theHero = theHero;
	}
	
	public static void heal()
    {
		
	    int hPoints;

		hPoints = (int)(Math.random() * (theHero.getDamageMax() - theHero.getDamageMin() + 1)) + theHero.getDamageMin();
		theHero.adjustHitPoints(-hPoints);
		System.out.println(theHero.getName() + " added [" + hPoints + "] points.\n"
							+ "Total hit points remaining are: "
							+ theHero.getHitPoints());
		 System.out.println();

    }
	
	public static void sneakAttack(DungeonCharacter opponent)
	{
		
		
		double surprise = Math.random();
		if (surprise <= .4)
		{
			System.out.println("Surprise attack was successful!\n" +
								theHero.getName() + " gets an additional turn.");
			theHero.setTurns(theHero.getTurns()+1);
			theHero.attack(opponent);
		}//end surprise
		else if (surprise >= .9)
		{
			System.out.println("Uh oh! " + opponent.getName() + " saw you and" +
								" blocked your attack!");
		}
		else
		    theHero.attack(opponent);


	}
	
	public static void crushingBlow(DungeonCharacter opponent)
	{
		if (Math.random() <= .4)
		{
			int blowPoints = (int)(Math.random() * 76) + 100;
			System.out.println(theHero.getName() + " lands a CRUSHING BLOW for " + blowPoints
								+ " damage!");
			opponent.adjustHitPoints(blowPoints);
		}//end blow succeeded
		else
		{
			System.out.println(theHero.getName() + " failed to land a crushing blow");
			System.out.println();
		}//blow failed

	}

}
