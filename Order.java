package myFoodoraSystem;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import myFoodoraMenu.*;
import myFoodoraUsers.*;

/**
 * @author anastasiabouzdine
 * La classe <b>Order</b> représente la commande passée par le client et fournie au coursier. </b>
 * Caractérisée par :
 * <ul>
 * <li>Un client. </li>
 * <li>Un restaurant.</li>
 * <li>Une liste des meals proposés.</li>
 * <li>Une liste des items proposés.</li>
 * <li>Une date de commande.</li>
 * <li>Un identifiant unique ID.</li>
 * <li>Un IDcounter qui permet d'attribuer un identifiant unique à chaque commande.</li>
 * <li>Le prix de la commande.</li>
 * <li>Le prix final payé par le Client.</li>
 * <li>Un booléen indiquant si la commande est payée.</li>
 * <li>Un booléen indiquant si la commande a été livrée par le coursier.</li>
 * <li>Les recettes du restaurant pour la commande.</li>
 * <li>Le profit réalisé par MyFoodora sur une commande.</li>
 * </ul>
 *
 * @see Customer
 * @see Restaurant
 */

public class Order {
	
	/**
	 * Le client qui passe la commande.
	 * 
	 * @see Customer
	 * @see Order#getCustomer()
	 */
	private Customer customer;

	/**
	 * Le restaurant dans lequel la commande est passée.
	 * 
	 * @see Restaurant
	 * @see Order#getRestaurant()
	 * @see Order#setRestaurant(Restaurant)
	 */
	private Restaurant restaurant;
	

	/**
	 * La liste des meals à commander selon la quantité désirée.
	 * @see HashMap
	 * @see Order#addMeal(Meal, int)
	 * @see Order#removeMeal(Meal, int)
	 */
	private HashMap<Meal,Integer> meals = new HashMap<Meal,Integer>();

	/**La liste des items à commander selon la quantité désirée.
	 * @see HashMap
	 * @see Order#addItem(Item, int)
	 * @see Order#removeItem(Item, int)
	 */
	private HashMap<Item,Integer> items = new HashMap<Item,Integer>();

	/**
	 * Le prix brut de la commande. 
	 * 
	 * @see Order#getInterPrice()
	 */
	private double interPrice = 0;

	/**
	 * Le prix final de la commande payé par le consommateur. 
	 * 
	 * @see Order#getFinalPrice()
	 */
	private double finalPrice = 0;

	/**
	 * Les recettes du restaurant pour la commande.
	 * @see MyFoodora#markupPercentage
	 * @see Order#getRestaurantIncomePerOrder()
	 */
	private double restaurantIncomePerOrder = 0;

	/**
	 * Le profit réalisé par MyFoodora sur une commande.
	 * @see MyFoodora#markupPercentage
	 * @see MyFoodora#serviceFee
	 * @see MyFoodora#deliveryCost
	 * @see Order#getMyFoodoraProfit()
	 */
	private double OrderProfit = 0;

	/**
	 * La date à laquelle la commande est passée.
	 * 
	 * @see Order#getDate()
	 */
	private GregorianCalendar date;


	/**
	 * Booléen décrivant l'état de paiement de la commande.
	 */
	private boolean orderPayed = false;
	
	/**
	 * Booléen indiquant si la commande a été livrée.
	 * 
	 * @see Order#isDelivered()
	 * @see Order#setDelivered(boolean)
	 */
	private boolean delivered = false;

	/**
	 * L'identifiant unique de la commande.
	 * 
	 * @see Order#getID()
	 * @see Order#IDcounter
	 */
	private int ID;

	/**
	 * Le compteur de ID non accessible.
	 * <p>Ce compteur est automatiquement incrémenté à chaque ajout d'une commande.
	 * Utilisé pour s'assurer l'unicité de ID.</p>
	 * 
	 * @see Order#ID
	 */
	private static int IDcounter = 0;
	
	/**
	 * Constructeur Order avec le restaurant et le client qui passe commande.
	 * La date du calendrier est automatiquement définie.
	 * 
	 * @param restaurant
	 * Le restaurant où la commande est passée.
	 * @param customer
	 * Le client qui passe commande.
	 * 
	 * @see Order#restaurant
	 * @see Order#customer
	 * @see Order#calendar
	 */
	public Order(Restaurant restaurant, Customer customer) {
		this.restaurant = restaurant;
		this.customer = customer;
		meals = new HashMap<Meal,Integer>();
		items = new HashMap<Item,Integer>();
		this.date = new GregorianCalendar();
		this.ID = Order.IDcounter ;
		IDcounter++;
	}
	
