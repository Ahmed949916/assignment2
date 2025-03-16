package com.example.assignment2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class NameActivity extends AppCompatActivity {

    private EditText edtName, edtEmail, edtPhone;
    private Button btnSave, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhone = findViewById(R.id.edtPhone);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);

        // Load existing data (if available)
        SharedPreferences preferences = getSharedPreferences("UserData", Context.MODE_PRIVATE);
        edtName.setText(preferences.getString("name", ""));
        edtEmail.setText(preferences.getString("email", ""));
        edtPhone.setText(preferences.getString("phone", ""));

        // Save button click: save data and return to MainActivity
        btnSave.setOnClickListener(v -> {
            String name = edtName.getText().toString().trim();
            String email = edtEmail.getText().toString().trim();
            String phone = edtPhone.getText().toString().trim();
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("name", name);
            editor.putString("email", email);
            editor.putString("phone", phone);
            editor.apply();
            Intent intent = new Intent();
            setResult(RESULT_OK, intent);
            finish();
        });

        // Cancel button click: simply return to MainActivity without saving
        btnCancel.setOnClickListener(v -> finish());
    }
}
