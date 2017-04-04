package myFoodoraMenu;

/**
 * @author anastasiabouzdine
 * 
 * Dessert est une classe héritée de <b>Item</b> décrivant les desserts proposés
 * Possède:
 * <li>Un nom.</li>
 * <li>Un prix.</li>
 * <li>Un type (Standard, Vegetarien ou sans gluten).</li>
 *  @see Item
 */
public class Dessert extends Item{
	
	/**
	 * Constructeur par défaut Dessert.
	 */
	public Dessert(){
	}
	
	/**
	 * Constructeur Dessert avec nom et prix du dessert.
	 * @param name
	 * Le nom du dessert.
	 * @param price
	 * Le prix du dessert.
	 * 
	 * @see Item#name
	 * @see Item#price
	 */
	public Dessert(String name, double price){
		super(name, price);
	}
	
	/**
	 * Constructeur Dessert avec nom, prix et type du dessert.
	 * @param name
	 * Le nom du dessert.
	 * @param price
	 * Le prix du dessert.
	 * @param type
	 * Le type du dessert.
	 * 
	 * @see Item#name
	 * @see Item#price
	 * @see Item#type
	 */	
	public Dessert(String name, double price, String type, boolean glutenFree) {
		super(name, price, type, glutenFree);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Dessert [getName()=" + getName() + "]";
	}
	

}
