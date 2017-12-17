package com.example.innocent.webview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ErrorActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);
        if(getIntent().getExtras().getString("MSG")!=null){
            textView = (TextView)findViewById(R.id.errorTextView);
            textView.setText(getIntent().getExtras().getString("MSG"));
        }

    }
    public void retryButton(View view){
        redirect();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        redirect();
    }
    private void redirect(){
        if(Common.connectionAvailable(ErrorActivity.this)){
            Intent home = new Intent(ErrorActivity.this, MainActivity.class);
            startActivity(home);
            finish();
        }
        else
            Toast.makeText(this, "Please check internet connection", Toast.LENGTH_SHORT).show();
    }
}
