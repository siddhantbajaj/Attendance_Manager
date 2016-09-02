package com.example.siddhant.attendancemanager.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.siddhant.attendancemanager.Adapter.Adapter_subjectStat;
import com.example.siddhant.attendancemanager.Class.subject;
import com.example.siddhant.attendancemanager.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_stat extends Fragment {
    ArrayList<subject> arr=new ArrayList<>();
    Adapter_subjectStat adapter;
    int cls_attend[]={10,25,12,13,14,15};


    public Fragment_stat() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_fragment_stat, container, false);
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        initialize_subject();
        initialize_subject_data();

        adapter=new Adapter_subjectStat(arr,getActivity());
        GridLayoutManager glm=new GridLayoutManager(getActivity(),1);
       // LinearLayoutManager lm=new LinearLayoutManager(getActivity());
        //lm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(glm);
        return v;
    }
    private void initialize_subject_data() {
        int attended;
        int left;
        int bunks;
        int percentage;
        int count=0;
    for(subject s:arr){
        attended=cls_attend[count];
        count++;
        left=s.getTotal_classes()-attended;
        bunks=left+attended-(75*s.getTotal_classes())/100;
        percentage=(attended*100)/(s.getTotal_classes());
        s.setBunks_available(bunks);
        s.setClasses_attended(attended);
        s.setLeft_classes(left);
        s.setPercentage(percentage);
    }
    }
    private void initialize_subject() {
        arr.add(new subject("Maths",30));
        arr.add(new subject("DS",30));
        arr.add(new subject("C&S",30));
        arr.add(new subject("FCS",30));
        arr.add(new subject("STLD",30));
        arr.add(new subject("CGMM",30));
    }

}
