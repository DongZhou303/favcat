package com.favcat;

import android.app.ActionBar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.favcat.fragment.CatDataList;
import com.favcat.fragment.DetailFragment;
import com.favcat.fragment.FavorityFragment;
import com.favcat.fragment.HomeFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private FrameLayout frameLayout;
    private RadioButton tab_search;
    private RadioButton tab_resule;
    private RadioButton tab_love;
    private RadioGroup tabBar;


    private FragmentManager manager;
    private FragmentTransaction transaction;
    private HomeFragment fragmenthome;
    private DetailFragment fragmentDetal;
    private FavorityFragment fragmentFav;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = this.findViewById(R.id.frameLayout);
        tabBar = this.findViewById(R.id.tab_home);
        tab_search = this.findViewById(R.id.tab_search);
        tab_resule = this.findViewById(R.id.tab_resule);
        tab_love = this.findViewById(R.id.tab_love);
        actionBar = this.getActionBar();

        RadioButton tabHome = (RadioButton) tabBar.getChildAt(0);
        tabHome.setChecked(true);
        tabBar.setOnCheckedChangeListener(this);
        initFragment();
    }

    private void initFragment() {
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        fragmenthome = new HomeFragment();

        fragmentDetal = new DetailFragment();
        fragmentFav = new FavorityFragment();
        transaction.add(R.id.frameLayout,fragmenthome);
        transaction.add(R.id.frameLayout,fragmentDetal);
        transaction.add(R.id.frameLayout,fragmentFav);
        hideAll(transaction);
        transaction.show(fragmenthome);
        transaction.commit();
    }




    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.tab_search:
                FragmentTransaction ft1 = manager.beginTransaction();
                hideAll(ft1);
                if (fragmenthome!=null){
                    ft1.show(fragmenthome);
                }else {
                    fragmenthome=new HomeFragment();
                    ft1.add(R.id.frameLayout,fragmenthome);
                }
                ft1.commit();
                if (actionBar!=null){
                    actionBar.setTitle("search");
                }
                break;
            case R.id.tab_resule:
                FragmentTransaction ft2 = manager.beginTransaction();
                hideAll(ft2);
                if (fragmentDetal!=null){
                    ft2.show(fragmentDetal);
                }else {
                    fragmentDetal = new DetailFragment();
                    ft2.add(R.id.frameLayout,fragmentDetal);
                }
                ft2.commit();
                if (actionBar!=null){
                    actionBar.setTitle("result");
                }
                break;
            case R.id.tab_love:
                FragmentTransaction ft5 = manager.beginTransaction();
                hideAll(ft5);
                if (fragmentFav!=null){
                    ft5.show(fragmentFav);
                }else {
                    fragmentFav = new FavorityFragment();
                    ft5.add(R.id.frameLayout, fragmentFav);
                }
                ft5.commit();
                if (actionBar!=null){
                    actionBar.setTitle("favorite");
                }
                break;
        }
    }

    private void hideAll(FragmentTransaction ft){
        if (ft==null){
            return;
        }
        if (fragmenthome!=null){
            ft.hide(fragmenthome);
        }
        if (fragmentDetal!=null){
            ft.hide(fragmentDetal);
        }
        if (fragmentFav!=null){
            ft.hide(fragmentFav);
        }
    }

    public void switcDetailDetail(CatDataList catDataList){
        FragmentTransaction ft2 = manager.beginTransaction();
        hideAll(ft2);
        if (fragmentDetal!=null){
            ft2.show(fragmentDetal);
        }else {
            fragmentDetal = new DetailFragment();
            ft2.add(R.id.frameLayout,fragmentDetal);
        }
        ft2.commit();

        tab_resule.setChecked(true);
        fragmentDetal.setData(catDataList);
        fragmentDetal.setimgResor();
    }

    private List<CatDataList> loveData;

    public void setLoveData(List<CatDataList> data){
        loveData = data;
        if (fragmentFav != null){
            fragmentFav.onResume();
        }
    }

    public List<CatDataList> getLoveData(){
        return loveData;
    }


}


