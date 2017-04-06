package myFoodoraUsers;

import myFoodoraMenu.*;
import myFoodoraSystem.*;

import java.util.ArrayList;

/**
 * @author anastasiabouzdine
 * 
 * <b>Restaurant</b>  représente l'utilisateur Restaurant et hérite donc de la classe abstraite User.
 * Caractérisé par :
 * <ul>
 * <li>Un username, un mot de passe, un identifiant unique.</li>
 * <li>Un nom.</li>
 * <li>Une adresse.</li>
 * <li>Une carte contenant les meals et items disponibles.</li>
 * <li>Un menu spécial de la semaine.</li>
 * <li>Un booléen décrivant son état d'activation.</li>
 * <li>Une remise genericDiscount de 5% par défaut.</li>
 * <li>Une remise spéciale specialDiscount de 10% par défaut pour le Meal Of the Week.</li>
 * <li>Les recettes du restaurant. </li>
 * <li>Une liste des commandes.</li>
 * </ul>
 * @see RestaurantMenu
 * @see Order
 * @see User
 * @see MealOfWeek

 */
public class Restaurant extends User {

	/**
	 * Le nom du restaurant.
	 * 
	 * @see Restaurant#getName()
	 * @see Restaurant#setName(String)
	 */
	private String name;
	
	/**
	 * Menu de la semaine disponible dans le restaurant.
	 * 
	 * @see Restaurant#getMealofWeek()
	 * @see Restaurant#setMealofWeek(MealofWeek)
	 */
	private MealOfWeek mealofweek;
	
	/**
	 * Tous les meals et items proposés par le restaurant.
	 * 
	 * <p>
	 * Le restaurant édite son menu par la classe RestaurantMenu.
	 * </p>
	 * 
	 * @see RestaurantMenu
	 */
	private RestaurantMenu menu = new RestaurantMenu();
	
	/**
	 * La remise genericDiscount appliquée sur chaque meal, par défaut 5%.
	 * <p>
	 * Le prix d'un meal est obtenu en faisant la somme des prix des items le composant, puis en appliquant la remise genericDiscount.
	 * </p>
	 * 
	 * @see Restaurant#getGenericDiscount()
	 * @see Restaurant#setGenericDiscount(double)
	 */
	private double genericDiscount = 0.05;
	
	/**
	 * La remise specialDiscount du menu sécial de la semaine, par défaut 10%.
	 * <p>
	 * Le prix du menu de la semaine est calculé en faisant la somme des prix des items le composant, puis en appliquant la remise specialDiscount.
	 * </p>
	 * 
	 * @see Restaurant#getSpecialDiscount()
	 * @see Restaurant#setSpecialDiscount(double)
	 * @see MealOfWeek
	 */
	private double specialDiscount = 0.1;
	
	/**
	 * Recettes générées par le restaurant.
	 * 
	 * @see Restaurant#computeIncome()
	 * @see Restaurant#getIncome()
	 */
	private double income = 0;
	
	/**
	 * La liste des commandes du restaurant.
	 * <p>
	 * Les commandes sont automatiquement ajoutées dès qu'elles sont livrées. 
	 * Les recettes du restaurant sont automatiquement mises à jour.
	 * </p>
	 * 
	 * @see Order
	 * @see Order#endOrder()
	 * @see Restaurant#addOrder(Order)
	 * @see Restaurant#income
	 */
	private ArrayList<Order> orders = new ArrayList<Order>();

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	/**Constructeur Restaurant par défaut.
	 * <p>
	 * On appelle le constructeur de la superclasse User.
	 * </p>
	 */
	public Restaurant(){
		super();
	}

	/**Constructeur Restaurant.
	 * <p>
	 * On appelle le constructeur de la superclasse User avec les paramètres de notre Restaurant.
	 * </p>
	 * @param name
	 * Le nom du restaurant.
	 * 
	 * @see Restaurant#name
	 * @see User#username
	 * @see User#password
	 * @see User#position
	 * @see User#activated
	 * @see Restaurant#orders
	 */
	public Restaurant(String name, String username, String password, Position position, boolean activated){
		super(username, password, position, activated);
		this.name = name;
	}
	
	
	/**
	 * Donne le nom du restaurant.
	 * @return
	 * Nom du restaurant
	 * 
	 * @see Restaurant#name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Mise à jour du nom du restaurant.
	 * @param name
	 * Le nouveau nom du restaurant.
	 * 
	 * @see Restaurant#name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Donne le menu spécial de la semaine.
	 * @return MealOfWeek
	 * 
	 * @see Restaurant#MealOfWeek
	 */
	public MealOfWeek getMealOfWeek(){
		return mealofweek;
	}
	
