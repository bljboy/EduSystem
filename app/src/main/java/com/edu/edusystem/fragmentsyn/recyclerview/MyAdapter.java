package com.edu.edusystem.fragmentsyn.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.edu.edusystem.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHoldler> {
    private Context mcontext;
    private OnItemClickListener onItemClickListener;
    private List<Items> list;
    Boolean aBoolean = true;

    public MyAdapter(Context context, List<Items> list, OnItemClickListener onItemClickListener) {
        this.mcontext = context;
        this.list = list;
        this.onItemClickListener = onItemClickListener;

    }

    @NonNull
    @Override
    public MyAdapter.MyHoldler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHoldler(LayoutInflater.from(mcontext).inflate(R.layout.item_layout, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull final MyHoldler holder, final int position) {
        Items items = list.get(position);
        holder.title.setText(items.getTitle());
        holder.time.setText(items.getTime());
        holder.many.setText(items.getMany());
        holder.money.setText(items.getMoney());
        holder.name.setText(items.getName());
        holder.syn_selected_love_item.setBackgroundResource(items.getImage());
        Glide.with(mcontext)
                .load(items.getTeacher())
                .error(R.drawable.ic_launcher_background)
                .into(holder.teacher);

        holder.syn_selected_love_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onClick(position);
                if (aBoolean) {
                    aBoolean = false;
                    holder.syn_selected_love_item.setBackgroundResource(R.drawable.ic_baseline_favorite_24);
                } else {
                    aBoolean = true;
                    holder.syn_selected_love_item.setBackgroundResource(R.drawable.ic_baseline_favorite_border_24);
                }


            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyHoldler extends RecyclerView.ViewHolder {
        TextView title;
        TextView time;
        TextView many;
        TextView money;
        TextView name;
        ImageView teacher;
        TextView syn_selected_love_item;

        public MyHoldler(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.syn_selected_title_item);
            time = itemView.findViewById(R.id.syn_selected_time_item);
            many = itemView.findViewById(R.id.syn_selected_many_item);
            money = itemView.findViewById(R.id.syn_selected_money_item);
            name = itemView.findViewById(R.id.syn_selected_name_item);
            teacher = itemView.findViewById(R.id.syn_selected_teacher_item);
            syn_selected_love_item = itemView.findViewById(R.id.syn_selected_love_item);
        }
    }

    public interface OnItemClickListener {
        void onClick(int pos);
    }
}
