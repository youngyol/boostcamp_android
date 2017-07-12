package com.example.nasos.firebasehw;

/**
 * Created by nasos on 2017-07-11.
 */

public class User {
    private String name;
    private  String email;
    private  String pw;


    public User() {
        name = "";
        email  ="";
        pw = "";
    }

    public User(String name, String email, String pw ) {

        this.name = name;
        this.email = email;
        this.pw = pw;

    }


    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
