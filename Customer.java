package myFoodoraUsers;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Set;
import myFoodoraMenu.*;
import myFoodoraSystem.*;
import myFoodoraFidelity.*;

/**
 * @author anastasiabouzdine
 * La classe <b>Customer</b> représente le client et hérite donc de la classe abstraite User.
 * Elle implémente l'interface ObserverC pour être notifiée de toute nouvelle offre spéciale.
 * 
 * Caractérisée par :
 * <ul>
 * <li>Un username, un mot de passe, un identifiant unique, une adresse et un état d'activation (booléen).</li>
 * <li>Une liste de commandes.</li>
 * <li>Un nom et prénom.</li>
 * <li>Un email.</li>
 * <li>Un numéro de téléphone</li>
 * <li>Une carte de fidélité.</li>
 * <li>Un booléen indiquant s'il accepte ou non les notifications.</li>
 * <li>Un message de notification.</li>
 * </ul>
 * 
 * @see MyFoodora
 * @see User
 * @see Order
 * @see ObserverC
 */
public class Customer extends User implements ObserverC{
	
	/**
	 * Le prénom du Client, modifiable.
	 * @see Customer#getFirstname()
	 * @see Customer#setFirstname(String)
	 */
	private String name;
	
	/**
	 * Le nom de famille du Client, modifiable.
	 * @see Customer#getSurname()
	 * @see Customer#setSurname(String)
	 */
	private String surname;
	
	/**
	 * Le numéro de téléphone du client.
	 * 
	 * @see Customer#getPhoneNumber()
	 * @see Customer#setPhoneNumber(String)
	 */
	private String phoneNumber;
	
	/**
	 * La liste des commandes passées par le client qu'on peut éditer.
	 * @see Order
	 */
	private ArrayList<Order> orders = new ArrayList<Order>();
	
	/**
	 * Le message de notification des offres promotionnelles.
	 * 
	 * @see Customer#getMessageNotification()
	 */
	private String messageNotification = "Hello !";
	
	/**
	 * Décrit si le client accepte ou non les notifications, par défaut false.
	 * 
	 * @see Customer#isAcceptNotification()
	 * @see Customer#setAcceptNotification(boolean)
	 */
	private boolean acceptNotification = false;
	
	/**
	 * Décrit le statut de la carte de fidélité du Client
	 * 
	 * @see Customer#getFidelityCard() 
	 */
	private FidelityCard fidelityCard;

	
	/**Constructeur Customer par défaut.
	 * <p>
	 * On appelle le constructeur de la superclasse User.
	 * </p>
	 */
	public Customer(){
		super();
	}

	/**Constructeur Customer.
	 * <p>
	 * On appelle le constructeur de la superclasse User avec les paramètres de notre Client.
	 * </p>
	 * @param firstname
	 * Le prénom du Client.
	 * @param lastname
	 * Le nom de famille du Client.
	 * @param FidelityCard
	 * La carte de fidélité du Client, initialisée à par défaut basic.
	 * 
	 * @see Customer#name
	 * @see Customer#surname
	 * @see Customer#fidelityCard
	 * @see User#username
	 * @see User#password
	 * @see User#position
	 * @see User#activated
	 */
	public Customer(String name, String surname, String phoneNumber, String username, String password, Position position, boolean activated){
		super(username, password, position, activated);
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.fidelityCard = new FidelityCardDefault();
	}
	
	/**
	 * Fait une commande dans un restaurant.
	 * 
	 * @param restaurant dans lequel est effectuée la commande.
	 * @param items
	 * HashMap avec items commandés et leurs quantités
	 * @param meals
	 * HashMap avec meals commandés et leurs quantités
	 * 
	 * @see Meal
	 * @see Item
	 * @see Restaurant
	 * @see Order
	 */
	public void makeOrder(Restaurant r, HashMap<Item, Integer> items, HashMap<Meal, Integer> meals){
		Order order = new Order(r, this);
		
		Set<Meal> keyMeals = meals.keySet();
		for(Meal meal : keyMeals){
			order.addMeal(meal, meals.get(meal));}
		
		Set<Item> keyItems = items.keySet();
		for(Item item : keyItems){
			order.addItem(item, items.get(item));}

		order.payOrder();
	}
	/**
	 * Affiche l'historique des commandes passées par le Client
	 * @return L'historique des commandes passées par le Client
	 * 
	 * @see Customer#orders
	 * @see Order
	 */
	public ArrayList<Order> getOrders() {
		return orders;
	}
	
	/**
	 * Ajoute une commande  à la liste des commandes.
	 * 
	 * @param order
	 * Commande ajoutée à la liste des commandes.
	 * 
	 * @see Customer#orders
	 * @see Order
	 */
	public void addOrder(Order order){
		orders.add(order);
	}
	
