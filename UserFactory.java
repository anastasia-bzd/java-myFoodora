package myFoodoraUsers;

/**
 * @author anastasiabouzdine
 * La classe abstraite <b> UserFactory </b> représente la factory d'un utilisateur et permet la création d'un utilisateur du système.
 * @see User
 */
public abstract class UserFactory {

	
	/**
	 * Méthode abstraite createUser.
	 *
	 * @param firstname
	 * Le prénom de l'utilisateur.
	 * @param lastname
	 * Le nom de l'utilisateur.
	 * @param username
	 * Le login de l'utilisateur.
	 * @param password
	 * Le mot de passe de l'utilisateur.
	 * @param activated
	 * L'état d'activation.
	 * @param position
	 * La position géographique.
	 * @return L'utilisateur créé.
	 * 
	 */
	abstract public User createUser(String firstname, String lastname, String phoneNumber, String username, String password, Position position, boolean activated);
	
	/**
	 * Méthode abstraite createUser.
	 * @param name
	 * Le nom du restaurant.
	 * @param username
	 * Le login du restaurant.
	 * @param password
	 * Le mot de passe du restaurant.
	 * @param activated
	 * L'état d'activation du restaurant.
	 * @param position
	 * L'adresse du restaurant.
	 * @return Le restaurant créé.
	 */
	abstract public User createUser(String name, String username, String password, Position position, boolean activated);
}


