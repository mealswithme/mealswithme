import java.util.*;
import java.io.*;

public class RecipeList {
	
	/*Constants*/
	private static final int MAX_INGREDIENTS = 20;
	private static final int MAX_RECIPES = 20;
	
	/* Instance Variables */
	public String[] recipeNames;
	public String[][] ingredientLists; 

	public RecipeList(){
		recipeNames = new String[MAX_RECIPES];
		ingredientLists = new String[MAX_RECIPES][MAX_INGREDIENTS];
		
		try{
			BufferedReader rd = new BufferedReader(new FileReader("Recipes.txt"));
			int i = 0;
			while(true){
				String line = rd.readLine();
				if(line == null) break;
				ArrayList<String> words = getWords(line);
				recipeNames[i] = words.get(0);
				ingredientLists[i] = getIngredients(words);
				i++;

			}
			rd.close();
		} catch(IOException ex) {
			throw new Error(ex);
		}
	}
	
	/**
	 * Get all words from a line
	 * 
	 * @param line one line of recipe list
	 * @return array list of each word in line
	 */
	private ArrayList<String > getWords(String line){
		ArrayList<String> words = new ArrayList<String>();
		
		StringTokenizer t = new StringTokenizer(line, ",");
		while(t.hasMoreTokens()){
			words.add(t.nextToken());
		}
		
		/*
		for(int i = 0; i < line.length(); i++){
			if(line.charAt(i) == ','){
				words.add(result);
			} else if(i == line.length()){
				result += line.charAt(i);
				words.add(result);
			} else {
				words.add(result);
			}
		}*/
		
		return words;
	}
	
	/**
	 * Get the name of each recipe which is the first word in a line
	 * 
	 * @param words ArrayList of words in a line
	 * @return      recipe name as String
	 */
	public String getRecipeName(ArrayList<String> words){
		return words.get(0);
	}
	
	/**
	 * Return an array of ingredients in a recipe
	 * 
	 * @param words ArrayList of words in a line
	 * @return      array of ingredients
	 */
	public String[] getIngredients(ArrayList<String> words){
		String[] ingredientList = new String[MAX_INGREDIENTS];
		for(int i = 1; i < words.size(); i++){
			ingredientList[i] = words.get(i);
		}
		return ingredientList;
	}
	
	public String[] getRecipeNames(){
		return recipeNames;
	}
	
	public String[][] getIngredientLists(){
		return ingredientLists;
	}
	
}
