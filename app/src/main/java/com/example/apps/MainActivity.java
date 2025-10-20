package com.example.apps;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ListView listView;
    Button button;
    EditText editText;


    PlanetaController planetaController;
    PlanetaAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);
        planetaController = new PlanetaController();
        PlanetaAdapter adapter = new PlanetaAdapter(this,R.layout.item_lista,
                planetaController.getPlanetas());
        listView.setAdapter(adapter);


    }
}
