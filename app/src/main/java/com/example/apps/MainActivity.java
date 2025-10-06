package com.example.apps;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    Button salvar;
    ArrayList<String> texto;
    EditText textoNome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.lista);
        salvar = findViewById(R.id.btnSalvar);
        textoNome = findViewById(R.id.textonome);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        texto = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                texto
                );
        list.setAdapter(adapter);
        salvar.setOnClickListener(v -> {
            texto.add(textoNome.getText().toString());
            adapter.notifyDataSetChanged();
        });
        list.setOnItemClickListener((parent, view, position, id) -> {
            String itemSelect = texto.get(position);
            texto.remove(position);
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Confirmação")
                    .setMessage("Quer excluir "+ itemSelect + "?")
                    .setPositiveButton("Sim",(dialog,which) -> {
                        texto.remove(position);
                        adapter.notifyDataSetChanged();
                    })
                    .setNegativeButton("Não", null)
                    .show();
        });
    }
}