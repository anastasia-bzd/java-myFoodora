
package myFoodoraMenu;


/**
 * @author anastasiabouzdine
 * 
 * Starter est une classe héritée de <b>Item</b> décrivant les entrées proposées.
 * Possède:
 * <li>Un nom.</li>
 * <li>Un prix.</li>
 * <li>Un type (Standard, Vegetarien ou sans gluten).</li>
 *  @see Item
 */
public class Starter extends Item{
	/**
	 * Constructeur par défaut Starter.
	 */
	public Starter(){
	}
	
	/**
	 * Constructeur Starter avec nom et prix de l'entrée.
	 * @param name
	 * Le nom de l'entrée.
	 * @param price
	 * Le prix de l'entrée.
	 * 
	 * @see Item#name
	 * @see Item#price
	 */
	public Starter(String name, double price){
		super(name, price);
	}
	
	/**
	 * Constructeur Starter avec nom, prix et type de l'entrée.
	 * @param name
	 * Le nom de l'entrée.
	 * @param price
	 * Le prix de l'entrée.
	 * @param type
	 * Le type de l'entrée.
	 * 
	 * @see Item#name
	 * @see Item#price
	 * @see Item#type
	 */	
	public Starter(String name, double price, String type, boolean glutenFree) {
		super(name, price, type, glutenFree);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Starter [getName()=" + getName() + "]";
	}
	

}

