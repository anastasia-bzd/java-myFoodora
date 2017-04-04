/**
 * 
 */
package myFoodoraMenu;

import java.util.ArrayList;

/**
 * 
 * @author anastasiabouzdine
 * 
 * <b>FullMeal</b> représente un meal complet (entrée/plat/dessert), et hérite de la classe abstraite <b>Menu</b>.
 * Elle implémente l'interface Observer pour être notifiée des modifications des <b>Item</b> qui la composent.
 * Possède:
 * <ul>
 * <li>Un nom.</li>
 * <li>Un prix.</li>
 * <li>Un type.</li>
 * <li>Une contenance en gluten.</li>
 * <li>Une remise sur le prix. </li>
 * <li>Une entrée.</li>
 * <li>Un plat.</li>
 * <li>Un dessert.</li>
 * </ul>
 *
 * @see MainDish
 * @see Starter
 * @see Dessert
 * @see Observable
 * @see Observer
 */
public class FullMeal extends Meal implements Observer{
	
	/**
	 * L'entrée du meal.
	 * 
	 * @see FullMeal#getStarter()
	 * @see FullMeal#setStarter(Starter)
	 */
	private Starter starter;

	/**
	 * Le plat principal du meal.
	 * 
	 * @see FullMeal#getmainDish()
	 * @see FullMeal#setmainDish(mainDish)
	 */
	private mainDish mainDish;

	/**
	 * Le dessert du meal.
	 * 
	 * @see FullMeal#getDessert()
	 * @see FullMeal#setDessert(Dessert)
	 */
	private Dessert dessert;

	/**
	 * Constructeur par défaut FullMeal.
	 */
	public FullMeal(){
		super();
	}

	/**
	 * Constructeur FullMeal avec nom, l'entrée, le plat principal, le dessert du FullMeal.
	 * @param name
	 * Le nom du FullMeal.
	 * @param starter
	 * L'entrée du FullMeal.
	 * @param mainDish
	 * Le plat du FullMeal.
	 * @param dessert
	 * Le dessert du FullMeal.
	 */
	public FullMeal(String name, Starter starter, mainDish mainDish, Dessert dessert){
		super(name);
		this.starter=starter;
		this.mainDish=mainDish;
		this.dessert=dessert;
	}

	/**
	 * Permet de caractériser le type du FullMeal grâce à ses items.
	 * @param fullMeal
	 * Le FullMeal dont on cherche le type.
	 * 
	 *@see Item#type
	 *@see Meal#type
	 */
	private static void accessType(FullMeal fullMeal){
		ArrayList<Item> meals = new ArrayList<Item>();
		meals.add(fullMeal.starter);
		meals.add(fullMeal.mainDish);
		meals.add(fullMeal.dessert);
		
		int vegCounter=0;
		int glutenFreeCounter=0;
		for(Item i : meals){
			if(i.getType().equals("Standard")){
				fullMeal.type = "Standard";}
			if(i.getType().equals("Vegetarian")){
				vegCounter+=1;}
			if(i.isGlutenFree()){
				glutenFreeCounter+=1;}
		}

		if(vegCounter==3){
			fullMeal.type = "Vegetarian";}
		if(glutenFreeCounter==3){
			fullMeal.glutenFree= true;}
	}

	/**
	 * Calcule le prix du FullMeal.
	 * 
	 * @param fullMeal
	 * Le FullMeal dont on calcule le prix total.
	 * 
	 * @see Meal#price
	 */
	private static void computePrice(FullMeal fullMeal){
		ArrayList<Item> meals = new ArrayList<Item>();
		meals.add(fullMeal.starter);
		meals.add(fullMeal.mainDish);
		meals.add(fullMeal.dessert);
		double price = 0;

		for(Item i : meals)
			price+=i.getPrice();

		fullMeal.price = price;
	}


	/**
	 * Retourne l'entrée du FullMeal.
	 * @return L'entrée du FullMeal.
	 * 
	 * @see FullMeal#starter
	 */
	public Starter getStarter() {
		return starter;
	}

	/**
	 * Mise à jour de l'entrée du FullMeal.
	 * @param starter la nouvelle entrée.
	 * 
	 * @see FullMeal#starter
	 */
	public void setStarter(Starter starter) {
		this.starter = starter;
	}

	/**
	 * Retourne le plat principal du FullMeal.
	 * @return Le plat principal du FullMeal.
	 * 
	 * @see FullMeal#mainDish
	 */
	public mainDish getmainDish() {
		return mainDish;
	}

	/**
	 * Mise à jour du plat principal du FullMeal.
	 * @param mainDish
	 * Le nouveau plat principal.
	 * 
	 * @see FullMeal#mainDish
	 */
	public void setmainDish(mainDish mainDish) {
		this.mainDish = mainDish;
	}

	/**
	 * Retourne le dessert du FullMeal.
	 * @return Le dessert du FullMeal.
	 * 
	 * @see FullMeal#dessert
	 */
	public Dessert getDessert() {
		return dessert;
	}

	/**
	 * Mise à jour du dessert du FullMeal.
	 * @param dessert
	 * Le nouveau dessert.
	 * 
	 * @see FullMeal#dessert
	 */
	public void setDessert(Dessert dessert) {
		this.dessert = dessert;
	}
	
	/**
	 * @return Le prix du Full Meal
	 * 
	 * @see FullMeal#price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Mise à jour du prix et du type du FullMeal.
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
		System.out.println("The price of the Menu is now : " + this.getPrice() + " and its type : " + this.getType()) ;
		System.out.println(isGlutenFree()?"It's gluten-free":"It's not suitable for vegans.");
	}



	@Override
	public String toString() {
		return "FullMeal [starter=" + starter + ", mainDish=" + mainDish + ", dessert=" + dessert + ", price=" + this.price  + ", type=" + this.type + "]";
	}
}

