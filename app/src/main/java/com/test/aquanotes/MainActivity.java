package com.test.aquanotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.test.aquanotes.Fragments.NotesFragment;
import com.test.aquanotes.Fragments.SearchFragment;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    FrameLayout frameLayout;

    NotesFragment notes = new NotesFragment();
    SearchFragment search = new SearchFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView= findViewById(R.id.bottom_nav);
        frameLayout = findViewById(R.id.frame);

        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.notes);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.notes:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,notes).commit();
                return true;
            case R.id.search:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame,search).commit();
                return true;
            default:
                return false;
        }
    }
}