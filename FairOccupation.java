package myFoodoraSystem;

/**
 * @author anastasiabouzdine
 * La classe FairOccupation décrit la politique de livraison "de moindre livraison" du système.
 * Elle hérite de la classe abstraite DeliveryPolicy.
 * Le coursier ayant le moins de commandes à son actif est sélectionné.
 */

public abstract class FairOccupation extends DeliveryPolicy{
	
	private String fairOccupationPolicy = "Fair Occupation Policy";

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Courier allocated according to" + fairOccupationPolicy + "]";
	}
	
	
}