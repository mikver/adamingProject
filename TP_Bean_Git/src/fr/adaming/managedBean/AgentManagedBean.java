package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import fr.adaming.model.Agent;
import fr.adaming.service.AgentServiceImpl;
import fr.adaming.service.IAgentService;

@ManagedBean
@SessionScoped
public class AgentManagedBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mail;
	private String mdp;
	private Agent agent;
	
	
	
	
	
	//constructeur 

	public AgentManagedBean() {
		this.mail = "";
		this.mdp = "";
		this.agent = null;
	}
	
	// méthode
	
	
		public String seConnecter()
		{
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------méthode se déconnecter---------------------------------------------------------------------------------------------------");
			IAgentService agentService = new AgentServiceImpl();
			List<Agent> liste=agentService.isExist(mail, mdp);
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------méthode se connecter---------------------------------------------------------------------------------------------------");
			
				if(liste.size()==1)
				{
					agent=liste.get(0);
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("agent", agent);
					return "succes";
				}else
				{
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Le login ou le mot de passe est incorrect !!"));
					return "failled";
				}
		}
		
	// getters et setters
	
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	
	
	

}
