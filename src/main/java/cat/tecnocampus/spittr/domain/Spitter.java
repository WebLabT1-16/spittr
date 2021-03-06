package cat.tecnocampus.spittr.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by roure on 21/07/2016.
 */
public class Spitter {
    private Long id;

    @NotNull
    @Size(min=5, max=16)
    private String userName;

    @NotNull
    @Size(min=5, max=25)
    private String password;

    @NotNull
    @Size(min=5, max=30)
    private String firstName;

    @NotNull
    @Size(min=2, max=30)
    private String lastName;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotNull
    @Size(min = 5, max = 80)
    private String email;

    public Spitter(String username, String password, String firstName, String lastName, String email) {
        this.userName = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Spitter(Long id, String username, String password, String firstName, String lastName, String email) {
        this.id = id;
        this.userName = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Spitter() {

    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Spitter spitter = (Spitter) o;

        if (!userName.equals(spitter.userName)) return false;
        if (!password.equals(spitter.password)) return false;
        if (!firstName.equals(spitter.firstName)) return false;
        if (!email.equals(spitter.email)) return false;
        return lastName.equals(spitter.lastName);

    }

    @Override
    public int hashCode() {
        if (userName==null) { //checking this because the first time registerForm uses an empty Spitter() with null atts
            return 1;
        } else {
            int result = userName.hashCode();
            result = 31 * result + password.hashCode();
            result = 31 * result + firstName.hashCode();
            result = 31 * result + lastName.hashCode();
            result = 31 * result + email.hashCode();
            return result;
        }
    }
}
