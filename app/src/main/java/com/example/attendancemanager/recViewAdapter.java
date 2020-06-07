package com.example.attendancemanager;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;



public class recViewAdapter extends RecyclerView.Adapter<recViewAdapter.viewHolder> {

    MyHelper helper;
    List<SubjectModel> list ;

    public recViewAdapter(List<SubjectModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_recview, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        holder.subject.setText(list.get(position).getSubject());
        holder.classesAttended.setText(list.get(position).getClassesAttended());
        holder.totalClasses.setText("/"+list.get(position).getTotalClasses());
        String result =String.valueOf(Integer.valueOf( list.get(position).getClassesAttended() )*100 / Integer.valueOf( list.get(position).getTotalClasses() ) );
        holder.attendancePercentage.setText(result + "%");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        private TextView subject, classesAttended,totalClasses, attendancePercentage;
        private ImageView presentBtn,absentBtn;

        public viewHolder(@NonNull final View itemView) {
            super(itemView);

            subject = itemView.findViewById(R.id.subject);
            classesAttended = itemView.findViewById(R.id.class_attended);
            totalClasses = itemView.findViewById(R.id.total_clases);
            attendancePercentage = itemView.findViewById(R.id.attendance_percentage);
            presentBtn =itemView.findViewById(R.id.present);
            absentBtn =itemView.findViewById(R.id.absent);

            presentBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String result =String.valueOf(Integer.valueOf( list.get(getAdapterPosition()).getClassesAttended() )+1);
                    String result1 =String.valueOf(Integer.valueOf( list.get(getAdapterPosition()).getClassesAttended() )+1);
                    boolean isUpdate =helper.onUpdate(list.get(getAdapterPosition()).getId(),list.get(getAdapterPosition()).getSubject(),result,result1);
                    if(isUpdate == true){
                        Toast.makeText(v.getContext(),"Data Update", Toast.LENGTH_SHORT).show();
                        notifyDataSetChanged();
                    }else {
                        Toast.makeText(v.getContext(),"Data not Updated", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            absentBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(), "absent clicked", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
