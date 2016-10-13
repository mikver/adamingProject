package fr.adaming.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.AgentDaoImpl;
import fr.adaming.dao.IAgentDao;
import fr.adaming.model.Agent;

@Stateful
public class AgentServiceImpl implements IAgentService {

	@EJB
	IAgentDao agent=new AgentDaoImpl();
	@Override
	public List<Agent> isExist(String login, String password) {
		System.out.println("1 méthode isExist"); 
		return agent.isExist(login, password);
	}

}
