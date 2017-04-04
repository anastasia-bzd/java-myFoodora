package myFoodoraMenu;

import java.util.ArrayList;

/**
 * @author anastasiabouzdine
 * 
 * <b>RestaurantMenu</b>  est une classe représentant la carte du restaurant avec les menus et items disponibles.
 * Caractérisé par:
 * <li>Une liste des items disponibles à la carte. </li>
 * <li>Une liste des meals disponibles.</li>
 * @see Item
 * @see Meal
 */

public class RestaurantMenu {
	
	/**
	 * Liste des meals disponibles, à obtenir avec un getter en dehors de la classe RestaurantMenu.
	 * 
	 * @see RestaurantMenu#getMeals()
	 * @see RestaurantMenu#setMeals(ArrayList)
	 */
	private ArrayList<Meal> meals = new ArrayList<Meal>();
	
	/**
	 * Liste des items disponibles, à obtenir avec un getter en dehors de la classe RestaurantMenu.
	 * 
	 * @see RestaurantMenu#getItems()
	 * @see RestaurantMenu#setItems(ArrayList)
	 */
	private ArrayList<Item> items = new ArrayList<Item>();
	
	
	/**
	 * Donne la liste des meals.
	 * @return La liste des meals.
	 * 
	 * @see RestaurantMenu#meals
	 */
	public ArrayList<Meal> getMeals() {
		return meals;
	}

	/**
	 * Mise à jour des meals.
	 * @param meals
	 * Les nouveaux meals.
	 * 
	 * @see RestaurantMenu#meals
	 */
	public void setMeals(ArrayList<Meal> meals) {
		this.meals = meals;
	}

	/**
	 * Donne la liste des items.
	 * @return La liste des items.
	 * 
	 * @see RestaurantMenu#items
	 */
	public ArrayList<Item> getItems() {
		return items;
	}
	
	/**
	 * Mise à jour des items de la carte
	 * @param items
	 * Les nouveaux items.
	 * 
	 * @see RestaurantMenu#items
	 */
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	

	/**
	 * Ajoute un item à la liste des items de la carte.
	 * @param item
	 * L'item à ajouter.
	 * 
	 * @see RestaurantMenu#items
	 */
	public void addItem(Item item){
		this.items.add(item);
	}

	/**
	 * Enlève un item de la liste des items de la carte.
	 * @param item
	 * L'item à supprimer.
	 * 
	 * @see RestaurantMenu#items
	 */
	public void removeItem(Item item){
		this.items.remove(item);
	}

	/**
	 * Ajoute un meal à la liste des meals.
	 * @param meal
	 * Le meal à ajouter.
	 * 
	 * @see RestaurantMenu#meals
	 */
	public void addMeal(Meal meal){
		this.meals.add(meal);
	}

	/**
	 * Enlève un meal de la liste des meals.
	 * @param meal
	 * Le menu à supprimer.
	 * 
	 * @see RestaurantMenu#meals
	 */
	public void removeMeal(Meal meal){
		this.meals.remove(meal);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RestaurantMenu [meals=" + meals + ", items=" + items + "]";
	}
	
	

	
}
