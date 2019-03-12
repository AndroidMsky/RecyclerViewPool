# RecyclerViewPool
RecyclerViewPool heap show RecycledViewPool的使用和堆内存分析

Pool使用核心代码
MainCode in ViewPagerAdapter:



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
--------------------- 
作者：AndroidMsky 
来源：CSDN 
原文：https://blog.csdn.net/AndroidMsky/article/details/88427160 
