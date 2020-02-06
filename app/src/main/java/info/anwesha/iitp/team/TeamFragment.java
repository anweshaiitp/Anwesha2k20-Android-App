package info.anwesha.iitp.team;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import info.anwesha.iitp.R;



public class TeamFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_team, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        RecyclerView recyclerView = view.findViewById(R.id.recycler_team);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        info.anwesha.iitp.team.TeamRecyclerAdapter adapter = new TeamRecyclerAdapter(getContext());
        recyclerView.setAdapter(adapter);

        List<info.anwesha.iitp.team.TeamItem> allMembers = new ArrayList<>();

//        allMembers.add(new info.anwesha.iitp.team.TeamItem("Mayank Wadhwani", "Fest Convener", "8181068781", "https://www.facebook.com/mayank.wadhwani", R.drawable.mayank_wadhwani));
        allMembers.add(new info.anwesha.iitp.team.TeamItem("Pranil Kesaralikar", "Overall Fest Coordinator", "6201169731", "https://www.facebook.com/pranil.kesaralikar", R.drawable.pranil));
        allMembers.add(new info.anwesha.iitp.team.TeamItem("Hitvardhan ", "Coordinator - Marketing and Sponsorship", "7761891077", "https://m.facebook.com/vardhan.hit", R.drawable.hitvardhan));
        allMembers.add(new info.anwesha.iitp.team.TeamItem("Nandan Shah ", "Coordinator - Marketing and Sponsorship", "0", "https://m.facebook.com/anwesha.iitpatna", R.drawable.nandan));
        allMembers.add(new info.anwesha.iitp.team.TeamItem("Mridul Srivastava ", "Coordinator - Marketing and Sponsorship", "0", "https://www.facebook.com/mridul.srivastava.3192", R.drawable.mridul));
        allMembers.add(new info.anwesha.iitp.team.TeamItem("Himanshu Gupta", "Coordinator - Media and Public Relations", "9521205729", "https://www.facebook.com/himgupta134", R.drawable.himanshu_gupta));
        allMembers.add(new info.anwesha.iitp.team.TeamItem("Kartik Singh", "Coordinator - Media and Public Relations", "8077516207", "https://www.facebook.com/profile.php?id=100005570138494", R.drawable.karthik_singh));
        allMembers.add(new info.anwesha.iitp.team.TeamItem("Bhavani Susmitha", "Coordinator - Media and Public Relations", "9123519137", "https://m.facebook.com/bhavani.susmitha", R.drawable.bhavani_susmitha));
        allMembers.add(new info.anwesha.iitp.team.TeamItem("Shivansh Shukla", "Pro Show Coordinator ", "8707499083", "https://facebook.com/shivansh.shukla.50", R.drawable.shivansh));
        allMembers.add(new info.anwesha.iitp.team.TeamItem("Kshitij Jain", "Coordinator - Development Team", "9131604185", "https://www.facebook.com/kshitij.jain.39904", R.drawable.kshitij_jain));
        allMembers.add(new info.anwesha.iitp.team.TeamItem("Adarsh Chaudhary ", "Coordinator - Development Team", "8827275145", "https://www.facebook.com/adarsh217", R.drawable.adarsh_chaudhary));
        allMembers.add(new info.anwesha.iitp.team.TeamItem("Vatsal Singhal", "Coordinator - Development Team", "8585992062", "https://m.facebook.com/vatsalsinghal1", R.drawable.vatsal_singhal));
        allMembers.add(new info.anwesha.iitp.team.TeamItem("Rajeshwar Ojha", "Coordinator - Creatives And Design", "07000125484", "https://www.facebook.com/rajeshwar.ojha.50", R.drawable.rajeshwar));
        allMembers.add(new info.anwesha.iitp.team.TeamItem("Utkarsh", "Coordinator - Creatives And Design", "08987044093", "https://www.facebook.com/utkarsh.virtuous", R.drawable.utkarsh));
        allMembers.add(new info.anwesha.iitp.team.TeamItem("Nikhil George", "Coordinator - Creatives And Design", "9060459361", "https://www.facebook.com/nikhil.george.102", R.drawable.nikhil_george));
        allMembers.add(new info.anwesha.iitp.team.TeamItem("Kanav Ghai", "Coordinator - Arts And Events Welfare", "7009857311", "https://www.facebook.com/kanav.ghai.1", R.drawable.kanav));
        allMembers.add(new info.anwesha.iitp.team.TeamItem("Deep Roshan", "Coordinator - Arts And Events Welfare", "0", "https://m.facebook.com/anwesha.iitpatna", R.drawable.deep));
        allMembers.add(new info.anwesha.iitp.team.TeamItem("Piyush Tiwary", "Coordinator - Technical Events Committee", "0", "https://www.facebook.com/thebackpropogator", R.drawable.piyush_tiwary));
        allMembers.add(new info.anwesha.iitp.team.TeamItem("Piyush Chauhan", "Coordinator - Technical Events Committee", "0", "https://www.facebook.com/piyushchauhaniitp", R.drawable.piyush_chauhan));
        allMembers.add(new info.anwesha.iitp.team.TeamItem("Avinash Singh", "Coordinator - Cultural Events Committee", "0", "https://www.facebook.com/profile.php?id=100021493361913", R.drawable.avinash));
        allMembers.add(new info.anwesha.iitp.team.TeamItem("Vivek Garg", "Coordinator - Cultural Events Committee", "0", "https://www.facebook.com/vivek.garg.102977", R.drawable.vivek));
        allMembers.add(new info.anwesha.iitp.team.TeamItem("Saurabh Gupta", "Coordinator - Cultural Events Committee", "0", "https://www.facebook.com/saurabh1666prime", R.drawable.saurabh));
        allMembers.add(new info.anwesha.iitp.team.TeamItem("Rahul Grover", "Coordinator - Hospitality", "8847433272", "https://m.facebook.com/rahulgrover1999", R.drawable.grover));
        allMembers.add(new info.anwesha.iitp.team.TeamItem("Rakshit Bhatt", "Coordinator - Hospitality", "9627765739", "https://m.facebook.com/", R.drawable.rakshit_bhatt));
        allMembers.add(new info.anwesha.iitp.team.TeamItem("Naveen Rathi", "Coordinator - Registrations And Security", "9079691918", "https://www.facebook.com/naveen.rathi.39395", R.drawable.naveen));
        allMembers.add(new info.anwesha.iitp.team.TeamItem("D K Gurjar", "Coordinator - Registrations And Security", "9352052504", "https://www.dontUseFacebook.com", R.drawable.dk));
        allMembers.add(new info.anwesha.iitp.team.TeamItem("Neeraj Paraliya", "Coordinator - Registrations And Security", "0", "https://www.facebook.com/profile.php?id=100013775678152", R.drawable.neeraj));
        allMembers.add(new info.anwesha.iitp.team.TeamItem("Anuj Shastri", "Coordinator - Registrations And Security", "0", "https://www.facebook.com/anuj.shastri.3910", R.drawable.anuj_shastri));

        adapter.setTeamItemList(allMembers);

        super.onViewCreated(view, savedInstanceState);
    }

}
