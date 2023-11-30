package com.example.cuentaatrasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvTimer;
    private Button button;
    private CountDownTimer countDownTimer;
    private long tiempoRestanteMillis; // El tiempo en milisegundos que quieres para el contador regresivo
    private static final long INTERVALO = 1000; // Intervalo de actualización en milisegundos (1 segundo en este caso)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTimer = findViewById(R.id.tvTimer);
        button = findViewById(R.id.button);

        tiempoRestanteMillis = 60000; // 10 minutos

        iniciarContador();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.start();
            }
        });
    }

    private void iniciarContador(){
        countDownTimer = new CountDownTimer(tiempoRestanteMillis, INTERVALO) {
            @Override
            public void onTick(long l) {
                tiempoRestanteMillis = l;
                actualizaContador();
            }

            @Override
            public void onFinish() {
                Toast.makeText(getApplicationContext(),"Tiempo terminado",Toast.LENGTH_LONG).show();
            }
        };
    }

    private void actualizaContador(){

        int segundos = (int) (tiempoRestanteMillis / 1000);
        String tiempoFormateado = String.format("%02d:%02d", segundos/60, segundos % 60);

        tvTimer.setText(tiempoFormateado);

    }
}