package com.aeq.vaccinelog.model;

import android.content.ContentValues;

import com.aeq.vaccinelog.database.Tables;

public class DataItemChild {
    private String guardian_id;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String motherName;
    private String fatherName;
    private String vaccines;

    public DataItemChild() {
    }

    public DataItemChild(String guardian_id,String firstName, String lastName, String dateOfBirth, String motherName,String fatherName,String vaccines) {
        this.guardian_id = guardian_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.motherName = motherName;
        this.fatherName = fatherName;
        this.vaccines = vaccines;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getVaccines() {
        return vaccines;
    }

    public void setVaccines(String vaccines) {
        this.vaccines = vaccines;
    }

    public ContentValues toValues() {
        ContentValues values = new ContentValues(6);
        values.put(Tables.GUARDIAN_ID, guardian_id);
        values.put(Tables.FIRST_NAME, firstName);
        values.put(Tables.LAST_NAME, lastName);
        values.put(Tables.DOB, dateOfBirth);
        values.put(Tables.FATHER_NAME, fatherName);
        values.put(Tables.MOTHER_NAME, motherName);
        values.put(Tables.VACCINES, vaccines);
        return values;
    }

    @Override
    public String toString() {
        return "DataItemChild{" +
                "guardian_id='" + guardian_id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", motherName='" + motherName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", vaccines='" + vaccines + '\'' +
                '}';
    }
}
