package com.aeq.vaccinelog.database;

public class Tables {
    //Constants for identifying Parent table and columns
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
    public static final String VACCINES = "vaccines";

    public static final String ALL_COLUMNS_CHILD[] = {ID,GUARDIAN_ID,FIRST_NAME,LAST_NAME,DOB,FATHER_NAME,MOTHER_NAME,VACCINES};

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
                    VACCINES + " TEXT, " +
                    PATIENT_CREATED + " TEXT default CURRENT_TIMESTAMP" +
                    ")";
    public static final String SQL_DELETE_TABLE_CHILD = "DROP TABLE" + TABLE_CHILD;

    //Constants for identifying Practitioner table and columns
    public static final String TABLE_PRACTITIONER = "practitioner";
    public static final String PRACTITIONER_ID = "_id";
    public static final String PRACTITIONER_GUARDIAN_ID = "guardianId";
    public static final String PRACTITIONER_FIRST_NAME = "practitionerFirstName";
    public static final String PRACTITIONER_LAST_NAME = "practitionerLastName";
    public static final String PRACTITIONER_EMAIL = "practitionerEmail";
    public static final String PRACTITIONER_PASSWORD = "practitionerPassword";
    public static final String PRACTITIONER_DOB = "dateOfBirth";
    public static final String PRACTITIONER_ADDRESS = "practiceAddress";
    public static final String PRACTITIONER_REGISTRATION = "practitionerRegistration";
    public static final String PRACTITIONER_CREATED = "practitionerCreated";

    public static final String ALL_COLUMNS_PRACTITIONER[] = {PRACTITIONER_ID,PRACTITIONER_GUARDIAN_ID,PRACTITIONER_FIRST_NAME,PRACTITIONER_LAST_NAME,PRACTITIONER_EMAIL,PRACTITIONER_PASSWORD,PRACTITIONER_DOB,PRACTITIONER_ADDRESS,PRACTITIONER_REGISTRATION};

    //SQL to create Practitioner table
    public static final String PRACTITIONER_TABLE_CREATE =
            "CREATE TABLE " + TABLE_PRACTITIONER + " (" +
                    PRACTITIONER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    PRACTITIONER_GUARDIAN_ID + " TEXT, " +
                    PRACTITIONER_FIRST_NAME + " TEXT, " +
                    PRACTITIONER_LAST_NAME + " TEXT, " +
                    PRACTITIONER_EMAIL + " TEXT, " +
                    PRACTITIONER_PASSWORD + " TEXT, " +
                    PRACTITIONER_DOB + " TEXT, " +
                    PRACTITIONER_ADDRESS + " TEXT, " +
                    PRACTITIONER_REGISTRATION + " TEXT, " +
                    PRACTITIONER_CREATED + " TEXT default CURRENT_TIMESTAMP" +
                    ")";
    public static final String SQL_DELETE_TABLE_PRACTITIONER = "DROP TABLE" + TABLE_PRACTITIONER;
}