	/**
	 * Mise à jour du menu spécial de la semaine.
	 * @param MealOfWeek
	 * Le nouveau MealOfWeek.
	 * 
	 * @see Restaurant#MealOfWeek
	 */
	public void setMealOfWeek(MealOfWeek mealofweek) {
		this.mealofweek = mealofweek ;}

	
	/**
	 * Donne la carte des meals et items du restaurant.
	 * @return
	 * La carte des meals et items du restaurant.
	 * 
	 * @see Menu
	 * @see RestaurantMenu#menu
	 */
	public RestaurantMenu getMenu() {
		return menu;
	}

	/**
	 * Mise à jour de la carte des meals et items du restaurant.
	 * @param menu
	 * La nouvelle carte.
	 * 
	 * @see Menu
	 * @see RestaurantMenu#menu
	 */
	public void setMenu(RestaurantMenu menu) {
		this.menu = menu;
	}
	
	/**
	 * Retourne la remise générique appliquée sur un menu.
	 * 
	 * @return La remise appliquée sur un menu.
	 * 
	 * @see Restaurant#genericDiscount
	 */
	public double getGenericDiscount() {
		return genericDiscount;
	}
	/**
	 * Mise à jour de la remise générique à appliquer sur un menu.
	 * 
	 * @param La nouvelle remise générique à appliquer sur un menu.
	 * 
	 * @see Restaurant#genericDiscount
	 */
	public void setGenericDiscount(double discount) {
		this.genericDiscount= discount;
	}
	
	/**
	 * Retourne la valeur de la remise spéciale à appliquer au menu de la semaine.
	 * @return
	 * La valeur de la remise sur le menu de la semaine.
	 */
	public double getSpecialDiscount() {
		return specialDiscount;
	}
	
	/**
	 * Mise à jour de la valeur de la remise spéciale à appliquer au menu de la semaine.
	 * @param 
	 * La nouvelle valeur de la remise spéciale
	 */
	public void setSpecialDiscount(double Specialdiscount) {
		 this.specialDiscount= Specialdiscount;
	}
	
	/**
	 * Calcule les recettes du restaurant.
	 * <p>
	 * Fait la somme de toutes les recettes générées par les différentes commandes.
	 * </p>
	 * 
	 * @see Order
	 * @see Order#restaurantIncome
	 * @see Restaurant#income
	 * 
	 */
	public void computeIncome(){
		double income = 0;
		for(Order o : orders){
			income += o.getRestaurantIncomePerOrder();
		}
		this.setIncome(income);
	}
	
	/**
	 * @return
	 * La valeur des recettes du restaurant.
	 * 
	 * @see Restaurant#income
	 */
	public double getIncome(){
		return(income);
	}
	
	/**
	 * Mise à jour de la valeur des recettes du restaurant.
	 * @param income
	 * La nouvelle valeur des recettes.
	 * 
	 * @see Restaurant#income
	 */
	private void setIncome(double income){
		this.income = income;
	}
	
	/**
	 * Retourne les commandes effectuées par le restaurant.
	 * @return La liste des commandes effectuées par le restaurant.
	 * 
	 * @see Restaurant#orders
	 * @see Order
	 */
	public ArrayList<Order> getOrders() {
		return orders;
	}
	
	/**
	 * Ajoute une commande à la liste des commandes réalisées par le restaurant.
	 * 
	 * @param order
	 * Commande ajoutée à la liste des commandes.
	 * 
	 * @see Restaurant#orders
	 * @see Order
	 */
	public void addOrder(Order order){
		orders.add(order);
		this.computeIncome();
	}
	
	/**
	 * Calcule le prix du menu spécial proposé par le restaurant
	 * 
	 * 
	 * @see Restaurant#getMealOfWeek
	 * @see MealOfWeek
	 */
	public double getMealOfWeekPrice(){
		MealOfWeek mealofweek = this.getMealOfWeek();
		double mealPrice = 0;
		for(Item i : mealofweek.getWeekItems())
			mealPrice+= i.getPrice();
		mealPrice = mealPrice*(1-this.getSpecialDiscount());
		return mealPrice;}

	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", menu=" + menu + ", income=" + income + "]";
	}


}


