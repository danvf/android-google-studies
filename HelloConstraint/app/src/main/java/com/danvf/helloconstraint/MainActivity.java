package com.danvf.helloconstraint;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.graphics.Color.DKGRAY;
import static android.graphics.Color.GRAY;

public class MainActivity extends AppCompatActivity {

    private int myCount = 0;
    private TextView myText;
    private Button myCountButton;
    private Button myZeroButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myText = (TextView) findViewById(R.id.show_count);
        myCountButton = (Button) findViewById(R.id.button_count);
        myZeroButton = (Button) findViewById(R.id.button_zero);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {

        if (myCount == 0) {
            myZeroButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        }

        myCount++;

        if ((myCount % 2) == 0) {
            view.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        } else {
            view.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        }

        if (myText != null)
            myText.setText(Integer.toString(myCount));
    }

    public void setToZero(View view) {
        myCount = 0;
        myText.setText("0");
        myCountButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        view.setBackgroundColor(getResources().getColor(R.color.colorGray));
    }
}
