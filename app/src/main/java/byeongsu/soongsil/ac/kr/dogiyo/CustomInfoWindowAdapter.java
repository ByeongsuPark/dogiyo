package byeongsu.soongsil.ac.kr.dogiyo;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

import byeongsu.soongsil.ac.kr.dogiyo.model.Store;

/**
 * Created by bosslab on 18. 6. 10.
 */

public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    private Activity context;

    public CustomInfoWindowAdapter(Activity context) {
        this.context = context;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {

        View viewParent = context.getLayoutInflater().inflate(R.layout.custom_info_window, null);

        TextView storeName = (TextView)viewParent.findViewById(R.id.store_name);
        TextView storeCategory = (TextView)viewParent.findViewById(R.id.store_category);
        TextView storeTel = (TextView)viewParent.findViewById(R.id.store_tel);

        Store store = (Store)marker.getTag();

        storeName.setText(store.getStoreName());
        storeCategory.setText(store.getStoreCategory());
        storeTel.setText(store.getStoreTel());

        return viewParent;
    }
}
