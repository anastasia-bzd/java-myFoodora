/**
 * 
 */
package myFoodoraMenu;



/**
 * @author anastasiabouzdine
 * 
 * <b>Meal</b> est une classe abstraite représentant le choix des meals possible du restaurant.
 * Possède:
 * <li>Un nom.</li>
 * <li>Un prix.</li>
 * <li>Un type (Standard, Vegetarien ou Vegan).</li>
 * <li>Un booléan sur la contenance en gluten ou pas du Meal. </li>
 * @see Item
 */
public abstract class Meal{
	
	/**
	 * Nom du meal.
	 * 
	 * @see Meal#getName()
	 * @see Meal#setName(String)
	 */
	private String name;
	
	/**
	 * Prix du meal.
	 * 
	 * @see Meal#getPrice() 
	 */
	protected double price;
	
	/**
	 * Type du meal.
	 * 
	 * @see Meal#getType()	 
	 * @see Meal#setType(String)
	 */
	protected String type;

	/**
	 * Contenance en gluten du Meal initialisée à false.
	 * @see Meal#isGlutenFree()
	 * @see Meal#setGlutenFree(boolean)
	 */
	protected boolean glutenFree=false;
	
	
	/**
	 * Constructeur Meal par défaut.
	 */
	public Meal(){
	}
	/**
	 * Constructeur Meal avec nom du meal.
	 * @param name
	 * Le nom du meal.
	 * 
	 * @see Meal#name
	 */
	public Meal(String name){
		this.name = name;}
	
	/**
	 * Constructeur Meal avec nom, prix, contenance en gluten et type du meal.
	 * @param name
	 * Le nom du meal.
	 * @param price
	 * Le prix du meal.
	 * @param glutenFree
	 * La contenance en gluten du meal.
	 * @param type
	 * Le type du meal.
	 * 
	 * @see Meal#name
	 * @see Meal#price
	 * @see Meal#glutenFree
	 * @see Meal#type
	 */
	public Meal(String name, double price, String type, boolean glutenFree){
		this.name = name;
		this.price = price;
		this.type = type;
		this.glutenFree=glutenFree;
	}

	/**
	 * @return le nom du menu.
	 * @see Meal#name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name 
	 * Le nouveau nom du meal.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return le prix du meal.
	 * @see Meal#price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price 
	 * Le nouveau prix du meal.
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return le type (standard, vegetarien ou vegan) du Meal.
	 * @see Meal#type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type 
	 * Le nouveau type du Meal.
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * @return boolean
	 * Le booléen sur la contenance en gluten du Meal ou non.
	 * 
	 * @see Meal#glutenFree
	 */
	public boolean isGlutenFree() {
		return glutenFree;
	}
	

	
	
}
