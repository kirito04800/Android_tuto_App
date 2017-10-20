package kirito04800.cours_android;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by julienavalle on 02/10/2017.
 */

public class BottleAdapter extends ArrayAdapter<Bottle> {
    private static final String TAG = BottleAdapter.class.getSimpleName();


    public BottleAdapter(Context context, List<Bottle> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

    Log.d(TAG, "ADAPTEUR  ");


        //sans le design pattern
        //on cree la vue
        View itemView = LayoutInflater.from(getContext()).inflate(R.layout.item,parent,false);
        //on recupere les elements de la vue
        TextView textView = (TextView) itemView.findViewById(R.id.listview_sample_item_txv);
        TextView textViewDesc = (TextView) itemView.findViewById(R.id.listview_sample_item_descr_txv);
        //on get l item de la liste associe a la position position
        Bottle sampleData = getItem(position);
        // on remplit les champs
        textView.setText(sampleData.getName());
        textViewDesc.setText(String.valueOf(sampleData.getPrice()));

//        imageView.setImageResource(ic_delete);




        return itemView;
    }

}

