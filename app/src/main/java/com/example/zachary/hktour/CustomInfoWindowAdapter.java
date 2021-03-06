package com.example.zachary.hktour;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {
    private final View mWindow;
    private Context mContext;


    public CustomInfoWindowAdapter(Context context){
        mContext = context;
        mWindow = LayoutInflater.from(mContext).inflate(R.layout.custom_info_window_button, (ViewGroup)null);
    }

    private void renderWindowText(Marker marker, View view){
        String title = marker.getTitle();
        TextView tvTitle = (TextView) view.findViewById(R.id.title);
        String snippet = marker.getSnippet();
        TextView tvSnippet = (TextView) view.findViewById(R.id.snippet);
        if(snippet != null){
            tvSnippet.setText(snippet);
        }
        if(title != null){
            tvTitle.setText(title);
        }
    }

    @Override
    public View getInfoContents(Marker marker) {
        renderWindowText(marker,mWindow);
        return mWindow;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        renderWindowText(marker,mWindow);
        return mWindow;
    }

}
