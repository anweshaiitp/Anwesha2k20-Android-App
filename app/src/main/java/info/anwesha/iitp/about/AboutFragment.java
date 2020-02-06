package info.anwesha.iitp.about;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import info.anwesha.iitp.R;
import info.anwesha.iitp.utils.IntentUtils;

public class AboutFragment extends Fragment implements View.OnClickListener {


    private Context context;

    public AboutFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getContext() != null)
            this.context = getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_about, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        ImageView image1 = view.findViewById(R.id.image1);
        ImageView image2 = view.findViewById(R.id.image2);
        ImageView image3 = view.findViewById(R.id.image3);
        ImageView image4 = view.findViewById(R.id.image4);
        ImageView image5 = view.findViewById(R.id.image5);
        ImageView image6 = view.findViewById(R.id.image6);
        ImageView image7 = view.findViewById(R.id.image7);
        ImageView image8 = view.findViewById(R.id.image8);
        ImageView image9 = view.findViewById(R.id.image9);
        ImageView image10 = view.findViewById(R.id.image10);
        CardView call1 = view.findViewById(R.id.card_call_1);
        CardView call2 = view.findViewById(R.id.card_call_2);
        CardView call3 = view.findViewById(R.id.card_call_3);
        CardView call4 = view.findViewById(R.id.card_call_4);
        CardView call5 = view.findViewById(R.id.card_call_5);
        CardView call6 = view.findViewById(R.id.card_call_6);
        CardView call7 = view.findViewById(R.id.card_call_7);
        CardView call8 = view.findViewById(R.id.card_call_8);
        CardView call9 = view.findViewById(R.id.card_call_9);
        CardView call10 = view.findViewById(R.id.card_call_10);

        call1.setOnClickListener(this);
        call2.setOnClickListener(this);
        call3.setOnClickListener(this);
        call4.setOnClickListener(this);
        call5.setOnClickListener(this);
        call6.setOnClickListener(this);
        call7.setOnClickListener(this);
        call8.setOnClickListener(this);
        call9.setOnClickListener(this);
        call10.setOnClickListener(this);

        CardView facebook1 = view.findViewById(R.id.card_facebook_1);
        CardView facebook2 = view.findViewById(R.id.card_facebook_2);
        CardView facebook3 = view.findViewById(R.id.card_facebook_3);
        CardView facebook4 = view.findViewById(R.id.card_facebook_4);
        CardView facebook5 = view.findViewById(R.id.card_facebook_5);
        CardView facebook8 = view.findViewById(R.id.card_facebook_8);
        CardView facebook9 = view.findViewById(R.id.card_facebook_9);
        CardView facebook10 = view.findViewById(R.id.card_facebook_10);

        facebook1.setOnClickListener(this);
        facebook2.setOnClickListener(this);
        facebook3.setOnClickListener(this);
        facebook4.setOnClickListener(this);
        facebook5.setOnClickListener(this);
        facebook8.setOnClickListener(this);
        facebook9.setOnClickListener(this);
        facebook10.setOnClickListener(this);

        CardView github1 = view.findViewById(R.id.card_github_1);
        CardView github2 = view.findViewById(R.id.card_github_2);
        CardView github3 = view.findViewById(R.id.card_github_3);
        CardView github4 = view.findViewById(R.id.card_github_4);
        CardView github5 = view.findViewById(R.id.card_github_5);
        CardView github6 = view.findViewById(R.id.card_github_6);
        CardView github7 = view.findViewById(R.id.card_github_7);
        CardView github8 = view.findViewById(R.id.card_github_8);
        CardView github9 = view.findViewById(R.id.card_github_9);
        CardView github10 = view.findViewById(R.id.card_github_10);
        github1.setOnClickListener(this);
        github2.setOnClickListener(this);
        github3.setOnClickListener(this);
        github4.setOnClickListener(this);
        github5.setOnClickListener(this);
        github6.setOnClickListener(this);
        github7.setOnClickListener(this);
        github8.setOnClickListener(this);
        github9.setOnClickListener(this);
        github10.setOnClickListener(this);

        Glide.with(context).load("http://anwesha.info/gallery/developers/ashwani.jpg")
                .placeholder(R.mipmap.anwesha_icon_round).into(image1);


        Glide.with(context).load("http://anwesha.info/gallery/developers/amish.jpg")
                .placeholder(R.mipmap.anwesha_icon_round).into(image2);


        Glide.with(context).load("http://anwesha.info/images/app/team/subhang.jpg")
              .placeholder(R.mipmap.anwesha_icon_round).into(image3);


        Glide.with(context).load("http://anwesha.info/gallery/developers/amartya.jpg")
                .placeholder(R.mipmap.anwesha_icon_round).into(image4);

        Glide.with(context).load("http://anwesha.info/gallery/developers/somenath.jpg")
                .placeholder(R.mipmap.anwesha_icon_round).into(image5);


        Glide.with(context).load("https://scontent.fdel1-2.fna.fbcdn.net/v/t1.0-0/p480x480/78411567_2411746825744895_7288578639686270976_o.jpg?_nc_cat=104&_nc_ohc=uONelHvmo7kAQkqKqMc4pmOjkmcHJtClYmEMVjkOhzZGlLMPcr43GCORA&_nc_ht=scontent.fdel1-2.fna&oh=a960d468686b630cd3aac20322d979f0&oe=5E8158ED")
                .placeholder(R.mipmap.anwesha_icon_round).into(image6);
        Glide.with(context).load("https://instagram.fjai3-1.fna.fbcdn.net/v/t51.2885-19/s320x320/79750612_1031570117203109_7214083372534988800_n.jpg?_nc_ht=instagram.fjai3-1.fna.fbcdn.net&_nc_ohc=cvcyutp4HtMAX_JU0g7&oh=04ec40bf767c5f4f18968ff32979bdcd&oe=5E96389E").placeholder(R.mipmap.anwesha_icon_round).into(image7);
        Glide.with(context).load("https://scontent.fpat1-1.fna.fbcdn.net/v/t1.0-9/81556673_167301961289350_322462425142001664_n.jpg?_nc_cat=101&_nc_ohc=a4OckavxUEkAQnmtquIYbZATA5GKo74k5AOmbOxxlzl_Idjl6iURoGrDg&_nc_ht=scontent.fpat1-1.fna&oh=38e9c3a31824a4df0b3d284ba078fb31&oe=5E69CAD6").placeholder(R.mipmap.anwesha_icon_round).into(image8);
        Glide.with(context).load("https://scontent.fdel1-2.fna.fbcdn.net/v/t1.0-9/cp0/e15/q65/p720x720/70253157_121698649207771_2210579453472407552_o.jpg?_nc_cat=101&efg=eyJpIjoidCJ9&_nc_ohc=34H-aQrEeN8AQnnzhF5YyAWV4m03VUw4DgCRoXzKiGZ964onzyDN-sSbQ&_nc_ht=scontent.fdel1-2.fna&oh=361bca9b62a39fe12c3a001792911247&oe=5E6ACA7C").placeholder(R.mipmap.anwesha_icon_round).into(image9);
        Glide.with(context).load("https://scontent.fdel1-3.fna.fbcdn.net/v/t1.0-9/fr/cp0/e15/q65/72642224_121631915910324_2013199579935145984_o.jpg?_nc_cat=106&efg=eyJpIjoidCJ9&_nc_ohc=wqKSL8W66Q0AQnvcIC42Z_VOpy7lUxWeRVRwaniRQv_RHB0DqZMstbe0A&_nc_ht=scontent.fdel1-3.fna&oh=05f529eb7bf62d730129d33e870f7512&oe=5E6DC37B").placeholder(R.mipmap.anwesha_icon_round).into(image10);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        Intent intent = new Intent();
        switch (id) {
            case R.id.card_call_1:
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+918299735195"));
                break;
            case R.id.card_call_4:
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+918967570983"));
                break;
            case R.id.card_call_5:
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+918013054710"));
                break;
            case R.id.card_call_2:
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+919821481639"));
                break;
            case R.id.card_call_3:
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+918978880947"));
                break;

            case R.id.card_call_6:
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+917339799440"));
                break;
            case R.id.card_call_7:
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+919610306949"));
                break;
            case R.id.card_call_8:
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+918420607591"));
                break;
            case R.id.card_call_9:
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+917704825224"));
                break;
            case R.id.card_call_10:
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+918910664884"));
                break;

            case R.id.card_facebook_1:
                info.anwesha.iitp.utils.IntentUtils.openWebBrowser(context, "https://www.facebook.com/ashwani.yadav9499");
                return;
            case R.id.card_facebook_4:
                info.anwesha.iitp.utils.IntentUtils.openWebBrowser(context, "https://www.facebook.com/atm1504");
                return;
            case R.id.card_facebook_5:
                info.anwesha.iitp.utils.IntentUtils.openWebBrowser(context, "https://www.facebook.com/somenath.sarkar.39");
                return;
            case R.id.card_facebook_2:
                info.anwesha.iitp.utils.IntentUtils.openWebBrowser(context, "https://www.facebook.com/amish.mittal.fliptrail");
                return;
            case R.id.card_facebook_3:
                info.anwesha.iitp.utils.IntentUtils.openWebBrowser(context, "https://www.facebook.com/subhang.vasireddy");
                return;

            case R.id.card_facebook_8:
                info.anwesha.iitp.utils.IntentUtils.openWebBrowser(context, "https://www.facebook.com/debarghya.maity.52");
                return;
            case R.id.card_facebook_9:
                info.anwesha.iitp.utils.IntentUtils.openWebBrowser(context, "https://www.facebook.com/priyanka.sachan.77964201");
                return;
            case R.id.card_facebook_10:
                info.anwesha.iitp.utils.IntentUtils.openWebBrowser(context, "https://www.facebook.com/mehuli.pal.1");
                return;


            case R.id.card_github_1:
                info.anwesha.iitp.utils.IntentUtils.openWebBrowser(context, "https://github.com/ashwaniYDV");
                return;
            case R.id.card_github_2:
                info.anwesha.iitp.utils.IntentUtils.openWebBrowser(context, "https://github.com/fliptrail");
                return;
            case R.id.card_github_4:
                info.anwesha.iitp.utils.IntentUtils.openWebBrowser(context, "https://github.com/atm1504");
                return;
            case R.id.card_github_5:
                info.anwesha.iitp.utils.IntentUtils.openWebBrowser(context, "https://github.com/somenath1435");
                return;
            case R.id.card_github_3:
                IntentUtils.openWebBrowser(context, "https://github.com/Subhang23");
                return;
            case R.id.card_github_6:
                IntentUtils.openWebBrowser(context, "https://github.com/s-ayush2903/");
                return;
            case R.id.card_github_7:
                IntentUtils.openWebBrowser(context, "https://github.com/Kavya-24");
                return;
            case R.id.card_github_8:
                IntentUtils.openWebBrowser(context, "https://github.com/debarghya472/");
                return;
            case R.id.card_github_9:
                IntentUtils.openWebBrowser(context, "https://github.com/Priyanka-Sachan");
                return;
            case R.id.card_github_10:
                IntentUtils.openWebBrowser(context, "https://github.com/Mehulipal");
                return;

        }

        startActivity(intent);
    }
}
