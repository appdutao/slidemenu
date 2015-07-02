package com.dutao.slidemenu.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.dutao.slidemenu.MainActivity;
import com.dutao.slidemenu.R;
import com.dutao.slidemenu.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dutao on 2015/7/1.
 */
public class MenuFragment extends Fragment {

    private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //返回需要的View
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.list_view, null);
        return view;
    }

    //数据填充
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ListView list_view = (ListView)view.findViewById(R.id.list_view);
        list_view.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,android.R.id.text1,initData()));

        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 BaseFragment fragment = null;
                 switch (i){
                     case 0:
                         fragment = new ContentFragment0();
                     case 1:
                         fragment = new ContentFragment1();
                     case 2:
                         fragment = new ContentFragment2();
                     case 3:
                         fragment = new ContentFragment3();
                     case 4:
                         fragment = new ContentFragment4();
                 }
                 switchContent2Fragment(fragment);
             }
         }
        );
    }

    private void switchContent2Fragment(Fragment fragment){
        if(getActivity() instanceof MainActivity){
            ((MainActivity)getActivity()).switchContent2Fragment(fragment);
        }
    }

    private List<String> initData() {
        List<String> list_data = new ArrayList<String>();
        list_data.add("fragment1");
        list_data.add("fragment2");
        list_data.add("fragment3");
        list_data.add("fragment4");
        list_data.add("fragment5");
        return list_data;
    }
}
