package com.example.admin.taxicabdriver.UserLogin.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.admin.taxicabdriver.Database.DatabaseHandler;

/**
 * Created by shree on 03/09/2017.
 */

public class Driver_Table_Helper
{
    private Driver_Table_Helper()
    {

    }

    public static boolean insertDriverData(Context context, Driver_Table driver)
    {
        try
        {
            SQLiteDatabase db =  DatabaseHandler.getInstance(context).getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(Driver_Table.CL_DRIVE_ID, driver.getDRIVE_ID_VALUE());
            values.put(Driver_Table.CL_FIRST_NAME, driver.getFIRST_NAME_VALUE());
            values.put(Driver_Table.CL_LAST_NAME, driver.getLAST_NAME_VALUE());
            values.put(Driver_Table.CL_MIDDLE_NAME, driver.getMIDDLE_NAME_VALUE());
            values.put(Driver_Table.CL_MOBILE, driver.getMOBILE_VALUE());
            values.put(Driver_Table.CL_DOB, driver.getDOB_VALUE());
            values.put(Driver_Table.CL_GENDER, driver.getGENDER_VALUE());
            values.put(Driver_Table.CL_EXPERIENCE_YEAR, driver.getEXPERIENCE_YEAR_VALUE());
            values.put(Driver_Table.CL_LICENSE_NO, driver.getLICENSE_NO_VALUE());
            values.put(Driver_Table.CL_STATE, driver.getSTATE_VALUE());
            values.put(Driver_Table.CL_CITY, driver.getCITY_VALUE());
            values.put(Driver_Table.CL_OTHER_ADDRESS, driver.getOTHER_ADDRESS_VALUE());
            values.put(Driver_Table.CL_DRIVER_PHOTO, driver.getDRIVER_PHOTO_VALUE());
            values.put(Driver_Table.CL_ADDRESS_PROOF, driver.getADDRESS_PROOF_VALUE());
            values.put(Driver_Table.CL_PHOTO_ID, driver.getPHOTO_ID_VALUE());
            values.put(Driver_Table.CL_PASSWORD, driver.getPASSWORD_VALUE());
            values.put(Driver_Table.CL_VEHICLE_ID, driver.getVEHICLE_ID_VALUE());
            values.put(Driver_Table.CL_VEHICLE_NAME, driver.getVEHICLE_NAME_VALUE());
            values.put(Driver_Table.CL_MODEL_NO, driver.getMODEL_NO_VALUE());
            values.put(Driver_Table.CL_NO_OF_SEAT, driver.getNO_OF_SEAT_VALUE());
            values.put(Driver_Table.CL_CATEGORY, driver.getCATEGORY_VALUE());
            values.put(Driver_Table.CL_PASSING_NO, driver.getPASSING_NO_VALUE());
            values.put(Driver_Table.CL_PASSING_TYPE, driver.getPASSING_TYPE_VALUE());
            values.put(Driver_Table.CL_AC_TYPE, driver.getAC_TYPE_VALUE());
            values.put(Driver_Table.CL_PASSING_EXP_DATE, driver.getPASSING_EXP_DATE_VALUE());
            values.put(Driver_Table.CL_INSURANCE_NO, driver.getINSURANCE_NO_VALUE());
            values.put(Driver_Table.CL_INSURANCE_EXP_DATE, driver.getINSURANCE_EXP_DATE_VALUE());
            values.put(Driver_Table.CL_EXPIRY_DATE, driver.getEXPIRY_DATE_VALUE());
            values.put(Driver_Table.CL_CAB_PHOTO, driver.getCAB_PHOTO_VALUE());

            // Inserting Row
            db.insert(Driver_Table.TABLE_DRIVER, null, values);
            db.close(); // Closing database connection
            //insertDefoultvalue(context);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
        finally
        {

        }
    }

    public static Driver_Table getdriverInfo(Context context)
    {
        Driver_Table driver_info=null;
        try
        {

            SQLiteDatabase db =  DatabaseHandler.getInstance(context).getWritableDatabase();

            Cursor cursor = db.rawQuery("SELECT * FROM "+Driver_Table.TABLE_DRIVER,null);
            //+" WHERE "+User_Table.CL_USERID+"="+new PrefManager(context).getMobileNumber()
            driver_info  =new Driver_Table();
            if (cursor != null) {
                cursor.moveToFirst();
                driver_info.setDRIVE_ID_VALUE(cursor.getString(cursor.getColumnIndex(Driver_Table.CL_DRIVE_ID)));
                driver_info.setFIRST_NAME_VALUE(cursor.getString(cursor.getColumnIndex(Driver_Table.CL_FIRST_NAME)));
                driver_info.setLAST_NAME_VALUE(cursor.getString(cursor.getColumnIndex(Driver_Table.CL_LAST_NAME)));
                driver_info.setMIDDLE_NAME_VALUE(cursor.getString(cursor.getColumnIndex(Driver_Table.CL_MIDDLE_NAME)));
                driver_info.setMOBILE_VALUE(cursor.getString(cursor.getColumnIndex(Driver_Table.CL_MOBILE)));
                driver_info.setDOB_VALUE(cursor.getString(cursor.getColumnIndex(Driver_Table.CL_DOB)));
                driver_info.setGENDER_VALUE(cursor.getString(cursor.getColumnIndex(Driver_Table.CL_GENDER)));
                driver_info.setEXPERIENCE_YEAR_VALUE(cursor.getString(cursor.getColumnIndex(Driver_Table.CL_EXPERIENCE_YEAR)));
                driver_info.setLICENSE_NO_VALUE(cursor.getString(cursor.getColumnIndex(Driver_Table.CL_LICENSE_NO)));
                driver_info.setEXPIRY_DATE_VALUE(cursor.getString(cursor.getColumnIndex(Driver_Table.CL_EXPIRY_DATE)));
                driver_info.setSTATE_VALUE(cursor.getString(cursor.getColumnIndex(Driver_Table.CL_STATE)));
                driver_info.setCITY_VALUE(cursor.getString(cursor.getColumnIndex(Driver_Table.CL_CITY)));
                driver_info.setOTHER_ADDRESS_VALUE(cursor.getString(cursor.getColumnIndex(Driver_Table.CL_OTHER_ADDRESS)));
                driver_info.setDRIVER_PHOTO_VALUE(cursor.getString(cursor.getColumnIndex(Driver_Table.CL_DRIVER_PHOTO)));
                driver_info.setADDRESS_PROOF_VALUE(cursor.getString(cursor.getColumnIndex(Driver_Table.CL_ADDRESS_PROOF)));
                driver_info.setPHOTO_ID_VALUE(cursor.getString(cursor.getColumnIndex(Driver_Table.CL_PHOTO_ID)));
                driver_info.setPASSWORD_VALUE(cursor.getString(cursor.getColumnIndex(Driver_Table.CL_PASSWORD)));
                driver_info.setVEHICLE_ID_VALUE(cursor.getString(cursor.getColumnIndex(Driver_Table.CL_VEHICLE_ID)));
                driver_info.setVEHICLE_NAME_VALUE(cursor.getString(cursor.getColumnIndex(Driver_Table.CL_VEHICLE_NAME)));
                driver_info.setMODEL_NO_VALUE(cursor.getString(cursor.getColumnIndex(Driver_Table.CL_MODEL_NO)));
                driver_info.setNO_OF_SEAT_VALUE(cursor.getString(cursor.getColumnIndex(Driver_Table.CL_NO_OF_SEAT)));
                driver_info.setCATEGORY_VALUE(cursor.getString(cursor.getColumnIndex(Driver_Table.CL_CATEGORY)));
                driver_info.setPASSING_NO_VALUE(cursor.getString(cursor.getColumnIndex(Driver_Table.CL_PASSING_NO)));
                driver_info.setPASSING_TYPE_VALUE(cursor.getString(cursor.getColumnIndex(Driver_Table.CL_PASSING_TYPE)));
                driver_info.setAC_TYPE_VALUE(cursor.getString(cursor.getColumnIndex(Driver_Table.CL_AC_TYPE)));
                driver_info.setPASSING_EXP_DATE_VALUE(cursor.getString(cursor.getColumnIndex(Driver_Table.CL_PASSING_EXP_DATE)));
                driver_info.setINSURANCE_NO_VALUE(cursor.getString(cursor.getColumnIndex(Driver_Table.CL_INSURANCE_NO)));
                driver_info.setINSURANCE_EXP_DATE_VALUE(cursor.getString(cursor.getColumnIndex(Driver_Table.CL_INSURANCE_EXP_DATE)));
                driver_info.setCAB_PHOTO_VALUE(cursor.getString(cursor.getColumnIndex(Driver_Table.CL_CAB_PHOTO)));

            }

            return driver_info;

        }
        catch (Exception e)
        {
            return driver_info;
        }

        // return contact

    }

    public static boolean updateUserInfo(Context context,Driver_Table driver)
    {
        try
        {

            SQLiteDatabase db =  DatabaseHandler.getInstance(context).getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(Driver_Table.CL_DRIVE_ID, driver.getDRIVE_ID_VALUE());
            values.put(Driver_Table.CL_FIRST_NAME, driver.getFIRST_NAME_VALUE());
            values.put(Driver_Table.CL_LAST_NAME, driver.getLAST_NAME_VALUE());
            values.put(Driver_Table.CL_MIDDLE_NAME, driver.getMIDDLE_NAME_VALUE());
            values.put(Driver_Table.CL_MOBILE, driver.getMOBILE_VALUE());
            values.put(Driver_Table.CL_DOB, driver.getDOB_VALUE());
            values.put(Driver_Table.CL_GENDER, driver.getGENDER_VALUE());
            values.put(Driver_Table.CL_EXPERIENCE_YEAR, driver.getEXPERIENCE_YEAR_VALUE());
            values.put(Driver_Table.CL_LICENSE_NO, driver.getLICENSE_NO_VALUE());
            values.put(Driver_Table.CL_STATE, driver.getSTATE_VALUE());
            values.put(Driver_Table.CL_CITY, driver.getCITY_VALUE());
            values.put(Driver_Table.CL_OTHER_ADDRESS, driver.getOTHER_ADDRESS_VALUE());
            values.put(Driver_Table.CL_DRIVER_PHOTO, driver.getDRIVER_PHOTO_VALUE());
            values.put(Driver_Table.CL_ADDRESS_PROOF, driver.getADDRESS_PROOF_VALUE());
            values.put(Driver_Table.CL_PHOTO_ID, driver.getPHOTO_ID_VALUE());
            values.put(Driver_Table.CL_PASSWORD, driver.getPASSWORD_VALUE());
            values.put(Driver_Table.CL_VEHICLE_ID, driver.getVEHICLE_ID_VALUE());
            values.put(Driver_Table.CL_VEHICLE_NAME, driver.getVEHICLE_NAME_VALUE());
            values.put(Driver_Table.CL_MODEL_NO, driver.getMODEL_NO_VALUE());
            values.put(Driver_Table.CL_NO_OF_SEAT, driver.getNO_OF_SEAT_VALUE());
            values.put(Driver_Table.CL_CATEGORY, driver.getCATEGORY_VALUE());
            values.put(Driver_Table.CL_PASSING_NO, driver.getPASSING_NO_VALUE());
            values.put(Driver_Table.CL_PASSING_TYPE, driver.getPASSING_TYPE_VALUE());
            values.put(Driver_Table.CL_AC_TYPE, driver.getAC_TYPE_VALUE());
            values.put(Driver_Table.CL_PASSING_EXP_DATE, driver.getPASSING_EXP_DATE_VALUE());
            values.put(Driver_Table.CL_INSURANCE_NO, driver.getINSURANCE_NO_VALUE());
            values.put(Driver_Table.CL_INSURANCE_EXP_DATE, driver.getINSURANCE_EXP_DATE_VALUE());
            values.put(Driver_Table.CL_EXPIRY_DATE, driver.getEXPIRY_DATE_VALUE());
            values.put(Driver_Table.CL_CAB_PHOTO, driver.getCAB_PHOTO_VALUE());

            // upadating Row
            db.update(Driver_Table.TABLE_DRIVER, values, Driver_Table.CL_DRIVE_ID+"="+driver.getDRIVE_ID_VALUE(), null);
            db.close(); // Closing database connection
            return true;
        }
        catch (Exception e)
        {
            return false;
        }


        // return contact


    }


    public static boolean deleteDriverInfo(Context context)
    {
        try
        {
            SQLiteDatabase db =  DatabaseHandler.getInstance(context).getWritableDatabase();

            db.execSQL("DELETE FROM "+ Driver_Table.TABLE_DRIVER); //delete all rows in a table

            Toast.makeText(context,"User Deleted Successfully",Toast.LENGTH_SHORT).show();


            db.close();

            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

}
