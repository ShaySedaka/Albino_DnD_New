package com.shay.albinodnd;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<GeneralListItem> GeneralList;

    public RecyclerViewAdapter(Context context, ArrayList<GeneralListItem> TempList) {
        this.GeneralList = TempList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        GeneralListItem item = GeneralList.get(position);

        holder.GeneralName.setText(item.getViewName());

        holder.GeneralDescription.setText(item.getViewDescription().toString());

    }

    @Override
    public int getItemCount() {
        return GeneralList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView GeneralName;
        public TextView GeneralDescription;

        public ViewHolder(View itemView) {

            super(itemView);

            GeneralName = (TextView) itemView.findViewById(R.id.ShowGeneralNameTextView);
            GeneralDescription = (TextView) itemView.findViewById(R.id.ShowGeneralDescTextView);
        }
    }
}
