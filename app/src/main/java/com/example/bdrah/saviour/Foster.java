package com.example.bdrah.saviour;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;


public class Foster extends AppCompatActivity implements View.OnClickListener  {
    public static final int REQUEST_CAPTURE =1;
    Button image_button, enter;
    EditText caseDesc, animalName, phone, animalLoc;
    RadioButton b1, b2, b3, b4, b5;
    TextView NR;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foster);
        image_button =(Button)findViewById(R.id.button);
        enter =(Button)findViewById(R.id.button2);
        image = (ImageView)findViewById(R.id.image_view);
        caseDesc =(EditText)findViewById(R.id.editText6);
        animalName =(EditText)findViewById(R.id.editText5);
        phone =(EditText)findViewById(R.id.editText11);
        animalLoc =(EditText)findViewById(R.id.editText7);
        b1 =(RadioButton)findViewById(R.id.radioButton5);
        b2 =(RadioButton)findViewById(R.id.radioButton2);
        b3 =(RadioButton)findViewById(R.id.radioButton3);
        b4 =(RadioButton)findViewById(R.id.radioButton6);
        b5 =(RadioButton)findViewById(R.id.radioButton7);
        NR =(TextView)findViewById(R.id.textView7);

        enter.setOnClickListener(this);

    if(!hasCamera())
        image_button.setEnabled(false);
    }

    public boolean hasCamera()
    {
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

    public void launchCamera(View v){
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, RESULT_CANCELED);

    }

     protected void onActivityResult(int requestCode, int resultCode, Intent data){
         if(requestCode == REQUEST_CAPTURE && resultCode == RESULT_CANCELED ){
             Bundle extras = data.getExtras();
             Bitmap photo = (Bitmap)extras.get("data");
             image.setImageBitmap(photo);
         }
     }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.button2:
                startActivity(new Intent(this, Search.class));
                break;

        }

    }
}
