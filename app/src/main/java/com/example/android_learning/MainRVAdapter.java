package com.example.android_learning;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private Context mContext;
    private ArrayList<Article> mArrayList;

    MainRVAdapter(Context context, ArrayList<Article> arrayList) {
        this.mContext = context;
        this.mArrayList = arrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder vh = (ViewHolder) viewHolder;
        Article article = mArrayList.get(i);
        vh.tvUser.setText(article.getUser());
        vh.tvTitle.setText(article.getTitle());
        vh.tvContent.setText(article.getContent());
        vh.tvDatetime.setText(article.getDatetime());

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private TextView tvContent;
        private TextView tvDatetime;
        private TextView tvUser;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvContent = itemView.findViewById(R.id.tv_content);
            tvDatetime = itemView.findViewById(R.id.tv_datetime);
            tvUser = itemView.findViewById(R.id.tv_user);
        }
    }

    @Override
    public int getItemCount() {
        if (mArrayList != null) {
            return mArrayList.size();
        }
        return 0;
    }

    @Override
    public void onClick(View v) {

    }
}
