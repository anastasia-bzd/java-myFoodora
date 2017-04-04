package myFoodoraSystem;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import myFoodoraMenu.*;
import myFoodoraUsers.*;
import myFoodoraFidelity.*;

/**
 * @author anastasiabouzdine
 * Le singleton <b>MyFoodora</b> représente le système central de MyFoodora.
 * Caractérisé par :
 * <ul>
 * <li>Une instance unique du singleton MyFoodora.</li>
 * <li>L'utilisateur, manager, restaurant, client ou coursier connecté au système.</li>
 * <li>Une liste de clients.</li>
 * <li>Une liste de restaurants.</li>
 * <li>Une liste de commandes.</li>
 * <li>Des frais de service appliqués sur les commandes.</li>
 * <li>Une liste de managers.</li>
 * <li>Une liste de coursiers.</li>
 * <li>Un coût de livraison pour chaque commande.</li>
 * <li>Une politique de livraison pour allouer les coursiers aux commandes.</li>
 * <li>La commission prélevée par MyFoodora sur le prix coûtant d'une commande.</li>
 * </ul>
 * 
 * 
 * @see Customer
 * @see Restaurant
 * @see Courier
 * @see Manager
 * @see Order
 * 
 *
 */

public class MyFoodora {
	
	/**
	 * L'instance du singleton MyFoodora, par défaut null.
	 */
	
	private static MyFoodora instance = null;
	
	/**
	 * L'utilisateur, manager, restaurant, client ou coursier connecté au système.
	 */
	private User current_user;
	private Courier current_courier;
	private Customer current_customer;
	private Manager current_manager;
	private Restaurant current_restaurant;
	

	/**
	 * La liste des utilisateurs du système.
	 * 
	 * @see User
	 * @see MyFoodora#addUser(User)
	 * @see MyFoodora#removeUser(User)
	 * @see MyFoodora#getUsers()
	 */
	private ArrayList<User> users = new ArrayList<User>();
	
	/**
	 * La liste des managers qui gèrent le système.
	 * 
	 * @see Manager
	 * @see MyFoodora#addManager(Manager)
	 * @see MyFoodora#removeManager(Manager)
	 * @see MyFoodora#getManagers()
	 */
	private ArrayList<Manager> managers = new ArrayList<Manager>();
	
	/**
	 * La liste des clients du système.
	 * 
	 * @see Customer
	 * @see MyFoodora#addCustomer(Customer)
	 * @see MyFoodora#removeCustomer(Customer)
	 * @see MyFoodora#getCustomers()
	 */
	private ArrayList<Customer> customers = new ArrayList<Customer>();
	
	/**
	 * La liste des restaurants du système.
	 * 
	 * @see Restaurant
	 * @see MyFoodora#addRestaurant(Restaurant)
	 * @see MyFoodora#removeRestaurant(Restaurant)
	 * @see MyFoodora#getRestaurants()
	 */
	private ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();

	/**
	 * La liste des commandes passées par les clients.
	 * 
	 * @see Order
	 * @see MyFoodora#addOrder(Order)
	 * @see MyFoodora#getOrders()
	 */
	private ArrayList<Order> orders = new ArrayList<Order>();

	/**
	 * La liste des coursiers du système.
	 * 
	 * @see Courier
	 * @see MyFoodora#addCourier(Courier)
	 * @see MyFoodora#removeCourier(Courier)
	 * @see MyFoodora#getCouriers()
	 */
	private ArrayList<Courier> couriers = new ArrayList<Courier>();


	/**
	 * La politique de livraison pour l'allocation d'un coursier à une commande, par défaut celle de la livraison la plus rapide.
	 * 
	 * @see DeliveryPolicy
	 * @see MyFoodora#setDeliveryPolicy(DeliveryPolicy)
	 * @see MyFoodora#getDeliveryPolicy()
	 */
	private DeliveryPolicy deliveryPolicy ;

	/**
	 * Les frais de service de MyFoodora, par défaut nuls.
	 * 
	 * @see MyFoodora#getServiceFee()
	 * @see MyFoodora#setServiceFee(double)
	 */
	private double serviceFee = 0;

	/**
	 * La commission appliquée par MyFoodora sur le prix coûtant de la commande, par défaut nulle.
	 * 
	 * @see MyFoodora#getMarkupPercentage()
	 * @see MyFoodora#setMarkupPercentage(double)
	 */
	private double markupPercentage = 0;

