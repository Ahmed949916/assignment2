package com.example.assignment2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class CertificationsActivity extends AppCompatActivity {

    private EditText editTextCertification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certifications);

        editTextCertification = findViewById(R.id.editTextCertification);
        Button btnSave = findViewById(R.id.btnSaveCertification);
        Button btnCancel = findViewById(R.id.btnCancelCertification);

        btnSave.setOnClickListener(v -> {
            String newEntry = editTextCertification.getText().toString().trim();
            if (!newEntry.isEmpty()) {
                SharedPreferences prefs = getSharedPreferences("UserData", MODE_PRIVATE);
                String existing = prefs.getString("certifications", "").trim();
                if (!existing.isEmpty()) {
                    existing += "\n" + newEntry;
                } else {
                    existing = newEntry;
                }
                prefs.edit().putString("certifications", existing).apply();
            }
            finish();
        });

        btnCancel.setOnClickListener(v -> finish());
    }
}
