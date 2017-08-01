package com.example.dreamworld.cardslibpoc;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import it.gmariotti.cardslib.library.internal.CardExpand;

/**
 * Created by DreamWorld on 7/26/2017.
 */
public class CustomExpandCard extends CardExpand {
    //Use your resource ID for your inner layout
    public CustomExpandCard(Context context) {
        super(context, R.layout.native_inner_base_expand);
    }

    @Override
    public void setupInnerViewElements(ViewGroup parent, View view) {

        if (view == null) return;

        //Retrieve TextView elements
        TextView tx1 = (TextView) view.findViewById(R.id.Product_title);
            tx1.setText("Nikon 569 i Model");
        TextView tx2 = (TextView) view.findViewById(R.id.Product_specification);
        tx2.setText("25mp FC and 15mp BC and 10000mah power");
        TextView tx3 = (TextView) view.findViewById(R.id.Product_price);
        tx3.setText("Price/Day is :$200");

        parent.setBackgroundColor(mContext.getResources().
                getColor(R.color.seagreen));
        }




}
