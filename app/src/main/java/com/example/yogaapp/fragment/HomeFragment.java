package com.example.yogaapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yogaapp.Pose;
import com.example.yogaapp.PoseAdapter;
import com.example.yogaapp.story.Category;
import com.example.yogaapp.story.CategoryAdapter;
import com.example.yogaapp.MainActivity;
import com.example.yogaapp.R;
import com.example.yogaapp.story.Story;
import com.example.yogaapp.story.StoryAdapter;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView rcvStory,rcvNewbies,rcvPrcrl;
    private View mView;
    private MainActivity mainActivity;
    private List<Story> list;
    private StoryAdapter storyAdapter;
    CategoryAdapter categoryAdapter;
    ArrayList<Category> arrayListCategories;
    PoseAdapter poseAdapter;

    FirebaseDatabase database = FirebaseDatabase.getInstance();


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public HomeFragment() {

    }


    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_home, container, false);
        mainActivity = (MainActivity) getActivity();
        getViewCategories();
        getViewPrc();
        getViewNewprc();
        return mView;
    }
//bài tập mới
    private void getViewNewprc() {
        rcvNewbies =mView.findViewById(R.id.rcv_newbies);
        poseAdapter = new PoseAdapter(mainActivity);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( mainActivity,RecyclerView.HORIZONTAL,false);
        rcvNewbies.setLayoutManager(linearLayoutManager);
        poseAdapter.setData(getListNewPose());
        rcvNewbies.setAdapter(poseAdapter);
    }

    private List<Pose> getListNewPose() {
        List<Pose> list = new ArrayList<>();
        list.add(new Pose(R.drawable.y706de8b11e, "Tư thế con cá"));
        list.add(new Pose(R.drawable.hatha8008691c0649643488f, "Tư thế con cá"));
        list.add(new Pose(R.drawable.hatha8008691c0649643488f, "Tư thế con cá"));
        list.add(new Pose(R.drawable.hatha8008691c0649643488f, "Tư thế con cá"));
        list.add(new Pose(R.drawable.hatha8008691c0649643488f, "Tư thế con cá"));
        return list;
    }

    //bài tập thư giãn
    private void getViewPrc() {
        rcvPrcrl =mView.findViewById(R.id.rcv_processrl);
        poseAdapter = new PoseAdapter(mainActivity);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( mainActivity,RecyclerView.HORIZONTAL,false);
        rcvPrcrl.setLayoutManager(linearLayoutManager);
        poseAdapter.setData(getListPose());
        rcvPrcrl.setAdapter(poseAdapter);
    }

    private List<Pose> getListPose() {
        List<Pose> list = new ArrayList<>();
        list.add(new Pose(R.drawable.hatha8008691c0649643488f, "Tư thế con cá"));
        list.add(new Pose(R.drawable.hatha8008691c0649643488f, "Tư thế con cá"));
        list.add(new Pose(R.drawable.hatha8008691c0649643488f, "Tư thế con cá"));
        list.add(new Pose(R.drawable.hatha8008691c0649643488f, "Tư thế con cá"));
        list.add(new Pose(R.drawable.hatha8008691c0649643488f, "Tư thế con cá"));
        return list;

    }
//story
    public void getViewCategories(){
        rcvStory =mView.findViewById(R.id.rcv_list_stories);
        storyAdapter = new StoryAdapter(mainActivity);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( mainActivity,RecyclerView.HORIZONTAL,false);
        rcvStory.setLayoutManager(linearLayoutManager);
        storyAdapter.setData(getListStr());
        rcvStory.setAdapter(storyAdapter);
    }
    private List<Story> getListStr() {
        List<Story> list = new ArrayList<>();
        list.add(new Story(R.drawable.str1, "Tập thở"));
        list.add(new Story(R.drawable.str2, "Tập thở"));
        list.add(new Story(R.drawable.str3, "Tập thở"));

        return list;
    }
}