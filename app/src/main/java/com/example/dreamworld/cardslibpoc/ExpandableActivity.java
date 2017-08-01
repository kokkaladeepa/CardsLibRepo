package com.example.dreamworld.cardslibpoc;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import it.gmariotti.cardslib.library.Constants;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.view.CardViewNative;

public class ExpandableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable);
        //Expandable card
        //Create a Card
        Card card = new Card(getApplicationContext());


        //Create a CardHeader
        CardHeader header = new CardHeader(getApplicationContext());
        header.setTitle("expand it");


//to add other icon for expand acrtion
header.setButtonExpandVisible(true);
   /*     header.setOtherButtonVisible(true);

        //Add a callback
        header.setOtherButtonClickListener(new CardHeader.OnClickCardHeaderOtherButtonListener() {
            @Override
            public void onButtonItemClick(Card card, View view) {

            }
        });

        if (Build.VERSION.SDK_INT >= Constants.API_L) {
            // Use the simple png. It is the src in image (Android-L uses the ripple)
            header.setOtherButtonDrawable(R.drawable.smile);
        } else {
            // Use a selector. It is the background in image
            header.setOtherButtonDrawable(R.drawable.like);
        }*/
        //Add Header to card
        card.addCardHeader(header);

        //This provides a simple (and useless) expand area
        //  CardExpand expand = new CardExpand(this);
        CustomExpandCard expand=new CustomExpandCard(this);

        //Add Expand Area to Card
        card.addCardExpand(expand);

        //Set card in the cardView
        CardViewNative cardView = (CardViewNative) this.findViewById(R.id.carddemo);

        cardView.setCard(card);

        //Animator listener
        card.setOnExpandAnimatorEndListener(new Card.OnExpandAnimatorEndListener() {
            @Override
            public void onExpandEnd(Card card) {
                //msg or animation if u want to have upon clicking on expand symbol
            }
        });

        card.setOnCollapseAnimatorEndListener(new Card.OnCollapseAnimatorEndListener() {
            @Override
            public void onCollapseEnd(Card card) {
                //msg or animation if u want to have upon clicking on expand symbol
            }
        });



}
}