	/**
	 * Le coût de la livraison appliquée à chaque commande.
	 * 
	 * @see MyFoodora#getDeliveryCost()
	 * @see MyFoodora#setDeliveryCost(double)
	 */
	private double deliveryCost = 0;
	
	/**
	 * Le profit total réalisé par MyFoodora
	 * 
	 * @see MyFoodora#computeTotalProfit()
	 */
	private double totalProfit ;
	
	/**
	 * Les recettes totales réalisées sur les commandes.
	 * 
	 * @see MyFoodora#computeTotalIncome()
	 */
	private double totalIncome ;

	/**
	 * Constructeur privé MyFoodora car singleton.
	 * 
	 * @see MyFoodora#getInstance()
	 */
	private MyFoodora(){}

	/**
	 * Instancie un singleton MyFoodora.
	 * 
	 * @see MyFoodora#instance
	 * @see MyFoodora#MyFoodora()
	 */
	public static MyFoodora getInstance(){
		if (instance==null){
			readMyFoodora();
		}
		return(instance);
	}
	
	/**
	 * Crée le système MyFoodora par défaut
	 * 
	 * @param myFoodora
	 * L'instance du système
	 */
	public static void defaultMyFoodora(MyFoodora myFoodora){
		myFoodora.addManager(new Manager("Anastasia", "Bouzdine", "anastasia", "10271995"));
		myFoodora.addManager(new Manager("Theocharis", "Zachariadis", "theocharis", "15011994"));
	}
	
	/**
	 * Lit le fichier MyFoodora.txt, et crée un nouveau fichier avec le système par défaut si inexistant.
	 * 
	 * @see MyFoodora#getInstance()
	 */
	public static void readMyFoodora(){
		FileInputStream fis;
		ObjectInputStream ois;
		try {
			fis = new FileInputStream ("myFoodora.txt");
			ois = new ObjectInputStream (fis);
			instance = (MyFoodora) ois.readObject();
			System.out.println(" Reading MyFoodora.");
			} 
		catch (IOException | ClassNotFoundException e) {
			defaultMyFoodora(new MyFoodora());
			System.out.println(" Initializing MyFoodora default system.");
			File file = new File("myFoodora.txt");
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} 
	}
	

	/**
	 * Permet de se connecter au système en s'identifiant et d'avoir accès à certaines informations suivant son profil.
	 * @param username
	 * Le login de l'utilisateur souhaitant se connecter
	 * @param password
	 * Le mot de passe de l'utilisateur souhaitant se connecter
	 * 
	 * @see User
	 */
	public void logIn(String username, String password){
		for(User u : users){
			if (u.getUsername().equals(username) && u.getPassword().equals(password)){
				u=current_user;
				if (u instanceof Customer){
					current_customer = (Customer) u;
					System.out.println("You successfully logged in as the Customer :" + current_customer.toString());}
				if (u instanceof Manager){
					current_manager = (Manager) u;
					System.out.println("You successfully logged in as the Manager :" + current_customer.toString());}
				if (u instanceof Restaurant){
					current_restaurant = (Restaurant) u;
					System.out.println("You successfully logged in as the Restaurant :" + current_customer.toString());}
				if (u instanceof Courier){
					current_courier = (Courier) u;
					System.out.println("You successfully logged in as the Courier :" + current_customer.toString());}
				}
			else{
				System.out.println("Wrong identity ! Please try to log in again.");
			}
		}
		
	}
	
	/**
	 * Permet de se déconnecter du système.
	 * 
	 * @see User
	 */
	public void logOut(){
		current_user = null;
		current_customer = null;
		current_manager = null;
		current_restaurant = null;
		current_courier = null;}
	
	/**
	 * @return l'utilisateur utilisant le système
	 */
	public User getCurrentUser() {
		return current_user;
	}

	/**
	 * @return le coursier utilisant le système
	 */
	public Courier getCurrentCourier() {
		if (current_courier != null) {
			return current_courier;
		} else {return null;}
	}

	/**
	 * @return le client utilisant le système
	 */
	public Customer getCurrentCustomer() {
		if (current_customer != null) {
			return current_customer;
		} else {return null;}
	}

	/**
	 * @return le manager utilisant le système
	 */
	public Manager getCurrentManager() {
		if (current_manager != null) {
			return current_manager;
		} else {return null;}
	}

	/**
	 * @return le restaurant utilisant le système
	 */
	public Restaurant getCurrentRestaurant() {
		if (current_restaurant != null) {
			return current_restaurant;
		} else {return null;}
	}

