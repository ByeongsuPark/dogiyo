package byeongsu.soongsil.ac.kr.dogiyo.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import byeongsu.soongsil.ac.kr.dogiyo.R;
import byeongsu.soongsil.ac.kr.dogiyo.model.ListStore;

/**
 * Created by bosslab on 18. 6. 11.
 */

public class StoreAdapter extends ArrayAdapter<ListStore> {

    Activity activity;
    int resource;

    public StoreAdapter( Context context, int resource, List<ListStore> objects) {
        super(context, resource, objects);
        activity = (Activity)context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // ListView에게 되돌려받은 레이아웃 객체
        View itemView = convertView;

        // 최초 호출시에는 null 이므로 생성자의 파라미터로 전달받은 리소스 아이디 값을
        // 사용하여 레이아웃을 생성
        if(itemView == null)
            itemView = activity.getLayoutInflater().inflate(resource, null);

        // 전달받은  list에서 데이터를 꺼낸다
        ListStore item = getItem(position);

        // 데이터가 존재한다면 레이아웃 객체에 포함된 컴포넌트 들에게 데이터를 출ㄹ력
        if( item != null){
            TextView storeName = (TextView)itemView.findViewById(R.id.list_store_name);
            TextView storeCategory = (TextView)itemView.findViewById(R.id.list_store_category);
            TextView storeTel = (TextView)itemView.findViewById(R.id.list_store_tel);
            ImageButton favorite = (ImageButton)itemView.findViewById(R.id.list_star_button);

            storeName.setText(item.getStoreName());
            storeCategory.setText(item.getStoreCategory());
            storeTel.setText(item.getStoreTel());

            if(item.isFavorite())
                favorite.setBackgroundResource(R.drawable.ic_full_star);
            else
                favorite.setBackgroundResource(R.drawable.ic_empty_star);

        }

        return itemView;
    }
}
