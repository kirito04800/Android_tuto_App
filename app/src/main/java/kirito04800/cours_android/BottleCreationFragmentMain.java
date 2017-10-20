package kirito04800.cours_android;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BottleCreationFragmentMain.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BottleCreationFragmentMain#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BottleCreationFragmentMain extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private String nameBottle;
    private double priceBottle;
    private EditText nameBottleField = null;
    private EditText priceBottleField = null;
    private Button saveButton = null;
    private Bottle sendBottle;

    private OnFragmentInteractionListener mListener;

    public BottleCreationFragmentMain() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BottleCreationFragmentMain.
     */
    // TODO: Rename and change types and number of parameters
    public static BottleCreationFragmentMain newInstance(String param1, String param2) {
        BottleCreationFragmentMain fragment = new BottleCreationFragmentMain();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_bottle_creation_fragment, container, false); // creer instance java

        saveButton = (Button) v.findViewById(R.id.buttonSave);
        saveButton.setOnClickListener(saveBottleOnclickListener);
        nameBottleField = (EditText) v.findViewById(R.id.nameB);
        priceBottleField= (EditText) v.findViewById(R.id.priceB);

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
        void sendInfo(Bottle sendBottle);
        void returnListFrag();
    }



    private View.OnClickListener saveBottleOnclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.d(TAG, "avant intent : ");
            if (!priceBottleField.getText().toString().equals("") && !priceBottleField.getText().toString().equals("")){
                nameBottle = nameBottleField.getText().toString();
                priceBottle = Double.parseDouble(priceBottleField.getText().toString());
                sendBottle = new Bottle(nameBottle, priceBottle);
                if (mListener != null) {
                    mListener.sendInfo(sendBottle);
                }
            }
            else {
                mListener.returnListFrag();
            }




        }
    };
}
