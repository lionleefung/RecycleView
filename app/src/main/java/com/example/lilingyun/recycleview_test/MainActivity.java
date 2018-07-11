package com.example.lilingyun.recycleview_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class  MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    //item 显示所需
    private String[] title = {"很晚很晚化合物",
            "谁拿了我的奶酪",
            "昨夜西风凋敝树 ",
            "左牵黄，右擎苍",
            "生存还是死亡",
            "还是个问题吗？",
    };

    private int[] pic = {R.mipmap.png1, R.mipmap.png2, R.mipmap.png3, R.mipmap.png4, R.mipmap.png5, R.mipmap.png6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        // 创建一个线性布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置垂直滚动，也可以设置横向滚动
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        //另外两种显示模式
        //  mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2)); Grid视图
        //  mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL)); 这里用线性宫格显示 类似于瀑布流

        //RecyclerView设置布局管理器
        mRecyclerView.setLayoutManager(layoutManager);
        //RecyclerView设置Adapter
        mRecyclerView.setAdapter(new RecyclerViewAdapter(this, title, pic));


    }



}
