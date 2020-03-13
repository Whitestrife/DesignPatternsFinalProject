package dungeon;

import java.util.Scanner;

public class GameStateManager {
	
	private static Room[][] gameDungeon;
	private static int[] currentRoom;
	private static Hero theHero;
	private static Scanner scan = new Scanner(System.in);

	public static void stateSetup() {
		statesHolder state = InitializeGame.BuildGame();
		theHero = state.theHero;
		gameDungeon = state.dungeon;
		currentRoom = state.currRoom;
		
		exploredMap();
		startGame();
		
	}
	
	public static void startGame() {
		theHero.nonBattleChoices();
	}
	
	public static Scanner getScanner() {
		return scan;
	}
	
	public static int[] getCurrentRoom() {
		return currentRoom;
	}
	
	public static Hero getHero() {
		return theHero;
	}
	
	public static int getInt() {
		
		int choice = -1;
		boolean isInt = false;
		do {
			if(scan.hasNextInt()) {
				choice = scan.nextInt();
				isInt = true;
			}else {
				scan.nextLine();
				System.out.println("Mismatch Exception: Try Again");
			}
		
		}while(!isInt);
		
		if(choice == 37 && theHero != null) {
			hiddenMenu();
		}
		
		return choice;
	}
	
	public static String getString() {
		return scan.next();
	}
	
	public static void pauseTime(double sleepTime) {
		try {
			Thread.sleep((int)(sleepTime*1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void setCurrentRoom(int x, int y) {
		currentRoom[0] = x;
		currentRoom[1] = y;
		
		if(!gameDungeon[x][y].characterHasBeenHere) {
			
			if(gameDungeon[x][y].getClass().toString().contains("exitRoom")) {
				
			}else {
			gameDungeon[x][y].characterHasBeenHere = true;
			}
			gameDungeon[x][y].triggerRoom(theHero);
		}else {
			System.out.println("This room feels familiar");
		}
		
		exploredMap();
	}

	public static void visionPotionReveal() {
		
		try{gameDungeon[currentRoom[0]][currentRoom[1]-1].temporaryReveal = true;}catch(ArrayIndexOutOfBoundsException e) {}
		try{gameDungeon[currentRoom[0]+1][currentRoom[1]-1].temporaryReveal = true;}catch(ArrayIndexOutOfBoundsException e) {}
		try{gameDungeon[currentRoom[0]+1][currentRoom[1]].temporaryReveal = true;}catch(ArrayIndexOutOfBoundsException e) {}
		try{gameDungeon[currentRoom[0]+1][currentRoom[1]+1].temporaryReveal = true;}catch(ArrayIndexOutOfBoundsException e) {}
		try{gameDungeon[currentRoom[0]][currentRoom[1]+1].temporaryReveal = true;}catch(ArrayIndexOutOfBoundsException e) {}
		try{gameDungeon[currentRoom[0]-1][currentRoom[1]+1].temporaryReveal = true;}catch(ArrayIndexOutOfBoundsException e) {}
		try{gameDungeon[currentRoom[0]-1][currentRoom[1]].temporaryReveal = true;}catch(ArrayIndexOutOfBoundsException e) {}
		try{gameDungeon[currentRoom[0]-1][currentRoom[1]-1].temporaryReveal = true;}catch(ArrayIndexOutOfBoundsException e) {}
		
		exploredMap();
	}
	
	public static void fullMapReveal() {
		for(Room[] r : gameDungeon) {
			for(Room rm : r) {
				rm.temporaryReveal = true;
			}
		}
		exploredMap();		 		 	
	}
	
	public static void resetVisionPotion() {
		for(Room[] r : gameDungeon) {
			for(Room rm : r) {
				rm.temporaryReveal = false;
			}
		}
	}
	
	public static void exploredMap() {
		
		int i = 0;
		
		for(i = 0; i <= ((gameDungeon.length*2)); i++) {
			System.out.print("*");
		}
		System.out.println();
		System.out.print("*");
		
		for(int j = 0; j < gameDungeon.length-1; j++) {
			
			for(i = 0; i < (gameDungeon.length-1);i++) {
				System.out.print(gameDungeon[i][j].getRoomType() + "|");
			}
			System.out.print(gameDungeon[i][j].getRoomType());
			System.out.print("*\n");
			System.out.print("*");
			
			for(i = 0; i < (gameDungeon.length);i++) {
				System.out.print("-*");
			}
			System.out.println();
			System.out.print("*");
		}
		
		for(i = 0; i < (gameDungeon.length-1);i++) {
			System.out.print(gameDungeon[i][gameDungeon.length-1].getRoomType() + "|");
		}
		System.out.print(gameDungeon[i][gameDungeon.length-1].getRoomType());
		System.out.print("*\n");
		
		for(i = 0; i <= ((gameDungeon.length*2)); i++) {
			System.out.print("*");
		}
		System.out.println();
		
	}
	
	public static void winGame() {
		System.out.println("You have collected the four Artifacts of OO and have become a code dungeon wizard. Now ask Tapaul for your 40 extra credit points.");
		if(DungeonAdventure.playAgain(scan)) {
			stateSetup();
		}else {
			System.exit(0);
		}
	}

	public static void hiddenMenu() {
		
		System.out.println("Welcome to the Cheats Menu!\n"
						 + "Choose your Cheat!\n"
						 + "1. Full Dungeon Reveal\n"
						 + "2. God Mode\n"
						 + "3. Big Head Mode");
		
		int choice = getInt();
		switch (choice)
	    {
		    case 1: fullMapReveal();
		    	break;
		    case 2: godMode();
		        break;
		    case 3: System.out.println("Just look in the mirror.");
		    	break;
		    default:
		        System.out.println("\nNo Valid Option Selected \n=================\n");
	    }
		
	}

	private static void godMode() {
		theHero.setAttackSpeed(10);
		theHero.setHitPoints(1000);
		theHero.setDamageMin(100);
		theHero.setDamageMax(200);
		theHero.setChanceToHit(1);
		
	}
}
