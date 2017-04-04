/**
 * 
 */
package myFoodoraMenu;

import java.util.ArrayList;

/**
 * @author anastasiabouzdine
 * 
 * <b> Item</b>  est une classe abstraite représentant un item disponible à la carte ou dans les menus.
 * Elle implémente l'interface Observable pour pouvoir notifier le <b> Menu </b> de tout changement au niveau des items.
 * Possède:
 * <li>Un nom.</li>
 * <li>Un prix.</li>
 * <li>Un booléan sur la contenance en gluten ou pas de l'Item</li>
 * <li>Un type (Standard, Vegetarien ou sans gluten).</li>
 * 
 */
public abstract class Item implements Observable{
	/**
	 * Nom de l'item.
	 * 
	 * @see Item#getName()
	 * @see Item#setName(String)
	 */
	private String name;
	
	/**
	 * Prix de l'item.
	 * 
	 * @see Item#getPrice()
	 * @see Item#setPrice(double)
	 */
	private double price;
	
	/**
	 * Type de l'item.
	 * @see Item#getType()
	 * @see Item#setType(String type)
	 */
	private String type;
	
	/**
	 * Nombre de commandes de l'item.
	 */
	public int numberOrders;
	
	/**
	 * Contenance en gluten de l'Item initialisée à false.
	 * @see Item#isGlutenFree()
	 * @see Item#setGlutenFree(boolean)
	 */
	private boolean glutenFree= false;
	
	/**
	 * Liste d'observateurs de l'item.
	 * <p>
	 * Ils sont notifiés de tout changement de l'item (nom, prix, type).
	 * </p>
	 * 
	 * @see Item#notifyObservers()
	 */
	private ArrayList<Observer> observers = new ArrayList<Observer>();

	/**
	 * Booléen activé en cas de changement de l'item (nom, prix, type)
	 * 
	 * @see Item#setType(String type)
	 * @see Item#setPrice(double)
	 * @see Item#notifyObservers()
	 */
	private boolean changed = false;

	/**
	 * Constructeur Item par défaut.
	 */
	public Item(){
	}

	/**
	 * Constructeur Item avec nom et prix de l'item.
	 * @param name
	 * Le nom de l'item.
	 * @param price
	 * Le prix de l'item.
	 * 
	 * @see Item#name
	 * @see Item#price
	 */
	public Item(String name, double price){
		this.name = name;
		this.price = price;
	}

	/**
	 * Constructeur Item avec nom, prix, contenance en gluten et type de l'item.
	 * @param name
	 * Le nom de l'item.
	 * @param price
	 * Le prix de l'item.
	 * @param type
	 * Le type de l'item.
	 * @param glutenFree
	 * La contenance en gluten de l'item.
	 * 
	 * @see Item#name
	 * @see Item#price
	 * @see Item#type
	 */
	public Item(String name, double price, String type, boolean glutenFree){
		this.name = name;
		this.price = price;
		this.type = type;
		this.glutenFree = glutenFree;
	}

	/**
	 * Retourne le nom de l'item.
	 * @return le nom de l'item.
	 * 
	 * @see Item#name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Mise à jour du nom de l'item.
	 * @param name
	 * Le nouveau nom de l'item (chaîne de caractères)
	 * 
	 * @see Item#name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	/**
	 * Contenance en gluten de l'item ou non.
	 * @return 
	 * Le booléen {@link Item#glutenFree}
	 * 
	 * @see Item#glutenFree
	 */
	public boolean isGlutenFree() {
		return glutenFree;
	}
	
	/**
	 * Mise à jour de la contenance en gluten de l'item.
	 * <p>
	 * Change le booléen {@link Item#changed} en true et notifie les observateurs {@link Item#notifyObservers()}. 
	 * </p>
	 * 
	 * @param glutenFree
	 * La nouvelle contenance en gluten.
	 * 
	 * @see Item#glutenFree
	 */
	public void setGlutenFree(boolean glutenFree) {
		this.glutenFree = glutenFree;
		this.changed = true;
		this.notifyObservers();
	}
	
	/**
	 * Retourne le prix de l'item.
	 * @return le prix de l'item (double)
	 * 
	 * @see Item#price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Mise à jour du prix de l'item.
	 * <p>
	 * Change le booléen {@link Item#changed} en true et notifie les observateurs {@link Item#notifyObservers()}. 
	 * </p>
	 * @param price
	 * Le nouveau prix de l'item.
	 * 
	 * @see Item#price
	 */
	public void setPrice(double price) {
		this.price = price;
		this.changed = true;
		this.notifyObservers();
	}

	/**
	 * Retourne le type d'item.
	 * @return Le type d'item (chaîne de caractères)
	 */
	public String getType() {
		return type;
	}

	/**
	 * Mise à jour du type de l'item.
	 * <p>
	 * Change le booléen {@link Item#changed} en true et notifie les observateurs {@link Item#notifyObservers()}. 
	 * </p>
	 * @param type
	 * Le nouveau type de l'item.
	 */
	public void setType(String type) {
		this.type = type;
		this.changed = true;
		this.notifyObservers();
	}

	/**
	 * Ajoute un observeur à l'item.
	 * 
	 * @see Observer
	 * @see Observable
	 */
	public void add(Observer o){
		observers.add(o);
	}

	/**
	 * Ôte un observeur de cet item.
	 * 
	 * @see Observer
	 * @see Observable
	 */
	public void delete(Observer o){
		observers.remove(o);
	}

	/**
	 * Notifie les observers de tout changement de l'item.
	 * 
	 * @see Item#price
	 * @see Item#type
	 * @see Item#glutenFree
	 * @see Observer
	 * @see Observable
	 */
	public void notifyObservers(){
		if (this.changed) {
			for (Observer ob : observers)
				ob.update();
			this.changed = false;
		}
	}
	
	
}


