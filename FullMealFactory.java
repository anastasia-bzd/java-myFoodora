package myFoodoraMenu;

/**
 * @author anastasiabouzdine
 * 
 * La classe <b>FullMealFactory</b> hérite de la classe abstraite MealFactory.
 * Elle permet de créer des objets FullMeal.
 * Caractérisée par:
 * <ul>
 * <li>Un nom.</li>
 * <li>Une entrée, un plat et un dessert du meal FullMeal.</li>
 * </ul>
 *
 * @see MealFactory
 * @see Meal
 */
public class FullMealFactory extends MealFactory {
	/**
	 * Constructeur par défaut FullMealFactory.
	 */
	private FullMealFactory(){}
	

	/**
	 * Méthode de création d'un meal FullMeal.
	 * @param starter
	 * L'entrée du meal.
	 * @param mainDish
	 * Le plat principal du meal.
	 * @param dessert
	 * Le dessert du meal.
	 * @see Meal
	 * @see FullMeal
	 */
	@Override
	public Meal createMeal(String name, Starter starter, mainDish mainDish, Dessert dessert) {
		return new FullMeal(name, starter, mainDish, dessert);
	}

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
	public Meal createMeal(String name, Item item1, Item item2) {
		return null;
	}
}
