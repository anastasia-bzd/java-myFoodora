package myFoodoraUsers;


/**
 * @author anastasiabouzdine
 * <b>ObserverC</b> est l'interface des observateurs/clients qui sont notifiés par l'offre spéciale du menu de la semaine proposée par un Restaurant.
 *
 *@see MealOfWeek
 */
public interface ObserverC{

	/**
	 * Notification des clients du menu de la semaine.
	 * @param r
	 * Le restaurant qui lance un nouveau menu spécial de la semaine.
	 */
	public void notifyCustomer(Restaurant r);
}

