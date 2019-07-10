package lk.ac.kln.fpro;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPreperence extends AppCompatActivity {

    Button back, save, show, goTonext;
    EditText TextSave;
    TextView showText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preperence);

        back = findViewById(R.id.goback);
        save = findViewById(R.id.save);
        show = findViewById(R.id.show);
        goTonext = findViewById(R.id.next);

        TextSave = findViewById(R.id.textotsave);
        showText = findViewById(R.id.showText);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SharedPreperence.this, MainActivity.class);
                startActivity(intent);
            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPref= getApplicationContext().getSharedPreferences("UserData", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                String TextToSave = TextSave.getText().toString();
                editor.putString("UserData", TextToSave);
                editor.commit();

            }
        });


        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sharedPref= getApplicationContext().getSharedPreferences("UserData", Context.MODE_PRIVATE);
                String value = sharedPref.getString("UserData", "DefaultText");
                showText.setText(value);

            }
        });


        goTonext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SharedPreperence.this, GetValueFromShared.class);
                startActivity(intent);
            }
        });
    }
}
