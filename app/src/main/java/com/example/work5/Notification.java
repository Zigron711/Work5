package com.example.work5;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.core.app.NotificationCompat;

public class Notification extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        ImageButton btnBell = view.findViewById(R.id.btnBell);
        btnBell.setOnClickListener(v -> {
            sendNotification();
        });

        return view;
    }

    private void sendNotification() {
        String channelId = "my_channel_id";
        NotificationManager manager = (NotificationManager) requireContext().getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId, "My Channel", NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(channel);
        }
        String title = "Новое уведомление";
        String text = "ФИО: Орлов Никита, Группа: Т-433901-ИСТ";

        NotificationCompat.Builder builder = new NotificationCompat.Builder(requireContext(), channelId)
                .setSmallIcon(android.R.drawable.ic_popup_reminder)
                .setContentTitle(title)
                .setContentText(text)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        manager.notify(1, builder.build());
    }
}