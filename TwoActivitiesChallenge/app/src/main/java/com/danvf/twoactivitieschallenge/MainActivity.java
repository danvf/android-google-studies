package com.danvf.twoactivitieschallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    static final String TAG = MainActivity.class.getSimpleName();
    static final String EXTRA_CODE = "com.danvf.twoactivitieschallenge.extra.CODE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToPassage(View view) {
        Intent intent = new Intent(this, PassageActivity.class);
        int code = 0;

        String entryButton = view.getResources().getResourceEntryName(view.getId());
        Log.d(TAG, entryButton + "veio ele!");

        if (entryButton.startsWith("first")) {
            code = 1;
        } else if (entryButton.startsWith("second")) {
            code = 2;
        } else {
            code = 3;
        }

        Bundle bundle = new Bundle();
        bundle.putInt(EXTRA_CODE, code);

        intent.putExtras(bundle);

        startActivity(intent);
    }
}
