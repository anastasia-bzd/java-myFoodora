package myFoodoraMenu;

/**
 * 
 * @author anastasiabouzdine
 * 
 * <b>HalfMeal représente un menu partiel (entrée/plat ou plat/dessert), et hérite de la classe abstraite <b>Meal</b>.
 * Il s'agit d'une classe abstraite qui implémente l'interface Observer pour être notifiée des modifications des <b>Item</b> qui la composent.
 * Possède:
 * <ul>
 * <li>Un nom.</li>
 * <li>Un prix.</li>
 * <li>Un type.</li>
 * <li>Une remise sur le prix.</li>
 * <li>Un booléen sur la contenance en gluten du Half Meal.</li>
 * <li>Un plat.</li>
 * </ul>
 *
 * @see MainDish
 * @see Starter
 * @see Dessert
 * @see Observable
 * @see Observer
 */
public abstract class HalfMeal extends Meal implements Observer{
	
	/**
	 * Le plat principal du menu.
	 * 
	 * @see HalfMeal#getmainDish()
	 * @see HalfMeal#setmainDish(mainDish)
	 */
	protected mainDish mainDish;
	
	/**
	 * Constructeur HalfMeal par défaut
	 */
	public HalfMeal(){
		super();
	}
	
	/**
	 * Constructeur HalfMeal avec nom et plat principal du HalfMeal.
	 * @param name
	 * Le nom du HalfMeal.
	 * @param mainDish
	 * Le plat du HalfMeal.
	 */
	public HalfMeal (String name, mainDish mainDish){
		super(name);
		this.mainDish = mainDish;
	}

	/**
	 * Retourne le plat principal du HalfMeal.
	 * @return Le plat principal du HalfMeal.
	 * 
	 * @see HalfMeal#mainDish
	 */
	public mainDish getmainDish() {
		return mainDish;
	}
	
	/**
	 * Mise à jour du plat principal du HalfMeal.
	 * @param mainDish
	 * Le nouveau plat principal.
	 * 
	 * @see HalfMeal#mainDish
	 */
	public void setmainDish(mainDish mainDish){
		this.mainDish = mainDish;
	}

	@Override
	public void update(){
	}
}
