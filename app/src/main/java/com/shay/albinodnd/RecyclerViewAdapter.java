package com.shay.albinodnd;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;

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

        GeneralListItem listItem = GeneralList.get(position);

        holder.GeneralName.setText(listItem.getViewName());

        holder.GeneralDescription.setText(listItem.getViewDescription().toString());

        holder.buttonViewOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //creating a popup menu
                PopupMenu popup = new PopupMenu(context, holder.buttonViewOption);
                //inflating menu from xml resource
                popup.inflate(R.menu.options_menu);
                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.editText:
                                FragmentManager fm = ((AppCompatActivity) context).getSupportFragmentManager();
                                DFragment alertDialog = DFragment.newInstance(listItem,position);
                                alertDialog.show(fm, "fragment_alert");
                                return true;
                            case R.id.remove:
                                //handle menu2 click
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                //displaying the popup
                popup.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return GeneralList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView GeneralName;
        public TextView GeneralDescription;
        public TextView buttonViewOption;

        public ViewHolder(View itemView) {
            super(itemView);

            GeneralName = (TextView) itemView.findViewById(R.id.ShowGeneralNameTextView);
            GeneralDescription = (TextView) itemView.findViewById(R.id.ShowGeneralDescTextView);
            buttonViewOption = (TextView) itemView.findViewById(R.id.textViewOptions);
        }
    }

}
