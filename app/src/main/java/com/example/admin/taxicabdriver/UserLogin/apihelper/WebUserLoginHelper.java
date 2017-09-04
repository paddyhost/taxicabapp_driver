package com.example.admin.taxicabdriver.UserLogin.apihelper;

import android.app.Activity;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.admin.taxicabdriver.App.MyApplication;
import com.example.admin.taxicabdriver.App.PrefManager;
import com.example.admin.taxicabdriver.UserLogin.database.Driver_Table;
import com.example.admin.taxicabdriver.UserLogin.database.Driver_Table_Helper;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Hashtable;
import java.util.Map;

import static com.example.admin.taxicabdriver.App.Constants.API_HOST_ADDRESS;

/**
 * Created by shree on 03/09/2017.
 */

public class WebUserLoginHelper
{
    public static String urlLogin = API_HOST_ADDRESS+"/login";

    public static boolean driverLogin(final Activity activity, final String password)
    {
        StringRequest strReq = new StringRequest(Request.Method.POST, urlLogin, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Driver_Table driver_table = null;
                try {
                    driver_table = new Driver_Table();

                    JSONObject responce = new JSONObject(response);
                    if (responce.getString("status").equalsIgnoreCase("success"))
                    {
                        if (responce.getString("message").equalsIgnoreCase("Login successfully"))
                        {
                            JSONArray rs = responce.getJSONArray("result");
                            JSONObject result = rs.getJSONObject(0);

                            driver_table.setDRIVE_ID_VALUE(result.getString("driver_id"));
                            driver_table.setFIRST_NAME_VALUE(result.getString("firstname"));
                            driver_table.setLAST_NAME_VALUE(result.getString("lastname"));
                            driver_table.setMIDDLE_NAME_VALUE(result.getString("midlename"));
                            driver_table.setMOBILE_VALUE(result.getString("mobile_no"));
                            driver_table.setDOB_VALUE(result.getString("dob"));
                            driver_table.setGENDER_VALUE(result.getString("gender"));
                            driver_table.setEXPERIENCE_YEAR_VALUE(result.getString("Expirience_year"));
                            driver_table.setLICENSE_NO_VALUE(result.getString("license_no"));
                            driver_table.setEXPIRY_DATE_VALUE(result.getString("Expiry_date"));
                            driver_table.setSTATE_VALUE(result.getString("state"));
                            driver_table.setCITY_VALUE(result.getString("city"));
                            driver_table.setOTHER_ADDRESS_VALUE(result.getString("otherAddresss_aria"));
                            driver_table.setDRIVER_PHOTO_VALUE(result.getString("dirver_photo"));
                            driver_table.setADDRESS_PROOF_VALUE(result.getString("address_proof"));
                            driver_table.setPHOTO_ID_VALUE(result.getString("photo_id"));
                            driver_table.setPASSWORD_VALUE(result.getString("password"));
                            driver_table.setVEHICLE_ID_VALUE(result.getString("id"));
                            driver_table.setVEHICLE_NAME_VALUE(result.getString("name"));
                            driver_table.setMODEL_NO_VALUE(result.getString("model_no"));
                            driver_table.setNO_OF_SEAT_VALUE(result.getString("no_of_seat"));
                            driver_table.setCATEGORY_VALUE(result.getString("category"));
                            driver_table.setPASSING_NO_VALUE(result.getString("passing_no"));
                            driver_table.setPASSING_TYPE_VALUE(result.getString("passing_type"));
                            driver_table.setAC_TYPE_VALUE(result.getString("ac_type"));
                            driver_table.setPASSING_EXP_DATE_VALUE(result.getString("passing_expiery_date"));
                            driver_table.setINSURANCE_NO_VALUE(result.getString("Ensurance_no"));
                            driver_table.setINSURANCE_EXP_DATE_VALUE(result.getString("ensurance_expiry_date"));
                            driver_table.setCAB_PHOTO_VALUE(result.getString("car_photo"));

                            if (Driver_Table_Helper.insertDriverData(activity, driver_table))
                            {
                                Toast.makeText(activity, "Login Successful", Toast.LENGTH_SHORT).show();
                                new PrefManager(activity).createLogin(new PrefManager(activity).getMobileNumber());
                                new PrefManager(activity).setRegistrationSucess(driver_table.getDRIVE_ID_VALUE());

                                driver_table.setUSER_LOGIN_STATUS(Driver_Table.USER_LOGIN_SUCCESS);
                                EventBus.getDefault().post(driver_table);

                            } else {
                                Toast.makeText(activity, "Local Registration Failed", Toast.LENGTH_SHORT).show();
                            }


                        } else {
                            //Toast.makeText(activity,"Registration Failed",Toast.LENGTH_SHORT).show();
                            driver_table.setUSER_LOGIN_STATUS(Driver_Table.USER_LOGIN_FAILED);
                            EventBus.getDefault().post(driver_table);

                        }


                    } else {
                        //Toast.makeText(activity,"Registration Failed",Toast.LENGTH_SHORT).show();
                        driver_table.setUSER_LOGIN_STATUS(Driver_Table.USER_LOGIN_FAILED);
                        EventBus.getDefault().post(driver_table);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    driver_table.setUSER_LOGIN_STATUS(Driver_Table.USER_LOGIN_FAILED);
                    EventBus.getDefault().post(driver_table);

                }
            }
        }
                , new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                error.printStackTrace();

            }
        }) {


            @Override
            protected Map<String, String> getParams() throws AuthFailureError
            {
                Map<String,String> params = new Hashtable<String, String>();
                params.put("key", "1234");
                params.put("format", "json");
                params.put("mobile",new PrefManager(activity).getMobileNumber());
                params.put("password",password);


                //registration time not added in api


                //returning parameters
                return params;
            }


        };

        // Adding request to request queue
        int socketTimeout = 30000; // 30 seconds. You can change it
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        strReq.setRetryPolicy(policy);
        MyApplication.getInstance().addToRequestQueue(strReq);
        return  true;


    }


}
