import java.util.*;

/* Create a user with a username, friends list, and inventory of food items. */

public class User {

	/* Instance Variables */
	public ArrayList<String> inventory = new ArrayList<String>();
	public ArrayList<Integer> inventoryUnits = new ArrayList<Integer>();
	public ArrayList<String> friends = new ArrayList<String>();
	public Scanner scan = new Scanner(System.in);

	public User(String name){
		String username = name;
	}

	/**
	 * Add food item to user inventory
	 *
	*/
	public void addItem(){
		System.out.print("Enter food item: ");
		//String item = System.console().readLine();
		String item = scan.nextLine();
		System.out.print("How many:");
		int unit = scan.nextInt();
		inventory.add(item);
		inventoryUnits.add(unit);
	}

	/**
	 * Add friend to user friend list
	 *
	*/
	public void addFriend(){
	    System.out.print("Enter new friend username: ");
	    String newFriend = System.console().readLine();
		friends.add(newFriend);
	}

	/**
	 * Get user inventory as an ArrayList
	 *
	 * @return user inventory of food items
	*/
	public ArrayList<String> getInventory(){
		return inventory;
	}

	/**
	 * Get user friend list as an ArrayList
	 *
	 * @return user inventory of food items
	*/
	public ArrayList<String> getFriends(){
		return friends;
	}
	
}

	
	
	
	