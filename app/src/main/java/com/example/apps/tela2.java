package com.example.apps;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.apps.R;

public class tela2 extends AppCompatActivity {


    TextView tvResultadoTabuada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        tvResultadoTabuada = findViewById(R.id.resultadoTabuada);

        Intent intent = getIntent();
        String numeroBaseStr = intent.getStringExtra("NUMERO_BASE");

        if (numeroBaseStr != null && !numeroBaseStr.isEmpty()) {
            try {
                int numeroBase = Integer.parseInt(numeroBaseStr);
                StringBuilder tabuada = new StringBuilder();

                for (int i = 0; i <= 10; i++) {
                    int resultado = i * numeroBase;
                    tabuada.append(i).append(" x ").append(numeroBase).append(" = ").append(resultado).append("\n");
                }


                tvResultadoTabuada.setText(tabuada.toString());

            } catch (NumberFormatException e) {
                tvResultadoTabuada.setText("Erro: O valor recebido não é um número válido.");
                Toast.makeText(this, "Erro ao processar número.", Toast.LENGTH_LONG).show();
            }
        } else {
            tvResultadoTabuada.setText("Nenhum número foi enviado pela tela anterior.");
        }
    }
}