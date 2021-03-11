package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IngredientsItem{

	@JsonProperty("image")
	private String image;

	@JsonProperty("foodId")
	private String foodId;

	@JsonProperty("weight")
	private double weight;

	@JsonProperty("text")
	private String text;

	@JsonProperty("foodCategory")
	private String foodCategory;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setFoodId(String foodId){
		this.foodId = foodId;
	}

	public String getFoodId(){
		return foodId;
	}

	public void setWeight(double weight){
		this.weight = weight;
	}

	public double getWeight(){
		return weight;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	public void setFoodCategory(String foodCategory){
		this.foodCategory = foodCategory;
	}

	public String getFoodCategory(){
		return foodCategory;
	}

	@Override
 	public String toString(){
		return 
			"IngredientsItem{" + 
			"image = '" + image + '\'' + 
			",foodId = '" + foodId + '\'' + 
			",weight = '" + weight + '\'' + 
			",text = '" + text + '\'' + 
			",foodCategory = '" + foodCategory + '\'' + 
			"}";
		}
}