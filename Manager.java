package myFoodoraUsers;

import myFoodoraSystem.MyFoodora;

/**
 * @author anastasiabouzdine
 * La classe <b>Manager</b> représente le manager du système, et héritoe donc de la classe User.
 * Caractérisée par:
 * <ul>
 * <li>Un login, un mot de passe et un identifiant.</li>
 * <li>Un nom et un prénom.</li>
 * </ul>
 * @see MyFoodora
 * @see User
 */

public class Manager extends User {
	
	/**
	 * Le prénom du manager.
	 * @see Manager#getFirstname()
	 * @see Manager#setFirstname(String)
	 */
	private String firstname;

	/**
	 * Le nom de famille du manager.
	 * @see Manager#getSurname()
	 * @see Manager#setSurname(String)
	 */
	private String surname;

	/**Constructeur Manager par défaut.
	 */
	public Manager(){
		super();
	}

	/**Constructeur Manager.
	 * Le nom du manager.
	 * @param firstname
	 * Le prénom du manager.
	 * @param lastname
	 * Le nom du Manager.
	 * @param username
	 * Le login du manager.
	 * @param password
	 * Le mot de passe du manager.
	 * 
	 * @see MyFoodora
	 * @see Manager#firstname
	 * @see Manager#surname
	 * @see User#username
	 * @see User#password
	 */
	public Manager(String firstname, String surname, String username, String password){
		super(username, password);
		this.firstname = firstname;
		this.surname = surname;
	}

	/**
	 * @return le prénom du manager.
	 * 
	 * @see Manager#firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Mise à jour du prénom du manager.
	 * @param firstname
	 * Le nouveau prénom du manager.
	 * 
	 * @see Manager#firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return le nom de famille du manager
	 * 
	 * @see Manager#surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Mise à jour du nom de famille du manager.
	 * @param surname 
	 * Le nouveau nom de famille du manager.
	 * 
	 * @see Manager#surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	/**
	 * Ajouter un utilisateur au système.
	 * 
	 * @param user
	 * L'utilisateur à ajouter.
	 * 
	 * @see User
	 * @see myFoodoraUsers#Customer
	 * @see myFoodoraUsers#Courier
	 * @see myFoodoraUsers#Restaurant
	 */
	public void addUser(User user){

		if(user instanceof Restaurant){
			Restaurant r = new Restaurant();
			r = (Restaurant) user;
			MyFoodora.getInstance().addRestaurant(r);
		}

		else if(user instanceof Courier){
			Courier courier = new Courier();
			courier = (Courier) user;
			MyFoodora.getInstance().addCourier(courier);
		}

		else if(user instanceof Customer){
			Customer customer = new Customer();
			customer = (Customer) user;
			MyFoodora.getInstance().addCustomer(customer);
		}
	}


	/**
	 * Enlever un utilisateur du système.
	 *
	 * @param user
	 * L'utilisateur à retirer.
	 *
	 * @see User
	 * @see myFoodoraUsers#Customer
	 * @see myFoodoraUsers#Courier
	 * @see myFoodoraUsers#Restaurant
	 */
	public void removeUser(User user){

		if(user instanceof Restaurant){
			Restaurant r = new Restaurant();
			r = (Restaurant) user;
			MyFoodora.getInstance().removeRestaurant(r);
		}

		else if(user instanceof Courier){
			Courier courier = new Courier();
			courier = (Courier) user;
			MyFoodora.getInstance().removeCourier(courier);
		}

		else if(user instanceof Customer){
			Customer customer = new Customer();
			customer = (Customer) user;
			MyFoodora.getInstance().removeCustomer(customer);
		}
	}

	/**
	 * Activer l'utilisateur dans le système.
	 * 
	 * @param user
	 * L'utilisateur à activer.
	 * 
	 * @see User
	 * @see User#activated
	 */
	public void activateUser(User user){
		user.setActivated(true);
	}

	/**
	 * Désactiver l'utilisateur du système.
	 * 
	 * @param user
	 * L'utilisateur à désactiver.
	 * 
	 * @see User
	 * @see User#activated
	 */
	public void desactivateUser(User user){
		user.setActivated(false);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Manager [name=" + firstname + ", surname=" + surname + "]";
	}
	
	
}
