package com.example.apps;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.aula2.R;

public class MainActivity extends AppCompatActivity {

    // Variáveis principais
    String[] nomes = new String[] {
            "Natan", "Sarah", "Anaju",
            "Maria Clara", "Clara"
    };

    ListView lv; // ListView onde os nomes vão aparecer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Carrega o layout da tela principal

        // Recupera a ListView do layout XML e liga a variável lv
        lv = findViewById(R.id.listview);

        // Criamos o Adapter que vai conectar os nomes ao layout de cada item da lista
        ArrayAdapter<String> a = new ArrayAdapter(
                this,
                R.layout.item_lista, // Layout do item individual da lista
                R.id.textView, // TextView dentro do layout que vai receber cada nome
                nomes // Vetor de nomes que será usado como dados
        );

        // Define o adapter para exibir os nomes na ListView
        lv.setAdapter(a);
    }
}