package dr.adaming.service;

import java.util.List;
import javax.ejb.Local;
import fr.adaming.model.Agent;

@Local
public interface IAgentService {
	
	public List<Agent> isExist(String login, String password);

}
