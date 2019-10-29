package model;

import java.time.LocalDate;

public class User implements Comparable<User> {
    private int id;
    private String name;
    private String login;
    private String email;
    private LocalDate createDate;

    public User(int id, String name, String login, String email, LocalDate createDate) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
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
        return "id: " + this.id + " Name: " + this.getName() + " Login: "
                + this.login + " E-mail: " + this.email + "  Date: "
                + this.createDate;
    }

    @Override
    public int compareTo(User user) {
        int userId = user.getId();
        int thisId = this.getId();
        return Integer.compare(userId, thisId) * -1;
    }
}
