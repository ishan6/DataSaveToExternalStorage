package lk.ac.kln.fpro;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExternalStorage extends AppCompatActivity {

    Button save, show, three;
    String savedText;
    private EditText getText, saveText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_storage);

        save = findViewById(R.id.save);
        show = findViewById(R.id.show);

        getText = findViewById(R.id.textToGet);
        saveText = findViewById(R.id.textToSave);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isExternalStoragePresent()) {
                    File file = new File(getExternalFilesDir("MyDir"), "savedText.txt");

                    String input = saveText.getText().toString();

                    if (!(saveText.getText().toString().isEmpty())) {

                        try {


                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            fileOutputStream.write(input.getBytes());
                            fileOutputStream.close();

                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    } else {
                        Toast.makeText(ExternalStorage.this, "No Data To Save", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });


        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    String filecontent = "";
                    File file = new File(getExternalFilesDir("MyDir"), "savedText.txt");

                    FileInputStream fileOutputStream = new FileInputStream(file);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileOutputStream));
                    String sLine;

                    while ((sLine = bufferedReader.readLine()) != null) {
                        filecontent = filecontent + sLine;
                    }

                    getText.setText(filecontent.toString());

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }


    private boolean isExternalStoragePresent() {
        String state = Environment.getExternalStorageState();

        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

}
