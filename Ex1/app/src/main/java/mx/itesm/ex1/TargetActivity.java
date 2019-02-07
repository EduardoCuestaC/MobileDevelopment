package mx.itesm.ex1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TargetActivity extends AppCompatActivity {
    TextView tTargetAct;
    Intent currIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);
        tTargetAct = findViewById(R.id.t1);

        currIntent = getIntent();
        String a = currIntent.getStringExtra("ValueToSend") + currIntent.getIntExtra("AnInteger", 0);
        tTargetAct.setText(a);

    }
}
