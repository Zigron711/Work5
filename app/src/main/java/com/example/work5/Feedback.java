package com.example.work5;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;

public class Feedback extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feedback, container, false);

        EditText etName = view.findViewById(R.id.etName);
        EditText etEmail = view.findViewById(R.id.etEmail);
        Button btnSend = view.findViewById(R.id.btnSend);

        btnSend.setOnClickListener(v -> {
            String name = etName.getText().toString();
            String email = etEmail.getText().toString();

            new AlertDialog.Builder(requireContext())
                    .setTitle("Заявка отправлена")
                    .setMessage("ФИО: " + name + "\nEmail: " + email)
                    .setPositiveButton("OK", null)
                    .show();

            etName.setText("");
            etEmail.setText("");
        });

        return view;
    }
}