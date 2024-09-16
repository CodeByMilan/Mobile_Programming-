package com.example.chapter7;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class LoginPage extends AppCompatActivity {

    private FragmentManager fm ;
    private Fragment currentFragment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        //Toolbar toolbar = findViewById(R.id.toolbar);
        fm=getSupportFragmentManager();
        currentFragment =fm.findFragmentById(R.id.newrecord);
        if(currentFragment == null) defaultFragment(new Defaultfragment());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menuitem){
            createfragment( new CreateStudent());
            return  true;
        } else if (item.getItemId()==R.id.liststudent) {
            createfragment(new ListViewfragment());
            return true;

        }
        return false;
    }

    private void createfragment(Fragment f){
        fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.newrecord,f).commit();
    }
    private void defaultFragment(Fragment f ){
        fm=getSupportFragmentManager();
        fm.beginTransaction().add(R.id.newrecord,f).commit();
    }
}
