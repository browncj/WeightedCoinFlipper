package org.bitbucket.guruchris.weightedcoinflipper;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void getDec(View view){
        EditText editText = (EditText) findViewById(R.id.decEnter);
        String input = editText.getText().toString();
        if(input.equals("")) {
            Toast.makeText(this, "Please enter a weighting", Toast.LENGTH_LONG).show();
            return;
        }

        double newWeighting = Double.parseDouble(input);

        if(newWeighting < -.0000001 || newWeighting > 100.0000001){
            Toast.makeText(this, "Please enter a number between 0 and 100", Toast.LENGTH_LONG).show();
            editText.setText("");
            return;
        }
        GlobalState state = ((GlobalState) getApplicationContext());
        state.setWeighting((newWeighting / 100));
        Toast.makeText(this, "Weighting modified", Toast.LENGTH_LONG).show();
        editText.setText("");
    }

}
