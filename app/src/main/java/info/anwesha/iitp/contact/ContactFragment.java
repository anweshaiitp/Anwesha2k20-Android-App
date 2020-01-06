package info.anwesha.iitp.contact;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import info.anwesha.iitp.R;
import info.anwesha.iitp.utils.IntentUtils;

public class ContactFragment extends Fragment implements View.OnClickListener {

    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getContext() != null)
            this.context = getContext();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contact_us, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        CardView bus = view.findViewById(R.id.bus_schedule);
        CardView fb = view.findViewById(R.id.connect_facebook);
        CardView inst = view.findViewById(R.id.connect_instagram);
        CardView youtube = view.findViewById(R.id.connect_youtube);
        CardView link = view.findViewById(R.id.connect_linkedin);

        fb.setOnClickListener(this);
        inst.setOnClickListener(this);
        youtube.setOnClickListener(this);
        link.setOnClickListener(this);
        bus.setOnClickListener(this);


        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        switch (id) {
            case R.id.bus_schedule:
                info.anwesha.iitp.utils.IntentUtils.openWebBrowser(context, "https://www.iitp.ac.in/index.php?option=com_content&view=article&id=60&Itemid=66");
                break;
            case R.id.connect_facebook:
                info.anwesha.iitp.utils.IntentUtils.openWebBrowser(context, "https://m.facebook.com/anwesha.iitpatna/");
                break;
            case R.id.connect_instagram:
                info.anwesha.iitp.utils.IntentUtils.openWebBrowser(context, "https://www.instagram.com/anwesha.iitp/");
                break;
            case R.id.connect_youtube:
                info.anwesha.iitp.utils.IntentUtils.openWebBrowser(context, "https://www.youtube.com/user/AnweshaIITP");
                break;
            case R.id.connect_linkedin:
                IntentUtils.openWebBrowser(context, "https://in.linkedin.com/company/anweshaiitp");
                break;
        }

    }
}