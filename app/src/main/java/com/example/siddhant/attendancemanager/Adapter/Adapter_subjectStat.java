package com.example.siddhant.attendancemanager.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    ArrayList<subject>marr;
    Context mcontext;

    public Adapter_subjectStat(ArrayList<subject> marr, Context mcontext) {
        this.marr = marr;
        this.mcontext = mcontext;
    }

    @Override
    public Adapter_subjectStat.ourHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mcontext).inflate(R.layout.subject,parent,false);

        return new ourHolder(v);

    }

    @Override
    public void onBindViewHolder(final Adapter_subjectStat.ourHolder holder, int position) {
        int max=30;
        int classes_left=marr.get(position).getLeft_classes();
       int total=marr.get(position).getTotal_classes();
        int bunks=marr.get(position).getBunks_available();
        int attended=marr.get(position).getClasses_attended();

        int percentage=marr.get(position).getPercentage();
        holder.subjectName.setText(marr.get(position).getName());
        if(percentage<75){
            holder.dp.setFinishedStrokeColor(Color.rgb(255,0,0));

        }
        else {
            holder.dp.setFinishedStrokeColor(Color.rgb(0,255,0));
        }
        Animation_for_circularProgress(holder.dp,percentage);
        Animation_for_circularProgress(holder.dp1,bunks);
        Animation_for_circularProgress(holder.dp2,attended);
        Animation_for_circularProgress(holder.dp3,classes_left);


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
        return marr.size();
    }
    public class ourHolder extends  RecyclerView.ViewHolder{
        TextView subjectName;
        DonutProgress dp;
        DonutProgress dp1;
        DonutProgress dp2;
        DonutProgress dp3;


        public ourHolder(View itemView) {
            super(itemView);
            subjectName=(TextView)itemView.findViewById(R.id.subject_name);
            dp=(DonutProgress) itemView.findViewById(R.id.donut_progress);
            dp1=(DonutProgress) itemView.findViewById(R.id.donut_progress1);
            dp2=(DonutProgress) itemView.findViewById(R.id.donut_progress2);
            dp3=(DonutProgress) itemView.findViewById(R.id.donut_progress3);

        }
    }
}
