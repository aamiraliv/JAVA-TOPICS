package model;

public class Users {
    private int id;
    private String name;
    private String email;

    public Users(int id, String name, String email) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User [ID=" + id + ", Name=" + name + ", Email=" + email + "]";
    }
}
