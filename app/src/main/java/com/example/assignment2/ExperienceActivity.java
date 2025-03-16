package com.example.assignment2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class ExperienceActivity extends AppCompatActivity {

    private EditText editTextExperience;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);

        editTextExperience = findViewById(R.id.editTextExperience);
        Button btnSave = findViewById(R.id.btnSaveExperience);
        Button btnCancel = findViewById(R.id.btnCancelExperience);

        btnSave.setOnClickListener(v -> {
            String newEntry = editTextExperience.getText().toString().trim();
            if (!newEntry.isEmpty()) {
                SharedPreferences prefs = getSharedPreferences("UserData", MODE_PRIVATE);
                String existing = prefs.getString("experience", "").trim();
                if (!existing.isEmpty()) {
                    existing += "\n" + newEntry;
                } else {
                    existing = newEntry;
                }
                prefs.edit().putString("experience", existing).apply();
            }
            finish();
        });

        btnCancel.setOnClickListener(v -> finish());
    }
}
