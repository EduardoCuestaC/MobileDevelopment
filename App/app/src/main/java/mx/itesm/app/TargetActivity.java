package mx.itesm.app;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TargetActivity extends AppCompatActivity {
    TextView tTargetAct;
    Intent currIntent;
    Button bBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);

        tTargetAct = findViewById(R.id.t1);
        currIntent = getIntent();
        String a = currIntent.getStringExtra("ValueToSend") + currIntent.getIntExtra("AnInteger", 0);
        tTargetAct.setText(a);

        bBack = findViewById(R.id.bBack);
        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(TargetActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
