package com.favcat.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.favcat.R;
import com.favcat.fragment.CatDataList;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class HomeRVAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<CatDataList> catListBean;
    private HomeRvLister homeRvLister;

    public HomeRVAdapter(Context context, List<CatDataList> catListBean) {
        this.mContext = context;
        this.catListBean = catListBean;
        Log.e("初始化数据",""+catListBean.size());
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_rv_view, viewGroup, false);
        return new CatHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int position) {
        ((CatHolder) viewHolder).catname.setText(catListBean.get(position).getBreeds().get(0).getName());
        ((CatHolder) viewHolder).tv_des.setText(catListBean.get(position).getBreeds().get(0).getDescription());

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    HttpURLConnection conn = (HttpURLConnection) new URL(
                            catListBean.get(position).getUrl()).openConnection();
                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(1000 * 10);
                    conn.connect();

                    int code = conn.getResponseCode();
                    if (code == 200) {
                        InputStream is = conn.getInputStream();
                        final Bitmap bitmap = BitmapFactory.decodeStream(is);

                        ((Activity) mContext).runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                ((CatHolder) viewHolder).iv_catimg.setImageBitmap(bitmap);
                            }
                        });
                    }
                } catch (Exception e) {

                }
            }
        }).start();

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (homeRvLister != null) {
                    homeRvLister.onclickpostion(position);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return catListBean.size();
    }

    private class CatHolder extends RecyclerView.ViewHolder {

        private TextView catname;
        private ImageView iv_catimg;
        private TextView tv_des;


        public CatHolder(final View itemView) {
            super(itemView);
            catname = (TextView) itemView.findViewById(R.id.tv_catname);
            iv_catimg = (ImageView) itemView.findViewById(R.id.iv_catimg);
            tv_des = (TextView) itemView.findViewById(R.id.tv_des);
        }
    }


    public void setonItemClickListner(HomeRvLister homeRvLister) {
        this.homeRvLister = homeRvLister;
    }
}
