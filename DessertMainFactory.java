package myFoodoraMenu;

/**
 * @author anastasiabouzdine
 * 
 * La classe <b>DessertMainFactory</b> hérite de la classe abstraite MealFactory.
 * Elle permet de créer des objets HalfMeal avec un plat principal et un dessert.
 * Caractérisée par:
 * <ul>
 * <li>Un nom.</li>
 * <li>Un plat principal et un dessert du meal HalfMeal.</li>
 * </ul>
 *
 * @see MealFactory
 * @see Meal
 */

public class DessertMainFactory extends MealFactory {
	/**
	 * Constructeur par défaut DessertMainFactory.
	 */
	private DessertMainFactory(){}
	
	/**
	 * Redéfinition de la méthode héritée de MealFactory.
	 * <p>
	 * Renvoie null car ne concerne par les FullMeal.
	 * </p>

	 * @return null
	 * 
	 * @see Meal
	 */
	@Override
	public Meal createMeal(String name, Starter starter, mainDish mainDish, Dessert dessert) {
		return null;}
	
	/**
	 * Redéfinition de la méthode héritée de MealFactory.
	 * <p>
	 * Crée un meal DessertMain
	 * </p>
	 * @param mainDish
	 * Le plat principal du Meal.
	 * @param dessert
	 * Le dessert du Meal.

	 * @return null
	 * 
	 * @see Meal
	 */		

		
	@Override
	public Meal createMeal(String name, Item mainDish, Item dessert) {
		return new MainDessert(name, (mainDish)mainDish, (Dessert)dessert);
	}



}
