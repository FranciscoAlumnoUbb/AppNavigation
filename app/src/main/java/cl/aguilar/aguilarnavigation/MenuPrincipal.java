package cl.aguilar.aguilarnavigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        String usuarioRecibido = getIntent().getStringExtra("usuario");
        Toast.makeText(this, "Hola " + usuarioRecibido, Toast.LENGTH_SHORT).show();

        ImageButton gocarro = (ImageButton) findViewById(R.id.botonCarrito);
        ImageButton golista = (ImageButton) findViewById(R.id.botonLista);
        Button cerrarSesion = (Button) findViewById(R.id.botonCerrarSesion);

        cerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuPrincipal.this, MainActivity.class));
                finish();
            }
        });

        gocarro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuPrincipal.this, CarritoCompras.class));

            }
        });
        golista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuPrincipal.this, ListarProductos.class));

            }
        });
    }
}