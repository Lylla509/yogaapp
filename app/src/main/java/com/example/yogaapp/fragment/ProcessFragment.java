package com.example.yogaapp.fragment;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.example.yogaapp.MainActivity;
import com.example.yogaapp.Pose;
import com.example.yogaapp.PoseAdapter;
import com.example.yogaapp.R;
import com.example.yogaapp.Tht;
import com.example.yogaapp.ThtAdapter;
import com.example.yogaapp.story.Category;
import com.example.yogaapp.story.CategoryAdapter;
import com.example.yogaapp.story.Story;
import com.example.yogaapp.story.StoryAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProcessFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProcessFragment extends Fragment {
    private RecyclerView rcvprc, rcv_tht;
    private View mView;
    private MainActivity mainActivity;
    private List<Story> list;
    private StoryAdapter storyAdapter;
    CategoryAdapter categoryAdapter;
    ArrayList<Category> arrayListCategories;
    PoseAdapter poseAdapter;
    private ThtAdapter mthtAdapter;//
    private List<Tht> mListTht;//
    GridView gridView;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference mref = database.getReference("Poses");



    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    public ProcessFragment() {
    }
    public static ProcessFragment newInstance(String param1, String param2) {
        ProcessFragment fragment = new ProcessFragment();
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
        mView = inflater.inflate(R.layout.fragment_process, container, false);
        mainActivity = (MainActivity) getActivity();

        getTht();
        getViewPrc();

        return mView;
    }

    //bài tập
    private void getViewPrc() {
        rcvprc =mView.findViewById(R.id.rcv_process);
        poseAdapter = new PoseAdapter(mainActivity);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager( mainActivity, RecyclerView.HORIZONTAL,false);
        rcvprc.setLayoutManager(linearLayoutManager);
        poseAdapter.setData(getListNewPose());
        rcvprc.setAdapter(poseAdapter);
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

    //
    private void getTht(){
        rcv_tht = mView.findViewById(R.id.rcv_tht);//
        mListTht = new ArrayList<>();
        mthtAdapter = new ThtAdapter(mListTht);//

        //GridLayoutManager gridLayoutManager = new GridLayoutManager(mainActivity, 2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mainActivity, RecyclerView.VERTICAL, false);
        rcv_tht.setLayoutManager(linearLayoutManager);

        mref.limitToLast(4).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                System.out.println(snapshot);
                if(mListTht.size() > 0) {mListTht.clear();}
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Tht tht = dataSnapshot.getValue(Tht.class);
                    mListTht.add(new Tht(tht.getIdTht(), tht.getNameTht()));//
            }
                //System.out.println(snapshot);
                mthtAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        rcv_tht.setAdapter(mthtAdapter);
    }
    
}