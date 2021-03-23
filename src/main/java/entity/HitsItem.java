package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HitsItem{

	@JsonProperty("bookmarked")
	private boolean bookmarked;

	@JsonProperty("bought")
	private boolean bought;

	@JsonProperty("recipe")
	private Recipe recipe;

	public void setBookmarked(boolean bookmarked){
		this.bookmarked = bookmarked;
	}

	public boolean isBookmarked(){
		return bookmarked;
	}

	public void setBought(boolean bought){
		this.bought = bought;
	}

	public boolean isBought(){
		return bought;
	}

	public void setRecipe(Recipe recipe){
		this.recipe = recipe;
	}

	public Recipe getRecipe(){
		return recipe;
	}

	@Override
 	public String toString(){
		return 
			"HitsItem{" + 
			"bookmarked = '" + bookmarked + '\'' + 
			",bought = '" + bought + '\'' + 
			",recipe = '" + recipe + '\'' + 
			"}";
		}
}