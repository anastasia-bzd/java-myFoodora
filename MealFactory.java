package myFoodoraMenu;
/**
 * @author anastasiabouzdine
 * 
 * La classe abstraite <b>MealFactory</b> permet de créer des objets Meal.
 * Caractérisée par:
 * <ul>
 * <li>Un nom.</li>
 * <li>Un à deux items du meal pour le HalfMeal</li>
 * <li>Une entrée, un plat principal, un dessert pour le FullMeal.</li>
 * </ul>
 * @see Meal
 */

public abstract class MealFactory {
	
	/**
	 * Méthode abstraite createMeal à redéfinir pour les classes FullMeal
	 * </p>
	 * @param name
	 * Nom du meal.
	 * @param starter
	 * Nom de l'entrée.
	 * @param mainDish
	 * Nom du plat principal.
	 * @param dessert
	 * Nom du dessert.
	 * @return Le meal créé.
	 * 
	 * @see Meal
	 */
	abstract public Meal createMeal(String name, Starter starter, mainDish mainDish, Dessert dessert);
	
	/**
	 * Méthode abstraite createMenu à redéfinir pour les classes HalfMeal.
	 * @param name
	 * Nom du meal.
	 * @param item1
	 * Item 1 du meal partiel
	 * @param item2
	 * Item 2 du meal partiel
	 * @return Le meal créé.
	 * 
	 * @see Meal
	 */
	abstract public Meal createMeal(String name, Item item1, Item item2);

}
