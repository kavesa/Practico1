package com.tsi2.practico.caps;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    Button capsBtn;
    EditText inputText;
    private String originalText;
    private String resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = (EditText) findViewById(R.id.inputText);
        capsBtn = (Button) findViewById(R.id.capsBtn);

        inputText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(inputText.getText().toString().isEmpty()){
                    capsBtn.setVisibility(View.INVISIBLE);
                }else{
                    capsBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        capsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!inputText.getText().toString().equalsIgnoreCase(originalText)){
                    originalText = inputText.getText().toString();
                }

                if(capsBtn.getText().toString().equals("Convert")){
                    capsBtn.setText("Undo");
                    resultText = originalText.toUpperCase();
                    inputText.setEnabled(false);
                }else {
                    capsBtn.setText("Convert");
                    resultText = originalText;
                    inputText.setEnabled(true);
                }

                inputText.setText(resultText);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