	/**
	 * Ajoute un utilisateur aux utilisateurs du système, par le manager uniquement.
	 * @param u
	 * L'utilisateur à ajouter.
	 * 
	 * @see User
	 * @see MyFoodora#users
	 */
	public void addUser(User u) {
		if (this.current_user instanceof Manager){
			users.add(u);
			System.out.println("User " + u.getUsername() + " added");}
		else{
			System.out.println("You are not allowed to perform this operation.");
		}
	}
	
	/**
	 * Ajoute un manager aux managers du système, par le manager uniquement.
	 * @param m
	 * Le manager à ajouter.
	 * 
	 * @see Manager
	 * @see MyFoodora#managers
	 */
	public void addManager(Manager m) {
		if (this.current_user instanceof Manager){
			managers.add(m);
			users.add(m);
			System.out.println("Manager " + m.getUsername() + " added");}
		else{
			System.out.println("You are not allowed to perform this operation.");
		}
	}
	
	/**
	 * Ajoute un client aux clients du système, par le manager uniquement.
	 * @param c
	 * Le client à ajouter.
	 * 
	 * @see Customer
	 * @see MyFoodora#customers
	 */
	public void addCustomer(Customer c){
		if (this.current_user instanceof Manager){
			customers.add(c);
			users.add(c);
			System.out.println("Customer " + c.getUsername() + " added");
			c.setActivated(true);}
		else{
			System.out.println("You are not allowed to perform this operation.");
		}
		
	}
	
	/**
	 * Ajoute un restaurant aux restaurants du système, par le manager uniquement.
	 * @param restaurant à ajouter.
	 * 
	 * @see Restaurant
	 * @see MyFoodora#restaurants
	 */
	public void addRestaurant(Restaurant restaurant){
		if (this.current_user instanceof Manager){restaurants.add(restaurant);
			users.add(restaurant);
			System.out.println("Restaurant " + restaurant.getName() + " added");
			restaurant.setActivated(true);}
		else{
			System.out.println("You are not allowed to perform this operation.");
		}
	}

	/**
	 * Ajoute un coursier aux coursiers du système, par le manager uniquement.
	 * @param courier à ajouter.
	 * 
	 * @see Courier
	 * @see MyFoodora#couriers
	 */
	public void addCourier(Courier courier){
		if (this.current_user instanceof Manager){
			couriers.add(courier);
			users.add(courier);
			System.out.println("Courier " + courier.getUsername() + " added");
			courier.setActivated(true);}
		else{
			System.out.println("You are not allowed to perform this operation.");
		}
	}
	
	/**
	 * Retire l'utilisateur des utilisateurs du système, par le manager uniquement.
	 * @param user à retirer.
	 * 
	 * @see User
	 * @see MyFoodora#users
	 */
	public void removeUser(User user) {
		if (this.current_user instanceof Manager){
			users.remove(user);
			System.out.println("User " + user.getUsername() + " removed");}
	else{
		System.out.println("You are not allowed to perform this operation.");}
	}
	
	/**
	 * Retire le manager des managers du système, par le manager uniquement.
	 * @param m
	 * Le manager à retirer.
	 * 
	 * @see Manager
	 * @see MyFoodora#managers
	 */
	public void removeManager(Manager m) {
		if (this.current_user instanceof Manager){
		managers.remove(m);
		System.out.println("Manager " + m.getUsername() + " removed");}
	else{
		System.out.println("You are not allowed to perform this operation.");}
	}
	
	/**
	 * Retire le client des clients du système, par le manager uniquement.
	 * @param cu
	 * Le client à retirer.
	 * 
	 * @see Customer
	 * @see MyFoodora#customers
	 */
	public void removeCustomer(Customer c){
		if (this.current_user instanceof Manager){
			customers.remove(c);
			System.out.println("Customer " + c.getUsername() + " removed");
			c.setActivated(false);}
	else{
		System.out.println("You are not allowed to perform this operation.");}
	}
	
	/**
	 * Retire le restaurant des restaurants du système, par le manager uniquement.
	 * @param restaurant à retirer.
	 * 
	 * @see Restaurant
	 * @see MyFoodora#restaurants
	 */
	public void removeRestaurant(Restaurant restaurant){
		if (this.current_user instanceof Manager){
			restaurants.remove(restaurant);
			System.out.println("Restaurant " + restaurant.getName() + " removed");
			restaurant.setActivated(false);}
		else{
			System.out.println("You are not allowed to perform this operation.");}
	}

