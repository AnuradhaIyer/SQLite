package intent.android.example.com.sqlitedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    Databasehelper myDb;
    EditText editName,editDescription,editPrice,editReview;
    Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main2 );
        myDb= new Databasehelper( this );
        editName = (EditText)findViewById( R.id.editText );
        editDescription = (EditText)findViewById( R.id.editText2 );
        editPrice = (EditText)findViewById( R.id.editText3 );
        editReview = (EditText)findViewById( R.id.editText4 );
        btnAddData=(Button)findViewById( R.id.button2 );
        AddData();
    }

    public void AddData(){

        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted=  myDb.insertData(editName.getText().toString(),editDescription.getText().toString(),editPrice.getText().toString(),editReview.getText().toString());
                        if(isInserted=true)
                            Toast.makeText( Main2Activity.this,"Data Inserted",Toast.LENGTH_LONG ).show();
                        else
                            Toast.makeText( Main2Activity.this,"Data Not Inserted",Toast.LENGTH_LONG ).show();



                    }
                }
        );

    }
}
