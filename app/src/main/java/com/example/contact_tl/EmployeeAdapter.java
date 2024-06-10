package com.example.contact_tl;

// EmployeeAdapter.java
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    private List<Employee> employeeList;
    private OnEmployeeClickListener onEmployeeClickListener;

    public EmployeeAdapter(List<Employee> employeeList, OnEmployeeClickListener onEmployeeClickListener) {
        this.employeeList = employeeList;
        this.onEmployeeClickListener = onEmployeeClickListener;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_employee, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee employee = employeeList.get(position);
        holder.employeeName.setText(employee.getName());
        holder.employeePosition.setText(employee.getTitle());

        holder.itemView.setOnClickListener(v -> onEmployeeClickListener.onEmployeeClick(employee));
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    static class EmployeeViewHolder extends RecyclerView.ViewHolder {
        TextView employeeName;
        TextView employeePosition;

        EmployeeViewHolder(View itemView) {
            super(itemView);
            employeeName = itemView.findViewById(R.id.employee_name);
            employeePosition = itemView.findViewById(R.id.employee_title);
        }
    }

    public interface OnEmployeeClickListener {
        void onEmployeeClick(Employee employee);
    }
}
