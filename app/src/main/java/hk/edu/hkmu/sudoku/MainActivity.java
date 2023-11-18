package hk.edu.hkmu.sudoku;


import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Add code here
        // Task: Retrieve boolean value if the splash screen needed to be shown
        // i. Obtain Resources object with method getResources
        // ii. Create a SharedPreferences object with class method getDefaultSharedPreferences
        // iii. Obtain boolean value with method getBoolean of the SharedPreferences object
        // iv. If splash screen is needed to show, call the method showMainMenu and return
        Resources res = getResources();
        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isShowing = prefs.getBoolean(res.getString(R.string.pref_splash_key), res.getBoolean(R.bool.pref_splash_default));
        if (!isShowing) {
            showMainMenu();
            return;
        }

        setContentView(R.layout.splash);
    }

    // Called when touched.
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN)
            showMainMenu();
        return true;
    }

    // Shows the SudokuHome Activity and finishes this activity.
    private void showMainMenu() {
        Intent intent = new Intent(MainActivity.this, SudokuHomeActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        finish();
    }
}