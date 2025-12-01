package com.example.aula2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class IMCresultado extends AppCompatActivity {

    Button button;
    TextView tvResultado;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_imcresultado);
        tvResultado=findViewById(R.id.tvResultado);
        imageView=findViewById(R.id.imageView2);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Double peso = bundle.getDouble("peso");
        Double altura = bundle.getDouble("altura");

        Double imc = peso/(altura*altura);

        tvResultado.setText(Double.toString(imc));
        imageView.setImageResource(R.drawable.perfil);

        if(imc < 18.5){
            imageView.setImageResource(R.drawable.abaixopeso);
        }
        if(imc >= 18.5 && imc < 25){
            imageView.setImageResource(R.drawable.normal);
        }
        if(imc >= 25 && imc < 30){
            imageView.setImageResource(R.drawable.sobrepeso);
        }
        if(imc >= 30 && imc < 35){
            imageView.setImageResource(R.drawable.obesidade1);
        }
        if(imc >= 35 && imc < 40){
            imageView.setImageResource(R.drawable.obesidade2);
        }
        if(imc >= 40){
            imageView.setImageResource(R.drawable.obesidade3);
        }


    }
}