package model;

import java.time.LocalDate;

public class User implements Comparable<User> {
    private int id;
    private String name;
    private String login;
    private String email;
    private LocalDate createDate;
    private String password;
    private Role role;
    private String country;
    private String town;

    public User(int id, String name, String login, String email, LocalDate createDate, String password, Role role) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
        this.password = password;
        this.role = role;
    }

    public User(int id, String name, String login, String email, LocalDate createDate, String password, Role role, String country, String town) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
        this.password = password;
        this.role = role;
        this.country = country;
        this.town = town;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public Role getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public String getCountry() {
        return country;
    }

    public String getTown() {
        return town;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        return ((User) obj).getId() == this.getId();
    }

    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", login='" + login + '\''
                + ", email='" + email + '\''
                + ", createDate=" + createDate
                + ", password='" + password + '\''
                + ", role=" + role
                + ", country='" + country + '\''
                + ", town='" + town + '\''
                + '}';
    }

    @Override
    public int compareTo(User user) {
        int userId = user.getId();
        int thisId = this.getId();
        return Integer.compare(userId, thisId) * -1;
    }
}
