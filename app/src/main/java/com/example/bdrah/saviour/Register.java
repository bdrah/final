package com.example.bdrah.saviour;

/**
 * Created by RHF on 10/03/2017.
 */

public class Register {

    Register(String email, String pass,String name,String phone, String city){
        setEmail(email);
        setPassword(pass);
        setName(name);
        setPhone(phone);
        setCity(city);
    }
    public long getID() {
        return ID;
    }


    public void setID(long ID) {
        this.ID = ID;
    }

    private long ID;
    private String email;
    private String password;
    private String name;
    private String phone;
    private String city;
    private int counter = 0;



    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCity(String city) {
        this.city = city;
    }



    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }



}
