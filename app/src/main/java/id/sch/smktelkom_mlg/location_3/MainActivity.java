package id.sch.smktelkom_mlg.location_3;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    static final CameraPosition BLITAR = CameraPosition.builder()
            .target(new LatLng(-8.095463, 112.160906))
            .zoom(10)
            .bearing(0)
            .tilt(45)
            .build();
    GoogleMap m_map;
    boolean mapReady = false;
    MarkerOptions Srengat;
    MarkerOptions Dandong;
    MarkerOptions Langon;
    MarkerOptions Bagelen;
    MarkerOptions Ponggok;

    @Override
    public Resources getResources() {
        return super.getResources();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Srengat = new MarkerOptions()
                .position(new LatLng(-8.085849, 112.05956))
                .title("Srengat")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_place_black_24dp));

        Dandong = new MarkerOptions()
                .position(new LatLng(-8.063434, 112.069951))
                .title("Dandong")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_place_black_24dp));

        Langon = new MarkerOptions()
                .position(new LatLng(-8.048335, 112.067012))
                .title("Langon")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_place_black_24dp));

        Bagelen = new MarkerOptions()
                .position(new LatLng(-8.061311, 112.086387))
                .title("Bagelen")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_place_black_24dp));

        Ponggok = new MarkerOptions()
                .position(new LatLng(-8.051389, 112.08))
                .title("Ponggok")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_place_black_24dp));

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        //MapsInitializer.initialize(getApplicationContext());
        mapReady = true;
        m_map = map;
        m_map.addMarker(Srengat);
        m_map.addMarker(Langon);
        m_map.addMarker(Dandong);
        m_map.addMarker(Bagelen);
        m_map.addMarker(Ponggok);
        flyTo(BLITAR);
    }

    private void flyTo(CameraPosition target) {
        m_map.moveCamera(CameraUpdateFactory.newCameraPosition(target));
    }
}
