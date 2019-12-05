package com.example.newsflush_cs147;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<News> mNews;
    Context context;

    public NewsAdapter(List<News> news) {
        mNews = news;
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
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
        time.setText(currNews.getTime() + " Minutes");
        if(currNews.getCategory().equals("Health")){
            holder.ivIcon.setImageResource(R.drawable.icon_health);
        } else if(currNews.getCategory().equals("Climate")){
            holder.ivIcon.setImageResource(R.drawable.icon_climate);
        } else if(currNews.getCategory().equals("Tech")){
            holder.ivIcon.setImageResource(R.drawable.icon_tech);
        } else if(currNews.getCategory().equals("Business")){
            holder.ivIcon.setImageResource(R.drawable.icon_business);
        } else if(currNews.getCategory().equals("Local")){
            holder.ivIcon.setImageResource(R.drawable.icon_local);
        } else if(currNews.getCategory().equals("Sports")){
            holder.ivIcon.setImageResource(R.drawable.icon_sports);
        } else if(currNews.getCategory().equals("Science")){
            holder.ivIcon.setImageResource(R.drawable.icon_science);
        } else if(currNews.getCategory().equals("Politics")){
            holder.ivIcon.setImageResource(R.drawable.icon_politics);
        } else if(currNews.getCategory().equals("Art")){
            holder.ivIcon.setImageResource(R.drawable.icon_art);
        }

    }

    @Override
    public int getItemCount() {
        return mNews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView tvCategory;
        public TextView tvHeadline;
        public TextView tvSummary;
        public TextView tvTime;
        public ImageView ivIcon;

        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            tvCategory = (TextView) itemView.findViewById(R.id.tvCategory);
            tvHeadline = (TextView) itemView.findViewById(R.id.tvHeadline);
            tvSummary = (TextView) itemView.findViewById(R.id.tvSummary);
            tvTime = (TextView) itemView.findViewById(R.id.tvTime);
            ivIcon = (ImageView) itemView.findViewById(R.id.ivIcon);
            tvCategory.setOnClickListener(this);
            tvHeadline.setOnClickListener(this);
            tvSummary.setOnClickListener(this);
            tvTime.setOnClickListener(this);
            ivIcon.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            final News currNews = mNews.get(position);
            Intent i = new Intent(context, SelectInterests.class);
            context.startActivity(i);
        }
    }
}
