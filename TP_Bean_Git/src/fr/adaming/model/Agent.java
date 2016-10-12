package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="agents")
public class Agent implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_agent;
	@Column(name="mail")
	private String mail;
	@Column(name="mdp")
	private String motDePasse;
	@OneToMany(mappedBy="agent",cascade=CascadeType.REMOVE,fetch=FetchType.LAZY)
	private List<User> UtilisateurEnregistre;
	
	
	//constructeur
	
	public Agent(long id_agent, String mail, String motDePasse, List<User> utilisateurEnregistre) {
		super();
		this.id_agent = id_agent;
		this.mail = mail;
		this.motDePasse = motDePasse;
		UtilisateurEnregistre = utilisateurEnregistre;
	}
	public Agent(String mail, String motDePasse, List<User> utilisateurEnregistre) {
		super();
		this.mail = mail;
		this.motDePasse = motDePasse;
		UtilisateurEnregistre = utilisateurEnregistre;
	}
	public Agent(String mail, String motDePasse) {
		super();
		this.mail = mail;
		this.motDePasse = motDePasse;
	}
	public Agent() {
		super();
	}
	
	// getters et setters
	
	public long getId_agent() {
		return id_agent;
	}
	public void setId_agent(long id_agent) {
		this.id_agent = id_agent;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public List<User> getUtilisateurEnregistre() {
		return UtilisateurEnregistre;
	}
	public void setUtilisateurEnregistre(List<User> utilisateurEnregistre) {
		UtilisateurEnregistre = utilisateurEnregistre;
	}
	@Override
	public String toString() {
		return "Agent [id_agent=" + id_agent + ", mail=" + mail + ", motDePasse=" + motDePasse + "]";
	}

}
