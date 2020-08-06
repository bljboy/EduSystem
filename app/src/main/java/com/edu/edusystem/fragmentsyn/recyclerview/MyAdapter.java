package com.edu.edusystem.fragmentsyn.recyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.nfc.Tag;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.edu.edusystem.R;
import com.edu.edusystem.tools.DBHelper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHoldler> {
    private Context mcontext;
    private OnItemClickListener onItemClickListener;
    private List<Items> list;
    boolean aBoolean1 = false; // 张雪峰
    boolean aBoolean2 = false; //化学
    boolean aBoolean3 = false;//语文
    boolean aBoolean4 = false;//数学
    boolean aBoolean5 = false;//生物
    String TAG = "MyAdapter";
    JsonObject jsonObject;
    JsonArray array;
    String jsonMysql = ""; // 云端的json数据

    String type;
    String user;

    public MyAdapter(Context context, List<Items> list, OnItemClickListener onItemClickListener, String jsonMysql, String type, String user) {
        this.mcontext = context;
        this.list = list;
        this.onItemClickListener = onItemClickListener;
        this.jsonMysql = jsonMysql;
        this.type = type;
        this.user = user;
        //Log.i("jsonMysql>>>>>>>>>", jsonMysql);
        //Log.i("list>>>>>>>>>", list.toString());
    }


    @NonNull
    @Override
    public MyAdapter.MyHoldler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHoldler(LayoutInflater.from(mcontext).inflate(R.layout.item_layout, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull final MyHoldler holder, final int position) {

        final Items items = list.get(position);
        holder.title.setText(items.getTitle());
        holder.time.setText(items.getTime());
        holder.many.setText(items.getMany());
        holder.money.setText(items.getMoney());
        holder.name.setText(items.getName());
        holder.syn_selected_love_item.setBackgroundResource(items.getImage());
        final android.os.Handler handler = new android.os.Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message message) {
                if (message.what == 1) {
                    if (aBoolean1) {
                        aBoolean1 = false;
                        holder.syn_selected_love_item.setBackgroundResource(R.drawable.ic_baseline_favorite_24);
                    } else if (aBoolean2) {
                        aBoolean2 = false;
                        holder.syn_selected_love_item.setBackgroundResource(R.drawable.ic_baseline_favorite_24);
                    } else if (aBoolean3) {
                        aBoolean3 = false;
                        holder.syn_selected_love_item.setBackgroundResource(R.drawable.ic_baseline_favorite_24);
                    } else if (aBoolean4) {
                        aBoolean4 = false;
                        holder.syn_selected_love_item.setBackgroundResource(R.drawable.ic_baseline_favorite_24);
                    } else if (aBoolean5) {
                        aBoolean5 = false;
                        holder.syn_selected_love_item.setBackgroundResource(R.drawable.ic_baseline_favorite_24);

                    }
                }
                return false;
            }
        });

        JsonParser parser = new JsonParser();
        jsonObject = (JsonObject) parser.parse(jsonMysql);
        array = jsonObject.getAsJsonArray("data");

        for (int i = 0; i < array.size(); i++) {
            JsonObject object = array.get(i).getAsJsonObject();
            String course = object.get("class").getAsString();
            if (course.equals(items.getTitle())) {
                holder.syn_selected_love_item.setBackgroundResource(R.drawable.ic_baseline_favorite_24);

            }
            if (course.equals("张雪峰高考志愿填报精品课")) {
                aBoolean1 = true;
            } else if (course.equals("2021高考化学全程班")) {
                aBoolean2 = true;
            } else if (course.equals("2021高考语文全程班")) {
                aBoolean3 = true;
            } else if (course.equals("2021高考数学全程班")) {
                aBoolean4 = true;
            } else if (course.equals("2021高考生物全程班")) {
                aBoolean5 = true;
            }
        }


        Glide.with(mcontext)
                .load(items.getTeacher())
                .error(R.drawable.ic_launcher_background)
                .into(holder.teacher);

        //love
        holder.syn_selected_love_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onClick(position);
                if (position == 0) {
                    if (!aBoolean1) {
                        aBoolean1 = true;
                        holder.syn_selected_love_item.setBackgroundResource(R.drawable.ic_baseline_favorite_24);
                        jsonadd(items.getTitle(), user);
                    } else {
                        //not love
                        aBoolean1 = false;
                        holder.syn_selected_love_item.setBackgroundResource(R.drawable.ic_baseline_favorite_border_24);
                        jsonremove(items.getTitle(), user);
                    }
                } else if (position == 1) {
                    if (!aBoolean2) {
                        aBoolean2 = true;
                        holder.syn_selected_love_item.setBackgroundResource(R.drawable.ic_baseline_favorite_24);
                        jsonadd(items.getTitle(), user);
                    } else {
                        //not love
                        aBoolean2 = false;
                        holder.syn_selected_love_item.setBackgroundResource(R.drawable.ic_baseline_favorite_border_24);
                        jsonremove(items.getTitle(), user);

                    }

                } else if (position == 2) {
                    if (!aBoolean3) {
                        aBoolean3 = true;
                        holder.syn_selected_love_item.setBackgroundResource(R.drawable.ic_baseline_favorite_24);
                        jsonadd(items.getTitle(), user);

                    } else {
                        //not love
                        aBoolean3 = false;
                        holder.syn_selected_love_item.setBackgroundResource(R.drawable.ic_baseline_favorite_border_24);
                        jsonremove(items.getTitle(), user);


                    }

                } else if (position == 3) {
                    if (!aBoolean4) {
                        aBoolean4 = true;
                        holder.syn_selected_love_item.setBackgroundResource(R.drawable.ic_baseline_favorite_24);
                        jsonadd(items.getTitle(), user);
                    } else {
                        //not love
                        aBoolean4 = false;
                        holder.syn_selected_love_item.setBackgroundResource(R.drawable.ic_baseline_favorite_border_24);
                        jsonremove(items.getTitle(), user);
                    }

                } else {
                    if (!aBoolean5) {
                        aBoolean5 = true;
                        holder.syn_selected_love_item.setBackgroundResource(R.drawable.ic_baseline_favorite_24);
                        jsonadd(items.getTitle(), user);

                    } else {
                        //not love
                        aBoolean5 = false;
                        holder.syn_selected_love_item.setBackgroundResource(R.drawable.ic_baseline_favorite_border_24);
                        jsonremove(items.getTitle(), user);
                    }
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

        void onItemClick(View v);
    }

    /**
     * json数据添加到云数据库
     *
     * @param gettitle
     * @param user
     */

    String sql;

    @SuppressLint("LongLogTag")
    public void jsonadd(final String gettitle, final String user) {
        if (type.equals("1")) {
            sql = "update user_table set favorite_course=? where phone=?";

        } else if (type.equals("2")) {
            sql = "update user_table set favorite_course=? where qq_openid=?";
        }
        JsonObject thisObject = new JsonObject();
        thisObject.addProperty("class", gettitle);
        array.add(thisObject);
        new Thread() {
            @Override
            public void run() {
                super.run();
                DBHelper.Update(sql, new Object[]{jsonObject.toString(), user});
            }
        }.start();

    }

    /**
     * 移除
     * 云数据库的json数据
     * 字段class某个数据
     *
     * @param gettitle
     * @param user
     */
    @SuppressLint("LongLogTag")
    public void jsonremove(final String gettitle, final String user) {
        if (type.equals("1")) {
            sql = "update user_table set favorite_course=? where phone=?";

        } else if (type.equals("2")) {
            sql = "update user_table set favorite_course=? where qq_openid=?";
        }
        JsonObject thisObject = new JsonObject();
        thisObject.addProperty("class", gettitle);
        array.remove(thisObject);
        new Thread() {
            @Override
            public void run() {
                super.run();
                DBHelper.Update(sql, new Object[]{jsonObject.toString(), user});
            }
        }.start();

    }

}
