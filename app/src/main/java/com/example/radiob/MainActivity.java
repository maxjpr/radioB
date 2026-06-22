package com.example.radiob;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Implementación de RadioButton y RadioGroup basada en el Manual.
 */
public class MainActivity extends AppCompatActivity {

    // Punto 8: Declaración de variables para los componentes
    RadioGroup rgLenguajes;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Punto 8: Vinculación de vistas con sus IDs definidos en XML
        rgLenguajes = findViewById(R.id.rgLenguajes);
        btnEnviar = findViewById(R.id.btnEnviar);

        // Punto 8: Evento Click para el botón enviar
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Punto 5: Obtener el ID del RadioButton seleccionado
                int idSeleccionado = rgLenguajes.getCheckedRadioButtonId();

                // Punto 8: Validación de selección
                if (idSeleccionado == -1) {
                    Toast.makeText(MainActivity.this,
                            "Seleccione una opción",
                            Toast.LENGTH_SHORT).show();
                } else {
                    // Punto 8: Obtener el texto del RadioButton seleccionado usando el ID
                    RadioButton rb = findViewById(idSeleccionado);
                    String opcion = rb.getText().toString();

                    Toast.makeText(MainActivity.this,
                            "Seleccionó: " + opcion,
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        // Punto 9: Implementación del Evento de Cambio Inmediato (opcional en el manual)
        rgLenguajes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Verificar que el ID sea válido (no -1)
                if (checkedId != -1) {
                    RadioButton rb = findViewById(checkedId);
                    Toast.makeText(MainActivity.this,
                            "Elegiste (Cambio Inmediato): " + rb.getText(),
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
