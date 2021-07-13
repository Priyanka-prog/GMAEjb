package it.polimi.gma.entities;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "answer", schema = "gma")
public class Answer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ansid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ansid;
	
	@Column(name="answer")
	private String answ;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uidx")
	private User uidx;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "questidx")
	private Question questidx;
	
	
	public Answer() {}
	
	public Answer(String answ, User usr, Question q) {
		this.answ = answ;
		this.uidx = usr;
		this.questidx = q;
	}

	public User getUser() {
		return this.uidx;
	}

	public void setUser(User user) {
		this.uidx = user;
	}

	public Question getQuestion() {
		return this.questidx;
	}

	public void setQuestion(Question question) {
		this.questidx = question;
	}

	public String getAnswer() {
		return this.answ;
	}

	public void setAnswer(String answer) {
		this.answ = answer;
	}
}