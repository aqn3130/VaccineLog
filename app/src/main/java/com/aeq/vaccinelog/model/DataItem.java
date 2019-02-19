package com.aeq.vaccinelog.model;

import android.content.ContentValues;

import com.aeq.vaccinelog.database.DBOpenHelper;

public class DataItem {
//    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public DataItem() {
    }

    public DataItem(String firstName, String lastName, String email, String password) {
//        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ContentValues toValues() {
        ContentValues values = new ContentValues(5);
//        values.put(DBOpenHelper.PATIENT_ID, id);
        values.put(DBOpenHelper.PATIENT_FN, firstName);
        values.put(DBOpenHelper.PATIENT_LN, lastName);
        values.put(DBOpenHelper.PATIENT_EMAIL, email);
        values.put(DBOpenHelper.PATIENT_PASSWORD, password);
        return values;
    }

    @Override
    public String toString() {
        return "DataItem{" +
//                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
