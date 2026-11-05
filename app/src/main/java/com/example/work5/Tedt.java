package com.example.work5;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;

public class Tedt extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tedt, container, false);

        Button btnAnswer = view.findViewById(R.id.btnAnswer);

        btnAnswer.setOnClickListener(v -> {
            String[] options = {"Москва", "Нижний Тагил", "Казань", "Екатеринбург"};

            new AlertDialog.Builder(requireContext())
                    .setTitle("Выберите ответ:")
                    .setItems(options, (dialog, which) -> {
                        if (which == 0) {
                            Toast.makeText(requireContext(), "Верно!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(requireContext(), "Неверно!", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .show();
        });

        return view;
    }
}