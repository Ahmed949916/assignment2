package com.example.assignment2;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;
    public static final String PREFS_NAME = "UserData";

    private ImageView imgProfilePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imgProfilePicture = findViewById(R.id.imgProfilePicture);
        imgProfilePicture.setOnClickListener(v -> openGallery());


        setupSection(R.id.name_section, "Introduction", NameActivity.class);
        setupSection(R.id.summary_section, "Summary", SummaryActivity.class);
        setupSection(R.id.education_section, "Education", EducationActivity.class);
        setupSection(R.id.experience_section, "Experience", ExperienceActivity.class);
        setupSection(R.id.certifications_section, "Certifications", CertificationsActivity.class);
        setupSection(R.id.references_section, "References", ReferenceActivity.class);


        setSectionBackground(R.id.name_section, "#FFC1A1");
        setSectionBackground(R.id.summary_section, "#4ef2e5");
        setSectionBackground(R.id.education_section, "#98FB98");
        setSectionBackground(R.id.experience_section, "#87CEFA");
        setSectionBackground(R.id.certifications_section, "#FFB6C1");
        setSectionBackground(R.id.references_section, "#D8BFD8");


        Button btnExport = findViewById(R.id.btnExport);
        btnExport.setOnClickListener(v -> exportData());

    }

    @Override
    protected void onResume() {
        super.onResume();

        updateIntroductionCard();
        updateSummaryCard();
        updateEducationCard();
        updateExperienceCard();
        updateCertificationsCard();
        updateReferencesCard();
    }



    private void updateIntroductionCard() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String name  = prefs.getString("name", "");
        String email = prefs.getString("email", "");
        String phone = prefs.getString("phone", "");

        View introSection = findViewById(R.id.name_section);
        if (introSection != null) {
            TextView titleView = introSection.findViewById(R.id.sectionTitle);
            TextView detailsView = introSection.findViewById(R.id.sectionDetails);
            if (titleView != null) {
                titleView.setText(R.string.introduction);
            }
            if (detailsView != null) {
                StringBuilder sb = new StringBuilder();
                if (!name.isEmpty())  sb.append("Name: ").append(name).append("\n");
                if (!email.isEmpty()) sb.append("Email: ").append(email).append("\n");
                if (!phone.isEmpty()) sb.append("Phone: ").append(phone);

                if (sb.length() > 0) {
                    detailsView.setText(sb.toString());
                    detailsView.setVisibility(View.VISIBLE);
                } else {
                    detailsView.setVisibility(View.GONE);
                }
            }
        }
    }

    private void updateSummaryCard() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String summary = prefs.getString("summary", "");

        View summarySection = findViewById(R.id.summary_section);
        if (summarySection != null) {
            TextView titleView = summarySection.findViewById(R.id.sectionTitle);
            TextView detailsView = summarySection.findViewById(R.id.sectionDetails);
            if (titleView != null) {
                titleView.setText(R.string.summary);
            }
            if (detailsView != null) {
                if (!summary.isEmpty()) {
                    detailsView.setText(summary);
                    detailsView.setVisibility(View.VISIBLE);
                } else {
                    detailsView.setVisibility(View.GONE);
                }
            }
        }
    }

    private void updateEducationCard() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String education = prefs.getString("education", "");

        View educationSection = findViewById(R.id.education_section);
        if (educationSection != null) {
            TextView titleView = educationSection.findViewById(R.id.sectionTitle);
            TextView detailsView = educationSection.findViewById(R.id.sectionDetails);
            if (titleView != null) {
                titleView.setText(R.string.education);
            }
            if (detailsView != null) {
                if (!education.isEmpty()) {
                    detailsView.setText(education);
                    detailsView.setVisibility(View.VISIBLE);
                } else {
                    detailsView.setVisibility(View.GONE);
                }
            }
        }
    }

    private void updateExperienceCard() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String experience = prefs.getString("experience", "");

        View experienceSection = findViewById(R.id.experience_section);
        if (experienceSection != null) {
            TextView titleView = experienceSection.findViewById(R.id.sectionTitle);
            TextView detailsView = experienceSection.findViewById(R.id.sectionDetails);
            if (titleView != null) {
                titleView.setText(R.string.experience);
            }
            if (detailsView != null) {
                if (!experience.isEmpty()) {
                    detailsView.setText(experience);
                    detailsView.setVisibility(View.VISIBLE);
                } else {
                    detailsView.setVisibility(View.GONE);
                }
            }
        }
    }

    private void updateCertificationsCard() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String certifications = prefs.getString("certifications", "");

        View certSection = findViewById(R.id.certifications_section);
        if (certSection != null) {
            TextView titleView = certSection.findViewById(R.id.sectionTitle);
            TextView detailsView = certSection.findViewById(R.id.sectionDetails);
            if (titleView != null) {
                titleView.setText(R.string.certifications);
            }
            if (detailsView != null) {
                if (!certifications.isEmpty()) {
                    detailsView.setText(certifications);
                    detailsView.setVisibility(View.VISIBLE);
                } else {
                    detailsView.setVisibility(View.GONE);
                }
            }
        }
    }

    private void updateReferencesCard() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String reference = prefs.getString("reference", "");

        View refSection = findViewById(R.id.references_section);
        if (refSection != null) {
            TextView titleView = refSection.findViewById(R.id.sectionTitle);
            TextView detailsView = refSection.findViewById(R.id.sectionDetails);
            if (titleView != null) {
                titleView.setText(R.string.references);
            }
            if (detailsView != null) {
                if (!reference.isEmpty()) {
                    detailsView.setText(reference);
                    detailsView.setVisibility(View.VISIBLE);
                } else {
                    detailsView.setVisibility(View.GONE);
                }
            }
        }
    }



    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//        startActivity(intent);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            if (selectedImageUri != null) {
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri);
                    imgProfilePicture.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private void setupSection(int layoutId, String title, Class<?> activityToLaunch) {
        View section = findViewById(layoutId);
        if (section != null) {
            // Assign the title
            TextView titleView = section.findViewById(R.id.sectionTitle);
            if (titleView != null) {
                titleView.setText(title);
            }
            // If we have an activity, make the section clickable
            if (activityToLaunch != null) {
                section.setOnClickListener(v -> {
                    Intent intent = new Intent(MainActivity.this, activityToLaunch);
                    startActivity(intent);
                });
            }
        }
    }


    private void setSectionBackground(int sectionId, String colorCode) {
        View sectionView = findViewById(sectionId);
        if (sectionView instanceof LinearLayout) {
            ((LinearLayout) sectionView).setBackgroundColor(Color.parseColor(colorCode));
        }
    }


    private void exportData() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        StringBuilder sb = new StringBuilder();
        sb.append("Introduction:\n")
                .append("Name: ").append(prefs.getString("name", "")).append("\n")
                .append("Email: ").append(prefs.getString("email", "")).append("\n")
                .append("Phone: ").append(prefs.getString("phone", "")).append("\n\n");

        sb.append("Summary:\n")
                .append(prefs.getString("summary", ""))
                .append("\n\n");

        sb.append("Education:\n")
                .append(prefs.getString("education", ""))
                .append("\n\n");

        sb.append("Experience:\n")
                .append(prefs.getString("experience", ""))
                .append("\n\n");

        sb.append("Certifications:\n")
                .append(prefs.getString("certifications", ""))
                .append("\n\n");

        sb.append("References:\n")
                .append(prefs.getString("reference", ""))
                .append("\n\n");

        String exportText = sb.toString();

        // Share Intent
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Exported CV Data");
        shareIntent.putExtra(Intent.EXTRA_TEXT, exportText);

        startActivity(Intent.createChooser(shareIntent, "Export Data"));
    }
}
