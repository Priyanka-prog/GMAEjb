package it.polimi.gma.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "Questionnaire", schema = "gma")
@NamedQueries({
	@NamedQuery(name = "Questionnaire.findDailyQuestionnaire", query = "SELECT q FROM Questionnaire q WHERE q.qdate = :date"),
	@NamedQuery(name = "Questionnaire.findQuestionnaireDP", query = "SELECT q FROM Questionnaire q  WHERE q.qdate = :date AND q.pidx = :product"),
	@NamedQuery(name = "Questionnaire.findAllQuestionnaires", query = "SELECT q FROM Questionnaire q")
})
public class Questionnaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="qid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qid;
	
	private String qdate;
	
	
	@OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, orphanRemoval = true)
	@JoinColumn(name="pidx")
	private Product pidx;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "qidx", cascade = { CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
	private List<Question> questions = new ArrayList<>();
	
	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "qidx1", cascade = { CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
	private List<Answer> answers = new ArrayList<>();
	*/

	public Questionnaire() {
	}
	
	public Questionnaire(String date) {
		qdate = date;
	}
	
	public Questionnaire(String date, Product product) {
		qdate = date;
		pidx = product;
	}
	
	public int getID() {
		return this.qid;
	}

	public void setID(int ID_questionnaire) {
		this.qid = ID_questionnaire;
	}
	
	public String getDate() {
		return this.qdate;
	}

	public void setDate(String date) {
		this.qdate = date;
	}
	
	public Product getProduct() {
		return pidx;
	}
	
	public void setProduct(Product product) {
		this.pidx = product;
	}
	
	public List<Question> getQuestions() {
		return this.questions;
	}

	public void add(Question question) {
		questions.add(question);
		question.setQuestionnaire(this);
	}

	public void removeQuestion(Question question) {
		getQuestions().remove(question);
	}
	
	/*public List<Answer> getAnswers() {
		return this.answers;
	}

	public void addAnswer(Answer answers) {
		answers.add(answers);
		answers.setQuestionnaire(this);
	}

	public void removeAnswer(Answer answers) {
		getAnswers().remove(answers);
	}*/
}