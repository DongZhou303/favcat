package com.favcat.fragment;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.favcat.MainActivity;
import com.favcat.R;
import com.favcat.adapter.HomeRVAdapter;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DetailFragment extends Fragment {

    private TextView cat_hint;
    private LinearLayout ll_catinfo_contain;
    private ImageView iv_catimg;
    private ImageView iv_love;
    private TextView catname;
    private TextView temperament;
    private TextView weight;
    private TextView origin;
    private TextView lifespan;
    private TextView wikipedialink;
    private TextView dogfriendlinesslevel;
    private TextView describe;
    private List<CatDataList> loveData;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View detailView = LayoutInflater.from(getContext()).inflate(R.layout.detail_fragment, null);
        cat_hint = detailView.findViewById(R.id.cat_hint);
        ll_catinfo_contain = detailView.findViewById(R.id.ll_catinfo_contain);
        ll_catinfo_contain.setVisibility(View.GONE);
        cat_hint.setVisibility(View.VISIBLE);

        iv_catimg = detailView.findViewById(R.id.iv_catimg);
        iv_love = detailView.findViewById(R.id.iv_love);
        catname = detailView.findViewById(R.id.catname);
        temperament = detailView.findViewById(R.id.Temperament);
        weight = detailView.findViewById(R.id.Weight);
        origin = detailView.findViewById(R.id.Origin);
        lifespan = detailView.findViewById(R.id.Lifespan);
        wikipedialink = detailView.findViewById(R.id.Wikipedialink);
        dogfriendlinesslevel = detailView.findViewById(R.id.Dogfriendlinesslevel);
        describe = detailView.findViewById(R.id.describe);

        Log.e("zhixing","onCreateView");

        return detailView;
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    public void setimgResor(){
        iv_love.setImageDrawable(getResources().getDrawable(R.drawable.tab_love_select));
    }



    public void setData(final CatDataList catDataList) {
        Log.e("zhixing","setData");
        if (catDataList != null){
            cat_hint.setVisibility(View.GONE);
            ll_catinfo_contain.setVisibility(View.VISIBLE);
            catname.setText("" + catDataList.getBreeds().get(0).getName());
            describe.setText("" + catDataList.getBreeds().get(0).getDescription());

            weight.setText("" + catDataList.getBreeds().get(0).getWeight().toString());
            temperament.setText("" + catDataList.getBreeds().get(0).getTemperament());
            origin.setText("" + catDataList.getBreeds().get(0).getOrigin());
            lifespan.setText("" + catDataList.getBreeds().get(0).getLife_span());
            wikipedialink.setText("" + catDataList.getBreeds().get(0).getWikipedia_url());
            dogfriendlinesslevel.setText("" + catDataList.getBreeds().get(0).getDog_friendly());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        HttpURLConnection conn = (HttpURLConnection) new URL(
                                catDataList.getUrl()).openConnection();
                        conn.setRequestMethod("GET");
                        conn.setConnectTimeout(1000 * 10);
                        conn.connect();

                        int code = conn.getResponseCode();
                        if (code == 200) {
                            InputStream is = conn.getInputStream();
                            final Bitmap bitmap = BitmapFactory.decodeStream(is);

                            (getActivity()).runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    iv_catimg.setImageBitmap(bitmap);
                                }
                            });
                        }
                    } catch (Exception e) {

                    }
                }
            }).start();



            iv_love.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    loveData = ((MainActivity) getActivity()).getLoveData();
                    if (loveData ==null){
                        loveData = new ArrayList<CatDataList>();
                        loveData.add(catDataList);
                    }else {
                        loveData.add(catDataList);
                    }

                    ((MainActivity) getActivity()).setLoveData(loveData);
                    iv_love.setImageDrawable(getResources().getDrawable(R.drawable.ic_love));
                    Toast.makeText(getActivity(), "successs", Toast.LENGTH_SHORT)
                            .show();
                }
            });
        }else {
            cat_hint.setVisibility(View.VISIBLE);
            ll_catinfo_contain.setVisibility(View.GONE);
        }


    }
}
