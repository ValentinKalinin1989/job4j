package json;

public class JsonUser {
    private String name;
    private String surname;
    private String descrip;
    private String sex;

    public JsonUser() {
    }

    public JsonUser(String name, String surname, String descrip, String sex) {
        this.name = name;
        this.surname = surname;
        this.descrip = descrip;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDescrip() {
        return descrip;
    }

    public String getSex() {
        return sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
