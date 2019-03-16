package mx.itesm.location;

import android.Manifest;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.security.Security;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        String locationProvider = LocationManager.GPS_PROVIDER;
        String[] p = {Manifest.permission.ACCESS_FINE_LOCATION};
        try {
            ActivityCompat.requestPermissions(this, p, 1);
            Location lastLocation = locationManager.getLastKnownLocation(locationProvider);
            // Add a marker in Sydney and move the camera
            LatLng ll = new LatLng(lastLocation.getLatitude(), lastLocation.getLongitude());
            mMap.addMarker(new MarkerOptions().position(ll).title("Marker"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(ll));
            Toast.makeText(this, "showing your location", Toast.LENGTH_LONG).show();
        }catch(SecurityException e){
            Toast.makeText(this, "run again with permissions enabled or add api key", Toast.LENGTH_LONG).show();
        }
    }
}
