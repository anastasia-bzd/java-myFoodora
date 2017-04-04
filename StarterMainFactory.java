package myFoodoraMenu;

/**
 * @author anastasiabouzdine
 * 
 * La classe <b>StarterMainFactory</b> hérite de la classe abstraite MealFactory.
 * Elle permet de créer des objets HalfMeal avec une entrée et un plat principal.
 * Caractérisée par:
 * <ul>
 * <li>Un nom.</li>
 * <li>Une entrée et un plat principal du mal HalfMeal.</li>
 * </ul>
 *
 * @see MealFactory
 * @see Meal
 */

public class StarterMainFactory extends MealFactory {
	/**
	 * Constructeur par défaut StarterMainFactory.
	 */
	private StarterMainFactory(){}
	
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
	 * Crée un meal StarterMain
	 * </p>
	 * @param starter
	 * L'entrée du meal.
	 * @param mainDish
	 * Le plat principal du meal.
	 * @see Meal
	 */		
	@Override
	public Meal createMeal(String name, Item starter, Item mainDish) {
		return new StarterMain(name, (Starter)starter, (mainDish)mainDish);
	}



}
