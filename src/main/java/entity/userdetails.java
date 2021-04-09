package entity;

import javax.persistence.*;

@Embeddable
@Entity
@Table(name="userdetails")
public class userdetails {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="userId")
    private int userId;
    @Column(name="name")
    private String name;
    @Column(name="password")
    private String password;
    @Column(name="email")
    private String email;
    public userdetails() {
        super();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public userdetails(String name, String password, String email) {
        super();
        this.name = name;
        this.password = password;
        this.email = email;
    }

}
