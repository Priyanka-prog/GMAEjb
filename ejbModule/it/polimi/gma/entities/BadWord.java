package it.polimi.gma.entities;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "offensivewords", schema = "gma")
@NamedQuery(name = "BadWord.getAllWords", query = "SELECT w FROM BadWord w")
public class BadWord implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String offensiveword;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	public BadWord() {}
	public int getID() {
		return this.id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String getWord() {
		return this.offensiveword;
	}

	public void setWord(String offensiveword) {
		this.offensiveword = offensiveword;
	}
}
