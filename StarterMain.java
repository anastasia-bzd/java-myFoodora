/**
 * 
 */
package myFoodoraMenu;

import java.util.ArrayList;

/**
 * @author anastasiabouzdine
 * 
 * StarterMain est une classe héritée de HalfMeal.
 * Elle représente un meal partiel comprenant uniquement l'entrée et le plat principal.
 * Possède:
 * <ul>
 * <li>Un nom.</li>
 * <li>Un prix.</li>
 * <li>Un type.</li>
 * <li>Un booléen sur la contenance en gluten.</li>
 * <li>Une remise sur le prix.</li>
 * <li>Une entrée.</li>
 * <li>Un plat.</li>
 *
 *
 **
 * @see HalfMeal
 * @see Starter
 * @see MainDish
 * @see Observable
 * @see Observer
 */
public class StarterMain extends HalfMeal implements Observer{
	
	/**
	 * L'entrée du menu.
	 * 
	 * @see StarterMain#getStarter()
	 * @see StarterMain#setStarter(Starter)
	 */
	private Starter starter;
	
	/**
	 * Constructeur par défaut StarterMain.
	 */
	public StarterMain(){
	}
	
	/**
	 * Constructeur StarterMain avec le nom, l'entrée et le plat principal du StarterMain.
	 * @param name
	 * Le nom du StarterMain.
	 * @param starter
	 * L'entrée du StarterMain.
	 * @param mainDish
	 * Le plat du StarterMain.
	 * 
	 * @see StarterMain#computePrice(StarterMain)
	 * @see StarterMain#accessType(StarterMain)
	 */
	public StarterMain (String name, Starter starter, mainDish mainDish){
		super(name, mainDish);
		this.starter = starter;
	}
	
	/**
	 * Permet de caractériser le type du StarterMain grâce à ses items.
	 * @param StarterMain
	 * Le StarterMain dont le type est recherché.
	 * 
	 *@see Item
	 *@see Meal#type
	 */
	private static void accessType(StarterMain starterMain){
		ArrayList<Item> meals = new ArrayList<Item>();
		meals.add(starterMain.starter);
		meals.add(starterMain.getmainDish());
		
		int vegCounter = 0;
		int glutenFreeCounter = 0;
		
		for(Item i : meals){
			if(i.getType().equals("Standard")){
				starterMain.type = "Standard";}
			if(i.getType().equals("Vegetarian")){
				vegCounter+=1;}
			if(i.isGlutenFree()){
				glutenFreeCounter+=1;}
		}

		if(vegCounter==2)
			starterMain.type = "Vegetarian";
		if(glutenFreeCounter==2)
			starterMain.glutenFree= true;
	}
	
	
	/**
	 * Calcule le prix du StarterMain.
	 * 
	 * @param StarterMain
	 * Le StarterMain dont on calcule le prix total.
	 * 
	 * @see Meal#price
	 */
	private static void computePrice(StarterMain starterMain){
		ArrayList<Item> meal = new ArrayList<Item>();
		meal.add(starterMain.getStarter());
		meal.add(starterMain.getmainDish());
		double price = 0;
		
		for(Item i : meal)
			price+=i.getPrice();
		starterMain.price = price;
	}

	
	/**
	 * Retourne l'entrée du StarterMain.
	 * @return L'entrée du StarterMain.
	 * 
	 * @see StarterMain#starter
	 */
	public Starter getStarter() {
		return starter;
	}
	
	/**
	 * Mise à jour de l'entrée du StarterMain.
	 * @param starter
	 * La nouvelle entrée.
	 * 
	 * @see StarterMain#starter
	 */
	public void setStarter(Starter starter) {
		this.starter = starter;
	}
	
	/**
	 * @return Le prix du StarterMain
	 * 
	 * @see StarterMain#price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Mise à jour du prix et du type du StarterMain.
	 * 
	 * @see Item
	 * @see Observer
	 * @see Meal#price
	 * @see Meal#type
	 */
	@Override
	public void update(){
		computePrice(this);
		accessType(this);
		System.out.println("The price of the StarterMain menu is now" + this.getPrice() + " type : " + this.getType());
		System.out.println(isGlutenFree()?"It's gluten-free":"It's not suitable for vegans.");}



	@Override
	public String toString() {
		return "StarterMain [starter=" + starter + ", mainDish=" + mainDish + ", price=" + price + ", type=" + type
			 + "]";
	}
	
	
	

}
