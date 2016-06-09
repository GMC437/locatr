package com.wrightcontrol.locatr.locatr;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.*;
import android.widget.ImageView;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.wrightcontrol.locatr.R;

/**
 * Created by Grant on 09/06/2016.
 */
public class LocatrFragment extends Fragment {
    private ImageView mPlaceHolderImage;
    private GoogleApiClient mClient;


    public static LocatrFragment newInstance(){
        return new LocatrFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_locatr, container, false);

        instantiateWidgets(view);

        return view;
    }

    private void instantiateWidgets(View view){
        mPlaceHolderImage = (ImageView) view.findViewById(R.id.image_view_place_holder);
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        mClient = new GoogleApiClient.Builder(getActivity())
                .addApi(LocationServices.API)
                .build();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_locatr_menu, menu);
    }
}
