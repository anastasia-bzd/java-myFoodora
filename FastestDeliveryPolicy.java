package myFoodoraSystem;

/**
 * @author anastasiabouzdine
 * La classe FastestDeliveryPolicy décrit la politique de livraison "de proximité" du système.
 * Elle hérite de la classe abstraite DeliveryPolicy.
 * Le coursier le plus proche de la commande est sélectionné.
 */

public abstract class FastestDeliveryPolicy extends DeliveryPolicy{
	
	private String fastestDeliveryPolicy = "Fastest Delivery Policy";

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Courier allocated according to" + fastestDeliveryPolicy + "]";
	}
	
	
}
