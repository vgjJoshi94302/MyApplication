package com.example.viraljoshi.myapplication;
//packages
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.TypedValue;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.*;
import java.util.Timer;
import java.util.TimerTask;

//By default class of the application when the app icon is launched
public class MainActivity extends AppCompatActivity {
//This method is figured when activity is loaded.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Its a view group which shows flexibilty to add views on screen compared to Linear layout
        //There are some attributes with it like background color
        RelativeLayout rl = new RelativeLayout(this);
        rl.setBackgroundColor(Color.GREEN);
        //Button is a widget a.k.a VIEW which is used to perform some action by pressing or clicking on it
        Button b = new Button(this);
        b.setText("Clear");
        b.setBackgroundColor(Color.GRAY);
        b.setId(R.id.btn);
        RelativeLayout.LayoutParams buttonParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        //For setting up its Height and width, we need to call the method addRule
        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonParams.addRule(RelativeLayout.CENTER_VERTICAL);
//The second Button for setting up the Text. It has some attributes like set Background color as well as its ID.
        Button bb = new Button(this);
        bb.setBackgroundColor(Color.BLUE);
        bb.setText("Submit");
        bb.setId(R.id.butn);
        RelativeLayout.LayoutParams btnprm =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        btnprm.addRule(RelativeLayout.CENTER_HORIZONTAL);
        btnprm.addRule(RelativeLayout.BELOW,b.getId());
// A type of VIEW where user can be able to EDIT the things as well can display the information on the activity
        final EditText myEditText = new EditText(this);
        myEditText.setId(R.id.txtv);
        myEditText.setId(View.generateViewId());
        RelativeLayout.LayoutParams textParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        textParams.addRule(RelativeLayout.ABOVE, b.getId());
        textParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        textParams.setMargins(0, 0, 0, 50);
        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 250,
                r.getDisplayMetrics());
        myEditText.setWidth(px);
//      A type of editor where user can be able to change the text. Also used to display the Information
//      entered by the user
         final TextView tt = new TextView(this);
            tt.setId(R.id.textview);
        RelativeLayout.LayoutParams tp =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        tp.addRule(RelativeLayout.BELOW, bb.getId());
        tp.addRule(RelativeLayout.CENTER_HORIZONTAL);
        //Setting up the Margin
        tp.setMargins(0, 0, 0, 90);

//Virtually create the Widget on the Activity
        rl.addView(b, buttonParams);
        rl.addView(bb,btnprm);

        rl.addView(myEditText, textParams);
        rl.addView(tt,tp);
        setContentView(rl);
        //This method will be used to clear up the text when the onClick method is triggered clicking the Button
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myEditText.setText("");
                tt.setText("");
            }
        });
        //  This method will be used to show up the text on the Text view when the onclick Method on the Button is triggered.
        //  Here we have called setText method which will set the Text and inside we are passing getText method which will take the Text inputted by the USER.
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tt.setText(myEditText.getText());
            }
        });
    }
/*
//This method is used to set text on Label
    public void click(View v) {
//Text View is used to set Text after Button is Clicked.
        ((TextView) findViewById(R.id.textView2)).setText("Text Changed...");
//This will call the Button widget from XML file.
    Button bt = (Button) findViewById(R.id.button);
//This method will be trigerred whenever Button is clicked for long time
        bt.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            //This method will return true or false on the Text View if the button is pressed for Sometime.
            public boolean onLongClick(View v) {
                TextView textView = (TextView)findViewById(R.id.textView2);
                textView.setText("Long Press Button event is triggered..");
                return true;
            }
        });
    }*/
}