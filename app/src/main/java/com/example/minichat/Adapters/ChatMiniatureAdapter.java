package com.example.minichat.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.minichat.ChatActivity;
import com.example.minichat.Classes.ChatMiniature;
import com.example.minichat.MainActivity;
import com.example.minichat.R;

import java.util.List;

public class ChatMiniatureAdapter extends RecyclerView.Adapter<ChatMiniatureAdapter.ChatMiniatureHolder> {

    Context context;
    static List<ChatMiniature> items;

    public ChatMiniatureAdapter(Context context, List<ChatMiniature> items) {
        this.context = context;
        ChatMiniatureAdapter.items = items;
    }

    @NonNull
    @Override
    public ChatMiniatureHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChatMiniatureHolder(LayoutInflater.from(context).inflate(R.layout.chat_miniature_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChatMiniatureHolder holder, int position) {
        holder.avatar.setImageResource(items.get(position).getAvatar());
        holder.username.setText(items.get(position).getUsername());
        holder.lastMsg.setText(items.get(position).getLastMsg());
        holder.date.setText(items.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ChatMiniatureHolder extends RecyclerView.ViewHolder {

        public RelativeLayout parent;
        public ImageView avatar;
        public TextView username, lastMsg, date;

        public ChatMiniatureHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent_view);
            avatar = itemView.findViewById(R.id.avatar);
            username = itemView.findViewById(R.id.username_text);
            lastMsg = itemView.findViewById(R.id.last_message_text);
            date = itemView.findViewById(R.id.message_date_text);

            parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ChatActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(ChatMiniature.class.getSimpleName(), items.get(getAbsoluteAdapterPosition()));
                v.getContext().startActivity(intent);
                }
            });
        }
    }
}

