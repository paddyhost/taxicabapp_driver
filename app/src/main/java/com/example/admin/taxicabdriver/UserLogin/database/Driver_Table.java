package com.example.admin.taxicabdriver.UserLogin.database;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;

/**
 * Created by shree on 03/09/2017.
 */

public class Driver_Table
{
    public Driver_Table()
    {

    }

    public static final String TABLE_DRIVER = "Driver_Table";

    //attributes
    public static final String CL_DRIVE_ID="Driver_ID",CL_FIRST_NAME="first_name",CL_LAST_NAME="last_name",
            CL_MIDDLE_NAME="middle_name",CL_MOBILE="driver_mobile",CL_DOB="dob",CL_GENDER="gender",
            CL_EXPERIENCE_YEAR="experience_year",CL_LICENSE_NO="licence_no",CL_EXPIRY_DATE="expiry_date",
            CL_STATE="state",CL_CITY="city",CL_OTHER_ADDRESS="other_address",CL_DRIVER_PHOTO="driver_photo",
            CL_ADDRESS_PROOF="address_proof",CL_PHOTO_ID="photo_id",CL_PASSWORD="password",CL_VEHICLE_ID="vehicle_id",
            CL_VEHICLE_NAME="vehicle_name", CL_MODEL_NO="model_no",CL_NO_OF_SEAT="no_of_seat", CL_CATEGORY="category",
            CL_PASSING_NO="passing_no",CL_PASSING_TYPE="passing_type",CL_AC_TYPE="AC_type",CL_PASSING_EXP_DATE="passing_exp_date",
            CL_INSURANCE_NO="insurance_no",CL_INSURANCE_EXP_DATE="insurance_exp_date",CL_CAB_PHOTO="Latitude";


    public static final String CREATE_DRIVER_TABLE = "CREATE TABLE " + TABLE_DRIVER +
                    "("+CL_DRIVE_ID+" Bigint PRIMARY KEY, "+CL_FIRST_NAME+" TEXT, "+CL_LAST_NAME+" TEXT,"
                    +CL_MIDDLE_NAME+" TEXT, " +CL_MOBILE+" TEXT, "+CL_DOB+" TEXT,"+CL_GENDER+" TEXT,"
                    +CL_LICENSE_NO+" TEXT," +CL_EXPIRY_DATE+ " TEXT,"+CL_STATE+" TEXT,"+CL_CITY+" TEXT,"
                    +CL_OTHER_ADDRESS+" TEXT,"+CL_DRIVER_PHOTO+" TEXT," +CL_ADDRESS_PROOF+" TEXT,"
                    +CL_PHOTO_ID+" TEXT,"+CL_PASSWORD+" TEXT,"+CL_VEHICLE_ID+" TEXT," +CL_VEHICLE_NAME+" TEXT,"
                    +CL_MODEL_NO+" TEXT,"+CL_NO_OF_SEAT+" TEXT,"+CL_CATEGORY+" TEXT," +CL_PASSING_NO+" TEXT,"
                    +CL_PASSING_TYPE+" TEXT,"+CL_AC_TYPE+" TEXT,"+CL_PASSING_EXP_DATE+" TEXT,"
                    +CL_INSURANCE_NO+" TEXT,"+CL_INSURANCE_EXP_DATE+" TEXT,"+CL_CAB_PHOTO+" TEXT,"
                    +CL_EXPERIENCE_YEAR+" TEXT)";

    private String DRIVE_ID_VALUE,FIRST_NAME_VALUE,LAST_NAME_VALUE, MIDDLE_NAME_VALUE,MOBILE_VALUE,
                DOB_VALUE,GENDER_VALUE , EXPERIENCE_YEAR_VALUE,LICENSE_NO_VALUE,EXPIRY_DATE_VALUE,
                STATE_VALUE,CITY_VALUE,OTHER_ADDRESS_VALUE, ADDRESS_PROOF_VALUE,PHOTO_ID_VALUE,
                PASSWORD_VALUE,VEHICLE_ID_VALUE, VEHICLE_NAME_VALUE, MODEL_NO_VALUE,NO_OF_SEAT_VALUE, CATEGORY_VALUE,
                PASSING_NO_VALUE,PASSING_TYPE_VALUE,AC_TYPE_VALUE,PASSING_EXP_DATE_VALUE, INSURANCE_NO_VALUE,
                INSURANCE_EXP_DATE_VALUE,DRIVER_PHOTO_VALUE, CAB_PHOTO_VALUE;

