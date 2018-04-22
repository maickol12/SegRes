package com.example.miguelr.seguimientoresidencias.Alumnos;

import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.miguelr.seguimientoresidencias.R;
import com.example.miguelr.seguimientoresidencias.adaptadores.PGAdapter;

/**
 * Created by miguelr on 24/03/2018.
 */

public class mostrarAlumnosActivity extends AppCompatActivity {
    private Toolbar toolbar;
    FragmentPagerAdapter adapterViewPager;
    ViewPager vp;
    public void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.activity_mostrar_alumnos);


        vp = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new PGAdapter(getSupportFragmentManager(),this);
        vp.setAdapter(adapterViewPager);


        toolbar = (Toolbar) findViewById(R.id.toolbarGeneral);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_mostra_alumnos,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }
}
