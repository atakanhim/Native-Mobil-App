package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends FragmentActivity {
    //AutoCompleteTextView autoCompleteTextView;

    private Spinner mySpinner;
    private  CustomSpinnerAdapter mAdepter;
    private  Menus mMenu;
    //buttons
    private Button exchangeBtn;
    private Button map;

    private void init(){
        exchangeBtn = findViewById(R.id.doviz_btn);
        map = findViewById(R.id.map_btn);
        mySpinner=findViewById(R.id.spinner);
        mAdepter = new CustomSpinnerAdapter(Menus.getData(this),this);
        mySpinner.setAdapter(mAdepter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();// menü ekleniyor
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                changeFragment(parent,i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                changeFragment(parent,0);
            }
        });
        // butona basıldıgında activity çagırıcak
        exchangeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity("exchange");
            }
        });
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity("map");
            }
        });

    }
<<<<<<< Updated upstream
    private void openDovizActivity(){
        Intent i  = new Intent(this,dovizActivity.class);//Burası butona eklenecek
        startActivity(i);
=======
    private void changeActivity(String activityName){
        if(activityName == "map") {
            Intent i = new Intent(this, MainActivity2.class);//Burası butona eklenecek
            startActivity(i);
        }
        if(activityName == "exchange") {
            Intent i = new Intent(this, dovizActivity.class);//Burası butona eklenecek
            startActivity(i);
        }
>>>>>>> Stashed changes
    }
    private void changeFragment(AdapterView<?> parent,int pos){
        mMenu = (Menus) parent.getItemAtPosition(pos);
        System.out.println(mMenu.getIconName());//Switch case ile yapılcak
        if(mMenu.getIconName()=="MAIN SCREEN"){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            MainScreen mainScreen = new MainScreen();
            transaction.replace(R.id.fragment_container,mainScreen);
            transaction.commit();
        }
        if(mMenu.getIconName()=="TURKEY MAP"){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            MapScreen mapScreen = new MapScreen();
            transaction.replace(R.id.fragment_container,mapScreen);
            transaction.commit();
        }
        if(mMenu.getIconName()=="BREAKFAST"){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            BreakfastScreen breakFastscreen = new BreakfastScreen();
            transaction.replace(R.id.fragment_container,breakFastscreen);
            transaction.commit();
        }


        /**/


    }
}