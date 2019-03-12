package com.example.recyclerviewpool;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by air on 2019/3/12.
 */
public class MyPagerAdapter extends PagerAdapter{
    private Context context;
    private SparseArray<RecyclerView> sparseArray= new SparseArray<>();
    private RecyclerView.RecycledViewPool pool;
    MyPagerAdapter(Context context){
        this.context=context;
    }
    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        RecyclerView recyclerView;
        if (sparseArray.get(position)==null){

            recyclerView=new RecyclerView(context);
            if (pool==null){
                pool=recyclerView.getRecycledViewPool();
                pool.setMaxRecycledViews(0,8);
            }
            else {
                recyclerView.setRecycledViewPool(pool);
            }
            recyclerView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context);
            linearLayoutManager.setRecycleChildrenOnDetach(true);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(new ListAdapter(context));
            sparseArray.put(position,recyclerView);

        }
        else {
            recyclerView=sparseArray.get(position);
        }

        container.addView(recyclerView);
        return recyclerView;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
