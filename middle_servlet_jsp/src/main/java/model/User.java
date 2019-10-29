package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor public class User implements Comparable<User> {
    @Setter @Getter private int id;
    @Setter @Getter private String name;
    @Setter @Getter private String login;
    @Setter @Getter private String email;
    @Setter @Getter private LocalDate createDate;

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
