package game;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	
	String name;
	int money = 750;
	int pos = 0;
	int doubleStreak = 0;
	boolean inJail = false;
	int inJailCounter = 0;
	boolean isMoving = true;
	//BoardSpace occupied = 
	
	//array list so it can be added to 
	ArrayList <BoardSpace> namesOfProperties = new ArrayList();
	
	
	public ArrayList <BoardSpace> getProperties(){
		return namesOfProperties;
	}
	
	public void printProperties(ArrayList <BoardSpace> properties) {
		if (properties.isEmpty()) {
			System.out.println("You own no properties");
		}
		else {
			for(int i = 0; i < properties.size(); i++) {
				System.out.println(properties.get(i).name);
			}
		}
	}
	
	public String getName() {
		return name;
	}
	
	public int getMoney() {
		return money;
	}
	
	public int getPosition() {
		return pos;
	}
	
	public int getDoubleStreak() {
		return doubleStreak;
	}
	
	public int getJailCounter() {
		return inJailCounter;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public void setPosition(int pos) {
		this.pos = pos;
	}
	
	public void addToDoubleStreak() {
		doubleStreak++;
	}
	
	public void resetDoubleStreak() {
		doubleStreak = 0;
	}
	
	public void addToJailCounter() {
		inJailCounter++;
	}
	
	public void resetJailCounter() {
		inJailCounter = 0;
	}
	public void addToProperties(BoardSpace property) {
		this.namesOfProperties.add(property);
	}
	
	public void addMoney(int priceOfProperty) {
		money += priceOfProperty;
		//if the player is paying the money, just use a negative input instead
	}
	
	public void payToPlayer(Player recipient, int amountOfMoney) {
		recipient.addMoney(amountOfMoney);
		//amount is negatively "added" to the player paying
		addMoney(-amountOfMoney);
	}
	
	public void buySpace(BoardSpace occupied, Player currentPlayer) {
		//Scanner scan = new Scanner(System.in);
		if (occupied.getOwned() == false) {
			
		//System.out.println("Player can buy this property for " + occupied.costToBuy + ".");
		//if (currentPlayer.getName().equals("player1")) { // only giving option to non-computer player
			//System.out.println("Does player want to buy this space?");
			//System.out.println("Type: 'y' for yes or 'n' for no");
			//String yesOrNo = scan.next();
	
			//if (yesOrNo.equalsIgnoreCase("y")) {
				currentPlayer.addToProperties(occupied);
				System.out.println("Added " + occupied.getName());
				occupied.setOwnerName(getName());
				currentPlayer.addMoney(-occupied.costToBuy);
			//}
			//else {
				//System.out.println("Space is not bought.");		
			//}
		//}
		}
		else {
			System.out.println("Space is owned by " + occupied.getOwnerName());
		}
	}
	
	public boolean doesPlayerOwn (BoardSpace property) {
		return namesOfProperties.contains(property);
	}
	
	public int payRent(Player currentPlayer) {
		int cost = Board.spaces[currentPlayer.pos].rent;
		payToPlayer(Board.spaces[currentPlayer.pos].owner, cost);
		return cost;
	}

	public boolean isBankrupt() {
		if(money <= 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean ownsColorGroup (String color) {
		int tempColor = 0;
		int maxTemp;
		if(color == "purple" || color == "blue" || color == "utilities") {
			maxTemp = 2;
		}
		else if(color == "railroad") {
			maxTemp = 4;
		}
		else {
			maxTemp = 3;
		}
		for(int i = 0; i < getProperties().size(); i++) {
			if((getProperties().get(i)).getColorSet() == color) {
				tempColor++;
			}
		}
		if(tempColor < maxTemp) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public int amountOfColor (String color) {
		int colorNum = 0;
		for(int i = 0; i < namesOfProperties.size(); i++) {
			if((namesOfProperties.get(i)).getColorSet() == color) {
				colorNum++;
			}
		}
			return colorNum;
	}
	}
