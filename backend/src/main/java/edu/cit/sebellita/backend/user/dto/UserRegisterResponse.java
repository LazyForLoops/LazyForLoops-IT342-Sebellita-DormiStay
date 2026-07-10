package edu.cit.sebellita.backend.user.dto;

public class UserRegisterResponse {

    private String lastname;
    private String email;


    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
