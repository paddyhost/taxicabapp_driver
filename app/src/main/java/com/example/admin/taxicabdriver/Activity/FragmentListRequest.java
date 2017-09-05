package com.example.admin.taxicabdriver.Activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.admin.taxicabdriver.R;

public class FragmentListRequest extends Fragment {
    private Button gobutton;
    private ImageView imgstatus;
    private TextView status, txtstatus, status_text;

    private ListView listrides;
    private String req_status[] = {
            "New",
            "Completed",
            "Completed",
            "Completed"
    };
    private String pickup_point[] = {
            "STPI, Chikalthana MIDC, Cidco",
            "SB College, Aurangpura",
            "Jadhavmandi, Aurangabad",
            "Railway Station, Aurangabad"
    };
    private String target_point[] = {
            "N-8, Cidco, Aurangabad",
            "Babapetrol pump, Aurangabad",
            "Chikalthana, Aurangabad",
            "Sanjay nagar, Mukundwadi, Aurangabad"
    };
    private String ride_date[] = {
            "30-08-2017",
            "29-08-2017",
            "28-08-2017",
            "27-08-2017"
    };
    private String ride_time[] = {
            "11:15 AM",
            "12:00 PM",
            "01:00 PM",
            "10:30 AM"
    };
    View view;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_list_request, container, false);
        imgstatus = (ImageView) view.findViewById(R.id.imgstatus);
        status = (TextView) view.findViewById(R.id.status);
        txtstatus = (TextView) view.findViewById(R.id.txtstatus);
        status_text = (TextView) view.findViewById(R.id.status_text);
        gobutton = (Button) view.findViewById(R.id.btn_changestatus);
        gobutton.setTag(1);
        gobutton.setText("Go online");
        gobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int statustag =(Integer) v.getTag();
                if(statustag == 1) {
                    gobutton.setText("Go offline");
                    status.setText("Online");
                    status.setTextColor(Color.rgb(34,34,34));
                    status.setBackgroundColor(Color.rgb(223,252,224));
                    imgstatus.setImageResource(R.drawable.ic_car_with_signal_online);
                    txtstatus.setText("You are online");
                    txtstatus.setTextColor(Color.rgb(60,128,30));
                    status_text.setText("Keep online to receive request !");
                    v.setTag(0);
                }else{
                    gobutton.setText("Go online");
                    status.setText("Offline");
                    status.setTextColor(Color.rgb(194,15,15));
                    status.setBackgroundColor(Color.rgb(255,236,240));
                    imgstatus.setImageResource(R.drawable.ic_car_with_signal);
                    txtstatus.setText("You are offline");
                    txtstatus.setTextColor(Color.rgb(221,42,42));
                    status_text.setText("Go online to receive request !");
                    v.setTag(1);
                }

            }
        });
        RequestList requestList = new RequestList(getActivity(), req_status, pickup_point, target_point, ride_date, ride_time);
        listrides =(ListView)view.findViewById(R.id.listreq);
        listrides.setAdapter(requestList);
        listrides.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.framestatus, new FragmentRideDetails());
                ft.commit();
            }
        });
        return view;
    }
}
