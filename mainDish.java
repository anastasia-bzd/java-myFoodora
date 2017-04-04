/**
 * 
 */
package myFoodoraMenu;

/**
 * @author anastasiabouzdine
 * 
 * mainDish est une classe héritée de <b>Item</b> décrivant les plats principaux proposés.
 * Possède:
 * <li>Un nom.</li>
 * <li>Un prix.</li>
 * <li>Un type (Standard, Vegetarien ou sans gluten).</li>
 *  @see Item
 */
public class mainDish extends Item{
	/**
	 * Constructeur par défaut mainDish.
	 */
	public mainDish(){
	}
	
	/**
	 * Constructeur mainDish avec nom et prix du plat.
	 * @param name
	 * Le nom du plat.
	 * @param price
	 * Le prix du plat.
	 * 
	 * @see Item#name
	 * @see Item#price
	 */
	public mainDish(String name, double price){
		super(name, price);
	}
	
	/**
	 * Constructeur mainDish avec nom, prix et type du plat.
	 * @param name
	 * Le nom du plat.
	 * @param price
	 * Le prix du plat.
	 * @param type
	 * Le type du plat.
	 * 
	 * @see Item#name
	 * @see Item#price
	 * @see Item#type
	 */	
	public mainDish(String name, double price, String type, boolean glutenFree) {
		super(name, price, type, glutenFree);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "mainDish [getName()=" + getName() + "]";
	}

}
