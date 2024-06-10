package com.example.contact_tl;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class EmployeeListFragment extends Fragment {

    private List<Employee> employeeList;
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_employee_list, container, false);

        employeeList = new ArrayList<>();
        employeeList.add(new Employee("John Doe", "Software Engineer"));
        employeeList.add(new Employee("Jane Smith", "Mechanical Engineer"));

        listView = view.findViewById(R.id.list_view_employee);
        ArrayAdapter<Employee> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, employeeList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle item click here, if needed
            }
        });

        return view;
    }
}
