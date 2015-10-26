package org.bitbucket.guruchris.weightedcoinflipper;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onResume(){
        super.onResume();
        final TextView streakCounter = (TextView) findViewById(R.id.streakCounter);
        streakCounter.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalState state = ((GlobalState) getApplicationContext());
                ImageView coinImg = (ImageView) findViewById(R.id.coin);
                TextView streakCounter = (TextView) findViewById(R.id.streakCounter);

                Random random = new Random();
                double randValue = random.nextDouble();

                if(randValue <= state.getWeighting()) {
                    if(state.isHeads()){
                        state.setStreak(state.getStreak() + 1);
                        streakCounter.setText("Heads x" + state.getStreak() + "!!");
                    }
                    else{
                        state.setIsHeads(true);
                        coinImg.setImageResource(R.drawable.obverse);
                        state.setStreak(1);
                        streakCounter.setText("Heads x" + state.getStreak() + "!!");
                    }
                }
                else {
                    if(state.isHeads()){
                        state.setIsHeads(false);
                        coinImg.setImageResource(R.drawable.reverse);
                        state.setStreak(1);
                        streakCounter.setText("Tails x" + state.getStreak() + "!!");
                    }
                    else{
                        state.setStreak(state.getStreak() + 1);
                        streakCounter.setText("Tails x" + state.getStreak() + "!!");
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
