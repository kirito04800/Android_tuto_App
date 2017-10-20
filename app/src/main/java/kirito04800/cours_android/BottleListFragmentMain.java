package kirito04800.cours_android;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * to handle interaction events.
 * Use the {@link BottleListFragmentMain#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BottleListFragmentMain extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = MainActivity.class.getSimpleName();


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //private OnFragmentInteractionListener mListener;



    private Cellar maCaveAVin = new Cellar();
    //private ListView listView = null ;
    private BottleAdapter adapter= null ;
    private View v;
    @BindView(R.id.list_item_View)  ListView listView;

    public BottleListFragmentMain() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BottleListFragmentMain.
     */
    // TODO: Rename and change types and number of parameters
    public static BottleListFragmentMain newInstance(String param1, String param2) {
        BottleListFragmentMain fragment = new BottleListFragmentMain();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        Log.d(TAG, "OBJET CREE ");
        adapter = new BottleAdapter(getActivity(), this.maCaveAVin.getListeBottle());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.d(TAG, "VUE LIST CREE ");
        v = inflater.inflate(R.layout.activity_bottle_list_fragment, container, false); // creer instance java

        ButterKnife.bind(this,v);
        //listView = (ListView) v.findViewById(R.id.list_item_View);
        Log.d(TAG,"listviewwww");

        if (listView.getAdapter()==null){
            listView.setAdapter(adapter);
            Log.d(TAG,adapter.toString());
        }



        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        /*if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }*/
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    /*
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);

    }*/

    public void updateCave(Bottle bottle){
        this.maCaveAVin.addBottle(bottle.getName(),bottle.getPrice());
        //Log.d(TAG,this.maCaveAVin.getListeBottle().get(0).getName());

        Log.d(TAG,listView.toString());
        adapter.notifyDataSetChanged();
        Log.d(TAG,"adapteur ID : "+adapter.toString());
        Log.d(TAG,"test actualiser ");
    }


    };

