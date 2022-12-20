package dam.pmdm.preferencias_api33;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    private TextView tvDifElegida, tvBDElegida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        tvDifElegida = findViewById(R.id.tvDifElegida);
        tvBDElegida = findViewById(R.id.tvBDElegida);
    }

    @Override
    protected void onResume() {
        super.onResume();

        String dificultad = preferences.getString("dificultad", "desconocida");
        String bd;
        if (preferences.getBoolean("bd", false)){
            String nombre = preferences.getString("nombre", "desconocida");
            String ip = preferences.getString("ip", "x.x.x.x");
            bd = "Externa: " + nombre + " " + ip;
        }else{
            bd = "Interna SQLite";
        }

        tvDifElegida.setText(dificultad);
        tvBDElegida.setText(bd);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mi_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.it_preferencias:
                startActivity(new Intent(this, PreferenciasActivity.class));
                break;
            case R.id.it_salir:
                finishAffinity();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}