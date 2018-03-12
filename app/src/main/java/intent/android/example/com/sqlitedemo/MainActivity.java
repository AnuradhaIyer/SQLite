package intent.android.example.com.sqlitedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button addItem,searchItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        addItem = (Button) findViewById( R.id.button8 );
        searchItem = (Button) findViewById( R.id.button11 );
        AddItem();
    }

    public void AddItem(){

        addItem.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent( getApplicationContext(),Main2Activity.class );
                        startActivity( intent );
                    }
                }
        );
    }


}
