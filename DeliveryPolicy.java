package myFoodoraSystem;


/**
 * @author anastasiabouzdine
 * La classe abstraite DeliveryPolicy permet de définir la politique de livraison utilisée par le système.
 * Deux politiques possibles :
 * <ul>
 * <li>Le coursier le plus proche de la commande est sélectionné.</li>
 * <li>Le coursier ayant effectué le moins de commandes est sélectionné.</li>
 * </ul>
 */

public abstract class DeliveryPolicy {
	
	private String deliveryPolicy= " ";

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "The deliveryPolicy chosen is" + deliveryPolicy + "]";
	}

	
	
	
	
	

}