	/**
	 * Enlève une commande de l'historique des commandes passées par le Client.
	 * 
	 * @param order
	 * Commande retirée de la liste des commandes.
	 * 
	 * @see Customer#orders
	 * @see Order
	 */
	public void removeOrder(Order order){
		orders.remove(order);
	}
	
	/**
	 * Informe du choix du client d'être notifié ou pas.
	 * @return 
	 * Le booléen acceptNotification de consensus ou non aux notifications.
	 */
	public boolean isToAcceptNotification() {
		return acceptNotification;
	}

	/**
	 * Permet au client de s'abonner/se désabonner aux notifications d'offres spéciales.
	 * @param acceptNotification
	 * Le nouveau booléen acceptNotification de consensus ou non aux notifications
	 */
	public void setAcceptNotification(boolean acceptNotification) {
		this.acceptNotification = acceptNotification;
	}
	
	/**
	 * Retourne le message de notification.
	 * @return
	 * Le message de notification.
	 * 
	 * @see Customer#messageNotification
	 */
	public String getMessageNotification() {
		return messageNotification;
	}
	
	/**
	 * @return le prénom du Client
	 */
	public String getFirstname() {
		return name;
	}

	/**
	 * @param 
	 * Le nouveau prénom du client à modifier
	 */
	public void setFirstname(String name) {
		this.name = name;
	}
	/**
	 * @return le nom de famille
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param 
	 * Le nouveau nom de famille du client à modifier
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return l'adresse du client
	 */
	public Position getClientPosition() {
		return position;
	}

	/**
	 * @param position
	 * la nouvelle adresse du client à modifier
	 */
	public void setClientPosition(Position position) {
		this.position = position;
	}

	/**
	 * @return le numéro de téléphone du Client
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 * le numéro de téléphone du Client à modifier
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * Permet d'obtenir le statut fidélité du Client.
	 * @return FidelityCard 	
	 * Le type de la carte de fidélité détenue par le client.
	 */
	public FidelityCard getFidelityCard() {
		return fidelityCard;
	}
	
	/**
	 * Permet de changer le statut de la carte de fidélité du Client s'il est nouveau.
	 * @param FidelityCard 	
	 * Le nouveau type de carte de fidélité.
	 */
	public void setFidelityCard(FidelityCard fidelityCard) {
		if(!(fidelityCard.getClass().equals(this.fidelityCard.getClass())))
			this.fidelityCard = fidelityCard;
	}

	public void setFidelityCardToDefault() {
		FidelityCardDefault basic = new FidelityCardDefault();
		setFidelityCard(basic);
	}
	public void setFidelityCardToPoint() {
		FidelityCardPoint point = new FidelityCardPoint();
		setFidelityCard(point);
	}
	public void setFidelityCardToLottery() {
		FidelityCardLottery lottery = new FidelityCardLottery();
		setFidelityCard(lottery);
	}
	
	/**
	 * Permet d'avoir accès au nombre de points du client s'il a une carte de fidélité de type "Points"
	 * @return le nombre de points obtenus.
	 */
	public int getNbFidelityPoints() {
		if (this.fidelityCard instanceof FidelityCardPoint){
			FidelityCardPoint point = (FidelityCardPoint) this.fidelityCard;
			return point.getPoints();
		}
		else{
			System.out.println("You do not own a Fidelity Card Point: you do not have any points !");
			return 0;}
	}

	/**
	 * Ajoute des points fidélité au client s'il détient une carte de fidélité de type "Point".
	 * @param nb le nombre de points à rajouter sur la carte
	 * 
	 */
	public void addFidelityPoints(int nb) {
		if (this.fidelityCard instanceof FidelityCardPoint){
			FidelityCardPoint point = (FidelityCardPoint) this.fidelityCard;
			point.setPoints(point.getPoints() + nb);
			} 
	}
	
	/**
	 * Mise à jour de la notification du client.
	 * 
	 * @param meal
	 * Le nouveau menu spécial de la semaine.
	 * 
	 * @see Customer#messageNotification
	 * @see menu.Menu
	 */
	public void notifyCustomer(Restaurant r) {
		
		if (acceptNotification){
			MealOfWeek mealofweek = r.getMealOfWeek();
			double mealPrice = 0;
			for(Item i : mealofweek.getWeekItems())
				mealPrice+= i.getPrice();
			mealPrice = mealPrice*(1-r.getSpecialDiscount());
			this.messageNotification = r.getName() + " has a new Meal of the Week : " + mealofweek.getSpecialMealName() + " at a price of" + mealPrice ;
			}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Customer [name=" + name + ", surname=" + surname + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
}
