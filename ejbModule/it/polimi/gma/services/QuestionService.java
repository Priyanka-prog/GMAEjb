package it.polimi.gma.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import it.polimi.gma.entities.Question;
import it.polimi.gma.entities.Questionnaire;

@Stateless
public class QuestionService {
	@PersistenceContext(unitName = "GMAEjb")
	private EntityManager em;

	public QuestionService() {
	}
	
	public List<Question> findMarketingQuestions(int ID_questionnaire) {
		List<Question> questions = null;
		
		try {
			questions = em.createNamedQuery("Question.findQuestions", Question.class).setParameter("ID", ID_questionnaire).setParameter("type", "Marketing").getResultList();
		} catch (PersistenceException e) {
			throw new PersistenceException("Could not find the questions for this questionnaire");
		}
		
		if (questions.isEmpty())
			return null;
		else 
			return questions;
	}
	
	public List<Question> findStatisticalQuestions(int ID_questionnaire) {
		List<Question> questions = null;
		
		try {
			questions = em.createNamedQuery("Question.findQuestions", Question.class).setParameter("ID", ID_questionnaire).setParameter("type", "Statistical").getResultList();
		} catch (PersistenceException e) {
			throw new PersistenceException("Could not find the questions for this questionnaire");
		}
		
		if (questions.isEmpty())
			return null;
		else 
			return questions;
	}
	
	public void submitQuestion(String quest, Questionnaire questionnaire, String questtype) {
		Question question = new Question(quest, questionnaire, questtype);
		
		em.merge(question);
	}
}
