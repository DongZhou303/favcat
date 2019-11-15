package com.favcat.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

import com.favcat.MainActivity;
import com.favcat.R;
import com.favcat.adapter.HomeRVAdapter;
import com.favcat.adapter.HomeRvLister;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class HomeFragment extends Fragment {

    private SearchView searchview;
    private RecyclerView hm_rv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View homeview = LayoutInflater.from(getContext()).inflate(R.layout.homefragment, null);
        searchview = homeview.findViewById(R.id.searchview);
        hm_rv = homeview.findViewById(R.id.hm_rv);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        hm_rv.setLayoutManager(manager);
        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                onNetWork(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                return false;
            }
        });
        return homeview;

    }

    private void onNetWork(final String breed){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try{
                    URL url = new URL("https://api.thecatapi.com/v1/images/search?breed_ids=" + breed);
                    connection = (HttpURLConnection)url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream in = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while((line = reader.readLine()) != null){
                        response.append(line);
                    }
                    retrunresult(response.toString());//更新ui
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if(reader != null){
                        try{
                            reader.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                    if(connection != null){
                        connection.disconnect();
                    }
                }
            }
        }

        ).start();
    }
    private void retrunresult(final String resultString){
        getActivity().runOnUiThread(new Runnable() {

            @Override
            public void run() {

                try {
                    Type type = new TypeToken<List<CatDataList>>() {
                    }.getType();
                    final List<CatDataList> catlist = new Gson().fromJson(resultString, type);
                    if (catlist.size() == 0){
                        Toast.makeText(getActivity(), "No Search", Toast.LENGTH_SHORT)
                                .show();

                        return;
                    }
                    HomeRVAdapter homeAdapter = new HomeRVAdapter(getActivity(), catlist);
                    homeAdapter.setonItemClickListner(new HomeRvLister() {
                        @Override
                        public void onclickpostion(int position) {
                            CatDataList catDataList = catlist.get(position);
                            ((MainActivity)getActivity()).switcDetailDetail(catDataList);
                        }
                    });
                    hm_rv.setAdapter(homeAdapter);
                }catch (Exception e){

                    Toast.makeText(getActivity(), "No Search", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }


}
