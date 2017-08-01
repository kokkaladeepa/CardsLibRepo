package com.example.dreamworld.cardslibpoc;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.cards.material.MaterialLargeImageCard;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardGridArrayAdapter;
import it.gmariotti.cardslib.library.prototypes.CardWithList;
import it.gmariotti.cardslib.library.prototypes.CardWithList.OnItemClickListener;
import it.gmariotti.cardslib.library.prototypes.LinearListView;
import it.gmariotti.cardslib.library.view.CardGridView;

public class MainActivity extends AppCompatActivity {

    //Grid View objects
    private CardGridArrayAdapter mCardArrayAdapter;
    private CardGridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Adding card to the view

        ArrayList<Card> cards = new ArrayList<>();

        mCardArrayAdapter = new CardGridArrayAdapter (this, cards);

        //Staggered grid view
        gridView = (CardGridView) findViewById(R.id.myGrid);


        //Set the empty view
        if (gridView != null) {
            gridView.setAdapter(mCardArrayAdapter);

        }
/*
           gridView.setOnItemClickListener( {

               @Override
               public void onItemClick(LinearListView parent, View view, int position, CardWithList.ListObject object) {

               }
           });*/


        //Load cards
        new LoaderAsyncTask().execute();
    }

    private ArrayList<Card> initCard() {

        ArrayList<Card> cards = new ArrayList<Card>();

        for (int i = 0; i < 5; i++) {


            MaterialLargeImageCard card = new MaterialLargeImageCard(this.getApplicationContext());
            card.setInnerLayout(R.layout.native_material_largeimage_card);
            card.setDrawableIdCardThumbnail(R.drawable.electronics);
            //Set the title and subtitle in the card
            card.setTextOverImage("Electronics");
            card.build();

            card.setOnClickListener(new Card.OnCardClickListener() {
                @Override
                public void onClick(Card card, View view) {
                    Toast.makeText(getApplicationContext(), " Click on ActionArea ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, CategoryWiseMaterialCardActivity.class);
                    startActivity(intent);

                }
            });
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
