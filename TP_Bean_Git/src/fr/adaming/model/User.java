package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_user;
	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	private Date dateN;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="agent_id", referencedColumnName="id_agent")
	private Agent agent;
	
	
	// constructeur
	public User(long id_user, String nom, String prenom, Date dateN) {
		super();
		this.id_user = id_user;
		this.nom = nom;
		this.prenom = prenom;
		this.dateN = dateN;
	}
	public User(String nom, String prenom, Date dateN) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateN = dateN;
	}
	public User() {
		super();
	}
	
	
	
	// getters et setters
	
	public long getId_user() {
		return id_user;
	}
	public void setId_user(long id_user) {
		this.id_user = id_user;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateN() {
		return dateN;
	}
	public void setDateN(Date dateN) {
		this.dateN = dateN;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	@Override
	public String toString() {
		return "User [id_user=" + id_user + ", nom=" + nom + ", prenom=" + prenom + ", dateN=" + dateN + "]";
	}
		
}
