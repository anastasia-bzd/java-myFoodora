package myFoodoraMenu;

/**
 * Interface des observables Item.
 * @author anastasiabouzdine
 *
 *@see Item
 */

public interface Observable {
	
	/**
	 * Ajoute un observateur supplémentaire de l'observable Item.
	 * @param o
	 * Observateur supplémentaire à ajouter à la liste.
	 */
	public void add(Observer o);
	
	/**
	 * Ôte un observateur de l'observable Item.
	 * @param o
	 * Observateur à détacher de la liste.
	 */
	public void delete(Observer o);
	
	/**
	 * Notifie les observateurs de toute modification de l'observable Item.
	 */
	public void notifyObservers();

}
