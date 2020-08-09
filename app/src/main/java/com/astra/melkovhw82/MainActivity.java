package com.astra.melkovhw82;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Spinner mLanguagesSpinner;
    private Button mButtonChangeLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        mLanguagesSpinner = findViewById(R.id.spinner_language);

        mButtonChangeLanguage = findViewById(R.id.button_change_language);
        mButtonChangeLanguage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Locale locale = new Locale("en");

                switch((int) mLanguagesSpinner.getSelectedItemId()) {
                    case 0:
                        locale = new Locale("en");
                        break;
                    case 1:
                        locale = new Locale("ru");
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                    Configuration config = new Configuration();
                    config.setLocale(locale);

                    getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                    recreate();
                }
            }
        });

        initSpinners();
    }

    private void initSpinners() {
        ArrayAdapter<CharSequence> adapterCountries = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        adapterCountries.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mLanguagesSpinner.setAdapter(adapterCountries);
    }
}