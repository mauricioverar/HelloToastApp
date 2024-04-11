package com.example.hellotoastapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // referenciar
        TextView numText = findViewById(R.id.textView2);
        Button btn1 = findViewById(R.id.button);
        Button btn2 = findViewById(R.id.button2);



        // mostrar mensaje Hello toast!
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // variables
                CharSequence text = "Hello toast!";
                int duration = Toast.LENGTH_SHORT;
                // duracion toast=ventana emergente
                Toast toast = Toast.makeText(getBaseContext(), text, duration);
                toast.show();
            }
        });

        // aumentar contador
        btn2.setOnClickListener(new View.OnClickListener() {
            // variables
            int contador = 0;

            @Override
            public void onClick(View v) {
                contador ++;

                 numText.setText(Integer.toString(contador));


            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}