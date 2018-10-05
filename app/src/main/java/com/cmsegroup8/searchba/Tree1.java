package com.cmsegroup8.searchba;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class Tree1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree1);

        ImageView palmtree;
        palmtree = (ImageView) findViewById(R.id.palmtree);

        int imageResource = getResources().getIdentifier("@drawable/palmtree", null, this.getPackageName());
        palmtree.setImageResource(imageResource);

        TextView info = (TextView) findViewById(R.id.info1);
        TextView feature = (TextView) findViewById(R.id.features);

        /*Intent incomingintent = getIntent();
        String incominginfo = incomingintent.getStringExtra("Tree_Info");
        info.setText(incominginfp);*/

        feature.setText("List palm features here");
        info.setText("Palms are one of the best known and most widely planted tree families." +
                 "They have held an important role for humans throughout much of history." +
                 "Many common products and foods come from palms." +
                 "They are often used in parks and gardens that are in areas that do not have heavy frosts." +
                "In the past palms were symbols of victory, peace, and fertility." +
                "Today palms are a popular symbol for the tropics and for vacations.");

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.navigation_home:
                        Intent home = new Intent(Tree1.this, Home.class);
                        startActivity(home);
                        break;

                    case R.id.navigation_Search:
                        Intent search = new Intent(Tree1.this, MainActivity.class);
                        startActivity(search);
                        break;

                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.navigation_Search) {

            Intent startsearch = new Intent(this, MainActivity.class);
            startActivity(startsearch);

        }

        if(id == R.id.navigation_home) {

            Intent starttree1 = new Intent(this, Home.class);
            startActivity(starttree1);

        }
        return super.onOptionsItemSelected(item);
    }
}
