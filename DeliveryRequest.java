package myFoodoraSystem;

/**
 * @author anastasiabouzdine
 * La classe <b>DeliveryRequest</b> représente la requête de livraison du coursier dès qu'une commande est payée.
 * Caractérisée par:
 * <ul>
 * <li>Une commande payée.</li>
 * <li>Un booléen d'acceptation ou non de la requête.</li>
 * </ul>
 *
 * @see Order
 *
 */
public class DeliveryRequest{
	/**
	 * La commande concernée par la requête.
	 */
	private Order order;
	
	/**
	 * Le booléen d'acceptation ou non de la requête envoyée au coursier.
	 */
	private boolean accepted = false;
	
	/**
	 * Constructeur DeliveryRequest.
	 * @param order
	 * La commande à livrer.
	 */
	public DeliveryRequest(Order order){
		this.order = order;
	}

	/**
	 * @return
	 * L'état d'acceptation de la commande.
	 * 
	 * @see DeliveryRequest#accepted
	 */
	public boolean isAccepted() {
		return accepted;
	}

	/**
	 * Mise à jour de l'état d'acceptation.
	 * @param accepted
	 * L'état d'acceptation.
	 * 
	 * @see DeliveryRequest#accepted
	 */
	public void setIsAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	/**
	 * @return La commande concernée.
	 * 
	 * @see DeliveryRequest#order
	 */
	public Order getOrder() {
		return order;
	}
}
