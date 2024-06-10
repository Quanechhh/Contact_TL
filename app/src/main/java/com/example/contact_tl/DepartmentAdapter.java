package com.example.contact_tl;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentAdapter.DepartmentViewHolder> {

    private List<Department> departmentList;
    private OnDepartmentClickListener onDepartmentClickListener;

    public DepartmentAdapter(List<Department> departmentList, OnDepartmentClickListener onDepartmentClickListener) {
        this.departmentList = departmentList;
        this.onDepartmentClickListener = onDepartmentClickListener;
    }

    @NonNull
    @Override
    public DepartmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_department, parent, false);
        return new DepartmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DepartmentViewHolder holder, int position) {
        Department department = departmentList.get(position);
        holder.departmentName.setText(department.getName());
        holder.departmentDetails.setText(department.getDetails());

        holder.itemView.setOnClickListener(v -> onDepartmentClickListener.onDepartmentClick(department));
    }

    @Override
    public int getItemCount() {
        return departmentList.size();
    }

    static class DepartmentViewHolder extends RecyclerView.ViewHolder {
        TextView departmentName;
        TextView departmentDetails;

        DepartmentViewHolder(View itemView) {
            super(itemView);
            departmentName = itemView.findViewById(R.id.department_name);
            departmentDetails = itemView.findViewById(R.id.department_details);
        }
    }

    public interface OnDepartmentClickListener {
        void onDepartmentClick(Department department);
    }
}
