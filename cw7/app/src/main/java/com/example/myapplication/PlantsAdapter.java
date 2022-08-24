package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class PlantsAdapter extends ArrayAdapter {
    List<Plants> plantslist;
    public PlantsAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        plantslist = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_row, parent, false);
        View view2 = LayoutInflater.from(getContext()).inflate(R.layout.activity_main, parent, false);
        Plants currentplant = plantslist.get(position);

        TextView nametxt = view.findViewById(R.id.txtname);
        TextView pricetxt = view.findViewById(R.id.txtprice);
        TextView typetxt = view.findViewById(R.id.txttype);
        ImageView plantimg = view.findViewById(R.id.img);

        nametxt.setText(currentplant.getPlantName());
        typetxt.setText(currentplant.getPlantType());
        plantimg.setImageResource(currentplant.getPlantPhoto());
        pricetxt.setText(currentplant.getPlantPrice() + " KD");


        ImageView delete = view.findViewById(R.id.imgdelete);
        delete.setOnClickListener(new View.OnClickListener() {
            Plants removedplant = plantslist.get(position);
            LinearLayout layout1 = view2.findViewById(R.id.layout);
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext()).setMessage("Are you sure you want to delete that ?")
                        .setTitle("Confirmatoin").setPositiveButton("Delete", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                plantslist.remove(removedplant);
                                Snackbar snackbar = Snackbar.make(layout1, " ", Snackbar.LENGTH_LONG)
                                                .setAction("Undo", new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View view) {
                                                        Snackbar snackbar1 = Snackbar.make(layout1, "Done", Snackbar.LENGTH_SHORT);
                                                        snackbar1.show();
                                                    }
                                                });
                                snackbar.show();
                                notifyDataSetChanged();

                            }
                        }).setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });

                builder.show();


            }
        });



        return view;
    }

}
