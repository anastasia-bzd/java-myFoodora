package myFoodoraFidelity;

/**
 * @author anastasiabouzdine
 * 
 * La classe FidelityCardDefault implémente l'interface Fidelity Card.
 * Elle comptabilise le nombre de points obtenus à chaque nouvelle commande (1 point pour 10 euros dépensés).
 * Elle offre une remise de 10% dès que le client possède 100 points. 
 */

public class FidelityCardPoint implements FidelityCard{
	
	/**
	 * Nombre de points sur la carte
	 */
	private int points;
	
	/**
	 * @param nb
	 * le nombre de points à rajouter.
	 */
	public void addPoints(int nb){
		points += nb ;
	}

	/**
	 * @return le nombre de points sur la carte de fidélité en question.
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Mise à jour du nombre de points sur la carte de fidélité.
	 * @param nb
	 * le nombre de points sur la carte
	 */
	public void setPoints(int nb) {
		this.points = nb;
	}

}
