package myFoodoraUsers;


/**
 * @author anastasiabouzdine
 * La classe abstraite <b> CourierFactory </b> représente la factory d'un coursier et permet la création d'un coursier.
 * Elle hérite bien sûr de la classe abstraite UserFactory.
 * @see UserFactory
 */

public class CourierFactory extends UserFactory{
	/**
	 * Overriding de la méthode abstraite createUser héritée de UserFactory.
	 * On choisit la première implémentation pour la création d'un coursier, plus pratique, tandis que la deuxième implémentation renvoie null.
	 */
	
	@Override
	public Courier createUser(String firstname, String lastname, String phoneNumber, String username, String password, Position position,
			boolean activated) {
		Courier courier = new Courier(firstname, lastname, phoneNumber, username, password, position, activated);		
		return courier;
	}

	@Override
	public Courier createUser(String name, String username, String password, Position position, boolean activated) {
		return null;
	}


}

