package byeongsu.soongsil.ac.kr.dogiyo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import byeongsu.soongsil.ac.kr.dogiyo.model.Store;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback  {

    static final String restaurant = "식사";
    static final String cafe = "카페";
    static final String cvs = "편의점";
    static final String beer = "술";

    private MapView mapView;
    private GoogleMap mMap;
    ArrayList<Integer> images = new ArrayList<>();


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

    public void addImages(){

        images.add(R.drawable._01);
        images.add(R.drawable._02);
        images.add(R.drawable._03);
        images.add(R.drawable._04);
        images.add(R.drawable._05);
        images.add(R.drawable._06);
        images.add(R.drawable._07);
        images.add(R.drawable._08);
        images.add(R.drawable._10); // 카페나무
        images.add(R.drawable._09); // 전주물갈비
        images.add(R.drawable._11);
        images.add(R.drawable._12);
        images.add(R.drawable._13);
        images.add(R.drawable._14);
        images.add(R.drawable._15);
        images.add(R.drawable.ic_launcher_background); // 당구장x
        images.add(R.drawable._17);
        images.add(R.drawable._18);
        images.add(R.drawable._19);
        images.add(R.drawable._20);
        images.add(R.drawable._21);
        images.add(R.drawable._22);
        images.add(R.drawable._23);
        images.add(R.drawable._24);
        images.add(R.drawable.ic_launcher_background); // 굴따리세븐일레븐
        images.add(R.drawable._25);
        images.add(R.drawable._26);
        images.add(R.drawable._27);
        images.add(R.drawable._28);
        images.add(R.drawable._29);
        images.add(R.drawable._30);
        images.add(R.drawable._31);
        images.add(R.drawable._32);
        images.add(R.drawable._33); // 빨강쭈꾸미
        images.add(R.drawable._34);
        images.add(R.drawable._35);
        images.add(R.drawable._36);
        images.add(R.drawable._37);

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
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tospia, 16));

        String[] storeName = getResources().getStringArray(R.array.store_name_array);
        String[] storeLat = getResources().getStringArray(R.array.store_latitude_array);
        String[] storeLng = getResources().getStringArray(R.array.store_longitude_array);
        String[] storeCategory = getResources().getStringArray(R.array.store_category);
        String[] storeTel = getResources().getStringArray(R.array.store_tel);

        addImages();

        for(int i = 0 ; i < storeName.length ; i++){

            float Lat = Float.parseFloat(storeLat[i]);
            float Lng = Float.parseFloat(storeLng[i]);

            LatLng store = new LatLng(Lat, Lng);

            // Settings for marker.
            Marker marker = mMap.addMarker(new MarkerOptions().position(store));
            marker.setTag(new Store(storeName[i], storeCategory[i], storeTel[i], images.get(i)));


            switch(storeCategory[i]){

                case restaurant:
                    marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.ic_restaurant));
                    break;

                case cafe:
                    marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cafe));
                    break;

                case cvs:
                    marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.ic_cvs));
                    break;

                case beer:
                    marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.ic_beer));
                    break;

                default:
                    // default setting
                    break;
            }



        }


    }
}
