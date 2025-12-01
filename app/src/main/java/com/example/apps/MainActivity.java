package com.example.apps;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btntela2, btngerar;
    EditText numero;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btntela2 = findViewById(R.id.buttontela2);
        btngerar = findViewById(R.id.buttonGera);
        numero = findViewById(R.id.Texto);
        textView = findViewById(R.id.textView2);

        btngerar.setOnClickListener(v -> {
            String texto = numero.getText().toString();


            int numeroBase = Integer.parseInt(texto);
            StringBuilder tabuada = new StringBuilder();

            for (int i = 0; i <= 10; i++) {
                int resultado = i * numeroBase;

                textView.setText(tabuada.toString());
            }
        });


        btntela2.setOnClickListener(v -> {
            String numStr = numero.getText().toString();
            Intent intent = new Intent(this, tela2.class);
            intent.putExtra("NUMERO_BASE", numStr);
            startActivity(intent);
        });
    }
}