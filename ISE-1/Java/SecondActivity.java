package com.example.ise_1;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    String phoneNumber="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Uri contactUri=getIntent().getData();

        Cursor cursor=getContentResolver().query(contactUri,null,null,null,null);

        if(cursor!=null && cursor.moveToFirst())
        {
            int phoneIndex=cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            phoneNumber=cursor.getString(phoneIndex);
            cursor.close();
        }

        ImageButton callBtn=findViewById(R.id.callBtn);
        ImageButton smsBtn=findViewById(R.id.smsBtn);
        ImageButton whatsappBtn=findViewById(R.id.whatsappBtn);

        callBtn.setOnClickListener(v->{

            Intent intent=new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+phoneNumber));
            startActivity(intent);

        });

        smsBtn.setOnClickListener(v->{

            Intent intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("sms:"+phoneNumber));
            startActivity(intent);

        });

        whatsappBtn.setOnClickListener(v->{

            Intent intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://wa.me/"+phoneNumber));
            startActivity(intent);

        });

    }
}