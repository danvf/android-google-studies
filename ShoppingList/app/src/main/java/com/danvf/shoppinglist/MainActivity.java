package com.danvf.shoppinglist;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static boolean[] items = new boolean[4];
    private static TextView[] texts = new TextView[4];
    private static final int ITEM_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texts[0] = findViewById(R.id.item1_textView);
        texts[1] = findViewById(R.id.item2_textView);
        texts[2] = findViewById(R.id.item3_textView);
        texts[3] = findViewById(R.id.item4_textView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        for (int i = 0; i < 4; i++) {
            if (items[i]) {
                texts[i].setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == ITEM_REQUEST) {
            if (resultCode == RESULT_OK) {
                assert data != null;
                items = data.getBooleanArrayExtra(ListActivity.EXTRA_ITEMS);
            }
        }
    }

    public void addToList(View view) {
        Intent intent = new Intent(this, ListActivity.class);
        startActivityForResult(intent, ITEM_REQUEST);
    }
}
