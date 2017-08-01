package com.example.dreamworld.cardslibpoc;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.cards.actions.BaseSupplementalAction;
import it.gmariotti.cardslib.library.cards.actions.IconSupplementalAction;
import it.gmariotti.cardslib.library.cards.actions.TextSupplementalAction;
import it.gmariotti.cardslib.library.cards.material.MaterialLargeImageCard;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.recyclerview.internal.CardArrayRecyclerViewAdapter;
import it.gmariotti.cardslib.library.recyclerview.view.CardRecyclerView;

public class CategoryWiseMaterialCardActivity extends AppCompatActivity {

    final int TOTAL_CARDS = 3;
    //private CardArrayAdapter
    private CardArrayRecyclerViewAdapter mCardArrayAdapter;
    private CardRecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_wise_material_card);


        ArrayList<Card> cards = new ArrayList<>();

        mCardArrayAdapter = new CardArrayRecyclerViewAdapter(this, cards);

        //Staggered grid view
        CardRecyclerView mRecyclerView = (CardRecyclerView) findViewById(R.id.card_recyclerview);
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Set the empty view
        if (mRecyclerView != null) {
            mRecyclerView.setAdapter(mCardArrayAdapter);
        }

        //Load cards
        new LoaderAsyncTask().execute();
    }

    private ArrayList<Card> initCard() {

        ArrayList<Card> cards = new ArrayList<Card>();

        for (int i = 0; i < TOTAL_CARDS; i++) {


            MaterialLargeImageCard card = new MaterialLargeImageCard(this.getApplicationContext());

            //card.setInnerLayout(R.layout.native_material_largeimage_text_card);
            card.setDrawableIdCardThumbnail(R.drawable.mainimage);
            card.setTextOverImage("Italian Beaches");
            //  card.setDrawableIdCardThumbnail(R.drawable.card_background_01);

            //Set the title and subtitle in the card
            card.setTitle("Nikon Camera");
            card.setSubTitle("Price per day: $200");



            IconSupplementalAction t1 = new IconSupplementalAction(this, R.id.ic1);
            t1.setOnActionClickListener(new BaseSupplementalAction.OnActionClickListener() {
                @Override
                public void onClick(Card card, View view) {
                    Toast.makeText(getApplicationContext(), " Did you like this product ", Toast.LENGTH_SHORT).show();
                }
            });

/*

            IconSupplementalAction t2 = new IconSupplementalAction(this, R.id.ic2);


            t2.setOnActionClickListener(new BaseSupplementalAction.OnActionClickListener() {
                @Override
                public void onClick(Card card, View view) {
                    Toast.makeText(getApplicationContext(), "Browse for similar product ", Toast.LENGTH_SHORT).show();
                }
            });
*/




            IconSupplementalAction t3 = new IconSupplementalAction(this, R.id.ic3);

            t3.setOnActionClickListener(new BaseSupplementalAction.OnActionClickListener() {
                @Override
                public void onClick(Card card, View view) {
                    Toast.makeText(getApplicationContext(), " Like it", Toast.LENGTH_SHORT).show();
                }
            });


            IconSupplementalAction t4 = new IconSupplementalAction(this, R.id.ic4);

            t4.setOnActionClickListener(new BaseSupplementalAction.OnActionClickListener() {
                @Override
                public void onClick(Card card, View view) {
                    Toast.makeText(getApplicationContext(), " Share with others ", Toast.LENGTH_SHORT).show();

                }
            });

            TextSupplementalAction t5=new TextSupplementalAction(this,R.id.ic5);
            t5.setOnActionClickListener(new BaseSupplementalAction.OnActionClickListener() {
                @Override
                public void onClick(Card card, View view) {
                    Toast.makeText(getApplicationContext(), " Expand activity sahould be called ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(CategoryWiseMaterialCardActivity.this, ExpandableActivity.class);
                    startActivity(intent);

                }
            });

            card.addSupplementalAction(t1);
          //  card.addSupplementalAction(t2);
            card.addSupplementalAction(t3);
            card.addSupplementalAction(t4);
            card.addSupplementalAction(t5);

            //Set the layout for supplemental actions
            card.setLayout_supplemental_actions_id(R.layout.material_supplemental_actions_layout);

            //Very important call: build the card
            card.build();
            cards.add(card);

        }

        return cards;
    }

    private void updateAdapter(ArrayList<Card> cards) {
        if (cards != null) {
            mCardArrayAdapter.addAll(cards);
        }
    }

    class LoaderAsyncTask extends AsyncTask<Void, Void, ArrayList<Card>> {

        LoaderAsyncTask() {
        }

        @Override
        protected ArrayList<Card> doInBackground(Void... params) {
            //elaborate images
            //SystemClock.sleep(1000); //delay to simulate download, don't use it in a real app

            ArrayList<Card> cards = initCard();
            return cards;

        }

        @Override
        protected void onPostExecute(ArrayList<Card> cards) {
            //Update the adapter
            updateAdapter(cards);
            //displayList();
        }
    }
}
