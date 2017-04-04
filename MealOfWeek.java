package myFoodoraMenu;

import java.util.ArrayList;


/**
 * @author anastasiabouzdine
 * 
 * <b>MealOfWeek</b>  est une classe représentant le menu spécial de la semaine.
 * Caractérisé par:
 * <li> Un nom. </li>
 * <li> Une liste des items le composant. </li>
 * @see Item
 */

public class MealOfWeek {
	
	/**
	 * Nom du menu spécial de la semaine.
	 * 
	 * @see MealOfWeek#getSpecialMealName()
	 * @see MealOfWeek#setSpecialMealName(String)
	 */
	private String SpecialMealName;
	
	/**
	 * Liste des items composant le menu spécial de la semaine.
	 * 
	 * @see MealOfWeek#getWeekItems()
	 * @see MealOfWeek#setWeekItems(ArrayList)
	 */
	private ArrayList<Item> itemsofweek = new ArrayList<Item>();
	
	
	/**
	 * Constructeur MealOfWeek avec son nom et la liste des items le composant.
	 * @param name
	 * Le nom du menu spécial.
	 * @param itemsofweek
	 * Liste des items le composant.
	 * 
	 * @see MealOfWeek#SpecialMealName
	 * @see MealOfWeek#itemsofweek
	 */
	
	public MealOfWeek(String name, ArrayList<Item> items){
		this.SpecialMealName = name;
		this.itemsofweek = items;
	}
	
	/**
	 * Donne le nom du menu spécial de la semaine.
	 * @return le nom du menu spécial
	 * 
	 * @see MealOfWeek#SpecialMealName
	 */
	public String getSpecialMealName() {
		return SpecialMealName;
	}
	
	/**
	 * Mise à jour du nom du menu spécial de la semaine.
	 * @param name
	 * Le nouveau nom.
	 * 
	 * @see MealOfWeek#SpecialMealName
	 */
	public void setSpecialMealName(String name) {
		this.SpecialMealName = name;
	}
	
	/**
	 * Donne la liste des items composant le menu spécial de la semaine.
	 * @return La liste des items.
	 * 
	 * @see MealOfWeek#itemsofweek
	 */
	public ArrayList<Item> getWeekItems() {
		return itemsofweek;
	}
	
	/**
	 * Mise à jour des items composant le menu spécial de la semaine.
	 * @param items
	 * Les nouveaux items.
	 * 
	 * @see MealOfWeek#itemsofweek
	 */
	public void setWeekItems(ArrayList<Item> items) {
		this.itemsofweek = items;
	}
	
	/**
	 * Ajoute un item à la liste des items du menu spécial de la semaine.
	 * @param item
	 * L'item à ajouter.
	 * 
	 * @see MealOfWeek#itemsofweek
	 */
	public void addWeekItem(Item item){
		this.itemsofweek.add(item);
	}

	/**
	 * Enlève un item de la liste du menu spécial de la semaine.
	 * @param item
	 * L'item à supprimer.
	 * 
	 * @see MealOfWeek#itemsofweek
	 */
	public void removeWeekItem(Item item){
		this.itemsofweek.remove(item);
	}
	

	@Override
	public String toString() {
		return "MealOfWeek [SpecialMealName=" + SpecialMealName + ", itemsofweek=" + itemsofweek + "]";
	}

}
