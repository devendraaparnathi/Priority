package com.example.priority;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "THIS_IS_CUSTOM_TAG" ;
    TextView tvLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLink = findViewById(R.id.tvLink);
        tvLink.setMovementMethod(LinkMovementMethod.getInstance());
        tvLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //This is Link ----->> https://play.google.com/store/apps/details?id=com.pinterest

                String link = tvLink.getText().toString();
                Log.d(TAG, "First: " + link);

/*              String[] mainLink = tvLink.getText().toString().split(Pattern.quote("https://play.google.com/"));
                String linkSplit =mainLink[1];
*/
                if(tvLink.getText().toString().matches("https://play.google.com/store/apps/details(.*)"))
                {
                    String[] data = tvLink.getText().toString().split(Pattern.quote("="));

                    //This will give referral code ----->>
                    String string =data[1];

                    //this will give url without referral code ----->>

                    Log.d(TAG, "Third: " + string);

                    Toast.makeText(MainActivity.this, "Referral :" + string, Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MainActivity.this, MyWebView.class);
                    i.putExtra("DEV",tvLink.getText().toString());
                    startActivity(i);
                }
            }
        });
    }
}