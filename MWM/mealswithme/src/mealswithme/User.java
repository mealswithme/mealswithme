/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mealswithme;
import java.util.*;
/* Create a user with a username, friends list, and inventory of food items. */

public class User {

	/* Instance Variables */
	public ArrayList inventory = new ArrayList();
	public ArrayList<Integer> inventoryUnits = new ArrayList<Integer>();
	public ArrayList<String> friends = new ArrayList<String>();
	public Scanner scan = new Scanner(System.in);
        public String username;

	public User(String name){
		username = name;
	}
        public String getUsername() {
            return username;
        }
	/**
	 * Add food item to user inventory
	 *
	*/
	public void addItem(String s){
		inventory.add(s);
                System.out.println(s);
                
	}
        public void replaceInventory(ArrayList <String> temp) {
            inventory = temp;
        }
        public void removeItem(String s) {
            for (int i = 0; i < this.getInventory().size(); i++) {
                if (getInventory().get(i).equals(s)) {
                    getInventory().remove(i);
                    return;
                }
            }
        }
	/**
	 * Add friend to user friend list
	 *
	*/
	public void addFriend(String newFriend){
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
