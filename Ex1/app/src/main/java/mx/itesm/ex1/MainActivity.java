package mx.itesm.ex1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bTargetAct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bTargetAct = findViewById(R.id.b1);
        bTargetAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(MainActivity.this, TargetActivity.class);
                intent.putExtra("ValueToSend", "Hello intent");
                intent.putExtra("AnInteger", 2);
                startActivity(intent);
            }
        });
    }
}
