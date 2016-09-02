package com.example.siddhant.attendancemanager.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.siddhant.attendancemanager.Class.subject;
import com.example.siddhant.attendancemanager.R;
import com.github.lzyzsd.circleprogress.DonutProgress;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by ABC on 31-08-2016.
 */
public class Adapter_subjectStat extends RecyclerView.Adapter<Adapter_subjectStat.ourHolder> {

    ArrayList<subject> subjectsStatList;
    Context mcontext;

    public Adapter_subjectStat(ArrayList<subject> marr, Context mcontext) {
        this.subjectsStatList = marr;
        this.mcontext = mcontext;
    }

    @Override
    public Adapter_subjectStat.ourHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mcontext).inflate(R.layout.subject,parent,false);

        //Adjusting size of subject card wrt to screen size
        DisplayMetrics displaymetrics ;
        displaymetrics = mcontext.getApplicationContext().getResources().getDisplayMetrics();
        int height = displaymetrics.heightPixels;
        int customHeight = height*5/7 ;
        v.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,customHeight));
        //Adjusting margins of subject card
        LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT, RecyclerView.LayoutParams.WRAP_CONTENT);
        buttonLayoutParams.setMargins(0, 10, 0, 0);
        v.setLayoutParams(buttonLayoutParams);

        return new ourHolder(v);

    }

    @Override
    public void onBindViewHolder(final Adapter_subjectStat.ourHolder holder, int position) {
        int max=30;
        int classes_left=subjectsStatList.get(position).getLeft_classes();
        int total=subjectsStatList.get(position).getTotal_classes();
        int bunks=subjectsStatList.get(position).getBunks_available();
        int attended=subjectsStatList.get(position).getClasses_attended();
        int percentage=subjectsStatList.get(position).getPercentage();

        holder.subjectName.setText(subjectsStatList.get(position).getName());
        if(percentage<75){
            holder.dp_percentage.setFinishedStrokeColor(Color.rgb(255,0,0));

        }
        else {
            holder.dp_percentage.setFinishedStrokeColor(Color.rgb(0,255,0));
        }
        Animation_for_circularProgress(holder.dp_percentage,percentage);
        Animation_for_circularProgress(holder.dp_bunks,bunks);
        Animation_for_circularProgress(holder.dp_attended,attended);
        Animation_for_circularProgress(holder.dp_classesLeft,classes_left);


    }
    public void  Animation_for_circularProgress(final DonutProgress DP, final int max){
        final int[] progress = {0};
        final Handler handler = new Handler();

        final Runnable Update = new Runnable() {
            public void run() {
                if(progress[0]<max)
                    DP.setProgress(++progress[0]);
            }
        };

        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(Update);
            }
        }, 500, 30);
    }

    @Override
    public int getItemCount() {
        return subjectsStatList.size();
    }
    public class ourHolder extends  RecyclerView.ViewHolder{
        TextView subjectName;
        DonutProgress dp_percentage;
        DonutProgress dp_bunks;
        DonutProgress dp_attended;
        DonutProgress dp_classesLeft;


        public ourHolder(View itemView) {
            super(itemView);
            subjectName=(TextView)itemView.findViewById(R.id.subject_name);
            dp_percentage=(DonutProgress) itemView.findViewById(R.id.donut_progress);
            dp_bunks=(DonutProgress) itemView.findViewById(R.id.donut_progress1);
            dp_attended=(DonutProgress) itemView.findViewById(R.id.donut_progress2);
            dp_classesLeft=(DonutProgress) itemView.findViewById(R.id.donut_progress3);

        }
    }
}
