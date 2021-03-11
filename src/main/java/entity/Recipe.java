package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Recipe{

	@JsonProperty("hits")
	private List<HitsItem> hits;

	@JsonProperty("q")
	private String Q;

	@JsonProperty("more")
	private boolean more;

	@JsonProperty("count")
	private int count;

	@JsonProperty("from")
	private int from;

	@JsonProperty("to")
	private int to;

	@JsonProperty("image")
	private String image;

	@JsonProperty("shareAs")
	private String shareAs;

	@JsonProperty("cautions")
	private List<String> cautions;

	@JsonProperty("healthLabels")
	private List<String> healthLabels;

	@JsonProperty("totalTime")
	private double totalTime;

	@JsonProperty("label")
	private String label;

	@JsonProperty("source")
	private String source;

	@JsonProperty("calories")
	private double calories;

	@JsonProperty("uri")
	private String uri;

	@JsonProperty("url")
	private String url;

	@JsonProperty("totalNutrients")
	private TotalNutrients totalNutrients;

	@JsonProperty("dietLabels")
	private List<String> dietLabels;

	@JsonProperty("yield")
	private double yield;

	@JsonProperty("totalWeight")
	private double totalWeight;

	@JsonProperty("digest")
	private List<DigestItem> digest;

	@JsonProperty("ingredients")
	private List<IngredientsItem> ingredients;

	@JsonProperty("totalDaily")
	private TotalDaily totalDaily;

	@JsonProperty("ingredientLines")
	private List<String> ingredientLines;

	@JsonProperty("mealType")
	private List<String> mealType;

	@JsonProperty("cuisineType")
	private List<String> cuisineType;

	@JsonProperty("dishType")
	private List<String> dishType;

	public void setHits(List<HitsItem> hits){
		this.hits = hits;
	}

	public List<HitsItem> getHits(){
		return hits;
	}

	public void setQ(String Q){
		this.Q = Q;
	}

	public String getQ(){
		return Q;
	}

	public void setMore(boolean more){
		this.more = more;
	}

	public boolean isMore(){
		return more;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setFrom(int from){
		this.from = from;
	}

	public int getFrom(){
		return from;
	}

	public void setTo(int to){
		this.to = to;
	}

	public int getTo(){
		return to;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setShareAs(String shareAs){
		this.shareAs = shareAs;
	}

	public String getShareAs(){
		return shareAs;
	}

	public void setCautions(List<String> cautions){
		this.cautions = cautions;
	}

	public List<String> getCautions(){
		return cautions;
	}

	public void setHealthLabels(List<String> healthLabels){
		this.healthLabels = healthLabels;
	}

	public List<String> getHealthLabels(){
		return healthLabels;
	}

	public void setTotalTime(double totalTime){
		this.totalTime = totalTime;
	}

	public double getTotalTime(){
		return totalTime;
	}

	public void setLabel(String label){
		this.label = label;
	}

	public String getLabel(){
		return label;
	}

	public void setSource(String source){
		this.source = source;
	}

	public String getSource(){
		return source;
	}

	public void setCalories(double calories){
		this.calories = calories;
	}

	public double getCalories(){
		return calories;
	}

	public void setUri(String uri){
		this.uri = uri;
	}

	public String getUri(){
		return uri;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setTotalNutrients(TotalNutrients totalNutrients){
		this.totalNutrients = totalNutrients;
	}

	public TotalNutrients getTotalNutrients(){
		return totalNutrients;
	}

	public void setDietLabels(List<String> dietLabels){
		this.dietLabels = dietLabels;
	}

	public List<String> getDietLabels(){
		return dietLabels;
	}

	public void setYield(double yield){
		this.yield = yield;
	}

	public double getYield(){
		return yield;
	}

	public void setTotalWeight(double totalWeight){
		this.totalWeight = totalWeight;
	}

	public double getTotalWeight(){
		return totalWeight;
	}

	public void setDigest(List<DigestItem> digest){
		this.digest = digest;
	}

	public List<DigestItem> getDigest(){
		return digest;
	}

	public void setIngredients(List<IngredientsItem> ingredients){
		this.ingredients = ingredients;
	}

	public List<IngredientsItem> getIngredients(){
		return ingredients;
	}

	public void setTotalDaily(TotalDaily totalDaily){
		this.totalDaily = totalDaily;
	}

	public TotalDaily getTotalDaily(){
		return totalDaily;
	}

	public void setIngredientLines(List<String> ingredientLines){
		this.ingredientLines = ingredientLines;
	}

	public List<String> getIngredientLines(){
		return ingredientLines;
	}

	public void setMealType(List<String> mealType){
		this.mealType = mealType;
	}

	public List<String> getMealType(){
		return mealType;
	}

	public void setCuisineType(List<String> cuisineType){
		this.cuisineType = cuisineType;
	}

	public List<String> getCuisineType(){
		return cuisineType;
	}

	public void setDishType(List<String> dishType){
		this.dishType = dishType;
	}

	public List<String> getDishType(){
		return dishType;
	}

	@Override
 	public String toString(){
		return 
			"Recipe{" + 
			"hits = '" + hits + '\'' + 
			",q = '" + Q + '\'' + 
			",more = '" + more + '\'' + 
			",count = '" + count + '\'' + 
			",from = '" + from + '\'' + 
			",to = '" + to + '\'' + 
			",image = '" + image + '\'' + 
			",shareAs = '" + shareAs + '\'' + 
			",cautions = '" + cautions + '\'' + 
			",healthLabels = '" + healthLabels + '\'' + 
			",totalTime = '" + totalTime + '\'' + 
			",label = '" + label + '\'' + 
			",source = '" + source + '\'' + 
			",calories = '" + calories + '\'' + 
			",uri = '" + uri + '\'' + 
			",url = '" + url + '\'' + 
			",totalNutrients = '" + totalNutrients + '\'' + 
			",dietLabels = '" + dietLabels + '\'' + 
			",yield = '" + yield + '\'' + 
			",totalWeight = '" + totalWeight + '\'' + 
			",digest = '" + digest + '\'' + 
			",ingredients = '" + ingredients + '\'' + 
			",totalDaily = '" + totalDaily + '\'' + 
			",ingredientLines = '" + ingredientLines + '\'' + 
			",mealType = '" + mealType + '\'' + 
			",cuisineType = '" + cuisineType + '\'' + 
			",dishType = '" + dishType + '\'' + 
			"}";
		}
}