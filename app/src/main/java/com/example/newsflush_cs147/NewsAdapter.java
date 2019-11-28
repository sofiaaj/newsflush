package com.example.newsflush_cs147;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<News> mNews;

    public NewsAdapter(List<News> news) {
        mNews = news;
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View newsView = inflater.inflate(R.layout.item_news, parent, false);

        // Return a new holder instance
        ViewHolder newsHolder = new ViewHolder(newsView);
        return newsHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        News currNews = mNews.get(position);
        TextView category = holder.tvCategory;
        TextView headline = holder.tvHeadline;
        TextView summary = holder.tvSummary;
        TextView time = holder.tvTime;
        category.setText(currNews.getCategory());
        headline.setText(currNews.getHeadline());
        summary.setText(currNews.getSummary());
        time.setText(currNews.getTime());
    }

    @Override
    public int getItemCount() {
        return mNews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvCategory;
        public TextView tvHeadline;
        public TextView tvSummary;
        public TextView tvTime;

        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            tvCategory = (TextView) itemView.findViewById(R.id.tvCategory);
            tvHeadline = (TextView) itemView.findViewById(R.id.tvHeadline);
            tvSummary = (TextView) itemView.findViewById(R.id.tvSummary);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);

        }


    }
}
