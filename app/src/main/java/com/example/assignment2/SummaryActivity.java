package com.example.assignment2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    private EditText editTextSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        editTextSummary = findViewById(R.id.editTextSummary);
        Button btnSaveSummary = findViewById(R.id.btnSaveSummary);
        Button btnCancelSummary = findViewById(R.id.btnCancelSummary);


        SharedPreferences prefs = getSharedPreferences("UserData", MODE_PRIVATE);
        String savedSummary = prefs.getString("summary", "");
        editTextSummary.setText(savedSummary);


        btnSaveSummary.setOnClickListener(v -> {
            String newSummary = editTextSummary.getText().toString();
            prefs.edit().putString("summary", newSummary).apply();
            finish();
        });


        btnCancelSummary.setOnClickListener(v -> {

            finish();

        });
    }
}
