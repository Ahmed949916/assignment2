package com.example.assignment2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CvTemplateActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "UserData";

    private TextView tvCvIntroduction;
    private TextView tvCvSummary;
    private TextView tvCvEducation;
    private TextView tvCvExperience;
    private TextView tvCvCertifications;
    private TextView tvCvReferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv_template);

        // 1. Initialize views
        tvCvIntroduction   = findViewById(R.id.tvCvIntroduction);
        tvCvSummary        = findViewById(R.id.tvCvSummary);
        tvCvEducation      = findViewById(R.id.tvCvEducation);
        tvCvExperience     = findViewById(R.id.tvCvExperience);
        tvCvCertifications = findViewById(R.id.tvCvCertifications);
        tvCvReferences     = findViewById(R.id.tvCvReferences);

        // 2. Load data from SharedPreferences
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        String introduction   = prefs.getString("introduction_details",  "No details provided");
        String summary        = prefs.getString("summary_details",       "No details provided");
        String education      = prefs.getString("education_details",     "No details provided");
        String experience     = prefs.getString("experience_details",    "No details provided");
        String certifications = prefs.getString("certifications_details","No details provided");
        String references     = prefs.getString("references_details",    "No details provided");

        // 3. Populate the CV template
        tvCvIntroduction.setText("Introduction:\n"   + introduction);
        tvCvSummary.setText("Summary:\n"            + summary);
        tvCvEducation.setText("Education:\n"        + education);
        tvCvExperience.setText("Experience:\n"      + experience);
        tvCvCertifications.setText("Certifications:\n" + certifications);
        tvCvReferences.setText("References:\n"      + references);
    }
}
