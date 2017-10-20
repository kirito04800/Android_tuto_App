package kirito04800.cours_android;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BottleCreationFragmentMain.OnFragmentInteractionListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int MAIN_ACTIVITY_INTENT_RESULT_CODE = 1;
    private Button button = null;
    private Bottle oneBottle;
    private Cellar maCaveAVin = new Cellar();
    private Button service2 = null;
    //private ListView listView;
    private BottleListFragmentMain fragmentList;
    private BottleCreationFragmentMain fragmentService;
    private FragmentManager fragmentManager;

    private static final String idCaveAVin = "Kirito04800";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // instanciation IHM
        button = (Button) findViewById(R.id.showHide);
        button.setOnClickListener(desBottlesOnClickListener);
        service2 = (Button) findViewById(R.id.buttonService);
        service2.setOnClickListener(nouveauServiceOnClickListener);




        fragmentList = new BottleListFragmentMain();
        fragmentService = new BottleCreationFragmentMain();

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        fragmentTransaction.add(R.id.ListFrag, fragmentList);
        fragmentTransaction.addToBackStack("tag");
        fragmentTransaction.commit();



    }












    private View.OnClickListener desBottlesOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d(TAG, "onClick: ");
            oneBottle = new Bottle("du bon vin",32.35);
            Toast.makeText(MainActivity.this,oneBottle.getName()+""+oneBottle.getPrice(),Toast.LENGTH_SHORT).show();
            maCaveAVin.addBottle(oneBottle.getName(),oneBottle.getPrice());
            Log.d(TAG, "onClick: ");

            Log.d(TAG, "On envoie la bouteille au serveur : "+ oneBottle.toString());

            fragmentList.updateCave(oneBottle);

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.ListFrag, fragmentList);
            //fragmentTransaction.hide(fragmentService);
            //fragmentTransaction.show(fragmentList);
            fragmentTransaction.addToBackStack("tag");
            fragmentTransaction.commit();


            Log.d(TAG, "On envoie la bouteille au serveur : "+ maCaveAVin.getListeBottle().get(0).getName());

        }
    };

    private View.OnClickListener recupServeurOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    private View.OnClickListener nouveauServiceOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.ListFrag, fragmentService);
            //fragmentTransaction.hide(fragmentList);
            //fragmentTransaction.show(fragmentService);
            fragmentTransaction.addToBackStack("tag");
            fragmentTransaction.commit();





            /* si deux activités
            Log.d(TAG, "avant intent : ");
            Intent intent = new Intent(MainActivity.this, CreateBottleActivity.class);
            Log.d(TAG, "avant start  intent : ");
            //MainActivity.this.startActivity(intent);
            MainActivity.this.startActivityForResult(intent,MAIN_ACTIVITY_INTENT_RESULT_CODE);
            */
        }
    };



    // si deux activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MAIN_ACTIVITY_INTENT_RESULT_CODE) {
            if (resultCode == RESULT_OK)
            {
                oneBottle= new Bottle();
                oneBottle = (Bottle) data.getSerializableExtra("bouteille");
                Log.d(TAG, "onClick: ");

                Toast.makeText(MainActivity.this,oneBottle.getName()+""+oneBottle.getPrice(),Toast.LENGTH_SHORT).show();
                maCaveAVin.addBottle(oneBottle.getName(),oneBottle.getPrice());
                Log.d(TAG, "onClick: ");
                //adapter.notifyDataSetChanged();

            }

        }
    }

    // func liaison frag creation bottle
    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    // func liaison frag creation bottle pour envoie des données
    @Override
    public void sendInfo(Bottle sendBottle) {
        oneBottle= sendBottle;

        Toast.makeText(MainActivity.this,oneBottle.getName()+""+oneBottle.getPrice(),Toast.LENGTH_SHORT).show();
        maCaveAVin.addBottle(oneBottle.getName(),oneBottle.getPrice());
        Log.d(TAG, "onClick: ");

        Log.d(TAG, "On envoie la bouteille au serveur : "+ oneBottle.toString());

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ListFrag, fragmentList);
        //fragmentTransaction.hide(fragmentService);
        //fragmentTransaction.show(fragmentList);
        fragmentTransaction.addToBackStack("tag");
        fragmentTransaction.commit();
        fragmentList.updateCave(oneBottle);

        //adapter.notifyDataSetChanged();
    }

    @Override
    public void returnListFrag() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ListFrag, fragmentList);
        fragmentTransaction.addToBackStack("tag");
        fragmentTransaction.commit();

    }





}
