package it.polimi.gma.entities;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "badword", schema = "gma")
@NamedQuery(name = "BadWord.getAllWords", query = "SELECT w FROM BadWord w")
public class BadWord implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String word;
	
	public BadWord() {}
	
	public String getWord() {
		return this.word;
	}

	public void setWord(String word) {
		this.word = word;
	}
}