package fr.adaming.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import fr.adaming.model.Agent;


@Stateless
public class AgentDaoImpl implements IAgentDao {

	
	@PersistenceContext(unitName="PU_TP_JSF_EJB_JPA")
	EntityManager em;
	@Override
	public List<Agent> isExist(String login, String password) {
		
		System.out.println("2 méthode isExist");
		
		if(em.isOpen())
		System.out.println("ok");
		
		String reqJpql="SELECT c FROM Agent c WHERE c.mail=:pmail AND c.motDePasse=:pmdp";
		System.out.println("2-1 méthode isExist");
		Query query= em.createQuery(reqJpql);
		System.out.println("2-2 méthode isExist");
		query.setParameter("pmail", login);
		query.setParameter("pmdp", password);


		List<Agent> liste = query.getResultList();


		return liste;
		
	
	}
	public AgentDaoImpl() {
		super();
	}

}
