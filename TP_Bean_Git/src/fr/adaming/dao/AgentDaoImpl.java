package fr.adaming.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.adaming.model.Agent;
import fr.adaming.model.User;


@Stateless
public class AgentDaoImpl implements IAgentDao {

	@PersistenceContext(unitName="PU_TP_JSF_EJB_JPA")
	EntityManager em;
	@Override
	public List<Agent> isExist(String login, String password) {

		
		String reqJpql="SELECT * from Agents where mail=:mail and motDePasse=:mdp";
		Query query= em.createQuery(reqJpql);
		query.setParameter("mail", login);
		query.setParameter("mdp", password);
		
		return query.getResultList();
		
	
	}

}
