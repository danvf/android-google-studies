package com.danvf.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText webEditText;
    private EditText locationEditText;
    private EditText shareEditText;
    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webEditText = findViewById(R.id.edit_website);
        locationEditText = findViewById(R.id.edit_location);
        shareEditText = findViewById(R.id.edit_share);
    }

    public void openWebsite(View view) {
        String url = webEditText.getText().toString();
        Uri webpage = Uri.parse(url);

        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        if (webIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(webIntent);
        } else {
            Log.d("IMPLICIT INTENTS", "INTENT COULDN'T BE HANDLED!\n ================");
        }
    }

    public void openLocation(View view) {
        String location = locationEditText.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" + location);

        Intent locationIntent = new Intent(Intent.ACTION_VIEW, addressUri);
        if (locationIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(locationIntent);
        } else {
            Log.d("IMPLICIT INTENTS", "INTENT COULDN'T BE HANDLED!\n ================");
        }

    }

    public void shareText(View view) {
        String text = shareEditText.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(R.string.chooser_title)
                .setText(text)
                .startChooser();
    }
}