	/**
	 * Retire le coursier des coursiers du système, par le manager uniquement.
	 * @param courier
	 * Coursier à retirer.
	 * 
	 * @see Courier
	 * @see MyFoodora#couriers
	 */
	public void removeCourier(Courier courier){
		if (this.current_user instanceof Manager){
			couriers.remove(courier);
			System.out.println("Courier " + courier.getUsername() + " removed");
			courier.setActivated(false);}
		else{
			System.out.println("You are not allowed to perform this operation.");}
	}


	/**
	 * Ajoute une commmande aux commandes du système.
	 * @param order
	 * La commande à ajouter.
	 * 
	 * @see Order
	 * @see MyFoodora#orders
	 */
	public void addOrder(Order order){
		orders.add(order);
	}

	/**
	 * Retire la commande des commandes du système.
	 * @param order
	 * La commande à retirer.
	 * 
	 * @see Order
	 * @see MyFoodora#orders
	 */
	public void removeOrder(Order order){
		orders.remove(order);
	}

	/**
	 * Alloue un coursier à une commande.
	 * @param order
	 * La commmande à livrer.
	 * @return Le coursier alloué.
	 * @see Courier
	 * @see Order
	 * @see MyFoodora#couriers
	 */
	public void allocateCourier(Order order){
		boolean allocated = false;
		ArrayList<Courier> availableCouriers = new ArrayList<Courier>();

		for(Courier c : this.couriers){
			if(c.isAvailable() == true){
				availableCouriers.add(c);}
		if (availableCouriers.size()==0){
			System.out.println("Pas de coursiers disponibles. Veuillez réessayer!");}
		else{
			Courier allocatedCourier = availableCouriers.get(0);
			
			if (deliveryPolicy instanceof FastestDeliveryPolicy){
				for(Courier courier : availableCouriers){
					double distance = courier.getPosition().calculateDistance(order.getCustomer().getClientPosition());
					double min = order.getRestaurant().getPosition().calculateDistance(order.getCustomer().getClientPosition());
					if (distance<min){
					allocatedCourier = courier;}}
			}
			else{
				for(Courier courier : availableCouriers){
					int nb = courier.getnbDeliveredOrders();
					int first = allocatedCourier.getnbDeliveredOrders();
					if (nb<first){
					allocatedCourier = courier;}}
			}
			DeliveryRequest request = new DeliveryRequest(order);
			allocatedCourier.setRequest(request);
			
			System.out.println("---------");
			System.out.println("Hello "+ allocatedCourier.getFirstname());
			System.out.println("Here is your new request :");
			System.out.println("The client " + order.getCustomer().getFirstname()+" which adress is : "+order.getCustomer().getPosition()+", has made a new order in the restaurant :"+order.getRestaurant().getName());
			System.out.println("Are you willing to accept it ? Please answer yes or no.");
			Scanner scanner = new Scanner(System.in);
			String answer = scanner.nextLine();

			if(answer.equals("yes")){
				request.setIsAccepted(true);
				allocated=true;
				System.out.println("Thank you very much !");}

			else{
				System.out.println("Courier "+ allocatedCourier.getFirstname() + "has denied the delivery request.");
				availableCouriers.remove(allocatedCourier);
				}
			}
		}
		}
		
	/**
	 * Permet au restaurant utilisant le système de changer le meal spécial de la semaine et de notifier les clients abonnés.
	 * 
	 * @param mealofweek
	 * le meal spécial de la semaine
	 */
	public void setMealOfWeek(MealOfWeek mealofweek){
			current_restaurant.setMealOfWeek(mealofweek);
			notifyCustomers();
	}

	/**
	 * Notifie les cliens abonnés aux notifications en cas de nouvelle offre spéciale.
	 */
	private void notifyCustomers() {
		for (Customer c : customers) {
			c.notifyCustomer(current_restaurant);
			}}
	
	/**
	 * Calcule les recettes totales d'un restaurant, par le manager uniquement.
	 * @param restaurant
	 * restaurant donc on veut les recettes
	 * @see Order
	 * @see Order#restaurantIncome
	 * @see Restaurant#income
	 */
	public void computeTotalIncome(Restaurant r){
		if (this.current_user instanceof Manager){
			double income = 0;
			income += r.getIncome();
			this.totalIncome = income;
			System.out.println("For the restaurant " + r.getName() +", the total income is : " + totalIncome);}
		else{
			System.out.println("You are not allowed to perform this operation.");}
	}
	
	/**
	 * Calcule le profit total réalisé par MyFoodora, par le manager uniquement.
	 * @see Order
	 * @see Order#OrderProfit
	 */
	public void computeTotalProfit(){
		if (this.current_user instanceof Manager){
			double profit = 0;
			for (Order o : orders) {
				profit += o.getOrderProfit();}
			this.totalProfit = profit ;
			System.out.println("The total profit is : " + totalProfit);}
		else{
			System.out.println("You are not allowed to perform this operation.");}
		}
	
