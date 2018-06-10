package byeongsu.soongsil.ac.kr.dogiyo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import byeongsu.soongsil.ac.kr.dogiyo.model.Store;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback  {

    private MapView mapView;
    private GoogleMap mMap;

    public MapFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab_map, container, false);

        // Gets the MapView form the XML layout and creates it
        mapView = (MapView)v.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);




        // Inflate the layout for this fragment
        return v;
    }


    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        CustomInfoWindowAdapter adapter = new CustomInfoWindowAdapter(getActivity());
        mMap.setInfoWindowAdapter(adapter);

        LatLng tospia = new LatLng(37.239171, 129.045525);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(tospia));

        String[] storeName = getResources().getStringArray(R.array.store_name_array);
        String[] storeLat = getResources().getStringArray(R.array.store_latitude_array);
        String[] storeLng = getResources().getStringArray(R.array.store_longitude_array);
        String[] storeCategory = getResources().getStringArray(R.array.store_category);
        String[] storeTel = getResources().getStringArray(R.array.store_tel);

        for(int i = 0 ; i < storeName.length ; i++){

            float Lat = Float.parseFloat(storeLat[i]);
            float Lng = Float.parseFloat(storeLng[i]);

            LatLng store = new LatLng(Lat, Lng);

            mMap.addMarker(new MarkerOptions().position(store))
            .setTag(new Store(storeName[i], storeCategory[i], storeTel[i]));
        } 


    }
}
