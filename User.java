package myFoodoraUsers;

import myFoodoraSystem.MyFoodora;

/**
 * @author anastasiabouzdine
 * <b>User est une classe abstraite qui représente un utilisateur du système.</b>
 * <p>
 * Caractérisée par :
 * <ul>
 * <li>Un identifiant unique ID.</li>
 * <li>Un IDcounter qui permet d'attribuer un identifiant unique à chaque utilisateur.</li>
 * <li>Un username sous forme de chaîne de caractères.</li>
 * <li>Un mot de passe sous forme de chaîne de caractères.</li>
 * <li>Une position ou "adresse". </li>
 * <li>Un booléen décrivant l'état d'activation du client.</li>
 * </ul>
 */

public abstract class User {
	
	/**
	 * Identifiant unique de l'utilisateur qui lui est attribué.
	 * 
	 * @see User#getID()
	 * @see User#IDcounter
	 */
	private int ID;
	
	
	/**
	 * Le compteur de ID non accessible.
	 * <p>Ce compteur est automatiquement incrémenté à chaque ajout d'un utilisateur.
	 * Utilisé pour s'assurer l'unicité de ID.</p>
	 * 
	 * @see User#ID
	 */
	private static int IDcounter = 0;
	
	/**
	 * Le login de l'utilisateur.
	 * 
	 * @see User#getUsername()
	 * @see User#setUsername(String)
	 */
	protected String username;
	
	/**
	 * Le mot de passe de l'utilisateur.
	 * 
	 * @see User#getPassword()
	 * @see User#setPassword(String)
	 */
	protected String password;
	
	/**
	 * La position ou adresse de l'utilisateur.
	 * 
	 * @see User#getPosition()
	 * @see User#setPosition(Position)
	 */
	protected Position position;
	
	/**
	 * L'état d'activation de l'utilisateur mis à jour par le Manager.
	 * 
	 * @see User#setActivated(boolean)
	 * @see User#isActivated()
	 */
	protected boolean activated;
	
	/**Constructeur User par défaut, instancie le singleton MyFoodora.
	 * @see MyFoodora
	 */
	public User(){
		MyFoodora.getInstance();
	}
	
	/**Constructeur User.
	 * <p>
	 * Défini avec un username et mot de passe.
	 * Chaque construction d'un User incrémente le IDcounter qui sert alors d'identifiant unique.
	 * <p>
	 * 
	 * @param username
	 * Le username de l'utilisateur.
	 * @param password
	 * Le mot de passe de l'utilisateur.
	 * 
	 * @see User#username
	 * @see User#password
	 * @see User#IDcounter
	 */
	
	public User(String username, String password){
		this.username = username;
		this.password = password;
		this.ID = User.IDcounter;
		IDcounter++;
	}
	
	/**Constructeur User.
	 * <p>
	 * Défini avec un username, mot de passe, la position de l'utilisateur et son état d'activation.
	 * Chaque construction d'un User incrémente le IDcounter qui sert alors d'identifiant unique.
	 * <p>
	 * 
	 * @param username
	 * Le username de l'utilisateur.
	 * @param password
	 * Le mot de passe de l'utilisateur.
	 * @param position
	 * La position de l'utilisateur.
	 * @param activated
	 * booléen décrivant l'état l'utilisateur.
	 * @see User#username
	 * @see User#password
	 * @see User#IDcounter
	 * @see User#activated
	 * @see User#position
	 */
	public User(String username, String password, Position position, boolean activated){
		this.username = username;
		this.password = password;
		this.position = position;
		this.activated = activated;
		this.ID = User.IDcounter;
		IDcounter++;
	}
	
	/**
	 * Retourne l'identifiant unique de l'utilisateur
	 * @return ID 
	 * 
	 * @see User#ID
	 */
	
	public int getID() {
		return ID;
	}
	
	/**
	 * Retourne le username de l'utilisateur
	 * @return username 
	 * 
	 * @see User#username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Mise à jour du username de l'utilisateur.
	 * @param username
	 * Le nouveau username de l'utilisateur.
	 * 
	 * @see User#username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Retourne le mot de passe de l'utilisateur
	 * @return password 
	 * 
	 * @see User#password
	 */
	public String getPassword() {
		return password;
	}
	

	/**
	 * Mise à jour du mot de passe de l'utilisateur.
	 * @param password
	 * Le nouveau mot de passe de l'utilisateur.
	 * 
	 * @see User#password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Retourne la position ou adresse de l'utilisateur.
	 * 
	 * @return La position de l'utilisateur.
	 * 
	 * @see User#position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * Mise à jour de la position ou adresse de l'utilisateur.
	 * @param position
	 * La nouvelle position ou adresse de l'utilisateur.
	 * 
	 * @see User#position
	 */
	public void setPosition(Position position) {
		this.position = position;
	}
	
	/**
	 * Retourne l'état d'activation de l'utilisateur.
	 * @return booléen représentant l'état d'activation de l'utilisateur.
	 * 
	 * @see User#activated
	 */
	public boolean isActivated() {
		return activated;
	}

	/**
	 * Mise à jour l'état d'activation de l'utilisateur.
	 * 
	 * @param activated
	 * Le nouvel état d'activation de l'utilisateur.
	 * 
	 * @see User#activated
	 */
	public void setActivated(boolean activated) {
		this.activated = activated;}
	
}
