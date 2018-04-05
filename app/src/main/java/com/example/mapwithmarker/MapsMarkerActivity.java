package com.example.mapwithmarker;

import android.location.Location;
import android.location.LocationProvider;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * An activity that displays a Google map with a marker (pin) to indicate a particular location.
 */
public class MapsMarkerActivity extends AppCompatActivity
        implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retrieve the content view that renders the map.
        setContentView(R.layout.activity_maps);
        // Get the SupportMapFragment and request notification
        // when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        //Location l = new Location();
    }

    /**
     * Manipulates the map when it's available.
     * The API invokes this callback when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user receives a prompt to install
     * Play services inside the SupportMapFragment. The API invokes this method after the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Add a marker in Sydney, Australia,
        // and move the map's camera to the same location.
        LatLng sydney = new LatLng(-33.852, 151.211);
        /*googleMap.addMarker(new MarkerOptions().position(sydney)
                .title("Marker in Sydney"));*/
        //googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        //aths location object
        Location MyLocation = googleMap.getMyLocation();
        LatLng MyCurrentLocation = new LatLng(MyLocation.getLatitude(), MyLocation.getLongitude());
        LatLng pctAths = new LatLng(41.233950, -77.026130);
        Location pctAths2 = new Location(pctAths.toString());
        pctAths2.distanceTo(MyLocation);
        googleMap.addMarker(new MarkerOptions().position(pctAths)
                .title("It's the aths!"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(pctAths));




    }
}
