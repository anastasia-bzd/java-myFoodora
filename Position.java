package myFoodoraUsers;

/**
 * @author anastasiabouzdine
 * La classe Position permet de définir l'adresse/position d'un utilisateur.
 * Caractérisée par:
 * <ul>
 * <li>Une coordonnée x entière.</li>
 * <li>Une coordonnée y entière.</li>
 * </ul>
 */

public class Position {
	
	/**
	 * Coordonnée x sous forme d'entier.
	 * 
	 * @see Position#getX()
	 * @see Position#setX(int)
	 */
	private int x;
	
	/**
	 * Coordonnée y sous forme d'entier.
	 * 
	 * @see Position#getY()
	 * @see Position#setY(int)
	 */
	private int y;
	
	/**Constructeur Position qui prend en paramètre les coordonnées x et y de l'emplacement de l'utilisateur.
	 */
	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Retourne la coordonnée x de la position.
	 * @return x 
	 */
	
	public int getX() {
		return x;
	}
	
	/**
	 * Mise à jour de la coordonnée x de la position
	 * @param x
	 * La nouvelle coordonnée x de la position
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Retourne la coordonnée y de la position.
	 * @return y 
	 */
	public int getY() {
		return y;
	}

	/**
	 * Mise à jour de la coordonnée y de la position
	 * @param y
	 * La nouvelle coordonnée y de la position
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Retourne la distance entre deux positions différentes
	 * 
	 * @see Position#x
	 * @see Position#y
	 */
	public double calculateDistance(Position pos){
		return Math.sqrt(Math.pow((this.x-pos.x),2) + Math.pow((this.y-pos.y),2));
	}
	
	
	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj instanceof Position){
			Position that = (Position) obj;
			result = (this.getX() == that.getX() && this.getY() == that.getY());}
		return false;
	}
	
	@Override
	public int hashCode() {
		return (41*(41*5 + getX()) + getY());
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}

	


	

}
