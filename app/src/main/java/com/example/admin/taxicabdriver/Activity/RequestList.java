package com.example.admin.taxicabdriver.Activity;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.admin.taxicabdriver.R;

import org.w3c.dom.Text;

/**
 * Created by admin on 8/30/2017.
 */

public class RequestList extends ArrayAdapter<String>{
    private String[] req_status;
    private String[] pickup_point;
    private String[] target_point;
    private String[] ride_date;
    private String[] ride_time;
    private Activity context;
    public RequestList(Activity context, String[] req_status, String[] pickup_point, String[] target_point, String[] ride_date, String[] ride_time){
        super(context, R.layout.list_request, req_status);
        this.context = context;
        this.req_status = req_status;
        this.pickup_point = pickup_point;
        this.target_point = target_point;
        this.ride_date = ride_date;
        this.ride_time = ride_time;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_request, null, true);
        TextView reqstatus = (TextView) listViewItem.findViewById(R.id.reqstatus);
        TextView pickuppoint = (TextView) listViewItem.findViewById(R.id.pickup_point);
        TextView targetpoint = (TextView) listViewItem.findViewById(R.id.target_point);
        TextView ridedate = (TextView) listViewItem.findViewById(R.id.ride_date);
        TextView ridetime = (TextView) listViewItem.findViewById(R.id.ride_time);

        reqstatus.setText(req_status[position]);
        pickuppoint.setText(pickup_point[position]);
        targetpoint.setText(target_point[position]);
        ridedate.setText(ride_date[position]);
        ridetime.setText(ride_time[position]);
        return listViewItem;
    }
}
