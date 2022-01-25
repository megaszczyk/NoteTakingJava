package com.example.notetaking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UpdateActivity extends AppCompatActivity {
    TextView title;
    TextView description;
    Button save, cancel;
    int noteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Update Note");
        setContentView(R.layout.activity_update);

        title = findViewById(R.id.textViewTitleUpdate);
        description = findViewById(R.id.textDescriptionUpdate);
        cancel = findViewById(R.id.buttonCancelUpdate);
        save = findViewById(R.id.buttonSaveUpdate);
        getData();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateNote();

            }
        });

    }

    private void updateNote(){
        String titleLast = title.getText().toString();
        String descriptionLast = description.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("titleLast",titleLast);
        intent.putExtra("descriptionLast", descriptionLast);
        if(noteId!=-1){
            intent.putExtra("noteId",noteId);
            setResult(RESULT_OK,intent);
            finish();
        }
    }

    public void getData(){
        Intent i = getIntent();
        noteId = i.getIntExtra("id",-1);
        String noteTitle = i.getStringExtra("title");
        String noteDescription = i.getStringExtra("description");

        title.setText(noteTitle);
        description.setText(noteDescription);
    }
}