	/**
	 * @return La liste des utilisateurs du système.
	 * 
	 * @see MyFoodora#users
	 */
	public ArrayList<User> getUsers() {
		return users;
	}
	
	/**
	 * @return La liste des managers du système.
	 * 
	 * @see MyFoodora#managers
	 */
	public ArrayList<Manager> getManagers() {
		return managers;
	}
	
	/** 
	 * @return La liste des clients du système.
	 * 
	 * @see MyFoodora#customers
	 */
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	
	/**
	 * @return La liste des commandes passées dans le système.
	 * 
	 * @see MyFoodora#restaurants
	 */
	public ArrayList<Order> getOrders() {
		return orders;
	}
	
	/**
	 * @return La liste des restaurants du système.
	 * 
	 * @see MyFoodora#restaurants
	 */
	public ArrayList<Restaurant> getRestaurants() {
		return restaurants;
	}

	/**
	 * @return La liste des coursiers du système.  
	 * 
	 * @see MyFoodora#couriers
	 */
	public ArrayList<Courier> getCouriers() {
		return couriers;
	}

	/**
	 * @return Les frais de service de MyFoodora.
	 * 
	 * @see MyFoodora#serviceFee
	 */
	public double getServiceFee() {
		return serviceFee;
	}

	/**
	 * Mise à jour des frais de service de MyFoodora, par le manager uniquement.
	 * @param serviceFee
	 * La nouvelle valeur des frais de service.
	 * 
	 * @see MyFoodora#serviceFee
	 */
	public void setServiceFee(double serviceFee) {
		if (current_user instanceof Manager){
			this.serviceFee = serviceFee;}
		else{
			System.out.println("You are not allowed to perform this operation.");}
	}

	/**
	 * @return La commission prélevée par MyFoodora 
	 * 
	 * @see MyFoodora#markupPercentage
	 */
	public double getMarkupPercentage() {
		return markupPercentage;
	}

	/**
	 * Mise à jour de la commission prélevée par MyFoodora, par le manager uniquement.
	 * 
	 * @param markupPercentage
	 * La commission prélevée par MyFoodora 
	 */
	public void setMarkupPercentage(double markupPercentage){
		if (current_user instanceof Manager){
			this.markupPercentage = markupPercentage;}
		else{
			System.out.println("You are not allowed to perform this operation.");}
		}
	
	/**
	 * @return le coût de livraison du système.
	 * 
	 * @see MyFoodora#deliveryCost
	 */
	public double getDeliveryCost() {
		return deliveryCost;
	}

	/**
	 * Mise à jour du coût de livraison du système, par le manager uniquement.
	 * @param deliveryCost
	 * Le nouveau coût de livraison.
	 * 
	 * @see MyFoodora#deliveryCost
	 */
	public void setDeliveryCost(double deliveryCost) {
		if (current_user instanceof Manager){
			this.deliveryCost = deliveryCost;}
		else{
		System.out.println("You are not allowed to perform this operation.");}
		}

	/**
	 * @return La politique de livraison du système.
	 * 
	 * @see DeliveryPolicy
	 * @see MyFoodora#deliveryPolicy
	 */
	public DeliveryPolicy getDeliveryPolicy(){
		return this.deliveryPolicy;
	}

	/**
	 * Mise à jour de la politique de livraison du système, par le manager uniquement.
	 * 
	 * @param policy
	 * La nouvelle politique de livraison.
	 * 
	 * @see DeliveryPolicy
	 * @see MyFoodora#deliveryPolicy
	 */
	public void setDeliveryPolicy(DeliveryPolicy policy){
		if (current_user instanceof Manager){
			this.deliveryPolicy = policy;}
		else{
			System.out.println("You are not allowed to perform this operation.");}
	}
	
	/**
	 * Montre l'historique des commandes réalisées par le client connecté. 
	 * 
	 * @return liste des commandes du client connecté.
	 */
	public ArrayList<Order> getHistoryOfOrders() {
		if (current_user instanceof Customer) {
			int ID = current_customer.getID();
			ArrayList<Order> customer_orders = new ArrayList<Order>();
			for (Order o : orders) {
				if (ID == o.getCustomer().getID()) {
					customer_orders.add(o);}
			}
		
			return customer_orders;
		} else {
			return null;
		}
	}
}



