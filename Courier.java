package myFoodoraUsers;

import java.util.LinkedList;

import myFoodoraSystem.*;


/**
 * @author anastasiabouzdine
 * La classe <b>Courier</b> représente le coursier qui va fournir le repas au client, et hérite donc de User.
 * Caractérisée par:
 * <ul>
 * <li>Un username, un mot de passe, un identifiant unique, une position et un état d'activation.</li>
 * <li>Un nom.</li>
 * <li>Un prénom. </li>
 * <li>Une liste de commandes.</li>
 * <li>Une requête de livraison.</li>
 * <li>Un booléen décrivant l'état du coursier (disponible ou pas).</li>
 * <li>Un compteur de livraisons.</li>
 * </ul>
 * 
 * 
 * @see MyFoodora
 * @see User
 */
public class Courier extends User {
	
	/**
	 * Le prénom du coursier.
	 * @see Courier#getFirstname()
	 * @see Courier#setFirstname(String)
	 */
	private String firstname;
	
	/**
	 * Le nom du coursier.
	 * @see Courier#getLastname()
	 * @see Courier#setLastname(String)
	 */
	private String lastname;
	
	/**
	 * Le numéro de téléphone du coursier.
	 * @see Courier#getPhoneNumber()
	 * @see Courier#setPhoneNumber(String)
	 */
	private String phoneNumber;
	
	
	/**
	 * L'état (en service ou non) du coursier, par défaut occupé.
	 * 
	 * @see Courier#isAvailable()
	 * @see Courier#setAvailability(boolean)
	 */
	private boolean available = false;
	
	/**
	 * Compteur des commandes effectuées.
	 * 
	 * @see Courier#getnbDeliveredOrders()
	 */
	private int nbDeliveredOrders = 0;
	
	/**
	 * Notifie le coursier d'une nouvelle livraison à effectuer.
	 * 
	 * @see DeliveryRequest
	 */
	private DeliveryRequest request = null;
	
	/**
	 * Liste des commandes reçues, "Linked" pour ajouter/retirer facilement les éléments en bout de chaîne.
	 * 
	 */
	private LinkedList<Order> listOfOrders; 
	
	/**
	 * Constructeur Courier par défaut.
	 */
	public Courier(){
		super();}
	
	/**Constructeur Courier.
	 * 
	 * @param firstname
	 * Le prénom du coursier.
	 * @param lastname
	 * Le nom du coursier.
	 * @param phoneNumber
	 * Le numéro de téléphone du coursier.
	 * @param username
	 * Le username du coursier.
	 * @param password
	 * Le mot de passe du coursier.
	 * @param activated
	 * L'état d'activation du coursier.
	 * @param position
	 * La position du coursier.
	 * 
	 * @see MyFoodora
	 * @see Courier#firstname
	 * @see Courier#lastname
	 * @see Courier#phoneNumber
	 * @see User#username
	 * @see User#password
	 * @see User#position
	 * @see User#activated
	 * @see Customer#orders
	 */
	public Courier(String firstname, String lastname, String phoneNumber, String username, String password, Position position, boolean activated){
		super(username, password, position, activated);
		this.firstname = firstname;
		this.lastname = lastname;	
		this.phoneNumber = phoneNumber;
		listOfOrders = new LinkedList<Order>();
	}
	
	
	/**
	 * @return Le nombre de commandes livrées.
	 * 
	 * @see Courier#nbDeliveredOrders
	 */
	public int getnbDeliveredOrders(){
		return nbDeliveredOrders;
	}
	
	/**
	 * Accepte la livraison à effectuer
	 */
	public void acceptDelivery(){
		Order order = this.listOfOrders.remove(); 
		nbDeliveredOrders++;
	}

	/**
	 * Refuse la livraison passée.
	 */
	public void declineDelivery(){
		this.listOfOrders.remove();  
	}
	
	/**
	 * @param order	
	 * commande reçue auprès du coursier
	 */
	public void addNewOrder(Order order) {
		this.listOfOrders.add(order);
	}
	
	/**
	 * Retourne l'état de disponibilité du coursier.
	 * @return L'état de disponibilité du coursier.
	 * 
	 * @see Courier#onDuty
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * Mise à jour de l'état de disponibilité du coursier.
	 * @param available
	 * Le nouvel état de disponibilité du coursier.
	 * 
	 * @see Courier#available
	 */
	public void setAvailability(boolean available) {
		this.available = available;
	}

	/**
	 * @return le prénom du coursier.
	 * 
	 * @see Courier#firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Mise à jour du prénom du coursier.
	 * @param firstname
	 * Le nouveau prénom du coursier.
	 * 
	 * @see Courier#firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return le nom de famille du coursier
	 * 
	 * @see Courier#lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Mise à jour du nom du coursier.
	 * @param lastname
	 * Le nouveau nom du coursier.
	 * 
	 * @see Courier#lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return La requête de livraison envoyée au coursier.
	 * 
	 * @see Courier#request
	 */
	public DeliveryRequest getRequest() {
		return request;
	}

	/**
	 * Mise à jour de la requête de livraison du coursier.
	 * @param request
	 * La nouvelle requête.
	 */
	public void setRequest(DeliveryRequest request) {
		this.request = request;
	}
	
	/**
	 * @return position
	 * la position géographique du coursier
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * Mise à jour de la position géographique du coursier
	 * @param position 
	 * la nouvelle position géographique du coursier
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * @return le numéro de téléphone du coursier
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Mise à jour du numéro de téléphone du coursier
	 * @param phoneNumber 
	 * le numéro de téléphone du coursier
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Courier [firstname=" + firstname + ", lastname=" + lastname + ", phoneNumber=" + phoneNumber
				+ ", available=" + available + "]";
	}
	
	

}
