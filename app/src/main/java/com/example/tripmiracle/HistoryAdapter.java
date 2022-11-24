package com.example.tripmiracle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class HistoryAdapter extends FirestoreRecyclerAdapter<Booking, HistoryAdapter.HistoryHolder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public HistoryAdapter(@NonNull FirestoreRecyclerOptions<Booking> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull HistoryHolder holder, int position, @NonNull Booking model) {
        holder.name.setText(model.getName());
        holder.room.setText(model.getRoom());
        holder.date.setText(model.getDate());
        holder.duration.setText(model.getDuration());
    }

    @NonNull
    @Override
    public HistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookings, parent, false);
        return new HistoryHolder(v);
    }

    class HistoryHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView room;
        public TextView date;
        public TextView duration;

     public HistoryHolder(@NonNull View itemView) {
         super(itemView);

        name = itemView.findViewById(R.id.historyUser);
        room = itemView.findViewById(R.id.historyRoom);
        date = itemView.findViewById(R.id.historyDate);
        duration = itemView.findViewById(R.id.historyDuration);

     }
 }
}
