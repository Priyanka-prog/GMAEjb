package it.polimi.gma.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "question", schema = "gma")
@NamedQuery(name="Question.findQuestions", query="SELECT q FROM Question q WHERE q.qidx.qid = :ID AND q.questtype = :type")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="questid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int questid;
	
	private String question;
	private String questtype;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "questidx", cascade = { CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
	private List<Answer> answers = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="qidx")
	private Questionnaire qidx;

	public Question() {}
	
	public Question(String question, Questionnaire questionnaire) {
		this.question = question;
		this.qidx = questionnaire;
		questtype = "Marketing";
	}
	
	public int getID() {
		return this.questid;
	}

	public void setID(String question) {
		this.question = question;
	}
	
	public String getQuestion() {
		return this.question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getType() {
		return this.questtype;
	}
	
	public void setType(String questtype) {
		this.questtype = questtype;
	}
	
	public Questionnaire getQuestionnaire() {
		return this.qidx;
	}
	
	public void setQuestionnaire(Questionnaire questionnaire) {
		this.qidx = questionnaire;
	}

	public List<Answer> getAnswer() {
		return this.answers;
	}

	public void add(Answer answer) {
		getAnswer().add(answer);
		answer.setQuestion(this);
	}

	public void removeAnswer(Answer answer) {
		getAnswer().remove(answer);
	}
}