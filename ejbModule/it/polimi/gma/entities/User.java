package it.polimi.gma.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
//import java.util.Date;

@Entity
@Table(name="user", schema="gma")

@NamedQueries({
	@NamedQuery(name = "User.checkCredentials", query = "SELECT r FROM User r  WHERE r.username = :username and r.password = :password"),
	@NamedQuery(name="User.getAnswers", query="SELECT a FROM Answer a WHERE a.uidx = :user and a.questidx.qidx = :questionnaire"),
})
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;

	private String username;

	private String password;

	private String email;

	private String role;
	
	private String last_login;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "uidx", cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH },  orphanRemoval=true)
	
	private List<Answer> answers;
	
	public User() {
	}
	
	public User(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = "ActiveUser";
	}
	public int getId() {
		return this.uid;
	}

	public void setId(int uid) {
		this.uid = uid;
	}

	public String getUserName() {
		return this.username;
	}

	public void setName(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastLogin() {
		return this.last_login;
	}

	public void setLastLogin(String last_login) {
		this.last_login = last_login;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Answer> getAnswers() {
		return this.answers;
	}
	
	public void addAnswer(Answer answer) {
		getAnswers().add(answer);
		answer.setUser(this);
	}

	public void removeAnswer(Answer answer) {
		getAnswers().remove(answer);
	}
	
	
}


