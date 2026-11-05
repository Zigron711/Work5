package com.example.work5;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        Fragment feedbackFragment = new Feedback();
        Fragment testFragment = new Tedt();
        Fragment notificationFragment = new Notification();
        setCurrentFragment(feedbackFragment);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_feedback) {
                setCurrentFragment(feedbackFragment);
                return true;
            } else if (id == R.id.nav_test) {
                setCurrentFragment(testFragment);
                return true;
            } else if (id == R.id.nav_notify) {
                setCurrentFragment(notificationFragment);
                return true;
            }
            return false;
        });
    }

    private void setCurrentFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flFragment, fragment)
                .commit();
    }
}