package kirito04800.cours_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by julienavalle on 02/10/2017.
 */

public class CreateBottleActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private String nameBottle;
    private double priceBottle;
    private EditText nameBottleField = null;
    private EditText priceBottleField = null;
    private Button saveButton = null;
    private Bottle sendBottle;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_bottle);

        saveButton = (Button) findViewById(R.id.buttonSave);
        saveButton.setOnClickListener(saveBottleOnclickListener);
        nameBottleField = (EditText) findViewById(R.id.nameB);
        priceBottleField= (EditText) findViewById(R.id.priceB);
    }




    private View.OnClickListener saveBottleOnclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d(TAG, "avant intent : ");
            nameBottle= nameBottleField.getText().toString();
            priceBottle= Double.parseDouble(priceBottleField.getText().toString());
            sendBottle= new Bottle(nameBottle,priceBottle);
            endActivity();
        }
    };

    public void endActivity() {
        Intent resultIntent = new Intent(); // attention type hashmap
        resultIntent.putExtra("bouteille",sendBottle);
        setResult(RESULT_OK,resultIntent);
        finish();

    }



}
