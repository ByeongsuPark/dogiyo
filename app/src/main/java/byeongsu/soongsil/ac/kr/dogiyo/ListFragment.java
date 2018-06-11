package byeongsu.soongsil.ac.kr.dogiyo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import byeongsu.soongsil.ac.kr.dogiyo.adapter.StoreAdapter;
import byeongsu.soongsil.ac.kr.dogiyo.model.ListStore;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    List<ListStore> list;
    StoreAdapter adapter;
    ListView listView;
    String[] storeName;
    String[] storeCategory;
    String[] storeTel;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        storeName = getActivity().getResources().getStringArray(R.array.store_name_array);
        storeCategory = getActivity().getResources().getStringArray(R.array.store_category);
        storeTel = getActivity().getResources().getStringArray(R.array.store_tel);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View parentView = inflater.inflate(R.layout.tap_list, container, false);

        list = new ArrayList<ListStore>();
        listView = (ListView)parentView.findViewById(R.id.listView);
        adapter = new StoreAdapter(getActivity(), R.layout.list_item, list);
        itemAdd();
        listView.setAdapter(adapter);


        // Inflate the layout for this fragment
        return parentView;
    }

    public void itemAdd(){


        // 리스트 생성
        for(int i = 0 ; i < storeName.length ; i++){
            adapter.add(new ListStore(storeName[i], storeCategory[i], storeTel[i], false));
        }


    }

}
