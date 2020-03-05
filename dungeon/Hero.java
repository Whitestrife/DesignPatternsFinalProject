package dungeon;

public abstract class Hero extends DungeonCharacter
{
	private double chanceToBlock;
	private int numTurns;

//-----------------------------------------------------------------
//calls base constructor and gets name of hero from user
  Hero(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock)
  {
	super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax);
	this.chanceToBlock = chanceToBlock;
	readName();
  }

/*-------------------------------------------------------
readName obtains a name for the hero from the user

Receives: nothing
Returns: nothing

This method calls: nothing
This method is called by: hero constructor
---------------------------------------------------------*/
  public void readName()
  {
		System.out.print("Enter character name: ");
		setName(Keyboard.readString());
  }//end readName method

/*-------------------------------------------------------
defend determines if hero blocks attack

Receives: nothing
Returns: true if attack is blocked, false otherwise

This method calls: Math.random()
This method is called by: subtractHitPoints()
---------------------------------------------------------*/
  public boolean defend()
  {
		return Math.random() <= chanceToBlock;

  }//end defend method


  public void adjustHitPoints(int hitPoints){
		if (hitPoints < 0){
			super.adjustHitPoints(hitPoints);
	}else if(defend()){
		System.out.println(getName() + " BLOCKED the attack!");
	}else{
		super.adjustHitPoints(hitPoints);
	}
}//end method
  
  public int getTurns() {
	  return numTurns;
  }
  
  public void setTurns(int turns) {
	  this.numTurns = turns;
  }

/*-------------------------------------------------------
battleChoices will be overridden in derived classes.  It computes the
number of turns a hero will get per round based on the opponent that is
being fought.  The number of turns is reported to the user.  This stuff might
go better in another method that is invoked from this one...

Receives: opponent
Returns: nothing

This method calls: getAttackSpeed()
This method is called by: external sources
---------------------------------------------------------*/
	public void battleChoices(DungeonCharacter opponent)
	{
	    numTurns = getAttackSpeed()/opponent.getAttackSpeed();

		if (numTurns == 0)
			numTurns++;

		System.out.println("Number of turns this round is: " + numTurns);

	}//end battleChoices

}//end Hero class