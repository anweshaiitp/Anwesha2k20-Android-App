package info.anwesha.iitp.sponsors;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import info.anwesha.iitp.R;

public class SponsorsFragment extends Fragment {

    public SponsorsFragment() {
    }

    private SponsorsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sponsors, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_sponsors);
//        Log.e("rcyclr: ",recyclerView.toString());
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        //recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new SponsorsAdapter(getContext());
        recyclerView.setAdapter(adapter);

        populateData();

        return view;
    }

    private void populateData() {

        List<SponsorItem> sponsorItems = new ArrayList<>();

        sponsorItems.add(new SponsorItem("Title Sponsor", "https://i.imgur.com/i08F0au.png", "https://www.airtel.in/", "Airtel"));
        sponsorItems.add(new SponsorItem("EDM Night & Official Music Partner", "https://i.imgur.com/0uHcCTF.jpg ", "https://gaana.com/", "Gaana"));


        sponsorItems.add(new SponsorItem("Associate Sponsor", "https://i.imgur.com/sM9mfam.jpg", " http://www.yac.bih.nic.in/", "YAC"));
        sponsorItems.add(new SponsorItem("Associate Sponsor", "https://i.imgur.com/uycuJOA.jpg", "http://www.rubanpatliputrahospital.com/", "Ruban"));
        sponsorItems.add(new SponsorItem("Associate Sponsor", "https://i.imgur.com/WCqfwVC.jpg", "http://www.bsedc.bihar.gov.in/", "Beltron"));

        sponsorItems.add(new SponsorItem("Key Partner", "https://i.imgur.com/kLddyyV.jpg", "http://www.bihartourism.gov.in/", "Bihar Tourism"));
        sponsorItems.add(new SponsorItem("Key Partner", "https://i.imgur.com/fStmMft.png", "http://ncclimited.com/", "NCC"));


        sponsorItems.add(new SponsorItem("Media Partner", "https://i.imgur.com/ce0x8MA.jpg", "https://www.radiomirchi.com/", "Radio Mirchi"));
        sponsorItems.add(new SponsorItem("Media Partner", "https://i.imgur.com/0T1xLg2.png", " https://www.campusvarta.com/", "Campus Vatra"));
        sponsorItems.add(new SponsorItem("Media Partner", "https://i.imgur.com/sjvmOQf.jpg", " http://www.biharsehai.in/", "Bihar Se Hai"));
        sponsorItems.add(new SponsorItem("Media Partner", "https://i.imgur.com/03vhL82.jpg", "http://icetl.com/", "Laughter Helpline"));

        sponsorItems.add(new SponsorItem("Event Sponsor", "https://i.imgur.com/NP3f5r5.jpg", " http://www.bseidc.in/", "BSEIDC"));
        sponsorItems.add(new SponsorItem("Event Sponsor", "https://i.imgur.com/wy9U3xo.png", "  https://www.daikinindia.com/", "Daikin"));
        sponsorItems.add(new SponsorItem("Event Sponsor", "https://i.imgur.com/L5KFsBx.jpg", "https://www.iocl.com/", "IOCL"));

        sponsorItems.add(new SponsorItem("Strategic Sponsor", "https://i.imgur.com/m4BJPhy.png", "https://www.canarabank.com/english", "Canara Bank"));
        sponsorItems.add(new SponsorItem("Strategic Sponsor", "https://i.imgur.com/SllGnaM.jpg", "https://www.godrej.com", "Godrej"));
        sponsorItems.add(new SponsorItem("Strategic Sponsor", "https://i.imgur.com/Wb1CQaT.jpg", "https://www.onlinesbi.com", "SBI"));


        sponsorItems.add(new SponsorItem("Food Partner", "https://i.imgur.com/IDXW6hy.png", "https://www.townscript.com/in/patna", "Pizza Hut"));
        sponsorItems.add(new SponsorItem("Food Partner", "https://i.imgur.com/0JUA5tJ.jpg", "https://thebelgianwaffle.co/", "Belgian Waffle"));
        sponsorItems.add(new SponsorItem("Food Partner", "https://i.imgur.com/499aoTI.png ", "http://www.goldenflavours.in/", "Golden Flavour"));
        sponsorItems.add(new SponsorItem("Food Partner", "https://i.imgur.com/0cYc6lP.png", "https://www.monginis.net/", "Monginis"));
        sponsorItems.add(new SponsorItem("Food Partner", "https://i.imgur.com/3f3ra21.png", "https://www.nescafe.com/", "Nescafe"));
        sponsorItems.add(new SponsorItem("Food Partner", "https://i.imgur.com/N2JPN6s.png", " https://www.facebook.com/FlavorsPatna/", "Flavors"));
        sponsorItems.add(new SponsorItem("Food Partner", "https://i.imgur.com/hQaNrHj.png", "https://www.facebook.com/pages/category/Restaurant/Highway-Restaurant-n-Bakers-1209279092543065/", "Highway"));
        sponsorItems.add(new SponsorItem("Food Partner", "https://i.imgur.com/vOUJlgM.png ", "http://www.indiansummercafe.com/", "Indian Summer"));
        sponsorItems.add(new SponsorItem("Food Partner", "https://i.imgur.com/LTKZd0s.png", "https://www.facebook.com/gangotri.in", "Gangotri"));


        sponsorItems.add(new SponsorItem("Apparel Partner", "https://i.imgur.com/J92DiUm.png", "https://maxapparel.com/", "Max"));
        sponsorItems.add(new SponsorItem("Colouring Partner", "https://i.imgur.com/sByiVjf.jpg", " https://www.nerolac.com/", "Nerolac"));

        sponsorItems.add(new SponsorItem("Ticketing Partner", "https://i.imgur.com/8N1wdcn.png", "https://www.townscript.com/in/patna", "TownScript"));
        sponsorItems.add(new SponsorItem("Grooming Partner", "https://i.imgur.com/vtW1vRH.png", "https://www.monsoonsalon.com/", "Monsoon Salon"));
        sponsorItems.add(new SponsorItem("Official Lens Partner", "https://i.imgur.com/7qOnx9k.png", " https://www.lensfit.com/", "LensFit"));
        sponsorItems.add(new SponsorItem("Industrial Skill Development Partner", "https://i.imgur.com/piqAIll.png", " https://foxmula.com/", "Foxmula"));
        sponsorItems.add(new SponsorItem("Beverage Partner", "https://i.imgur.com/fM29tix.png", " https://www.coca-colaindia.com/", "Coca Cola"));
        sponsorItems.add(new SponsorItem("Security Partner", "https://i.imgur.com/YMoY2X3.jpg", "http://bvglife.in/", "BVG"));
        sponsorItems.add(new SponsorItem("Ethnic Wear Partner", "https://i.imgur.com/2UGcZA3.jpg ", "https://www.fabindia.com/", "Fab India"));
        sponsorItems.add(new SponsorItem("Housekeeping Partner", "https://i.imgur.com/FCyObGG.png", "https://www.engconvo.com/", "CHS"));
        sponsorItems.add(new SponsorItem("Entertainment Partner", "https://i.imgur.com/cS1GMcP.png ", "http://bingosnacks.com/", "Bingo"));


//
//        sponsorItems.add(new SponsorItem("Event Sponsor", "http://www.celesta.org.in/assets/images/sponsors/icetl.png", "http://icetl.com/"));
//        sponsorItems.add(new SponsorItem("Event Sponsor", "http://www.celesta.org.in/assets/images/sponsors/engconvo.png", "https://www.engconvo.com/"));
//        sponsorItems.add(new SponsorItem("Event Sponsor", "http://www.celesta.org.in/assets/images/sponsors/quadnation.png", "https://quadnationdrone.business.site/?utm_source=gmb&utm_medium=referral"));
//
//        sponsorItems.add(new SponsorItem("Workshop Partner", "http://www.celesta.org.in/assets/images/sponsors/techobyte.png", "https://techobytes.com/"));
//
//        sponsorItems.add(new SponsorItem("Key Partner", "http://www.celesta.org.in/assets/images/sponsors/hero.png", "https://www.heromotocorp.com/en-in/"));
//
//        sponsorItems.add(new SponsorItem("Strategic Partner", "http://www.celesta.org.in/assets/images/sponsors/startupbihar.png", "http://www.startup.bihar.gov.in/"));
//
//        sponsorItems.add(new SponsorItem("Advisory Partner", "http://www.celesta.org.in/assets/images/sponsors/eventom.png", "https://eventomindia.jimdofree.com/"));
//
//        sponsorItems.add(new SponsorItem("Hospitality Partner", "http://www.celesta.org.in/assets/images/sponsors/AmalfiGrand.png", "http://www.amalfigrand.com/"));
//
//        sponsorItems.add(new SponsorItem("Coding Partners", "http://www.celesta.org.in/assets/images/sponsors/hackerearth_new.png", "https://www.hackerearth.com"));
//
//        sponsorItems.add(new SponsorItem("Implementation Partner", "https://celesta.org.in/assets/images/sponsors/techprolabz.png", "http://www.techprolabz.com/"));
//        sponsorItems.add(new SponsorItem("Implementation Partner", "http://www.celesta.org.in/assets/images/sponsors/sybyline.png", "http://sybytech.com/"));
//        sponsorItems.add(new SponsorItem("Implementation Partner", "http://www.celesta.org.in/assets/images/sponsors/eduquis.png", "https://www.facebook.com/Eduquis-Technology-114371789937992/"));
//
//        sponsorItems.add(new SponsorItem("Beverage Partner", "http://www.celesta.org.in/assets/images/sponsors/coca.png", "https://www.coca-colaindia.com/"));
//
//        sponsorItems.add(new SponsorItem("Audio Partner", "http://www.celesta.org.in/assets/images/sponsors/zebronics2.png", "https://zebronics.com"));
//
//        sponsorItems.add(new SponsorItem("Merchandise Partner", "http://www.celesta.org.in/assets/images/sponsors/layyon.png", "http://www.layyon.com/"));
//
//        sponsorItems.add(new SponsorItem("Online Media Partner", "http://www.celesta.org.in/assets/images/sponsors/patnaites.png", "http://patnaites.com/"));
//        sponsorItems.add(new SponsorItem("Online Media Partner", "http://www.celesta.org.in/assets/images/sponsors/ABJ.png", "https://www.facebook.com/AmazingBiharJharkhand/"));
//
//        sponsorItems.add(new SponsorItem("Printing Partner", "http://www.celesta.org.in/assets/images/sponsors/eventom.png", "https://eventomindia.jimdofree.com/"));
//
//        sponsorItems.add(new SponsorItem("Gifting Partner", "http://www.celesta.org.in/assets/images/sponsors/thesouledstore.png", "https://www.thesouledstore.com/"));
//
//        sponsorItems.add(new SponsorItem("Online Savings Partner", "http://www.celesta.org.in/assets/images/sponsors/grabon.png", "https://www.grabon.in/"));
//
//        sponsorItems.add(new SponsorItem("Privilege Partner", "http://www.celesta.org.in/assets/images/sponsors/swiggy.png", "https://www.swiggy.com/"));
//
        adapter.setSponsorItemList(sponsorItems);

    }

}
