# Manual de RadioButton y RadioGroup en Android Studio (Java)

Este proyecto es una guía práctica sobre cómo implementar y utilizar los componentes **RadioButton** y **RadioGroup** en aplicaciones Android desarrolladas con Java.

---

## 1. Introducción

En el desarrollo de aplicaciones Android, es común solicitar al usuario que seleccione una sola opción entre varias alternativas. Para este propósito, Android proporciona dos componentes principales:

*   **RadioButton**: La opción individual.
*   **RadioGroup**: El contenedor que agrupa y gestiona la selección única.

Estos controles son ampliamente utilizados en formularios, encuestas, métodos de pago y preferencias de usuario.

---

## 2. RadioButton

### 2.1 Definición
Un `RadioButton` es un componente que permite seleccionar una opción dentro de un conjunto. Se representa como un círculo que puede estar desmarcado (○) o seleccionado (●).

### 2.2 Sintaxis básica en XML
```xml
<RadioButton
    android:id="@+id/rbJava"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Java"/>
```

### 2.3 Atributos principales
| Atributo | Descripción |
| :--- | :--- |
| `id` | Identificador único del componente. |
| `text` | Texto visible al lado del botón. |
| `checked` | Define si está seleccionado por defecto (`true`/`false`). |
| `textSize` | Tamaño del texto. |
| `enabled` | Habilita o deshabilita el componente. |

---

## 3. RadioGroup

### 3.1 Definición
Un `RadioGroup` es un contenedor que agrupa varios `RadioButton`. Su función principal es garantizar la **exclusividad mutua**: solo una opción puede estar seleccionada a la vez dentro del grupo.

### 3.2 Sintaxis básica
```xml
<RadioGroup
    android:id="@+id/rgOpciones"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">
    <!-- Aquí van los RadioButtons -->
</RadioGroup>
```

---

## 4. Ventajas del RadioGroup
*   Evita múltiples selecciones accidentales.
*   Mejora la experiencia del usuario (UX).
*   Reduce la lógica de validación en el código Java.
*   Aumenta la consistencia de los datos capturados.

---

## 5. Métodos importantes en Java

*   **Obtener opción seleccionada:**
    `int id = radioGroup.getCheckedRadioButtonId();`
    Retorna el ID del RadioButton seleccionado o `-1` si no hay ninguno.
*   **Seleccionar opción desde código:**
    `radioGroup.check(R.id.rbJava);`
*   **Limpiar selección:**
    `radioGroup.clearCheck();`

---

## 6. Aplicación Práctica: Encuesta de Lenguajes

### Diseño XML (`activity_main.xml`)
```xml
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="¿Cuál es tu lenguaje favorito?"
        android:textSize="22sp"
        android:textStyle="bold"/>

    <RadioGroup
        android:id="@+id/rgLenguajes"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="20dp">

        <RadioButton
            android:id="@+id/rbJava"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Java"/>

        <RadioButton
            android:id="@+id/rbPython"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Python"/>

        <RadioButton
            android:id="@+id/rbKotlin"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Kotlin"/>
    </RadioGroup>

    <Button
        android:id="@+id/btnEnviar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Enviar"
        android:layout_marginTop="20dp"/>
</LinearLayout>
```

### Código Java (`MainActivity.java`)
```java
package com.example.radiob;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgLenguajes;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgLenguajes = findViewById(R.id.rgLenguajes);
        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idSeleccionado = rgLenguajes.getCheckedRadioButtonId();

                if (idSeleccionado == -1) {
                    Toast.makeText(MainActivity.this, "Seleccione una opción", Toast.LENGTH_SHORT).show();
                } else {
                    RadioButton rb = findViewById(idSeleccionado);
                    String opcion = rb.getText().toString();
                    Toast.makeText(MainActivity.this, "Seleccionó: " + opcion, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
```

---

## 7. Evento de Cambio Inmediato
Si deseas detectar el cambio en el momento que ocurre, usa el listener `OnCheckedChangeListener`:

```java
rgLenguajes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        RadioButton rb = findViewById(checkedId);
        Toast.makeText(MainActivity.this, "Elegiste: " + rb.getText(), Toast.LENGTH_SHORT).show();
    }
});
```

---

---

## 8. Resumen
| Componente / Método | Función |
| :--- | :--- |
| `RadioButton` | Opción individual de selección. |
| `RadioGroup` | Agrupa opciones y asegura selección única. |
| `getCheckedRadioButtonId()` | Obtiene el ID de la opción seleccionada. |
| `setOnCheckedChangeListener` | Detecta cambios de selección en tiempo real. |
