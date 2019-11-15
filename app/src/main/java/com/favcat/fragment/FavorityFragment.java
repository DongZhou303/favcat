package com.favcat.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.favcat.MainActivity;
import com.favcat.R;
import com.favcat.adapter.HomeRVAdapter;

import java.util.List;

public class FavorityFragment extends Fragment {

    private RecyclerView rv_fav;
    private TextView tv_nocontent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View favorityfragment = LayoutInflater.from(getContext()).inflate(R.layout.favorityfragment, null);
        tv_nocontent = favorityfragment.findViewById(R.id.tv_nocontent);
        rv_fav = favorityfragment.findViewById(R.id.rv_fav);

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        rv_fav.setLayoutManager(manager);
        return favorityfragment;

    }

    @Override
    public void onResume() {
        super.onResume();

        List<CatDataList> loveData = ((MainActivity) getActivity()).getLoveData();

        if (loveData !=null){
            Log.e("获取数据",loveData.toString());
            tv_nocontent.setVisibility(View.GONE);
            rv_fav.setVisibility(View.VISIBLE);
            HomeRVAdapter homeAdapter = new HomeRVAdapter(getActivity(), loveData);
            rv_fav.setAdapter(homeAdapter);
        }else {
            tv_nocontent.setVisibility(View.VISIBLE);
            rv_fav.setVisibility(View.GONE);
        }

    }


}
