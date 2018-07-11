package com.example.lilingyun.recycleview_test;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.NormalViewHolder>{
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private  String[] mTitle;
    private int[] mPic;

    public RecyclerViewAdapter(Context context,String[] title,int[] pic){
        mContext=context;
        mTitle=title;
        mPic=pic;
        mLayoutInflater=LayoutInflater.from(context);
    }
    //自定义的ViewHolder，持有每个Item的所有界面元素
    public static class NormalViewHolder extends RecyclerView.ViewHolder{
        TextView mTextView;
        CardView mCardView;
        ImageView mImageView;
        public NormalViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_text);
            mCardView = (CardView) itemView.findViewById(R.id.cv_item);
            mImageView = (ImageView) itemView.findViewById(R.id.iv_pic);
        }
    }
    /*
    在该方法中我们创建一个ViewHolder并返回，ViewHolder必须有一个带有View的构造函数，
    这个View就是我们Item的根布局，在这里我们使用自定义Item的布局；
    */
    @Override
    public NormalViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        return new NormalViewHolder(mLayoutInflater.inflate(R.layout.view_item,parent,false));
    }
    //将数据与界面绑定
    @Override
    public void onBindViewHolder(NormalViewHolder holder,final int position) {
        holder.mTextView.setText(mTitle[position]);
        holder.mImageView.setBackgroundResource(mPic[position]);
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, mTitle[position],Toast.LENGTH_SHORT).show();
            }
        });
    }
        //获取数据量
        @Override
        public int getItemCount () {
            return mTitle == null ? 0 : mTitle.length;
        }
    }
