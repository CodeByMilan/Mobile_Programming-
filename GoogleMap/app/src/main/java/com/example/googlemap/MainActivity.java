package com.example.googlemap;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap gmap;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapactivity);
        SupportMapFragment mfragmet = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        if(mfragmet!=null){
            mfragmet.getMapAsync(this);
        }

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        gmap=googleMap;
        LatLng location = new LatLng(-34,151);
        gmap.addMarker(new MarkerOptions().position(location).title("Sydney"));
        gmap.moveCamera(CameraUpdateFactory.newLatLngZoom(location,15));
    }
}
