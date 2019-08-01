package com.example.fragmentdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MyCustomDialog.OnListener {

    public static final String TAG = "MainActivity";
    ViewHolder viewHolder = new ViewHolder();

    String mInput;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewHolder.btnOpen = findViewById(R.id.open_dialog);
        viewHolder.txtInput = findViewById(R.id.input_display);

       viewHolder.btnOpen.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               MyCustomDialog dialog = new MyCustomDialog();
               dialog.show(getSupportFragmentManager(),"MyCustomDialog");
           }
       });

    }

    @Override
    public void input(String input) {
        Log.d(TAG , "sendInput: got the input: " +  input);

        viewHolder.txtInput.setText(input);
    }


    private class ViewHolder{
        Button btnOpen;
        TextView txtInput;
    }
}
