package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dr.adaming.service.AgentServiceImpl;
import dr.adaming.service.IAgentService;
import fr.adaming.model.Agent;

@ManagedBean(name="agentBean")
@SessionScoped
public class AgentManagedBean implements Serializable{
	
	private String mail;
	private String mdp;
	private Agent agent;
	
	
	
	
	// méthode
	
	
	public String isExist()
	{
		IAgentService agentService = new AgentServiceImpl();
		List<Agent> liste=agentService.isExist(mail, mdp);
		if(liste.size()==1)
		{
			agent=liste.get(0);
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("agent", agent);
			return "succes";
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Le login ou le mot de passe est incorrect !!"));
			return "failled";
		}
		
		
	}
	
	
	
	
	
	//constructeur 
	
	public AgentManagedBean(String mail, String mdp, Agent agent) {
		super();
		this.mail = mail;
		this.mdp = mdp;
		this.agent = agent;
	}
	public AgentManagedBean() {
		super();
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
