package com.aeq.vaccinelog.database;

public class Tables {
    //Constants for identifying Patients table and columns
    public static final String TABLE_PATIENT = "patients";
    public static final String PATIENT_ID = "_id";
    public static final String PATIENT_FN = "patientFirstName";
    public static final String PATIENT_LN = "patientLastName";
    public static final String PATIENT_EMAIL = "patientEmail";
    public static final String PATIENT_PASSWORD = "patientPassword";
    public static final String PATIENT_CREATED = "patientCreated";

    public static final String ALL_COLUMNS[] = {PATIENT_ID,PATIENT_FN,PATIENT_LN,PATIENT_EMAIL,PATIENT_PASSWORD,PATIENT_CREATED};

    //SQL to create table
    public static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_PATIENT + " (" +
                    PATIENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    PATIENT_FN + " TEXT, " +
                    PATIENT_LN + " TEXT, " +
                    PATIENT_EMAIL + " TEXT, " +
                    PATIENT_PASSWORD + " TEXT, " +
                    PATIENT_CREATED + " TEXT default CURRENT_TIMESTAMP" +
                    ")";
    public static final String SQL_DELETE = "DROP TABLE" + TABLE_PATIENT;

    //Constants for identifying Child table and columns
    public static final String TABLE_CHILD = "child";
    public static final String ID = "_id";
    public static final String GUARDIAN_ID = "guardianId";
    public static final String FIRST_NAME = "patientFirstName";
    public static final String LAST_NAME = "patientLastName";
    public static final String DOB = "dateOfBirth";
    public static final String FATHER_NAME = "fatherName";
    public static final String MOTHER_NAME = "motherName";

    public static final String ALL_COLUMNS_CHILD[] = {ID,GUARDIAN_ID,FIRST_NAME,LAST_NAME,DOB,FATHER_NAME,MOTHER_NAME};

    //SQL to create Child table
    public static final String CHILD_TABLE_CREATE =
            "CREATE TABLE " + TABLE_CHILD + " (" +
                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    GUARDIAN_ID + " TEXT, " +
                    FIRST_NAME + " TEXT, " +
                    LAST_NAME + " TEXT, " +
                    DOB + " TEXT, " +
                    FATHER_NAME + " TEXT, " +
                    MOTHER_NAME + " TEXT, " +
                    PATIENT_CREATED + " TEXT default CURRENT_TIMESTAMP" +
                    ")";
    public static final String SQL_DELETE_TABLE_CHILD = "DROP TABLE" + TABLE_CHILD;
}
