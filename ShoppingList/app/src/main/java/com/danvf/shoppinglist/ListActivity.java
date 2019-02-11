package com.danvf.shoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class ListActivity extends AppCompatActivity {

    public static final String EXTRA_ITEMS = "com.danvf.shoppinglist.extra.ITEMS";
    private static boolean[] items = new boolean[4];
    private static CheckBox[] buttons = new CheckBox[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        buttons[0] = findViewById(R.id.item1_toggle);
        buttons[1] = findViewById(R.id.item2_toggle);
        buttons[2] = findViewById(R.id.item3_toggle);
        buttons[3] = findViewById(R.id.item4_toggle);
    }

    @Override
    protected void onStop() {
        super.onStop();
        for (int i = 0; i < 4; i++) {
            items[i] = false;
        }
    }

    public void backToMain(View view) {
        Intent goBackIntent = new Intent(this, MainActivity.class);

        for (int i = 0; i < 4; i++) {
            items[i] = buttons[i].isChecked();
        }

        goBackIntent.putExtra(EXTRA_ITEMS, items);
        setResult(RESULT_OK, goBackIntent);
        finish();
    }
}
