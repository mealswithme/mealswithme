/*
 * File: BlankClass.java
 * ---------------------
 * This class is a blank one that you can change at will. Remember, if you change
 * the class name, you'll need to change the filename so that it matches.
 * Then you can extend GraphicsProgram, ConsoleProgram, or DialogProgram as you like.
 */


public class RecipeReader {
	
	private static RecipeList recipeList = new RecipeList();
	
	public static void main(String[] args) {
		
			String[] recipeNames = recipeList.getRecipeNames();
			System.out.println(recipeNames[1]);
			
			User jen = new User("jcard27");
			jen.addFriend();
			jen.addItem();
            jen.addItem();
			System.out.println(jen.getInventory());
	}
	
	

}



