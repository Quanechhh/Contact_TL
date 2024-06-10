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

public class DepartmentListFragment extends Fragment {

    private List<Department> departmentList;
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_department_list, container, false);

        departmentList = new ArrayList<>();
        departmentList.add(new Department("IT Department", "Details about IT Department"));
        departmentList.add(new Department("HR Department", "Details about HR Department"));

        listView = view.findViewById(R.id.list_view_department);
        ArrayAdapter<Department> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, departmentList);
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
