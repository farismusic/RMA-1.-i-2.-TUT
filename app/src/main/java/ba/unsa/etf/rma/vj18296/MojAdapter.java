package ba.unsa.etf.rma.vj18296;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MojAdapter extends BaseAdapter {

    Activity context;
    ArrayList<Muzicar> muzicari;
    private static LayoutInflater infalter = null;
    Resources resources;

    public MojAdapter(Activity context, ArrayList<Muzicar> muzicari, Resources res){
        this.context = context;
        this.muzicari = muzicari;
        resources = res;

        infalter =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getCount() {
        return muzicari.size();
    }

    @Override
    public Object getItem(int position) {
        return muzicari.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        itemView = (itemView == null) ? infalter.inflate(R.layout.element_liste, null) : itemView;

        TextView ime = (TextView) itemView.findViewById(R.id.ime);
        TextView zanr = (TextView) itemView.findViewById(R.id.zanr);
        ImageView slika = (ImageView) itemView.findViewById(R.id.slika);

        Muzicar m = muzicari.get(position);

        ime.setText(m.getIme() + " " + m.getPrezime());
        zanr.setText(m.getZanr());

        if(m.getZanr().equalsIgnoreCase("folk")) slika.setImageResource(R.drawable.folk);
        if(m.getZanr().equalsIgnoreCase("rok")) slika.setImageResource(R.drawable.rok);
        if(m.getZanr().equalsIgnoreCase("pop")) slika.setImageResource(R.drawable.pop);

        return itemView;
    }
}
