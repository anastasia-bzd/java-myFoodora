package myFoodoraUsers;

/**
 * @author anastasiabouzdine
 * La classe abstraite <b> RestaurantFactory </b> représente la factory d'un restaurant et permet la création d'un restaurant.
 * Elle hérite bien sûr de la classe abstraite UserFactory.
 * @see UserFactory
 */

public class RestaurantFactory extends UserFactory{
	/**
	 * Overriding de la méthode abstraite createUser héritée de UserFactory.
	 * On choisit la deuxième implémentation pour la création d'un restaurant, plus pratique, tandis que la première implémentation renvoie null.
	 */
	
	@Override
	public Restaurant createUser(String firstname, String lastname, String phoneNumber, String username, String password, Position position,
			boolean activated) {
		return null;
	}

	@Override
	public Restaurant createUser(String name, String username, String password, Position position, boolean activated) {
		Restaurant restaurant = new Restaurant(name, username, password, position, activated);		
		return restaurant;
	}

	
}
