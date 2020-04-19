package fr.istic.taa_gli.domain;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Authentification {

	private String login;

    private String password;

    public Authentification() {
	}
    
	public Authentification(String login, String password) {
		this.login = login;
		this.password = password;
	}
	@Id
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getpassword() {
		return password;
	}

	public void setpassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Authentification [login=" + login + ", Motdepasse=" + password + "]";
	}

	
}
