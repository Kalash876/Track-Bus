package com.example.bustracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.ViewHolder> {
    List<AttendanceModel> attendanceModelList;

    public AttendanceAdapter(List<AttendanceModel> attendanceModelList) {
        this.attendanceModelList = attendanceModelList;
    }

    @NonNull
    @Override
    public AttendanceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student_attendance, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AttendanceAdapter.ViewHolder holder, int position) {
        AttendanceModel model = attendanceModelList.get(position);
        holder.studentId.setText(model.getStudentId());
        holder.name.setText(model.getName());

        holder.checkbox.setChecked(model.isPresent());

        holder.checkbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            model.setPresent(isChecked);
        });




    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView name, studentId;
        CheckBox checkbox;
        ImageView profile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.list_student_name);
            studentId=itemView.findViewById(R.id.list_roll_no);
            checkbox=itemView.findViewById(R.id.present);
            profile=itemView.findViewById(R.id.img_profile);

        }
    }
}
