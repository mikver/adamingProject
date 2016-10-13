package dr.adaming.service;

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
		
		return agent.isExist(login, password);
	}

}
