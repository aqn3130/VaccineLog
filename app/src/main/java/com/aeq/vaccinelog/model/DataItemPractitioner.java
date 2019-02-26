package com.aeq.vaccinelog.model;

import android.content.ContentValues;

import com.aeq.vaccinelog.database.Tables;

public class DataItemPractitioner {
    private String guardian_id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String dateOfBirth;
    private String address;
    private String registration;

    public DataItemPractitioner() {
    }

    public DataItemPractitioner(String guardian_id, String firstName, String lastName, String email, String password, String dateOfBirth, String address, String registration) {
        this.guardian_id = guardian_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.registration = registration;
    }

    public String getGuardian_id() {
        return guardian_id;
    }

    public void setGuardian_id(String guardian_id) {
        this.guardian_id = guardian_id;
    }

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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public ContentValues toValues() {
        ContentValues values = new ContentValues(6);
        values.put(Tables.PRACTITIONER_GUARDIAN_ID, guardian_id);
        values.put(Tables.PRACTITIONER_FIRST_NAME, firstName);
        values.put(Tables.PRACTITIONER_LAST_NAME, lastName);
        values.put(Tables.PRACTITIONER_EMAIL, email);
        values.put(Tables.PRACTITIONER_PASSWORD, password);
        values.put(Tables.PRACTITIONER_DOB, dateOfBirth);
        values.put(Tables.PRACTITIONER_ADDRESS, address);
        values.put(Tables.PRACTITIONER_REGISTRATION, registration);
        return values;
    }

    @Override
    public String toString() {
        return "DataItemPractitioner{" +
                "guardian_id='" + guardian_id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", address='" + address + '\'' +
                ", registration='" + registration + '\'' +
                '}';
    }
}