    public static final int USER_LOGIN_SUCCESS=1,USER_LOGIN_FAILED=0;

    private int USER_LOGIN_STATUS;

    private Driver_Table(String DRIVE_ID_VALUE,String FIRST_NAME_VALUE,String LAST_NAME_VALUE,String MIDDLE_NAME_VALUE,
                         String MOBILE_VALUE, String DOB_VALUE,String GENDER_VALUE ,String EXPERIENCE_YEAR_VALUE,
                         String LICENSE_NO_VALUE,String EXPIRY_DATE_VALUE, String STATE_VALUE,String CITY_VALUE,
                         String OTHER_ADDRESS_VALUE,String ADDRESS_PROOF_VALUE,String PHOTO_ID_VALUE,
                         String PASSWORD_VALUE,String VEHICLE_ID_VALUE,String VEHICLE_NAME_VALUE,String MODEL_NO_VALUE,
                         String NO_OF_SEAT_VALUE, String CATEGORY_VALUE,String PASSING_NO_VALUE,String PASSING_TYPE_VALUE,
                         String AC_TYPE_VALUE,String PASSING_EXP_DATE_VALUE, String INSURANCE_NO_VALUE,
                         String INSURANCE_EXP_DATE_VALUE, String DRIVER_PHOTO_VALUE,String CAB_PHOTO_VALUE)
    {
        this.DRIVE_ID_VALUE=DRIVE_ID_VALUE;
        this.FIRST_NAME_VALUE=FIRST_NAME_VALUE;
        this.LAST_NAME_VALUE=LAST_NAME_VALUE;
        this.MIDDLE_NAME_VALUE=MIDDLE_NAME_VALUE;
        this.MOBILE_VALUE=MOBILE_VALUE;
        this.DOB_VALUE=DOB_VALUE;
        this.GENDER_VALUE=GENDER_VALUE;
        this.EXPERIENCE_YEAR_VALUE=EXPERIENCE_YEAR_VALUE;
        this.LICENSE_NO_VALUE=LICENSE_NO_VALUE;
        this.EXPIRY_DATE_VALUE=EXPIRY_DATE_VALUE;
        this.CITY_VALUE=CITY_VALUE;
        this.OTHER_ADDRESS_VALUE=OTHER_ADDRESS_VALUE;
        this.ADDRESS_PROOF_VALUE=ADDRESS_PROOF_VALUE;
        this.STATE_VALUE=STATE_VALUE;
        this.PHOTO_ID_VALUE=PHOTO_ID_VALUE;
        this.PASSWORD_VALUE=PASSWORD_VALUE;
        this.VEHICLE_ID_VALUE=VEHICLE_ID_VALUE;
        this.VEHICLE_NAME_VALUE=VEHICLE_NAME_VALUE;
        this.MODEL_NO_VALUE=MODEL_NO_VALUE;
        this.NO_OF_SEAT_VALUE=NO_OF_SEAT_VALUE;
        this.CATEGORY_VALUE=CATEGORY_VALUE;
        this.PASSING_NO_VALUE=PASSING_NO_VALUE;
        this.PASSING_TYPE_VALUE=PASSING_TYPE_VALUE;
        this.AC_TYPE_VALUE=AC_TYPE_VALUE;
        this.PASSING_EXP_DATE_VALUE=PASSING_EXP_DATE_VALUE;
        this.INSURANCE_NO_VALUE=INSURANCE_NO_VALUE;
        this.INSURANCE_EXP_DATE_VALUE=INSURANCE_EXP_DATE_VALUE;
        this.DRIVER_PHOTO_VALUE=DRIVER_PHOTO_VALUE;
        this.CAB_PHOTO_VALUE=CAB_PHOTO_VALUE;

    }

    public String getDRIVE_ID_VALUE() {
        return DRIVE_ID_VALUE;
    }

