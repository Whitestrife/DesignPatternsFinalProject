package dungeon;


public class Thief extends Hero implements Attack
{

    public Thief()
	{
		super("Thief", 75, 6, .8, 20, 40, .5);

    }//end constructor
    
    public void attack(DungeonCharacter opponent)
	{
		System.out.println(getName() + " swings a mighty sword at " +
							opponent.getName() + ":");
		super.attack(opponent);
	}

	public void special(DungeonCharacter opponent)
	{
		SpellPool.sneakAttack(opponent);
	}//end surpriseAttack method
}