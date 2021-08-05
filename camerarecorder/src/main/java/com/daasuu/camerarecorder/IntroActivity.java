package com.daasuu.camerarecorder;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.ramotion.paperonboarding.PaperOnboardingEngine;
import com.ramotion.paperonboarding.PaperOnboardingPage;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnChangeListener;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnRightOutListener;
import java.util.ArrayList;
public class IntroActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding_main_layout);
        PaperOnboardingEngine engine = new PaperOnboardingEngine(findViewById(R.id.onboardingRootView), getDataForOnboarding(), getApplicationContext());
        engine.setOnChangeListener(new PaperOnboardingOnChangeListener() {
            @Override
            public void onPageChanged(int oldElementIndex, int newElementIndex) {
                Toast.makeText(getApplicationContext(), "Swiped from " + oldElementIndex + " to " + newElementIndex, Toast.LENGTH_SHORT).show();
            }
        });
        engine.setOnRightOutListener(new PaperOnboardingOnRightOutListener() {
            @Override
            public void onRightOut() {
                finish();
            }
        });
    }
    private ArrayList<PaperOnboardingPage> getDataForOnboarding() {
        PaperOnboardingPage scr1 = new PaperOnboardingPage("Manage your own Profile", "Customise your Profile,keep it private to hide it from recommending to others and limiting to your Friends only",
                Color.parseColor("#678FB4"), R.drawable.hotels, R.drawable.key);
        PaperOnboardingPage scr2 = new PaperOnboardingPage("Introducing Lanza Editor", "Create Short Videos as Stories or Post and more with the Lanza",
                Color.parseColor("#65B0B4"), R.drawable.banks, R.drawable.key);
        PaperOnboardingPage scr3 = new PaperOnboardingPage("End to End Enscryption", "Message your friends without worrying about Privacy as we got you covered with End to End Enscrypted Messages",
                Color.parseColor("#9B90BC"), R.drawable.stores, R.drawable.key);
        PaperOnboardingPage scr4 = new PaperOnboardingPage("Funny Filters", "Use funny filters to Create more appealing Posts",
                Color.parseColor("#9B90BC"), R.drawable.faces, R.drawable.key);
        PaperOnboardingPage scr5 = new PaperOnboardingPage("Verify your Contact Anytime", "Verify your contact in order to get your Profile Assured and Reach to more people",
                Color.parseColor("#9B90BC"), R.drawable.verify, R.drawable.key);
        ArrayList<PaperOnboardingPage> elements = new ArrayList<>();
        elements.add(scr1);
        elements.add(scr2);
        elements.add(scr3);
        elements.add(scr4);
        elements.add(scr5);
        return elements;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    public void finish() {
        Intent data = new Intent();
        data.putExtra("CompleteStatus", "completed");
        this.setResult(RESULT_OK, data);
        super.finish();
    }
}