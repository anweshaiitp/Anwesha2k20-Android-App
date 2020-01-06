package info.anwesha.iitp.accomodation;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import info.anwesha.iitp.R;


public class AccomodationFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private Button submit_button;
    private Spinner accomodation_options_spinner;


    public AccomodationFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_accomodation, container, false);
        submit_button = rootview.findViewById(R.id.book_button);
        accomodation_options_spinner = rootview.findViewById(R.id.accoomo_spinner);
        return rootview;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(), R.array.days_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        accomodation_options_spinner.setAdapter(adapter);
        submit_button.setClickable(false);
        submit_button.setEnabled(false);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        accomodation_options_spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
