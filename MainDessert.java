/**
 * 
 */
package myFoodoraMenu;

import java.util.ArrayList;

/**
 * @author anastasiabouzdine
 * 
 * MainDessert est une classe héritée de HalfMeal.
 * Elle représente un meal partiel comprenant uniquement le plat principal et le dessert.
 * Possède:
 * <ul>
 * <li>Un nom.</li>
 * <li>Un prix.</li>
 * <li>Un type.</li>
 * <li>Un booléen sur la contenance en gluten.</li>
 * <li>Une remise sur le prix.</li>
 * <li>Un plat.</li>
 * <li>Un dessert.</li>
 *
 *
 **
 * @see HalfMeal
 * @see MainDish
 * @see Dessert
 * @see Observable
 * @see Observer
 */
public class MainDessert extends HalfMeal implements Observer{
	
	/**
	 * Le dessert du menu.
	 * 
	 * @see MainDessert#getDessert()
	 * @see MainDessert#setDessert(Dessert)
	 */
	private Dessert dessert;
	
	/**
	 * Constructeur par défaut MainDessert.
	 */
	public MainDessert(){
	}
	
	/**
	 * Constructeur MainDessert avec le nom, le plat principal et le dessert du MainDessert.
	 * @param name
	 * Le nom du MainDessert.
	 * @param mainDish
	 * Le plat du MainDessert.
	 * @param dessert
	 * Le dessert du MainDessert.
	 * 
	 * @see MainDessert#computePrice(MainDessert)
	 * @see MainDessert#accessType(MainDessert)
	 */
	public MainDessert (String name, mainDish mainDish, Dessert dessert){
		super(name, mainDish);
		this.dessert=dessert;
	}
	
	/**
	 * Permet de caractériser le type du MainDessert grâce à ses items.
	 * @param MainDessert
	 * Le MainDessert dont le type est recherché.
	 * 
	 *@see Item
	 *@see Meal#type
	 */
	private static void accessType(MainDessert MainDessert){
		ArrayList<Item> meals = new ArrayList<Item>();
		meals.add(MainDessert.getmainDish());
		meals.add(MainDessert.dessert);
		
		int vegCounter = 0;
		int glutenFreeCounter = 0;
		
		for(Item i : meals){
			if(i.getType().equals("Standard")){
				MainDessert.type = "Standard";}
			if(i.getType().equals("Vegetarian")){
				vegCounter+=1;}
			if(i.isGlutenFree()){
				glutenFreeCounter+=1;}
		}

		if(vegCounter==2)
			MainDessert.type = "Vegetarian";
		if(glutenFreeCounter==2)
			MainDessert.glutenFree= true;
	}
	
	
	/**
	 * Calcule le prix du MainDessert.
	 * 
	 * @param MainDessert
	 * Le MainDessert dont on calcule le prix total.
	 * 
	 * @see Meal#price
	 */
	private static void computePrice(MainDessert MainDessert){
		ArrayList<Item> meal = new ArrayList<Item>();
		meal.add(MainDessert.getmainDish());
		meal.add(MainDessert.getDessert());
		double price = 0;
		
		for(Item i : meal)
			price+=i.getPrice();
		MainDessert.price = price;
	}

	
	/**
	 * Retourne le dessert du MainDessert.
	 * @return Le dessert du MainDessert.
	 * 
	 * @see MainDessert#dessert
	 */
	public Dessert getDessert() {
		return dessert;
	}
	
	/**
	 * Mise à jour du dessert du StarterMain.
	 * @param dessert
	 * Le nouveau dessert.
	 * 
	 * @see MainDessert#dessert
	 */
	public void setDessert(Dessert dessert) {
		this.dessert = dessert;
	}
	
	/**
	 * @return Le prix du MainDessert
	 * 
	 * @see MainDessert#price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Mise à jour du prix et du type du MainDessert.
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
		System.out.println(isGlutenFree()?"It's gluten-free":"It's not suitable for vegans.");
	}

	

	@Override
	public String toString() {
		return "MainDessert [mainDish=" + mainDish + "and dessert=" + dessert + ", price=" + price + ", type=" + type +"]";
	}
	
	
	

}

