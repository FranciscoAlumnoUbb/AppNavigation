package cl.aguilar.aguilarnavigation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        context = this;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button botonInicio = (Button) findViewById(R.id.boton_inicio);
        EditText userCapturado = (EditText) findViewById(R.id.inputUser);
        EditText passCapturada = (EditText) findViewById(R.id.inputPass);



        botonInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  String userIn  = userCapturado.getText().toString();
                  String PassIn  = passCapturada.getText().toString();
//                startActivity(new Intent(MainActivity.this, MenuPrincipal.class));
                  String prueba = userCapturado.getText().toString();
//                Toast.makeText(MainActivity.this, "Usuario: " + prueba, Toast.LENGTH_SHORT).show();
                if(iniciarSesion(userIn, PassIn)){
                    Intent intent = new Intent(MainActivity.this, MenuPrincipal.class);
                    intent.putExtra("usuario", "userCapturado");
                    startActivity(intent);
                    finish();
//                    startActivity(new Intent(MainActivity.this, MenuPrincipal.class));
                    Toast.makeText(MainActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(MainActivity.this, "Credenciales invalidas", Toast.LENGTH_SHORT).show();
                }
                userCapturado.setText("");
                passCapturada.setText("");
            }


        });



    }
    public static boolean iniciarSesion(String userIngresado, String claveIngresada){
        //        Credenciales
        String adminUser = "user";
        String adminPassword = "1234";

        if(userIngresado.equalsIgnoreCase(adminUser)){
            if(claveIngresada.equals(adminPassword)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }

    }
}