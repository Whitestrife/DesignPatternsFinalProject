package dungeon;

public abstract class Room {
	
	boolean characterHasBeenHere;
	boolean temporaryReveal;
	public abstract void triggerRoom(Hero theHero);
	public abstract char getRoomType();

}