    public void setDRIVE_ID_VALUE(String DRIVE_ID_VALUE) {
        this.DRIVE_ID_VALUE = DRIVE_ID_VALUE;
    }

    public String getFIRST_NAME_VALUE() {
        return FIRST_NAME_VALUE;
    }

    public void setFIRST_NAME_VALUE(String FIRST_NAME_VALUE) {
        this.FIRST_NAME_VALUE = FIRST_NAME_VALUE;
    }

    public String getLAST_NAME_VALUE() {
        return LAST_NAME_VALUE;
    }

    public void setLAST_NAME_VALUE(String LAST_NAME_VALUE) {
        this.LAST_NAME_VALUE = LAST_NAME_VALUE;
    }

    public String getMIDDLE_NAME_VALUE() {
        return MIDDLE_NAME_VALUE;
    }

    public void setMIDDLE_NAME_VALUE(String MIDDLE_NAME_VALUE) {
        this.MIDDLE_NAME_VALUE = MIDDLE_NAME_VALUE;
    }

    public String getMOBILE_VALUE() {
        return MOBILE_VALUE;
    }

    public void setMOBILE_VALUE(String MOBILE_VALUE) {
        this.MOBILE_VALUE = MOBILE_VALUE;
    }

    public String getDOB_VALUE() {
        return DOB_VALUE;
    }

    public void setDOB_VALUE(String DOB_VALUE) {
        this.DOB_VALUE = DOB_VALUE;
    }

    public String getGENDER_VALUE() {
        return GENDER_VALUE;
    }

    public void setGENDER_VALUE(String GENDER_VALUE) {
        this.GENDER_VALUE = GENDER_VALUE;
    }

    public String getEXPERIENCE_YEAR_VALUE() {
        return EXPERIENCE_YEAR_VALUE;
    }

    public void setEXPERIENCE_YEAR_VALUE(String EXPERIENCE_YEAR_VALUE) {
        this.EXPERIENCE_YEAR_VALUE = EXPERIENCE_YEAR_VALUE;
    }

    public String getLICENSE_NO_VALUE() {
        return LICENSE_NO_VALUE;
    }

    public void setLICENSE_NO_VALUE(String LICENSE_NO_VALUE) {
        this.LICENSE_NO_VALUE = LICENSE_NO_VALUE;
    }

    public String getEXPIRY_DATE_VALUE() {
        return EXPIRY_DATE_VALUE;
    }

    public void setEXPIRY_DATE_VALUE(String EXPIRY_DATE_VALUE) {
        this.EXPIRY_DATE_VALUE = EXPIRY_DATE_VALUE;
    }

    public String getSTATE_VALUE() {
        return STATE_VALUE;
    }

    public void setSTATE_VALUE(String STATE_VALUE) {
        this.STATE_VALUE = STATE_VALUE;
    }

    public String getCITY_VALUE() {
        return CITY_VALUE;
    }

    public void setCITY_VALUE(String CITY_VALUE) {
        this.CITY_VALUE = CITY_VALUE;
    }

    public String getOTHER_ADDRESS_VALUE() {
        return OTHER_ADDRESS_VALUE;
    }

    public void setOTHER_ADDRESS_VALUE(String OTHER_ADDRESS_VALUE) {
        this.OTHER_ADDRESS_VALUE = OTHER_ADDRESS_VALUE;
    }

    public String getADDRESS_PROOF_VALUE() {
        return ADDRESS_PROOF_VALUE;
    }

    public void setADDRESS_PROOF_VALUE(String ADDRESS_PROOF_VALUE) {
        this.ADDRESS_PROOF_VALUE = ADDRESS_PROOF_VALUE;
    }

    public String getPHOTO_ID_VALUE() {
        return PHOTO_ID_VALUE;
    }

    public void setPHOTO_ID_VALUE(String PHOTO_ID_VALUE) {
        this.PHOTO_ID_VALUE = PHOTO_ID_VALUE;
    }

    public String getPASSWORD_VALUE() {
        return PASSWORD_VALUE;
    }

    public void setPASSWORD_VALUE(String PASSWORD_VALUE) {
        this.PASSWORD_VALUE = PASSWORD_VALUE;
    }

