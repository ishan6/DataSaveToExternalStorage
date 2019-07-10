package lk.ac.kln.fpro;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GetValueFromShared extends AppCompatActivity {

    TextView showText;
    Button getText, goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_value_from_shared);

        showText = findViewById(R.id.show);
        getText = findViewById(R.id.getData);
        goBack = findViewById(R.id.back);


        getText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref= getApplicationContext().getSharedPreferences("UserData", Context.MODE_PRIVATE);
                String value = sharedPref.getString("UserData", "DefaultText");
                showText.setText(value);
            }
        });

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GetValueFromShared.this, SharedPreperence.class);
                startActivity(intent);
            }
        });
    }
}
