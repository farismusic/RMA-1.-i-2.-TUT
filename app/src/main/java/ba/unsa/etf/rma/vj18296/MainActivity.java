package ba.unsa.etf.rma.vj18296;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    private ArrayList<Muzicar> muzicari = new ArrayList<>();
    private MojAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        muzicari.add(new Muzicar("Faris", "Music", "Pop", "https://www.youtube.com/watch?v=bVw_GSbYLks", "Rođen 4. oktobra 1998. godine u Sarajevu"));
        muzicari.add(new Muzicar("Edin", "Omerovic", "Folk", "http://google.com", "Rođen 23. juna 1998. godine u nekom\n selu pored Zavidovica"));
        muzicari.add(new Muzicar("Adnan", "Mahinic", "Rok", "http://yahoo.com", "Rođen 7. januara 1998. godine u Puli"));


        lista = (ListView) findViewById(R.id.list);
        Resources res = getResources();

        adapter = new MojAdapter(this, muzicari, res);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detalji = new Intent(getApplicationContext(), Detalji.class);

                String[] zaProslijediti = new String[]{muzicari.get(position).getIme(), muzicari.get(position).getPrezime(), muzicari.get(position).getBiografija(), muzicari.get(position).getZanr(), muzicari.get(position).getWebStranica()};
                detalji.putExtra("key", zaProslijediti);
                startActivity(detalji);

            }
        });

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent proba = new Intent();
                proba.setAction(Intent.ACTION_SEND);
                proba.putExtra(Intent.EXTRA_TEXT, "Samo probavam");
                proba.setType("text/plain");
                startActivity(Intent.createChooser(proba, "Izaberi: "));
                Toast.makeText(getApplicationContext(), "Izaberi", Toast.LENGTH_SHORT).show();
            }
        });



        Intent intent = getIntent();
        String poruka = intent.getStringExtra(Intent.EXTRA_TEXT);
        EditText et = (EditText) findViewById(R.id.editText);
        et.setText(poruka);

    }
}