    public String getVEHICLE_ID_VALUE() {
        return VEHICLE_ID_VALUE;
    }

    public void setVEHICLE_ID_VALUE(String VEHICLE_ID_VALUE) {
        this.VEHICLE_ID_VALUE = VEHICLE_ID_VALUE;
    }

    public String getVEHICLE_NAME_VALUE() {
        return VEHICLE_NAME_VALUE;
    }

    public void setVEHICLE_NAME_VALUE(String VEHICLE_NAME_VALUE) {
        this.VEHICLE_NAME_VALUE = VEHICLE_NAME_VALUE;
    }

    public String getMODEL_NO_VALUE() {
        return MODEL_NO_VALUE;
    }

    public void setMODEL_NO_VALUE(String MODEL_NO_VALUE) {
        this.MODEL_NO_VALUE = MODEL_NO_VALUE;
    }

    public String getNO_OF_SEAT_VALUE() {
        return NO_OF_SEAT_VALUE;
    }

    public void setNO_OF_SEAT_VALUE(String NO_OF_SEAT_VALUE) {
        this.NO_OF_SEAT_VALUE = NO_OF_SEAT_VALUE;
    }

    public String getCATEGORY_VALUE() {
        return CATEGORY_VALUE;
    }

    public void setCATEGORY_VALUE(String CATEGORY_VALUE) {
        this.CATEGORY_VALUE = CATEGORY_VALUE;
    }

    public String getPASSING_NO_VALUE() {
        return PASSING_NO_VALUE;
    }

    public void setPASSING_NO_VALUE(String PASSING_NO_VALUE) {
        this.PASSING_NO_VALUE = PASSING_NO_VALUE;
    }

    public String getPASSING_TYPE_VALUE() {
        return PASSING_TYPE_VALUE;
    }

    public void setPASSING_TYPE_VALUE(String PASSING_TYPE_VALUE) {
        this.PASSING_TYPE_VALUE = PASSING_TYPE_VALUE;
    }

    public String getAC_TYPE_VALUE() {
        return AC_TYPE_VALUE;
    }

    public void setAC_TYPE_VALUE(String AC_TYPE_VALUE) {
        this.AC_TYPE_VALUE = AC_TYPE_VALUE;
    }

    public String getPASSING_EXP_DATE_VALUE() {
        return PASSING_EXP_DATE_VALUE;
    }

    public void setPASSING_EXP_DATE_VALUE(String PASSING_EXP_DATE_VALUE) {
        this.PASSING_EXP_DATE_VALUE = PASSING_EXP_DATE_VALUE;
    }

    public String getINSURANCE_EXP_DATE_VALUE() {
        return INSURANCE_EXP_DATE_VALUE;
    }

    public void setINSURANCE_EXP_DATE_VALUE(String INSURANCE_EXP_DATE_VALUE) {
        this.INSURANCE_EXP_DATE_VALUE = INSURANCE_EXP_DATE_VALUE;
    }


    public int getUSER_LOGIN_STATUS() {
        return USER_LOGIN_STATUS;
    }

    public void setUSER_LOGIN_STATUS(int USER_LOGIN_STATUS) {
        this.USER_LOGIN_STATUS = USER_LOGIN_STATUS;
    }

    public String getINSURANCE_NO_VALUE() {
        return INSURANCE_NO_VALUE;
    }

    public void setINSURANCE_NO_VALUE(String INSURANCE_NO_VALUE) {
        this.INSURANCE_NO_VALUE = INSURANCE_NO_VALUE;
    }

    public String getDRIVER_PHOTO_VALUE() {
        return DRIVER_PHOTO_VALUE;
    }

    public void setDRIVER_PHOTO_VALUE(String DRIVER_PHOTO_VALUE) {
        this.DRIVER_PHOTO_VALUE = DRIVER_PHOTO_VALUE;
    }

    public String getCAB_PHOTO_VALUE() {
        return CAB_PHOTO_VALUE;
    }

    public void setCAB_PHOTO_VALUE(String CAB_PHOTO_VALUE) {
        this.CAB_PHOTO_VALUE = CAB_PHOTO_VALUE;
    }
}
