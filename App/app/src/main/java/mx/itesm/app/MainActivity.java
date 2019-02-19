package mx.itesm.app;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.annotation.Target;

public class MainActivity extends AppCompatActivity {
    Button bTargetAct;
    EditText etMain;
    String sent;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bTargetAct = findViewById(R.id.b1);
        etMain = findViewById(R.id.et1);

        context = getApplicationContext();

        bTargetAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sent = "sent: "+ etMain.getText().toString();
                Intent intent =  new Intent(MainActivity.this, TargetActivity.class);
                intent.putExtra("ValueToSend", sent);
                intent.putExtra("AnInteger", 2);
                startActivity(intent);
            }
        });

        Toast mToast = new Toast(context);
        mToast.makeText(context, "A toast", Toast.LENGTH_LONG);

        AlertDialog.Builder mDialogBase = new AlertDialog.Builder(this);
        mDialogBase.setTitle("Confirmation dialog");
        mDialogBase.setMessage("Dialog text");
        mDialogBase.setIcon(R.mipmap.ic_launcher);
        mDialogBase.setNeutralButton("Close",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(context, "Dialog closed", Toast.LENGTH_LONG).show();
                    }
                });
        mDialogBase.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(context, "Action approved", Toast.LENGTH_LONG).show();
                    }
                });
        mDialogBase.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(context, "Action canceled", Toast.LENGTH_LONG).show();
                    }
                });
        AlertDialog mAlertDialog = mDialogBase.create();
        mAlertDialog.show();

        AlertDialog.Builder textDialog = new AlertDialog.Builder(this);
        textDialog.setTitle("Text dialog");
        textDialog.setMessage("Text dialog text");
        textDialog.setIcon(R.mipmap.ic_launcher);

        final EditText etDialog = new EditText(context);
        etDialog.setTextColor(Color.BLUE);
        textDialog.setView(etDialog);

        textDialog.setNeutralButton("Close",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "Dialog closed", Toast.LENGTH_LONG).show();
                    }
                });
        textDialog.setPositiveButton("Submit",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String s = etDialog.getEditableText().toString();
                        Toast.makeText(context, s, Toast.LENGTH_LONG);
                    }
                });
        AlertDialog mTextAlertDialog = textDialog.create();
        mTextAlertDialog.show();

        int M_NOTIF_ID = 1111;
        Notification.Builder mNotifBuilder = new Notification.Builder(this);
        mNotifBuilder.setSmallIcon(R.mipmap.ic_launcher);
        mNotifBuilder.setContentTitle("Content title");
        mNotifBuilder.setContentText("Content text");

        Intent intentMNotif = new Intent(context, TargetActivity.class);
        intentMNotif.putExtra("ValueToSend", "Came from notification");
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, intentMNotif, 0);

        mNotifBuilder.setContentIntent(contentIntent);
        NotificationManager notifManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notifManager.notify(M_NOTIF_ID, mNotifBuilder.build());
    }
}
