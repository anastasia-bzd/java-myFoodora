package myFoodoraUsers;

/**
 * @author anastasiabouzdine
 * La classe abstraite <b> CustomerFactory </b> représente la factory d'un client et permet la création d'un client.
 * Elle hérite bien sûr de la classe abstraite UserFactory.
 * @see UserFactory
 */

public class CustomerFactory extends UserFactory{
	/**
	 * Overriding de la méthode abstraite createUser héritée de UserFactory.
	 * On choisit la première implémentation pour la création d'un coursier, plus pratique, tandis que la deuxième implémentation renvoie null.
	 */
	
	@Override
	public Customer createUser(String firstname, String lastname, String phoneNumber, String username, String password, Position position,
			boolean activated) {
		Customer customer = new Customer(firstname, lastname, phoneNumber, username, password, position, activated);		
		return customer;
	}

	@Override
	public Customer createUser(String name, String username, String password, Position position, boolean activated) {
		return null;
	}


}
