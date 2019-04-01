package ba.unsa.etf.rma.vj18296;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Detalji extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalji);

        Intent aktivnost = getIntent();

        TextView ime = (TextView) findViewById(R.id.detaljiIme);
        TextView zanr = (TextView) findViewById(R.id.detaljiZanr);
        TextView biografija = (TextView) findViewById(R.id.biografija);
        TextView web = (TextView) findViewById(R.id.webStranica);

        final String[] vrijednosti = aktivnost.getStringArrayExtra("key");

        ime.setText(vrijednosti[0] + " " + vrijednosti[1]);
        zanr.setText(vrijednosti[2]);
        biografija.setText(vrijednosti[3]);
        web.setText(vrijednosti[4]);

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent newIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(vrijednosti[4]));
                    startActivity(newIntent);
                }catch (ActivityNotFoundException e){
                    Toast.makeText(getApplicationContext(), "Bruda nemas interneta", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });


    }
}
