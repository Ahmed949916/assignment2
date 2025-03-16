package com.example.assignment2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class ReferenceActivity extends AppCompatActivity {

    private EditText editTextReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reference);

        editTextReference = findViewById(R.id.editTextReference);
        Button btnSave = findViewById(R.id.btnSaveReference);
        Button btnCancel = findViewById(R.id.btnCancelReference);

        btnSave.setOnClickListener(v -> {
            String newEntry = editTextReference.getText().toString().trim();
            if (!newEntry.isEmpty()) {
                SharedPreferences prefs = getSharedPreferences("UserData", MODE_PRIVATE);
                String existing = prefs.getString("reference", "").trim();
                if (!existing.isEmpty()) {
                    existing += "\n" + newEntry;
                } else {
                    existing = newEntry;
                }
                prefs.edit().putString("reference", existing).apply();
            }
            finish();
        });

        btnCancel.setOnClickListener(v -> finish());
    }
}
