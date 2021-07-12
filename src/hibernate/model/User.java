package hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users2")
public class User implements Serializable 
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "username")
    private String UserName;

    @Column(name = "accountnumber")
    private String AccountNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public String getFirstName() {
        return UserName;
    }
    public void setFirstName(String UserName) {
        this.UserName = UserName;
    }
    public String getLastName() {
        return AccountNumber;
    }
    public void setLastName(String AccountNumber) {
        this.AccountNumber = AccountNumber;
    }
    public String getUsername() {
        return email;
    }
    public void setUsername(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}