	/**
	 * Constructeur Order avec le restaurant, le client qui passe commande et une date fixée passée en paramètre.
	 * 
	 * @param restaurant
	 * Le restaurant où la commande est passée.
	 * @param customer
	 * Le client qui passe commande.
	 * @param date
	 * La date fixée de la commande.
	 * 
	 * @see Order#restaurant
	 * @see Order#customer
	 * @see Order#date
	 * @see Order#calendar
	 */
	public Order(Restaurant restaurant, Customer customer, GregorianCalendar date) {
		this.restaurant = restaurant;
		this.customer = customer;
		meals = new HashMap<Meal,Integer>();
		items = new HashMap<Item,Integer>();
		this.date = date;
		this.ID = Order.IDcounter ;
		IDcounter++;
	}
	/**
	 * @return Le client qui a commandé
	 * 
	 * @see Customer
	 * @see Order#customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @return Le restaurant dans lequel la commmande a été effectuée.
	 * 
	 * @see Restaurant
	 * @see Order#restaurant
	 */
	public Restaurant getRestaurant() {
		return restaurant;}
	
	/**
	 * Mise à jour du restaurant où la commande est passée.
	 * @param restaurant où le consommateur passe commande.
	 * @see Restaurant
	 * @see Order#restaurant
	 */
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
		}
	
	/**
	 * @return L'identifiant unique de la commmande.
	 * 
	 * @see Order#ID
	 */
	public int getID() {
		return ID;
	}
	
	/**
	 * @return La date de la commande
	 */
	public GregorianCalendar getDate() {
		return date;
	}

	/**
	 * Mise à jour de la date de la commande.
	 * @param date
	 * 
	 * @see Order#calendar
	 */
	public void setDate(GregorianCalendar date) {
		this.date = date;
	}


	/**
	 * @return La liste des meals commandés suivant leur nombre.
	 * 
	 * @see Order#meals
	 */
	public HashMap<Meal, Integer> getMeals() {
		return meals;
	}

	/**
	 * @return La liste des meals commandés suivant leur nombre.
	 * 
	 * @see Order#items
	 */
	public HashMap<Item, Integer> getItems() {
		return items;
	}
	/**
	 * @return Le prix final de la commande payé par le client.
	 * 
	 * @see Order#finalPrice
	 */
	public double getfinalPrice() {
		return finalPrice;
	}
	
	/**
	 * @return Le prix coûtant de la commande
	 * 
	 * @see Order#interPrice
	 */
	public double getInterPrice() {
		return interPrice;
	}
	
	/**
	 * @return Les recettes du restaurant pour la commande
	 * 
	 * @see Order#restaurantIncomePerOrder
	 */
	public double getRestaurantIncomePerOrder() {
		return restaurantIncomePerOrder;
	}

	/**
	 * @return Le profit de MyFoodora sur une commande
	 * 
	 * @see Order#OrderProfit
	 */
	public double getOrderProfit() {
		return OrderProfit;
	}
	
	/**
	 * @return L'état de la livraison de la commande.
	 * 
	 * @see Order#delivered
	 */
	public boolean isDelivered() {
		return delivered;}

	/**
	 * Mise à jour de l'état de livraison de la commande.
	 * @param delivered
	 * 
	 * @see Order#delivered
	 */
	public void setDelivered(boolean delivered) {
		this.delivered = delivered ;}

	/**
	 * Ajoute un meal à la quantité désirée à la liste des meals commandés.
	 * 
	 * @param meal
	 * Le meal à ajouter à la commande.
	 * @param number
	 * Le nombre de meals de même type concernés.
	 * 
	 * @see Order#restaurant
	 * @see Order#meals
	 */
	public void addMeal(Meal meal, int number){
		if(meals.containsKey(meal)){
			number+= meals.get(meal);
			meals.put(meal, number);}
		else{
			meals.put(meal, number);}
			System.out.println( "On a ajouté à la commande : " + number + " " + meal.getName());
		}


	/**
	 * Enlève un meal à la quantité désirée de la liste des meals commandés.
	 * 
	 * @param meal
	 * Le meal à retirer de la commande.
	 * @param number
	 * Le nombre de meals de même type concernés.
	 * 
	 * @see Order#restaurant
	 * @see Order#meals
	 */
	public void removeMeal(Meal meal, int number){
		if(meals.containsKey(meal)){
			number-= meals.get(meal);
			meals.put(meal, number);}
		else{
			meals.remove(meal);}
			System.out.println( "On a retiré de la commande : " + number + " " + meal.getName());
		}


	/**
	 * Ajoute un item et la quantité désirée de la liste des items commandés.
	 * 
	 * @param item
	 * L'item à ajouter à la commande.
	 * @param number
	 * Le nombre d'items du même type à ajouter.
	 * 
	 * @see Order#restaurant
	 * @see Order#items
	 */
	public void addItem(Item item, int number){
			if(items.containsKey(item)){
				number+= items.get(item);
				items.put(item, number);	
			}
			else{
				items.put(item, number);
			}
			System.out.println( "On a ajouté à la commande : " + number + " " + item.getName());}

	/**
	 * Enlève un item à la quantité désirée de la liste des items commandés.
	 * 
	 * @param item
	 * L'item à retirer de la commande.
	 * @param quantity
	 * Le nombre d'items du même type à retirer.
	 * 
	 * @see Order#restaurant
	 * @see Order#items
	 */
	public void removeItem(Item item, int number){
			if(items.containsKey(item)){
				number-= items.get(item);
				items.put(item, number);	
			}
			else{
				items.remove(item, number);
			}
			System.out.println( "On a retiré de la commande : " + number + " " + item.getName());}
	
	/**
	 * Calcule le prix coûtant de la commande sans les divers frais et commissions
	 * 
	 * @see Restaurant#GenericDiscount
	 * @see Item
	 * @see Meal
	 */
	public void computeInterPrice() {
		double price = 0.0;
		
		Set mealsSet = (Set) meals.entrySet();
		Iterator it = mealsSet.iterator();
		while(it.hasNext()){
		    Entry entry = (Entry) it.next();
		    int number = (int) entry.getValue();
		    if ( (restaurant.getMealOfWeek()).equals(entry.getKey()) ){
		    	price += number*(restaurant.getMealOfWeekPrice()); }
		    else { 
		    	price += (((Meal) entry.getKey()).getPrice()) * number * (1-restaurant.getGenericDiscount());}
		}
		
		Set itemsSet = (Set) items.entrySet();
		Iterator setIt = itemsSet.iterator();
		while(setIt.hasNext()){
			Entry entry = (Entry) setIt.next();
			int number = (int) entry.getValue();
			price += (((Item) entry.getKey()).getPrice()) * number;}
		
		this.interPrice = price;
		
		System.out.println("Prix coûtant (hors charges) : " + this.interPrice + " ");
	}
	
	/**
	 * Calcule le prix final de la commande avec les divers frais et commissions.
	 * 
	 * @see MyFoodora#ServiceFee
	 */
	public void computeFinalPrice() {
		double price = interPrice + MyFoodora.getInstance().getServiceFee();
		this.finalPrice = price; 
		System.out.println("Charges : " + MyFoodora.getInstance().getServiceFee() + " ");
		System.out.println("Prix final (avec charges) : " + this.finalPrice + " ");}
	
	
	/**
	 * Fait payer le client et calcule les différentes commissions.
	 * Déclare la commande terminée et prête à être livrée.
	 * 
	 * @see MyFoodora#MarkupPercentage
	 */
	public void payOrder(){
		this.computeFinalPrice();
		restaurantIncomePerOrder = interPrice*(1-MyFoodora.getInstance().getMarkupPercentage());
		OrderProfit = interPrice*(MyFoodora.getInstance().getMarkupPercentage()) + MyFoodora.getInstance().getServiceFee()-MyFoodora.getInstance().getDeliveryCost();

		System.out.println("La commande s'élève à : " + finalPrice + " ");
		System.out.println("Nous vous remercions pour votre intérêt ! Un coursier va se charger de votre commande.");
		
		orderPayed = true;
		restaurant.addOrder(this);
		customer.addOrder(this);
		
		MyFoodora.getInstance().allocateCourier(this);
		}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [customer=" + customer + ", restaurant=" + restaurant + ", date=" + date + ", ID=" + ID + "]";
	}

	

		
		
		  
		  
		


}
