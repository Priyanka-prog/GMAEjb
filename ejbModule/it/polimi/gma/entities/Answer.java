package it.polimi.gma.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
//@Table(name = "Answer", schema = "database")
public class Answer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ansid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ansid;
	
	@Column(name="answer")
	private String ans;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "uidx")
	private User uidx;
	
	
	
	public Answer() {}
	
	public Answer(String ans, User usr) {
		this.ans = ans;
		this.uidx = usr;
		
	}

	public User getUser() {
		return this.uidx;
	}

	public void setUser(User user) {
		this.uidx = user;
	}


	public String getAnswer() {
		return this.ans;
	}

	public void setAnswer(String answer) {
		this.ans = answer;
	}
}