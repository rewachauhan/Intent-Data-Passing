package com.example.intentdatapassing;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class IntentDataassingActivity extends Activity {
 

private static final int REQUEST_CODE_INDENTDATAASSINGACTIVITY = 100;
EditText et1,et2;
 TextView tv;
 Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_dataassing);
        et1=(EditText) findViewById(R.id.editText1);
        et2=(EditText) findViewById(R.id.editText2);
        tv=(EditText) findViewById(R.id.textView3);
        
        bt=(Button) findViewById(R.id.button1);
        bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String fno,sno;
				fno=et1.getText().toString();
				sno=et1.getText().toString();
				Intent i=new Intent(IntentDataassingActivity.this,SecondActivity.class);
				i.putExtra("num1", fno);
				i.putExtra("num2", sno);
				//startActivity(i);
				startActivityForResult(i,REQUEST_CODE_INDENTDATAASSINGACTIVITY) ;
			}
		});
        
    }


    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		String mesg;
		if(requestCode==REQUEST_CODE_INDENTDATAASSINGACTIVITY)
		{
			if(resultCode==RESULT_OK)
			{
				mesg=data.getStringExtra("avg");
				tv.setText(mesg);
			}
		}
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.intent_dataassing, menu);
        return true;
    }
    
}
