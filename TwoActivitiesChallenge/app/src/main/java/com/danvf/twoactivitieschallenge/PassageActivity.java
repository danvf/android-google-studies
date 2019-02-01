package com.danvf.twoactivitieschallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class PassageActivity extends AppCompatActivity {

    static final String TAG = PassageActivity.class.getSimpleName();
    TextView passage;
    int code = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passage);

        passage = findViewById(R.id.passage_text);
        passage.setVisibility(View.INVISIBLE);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        assert bundle != null;
        code = bundle.getInt(MainActivity.EXTRA_CODE);
        showMessage(code);
    }

    void showMessage(int code) {
        switch (code) {
            case 1:
                Log.d(TAG, "case 1");
                passage.setText(R.string.first_passage_text);
                break;
            case 2:
                Log.d(TAG, "case 2");
                passage.setText(R.string.second_passage_text);
                break;
            case 3:
                Log.d(TAG, "case 3");
                passage.setText(R.string.third_passage_text);
                break;
        }

        passage.setVisibility(View.VISIBLE);
    }

    public void returnToMain(View view) {
        finish();
    }
}
