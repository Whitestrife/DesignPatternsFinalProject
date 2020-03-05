package dungeon;


public class Warrior extends Hero implements Attack
{

    public Warrior()
	{

		super("Warrior", 125, 4, .8, 35, 60, .2);


    }//end constructor


    public void special(DungeonCharacter opponent) {
    	SpellPool.crushingBlow(opponent);
    }

	public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " swings a mighty sword at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}//end override of attack method

}//end Hero class