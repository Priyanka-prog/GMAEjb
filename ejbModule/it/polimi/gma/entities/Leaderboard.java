package it.polimi.gma.entities;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "Leaderboard", schema = "gma")
@NamedQueries({
	@NamedQuery(name = "Leaderboard.findLeaderboard", query="SELECT l FROM Leaderboard l WHERE l.qidx2 = :questionnaire"),
	@NamedQuery(name = "Leaderboard.findUserCancel", query = "SELECT l FROM Leaderboard l  WHERE l.qidx2 = :questionnaire AND l.uidx2 = :user AND l.points = 0"),
	@NamedQuery(name = "Leaderboard.findCancel", query = "SELECT l FROM Leaderboard l  WHERE l.qidx2 = :questionnaire AND l.points = 0"),
})
public class Leaderboard implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ranking")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ranking;
	
	private int points;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="uidx2")
	private User uidx2;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="qidx2")
	private Questionnaire qidx2;
	

	public Leaderboard() {}
	
	public Leaderboard(User user, Questionnaire questionnaire) {
		uidx2 = user;
		qidx2 = questionnaire;
		points = 0;
	}
	
	public int getRanking() {
		return this.ranking;
	}

	public void setRank(int ranking) {
		this.ranking = ranking;
	}
	
	public int getPoints() {
		return this.points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Questionnaire getQuestionnaires() {
		return this.qidx2;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.qidx2 = questionnaire;
	}

	public User getUser() {
		return this.uidx2;
	}

	public void setUser(User user) {
		this.uidx2 = user;
	}
}