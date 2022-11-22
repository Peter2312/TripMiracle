package com.example.tripmiracle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {
    Context context;
    ArrayList<Booking> booking;

    public HistoryAdapter(Context context, ArrayList<Booking> booking) {
            this.context = context;
            this.booking = booking;
    }

    @NonNull
    @Override
    // inflate the layout
    public HistoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.history_row, parent, false);

        return new HistoryAdapter.MyViewHolder(view);
    }

    @Override
    // assign value to the view the holder in recycle
    public void onBindViewHolder(@NonNull HistoryAdapter.MyViewHolder holder, int position) {
        holder.roomNo.setText(booking.get(position).getRoomNo());
        holder.historyDuration.setText(booking.get(position).getHistoryDuration());
        holder.historyTime.setText(booking.get(position.getHistoryTime()));
    }

    @Override
    // how many item to display
    public int getItemCount() {

        return booking.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // get view from recycle view row
        // connect to elements in row
        TextView roomNo;
        TextView historyTime;
        TextView historyDuration;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            roomNo = itemView.findViewById(R.id.roomNo);
            historyTime = itemView.findViewById(R.id.historyTime);
            historyDuration = itemView.findViewById(R.id.historyDuration);

        }
    }
}
