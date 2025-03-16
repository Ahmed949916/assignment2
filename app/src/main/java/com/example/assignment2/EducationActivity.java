package com.example.assignment2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class EducationActivity extends AppCompatActivity {

    private EditText editTextEducation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        editTextEducation = findViewById(R.id.editTextEducation);
        Button btnSave = findViewById(R.id.btnSaveEducation);
        Button btnCancel = findViewById(R.id.btnCancelEducation);

        btnSave.setOnClickListener(v -> {
            String newEntry = editTextEducation.getText().toString().trim();
            if (!newEntry.isEmpty()) {
                // Append to existing multiline
                SharedPreferences prefs = getSharedPreferences("UserData", MODE_PRIVATE);
                String existing = prefs.getString("education", "").trim();
                if (!existing.isEmpty()) {
                    existing += "\n" + newEntry;
                } else {
                    existing = newEntry;
                }
                prefs.edit().putString("education", existing).apply();
            }
            finish();
        });

        btnCancel.setOnClickListener(v -> finish());
    }
}
