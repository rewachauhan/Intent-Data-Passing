package com.example.intentdatapassing;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {
	TextView tv,tv1;
	Button bt;
	String data,data1,msg;
	int no1,no2;
	double res;
	double avg;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		data=getIntent().getStringExtra("num1");
		data1=getIntent().getStringExtra("num2");
		no1=Integer.parseInt(data);
		no2=Integer.parseInt(data1);
		res=no1+no2;
		avg=res/2;
		tv1=(TextView) findViewById(R.id.textView2);
		tv1.setText("Addition Result:"+String.valueOf(res));
		Toast.makeText(this, "Average:"+String.valueOf(avg), Toast.LENGTH_LONG).show();
		bt=(Button) findViewById(R.id.button1);
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				msg=String.valueOf(avg);
				Intent i1=new Intent();
				i1.putExtra("avg", msg);
				setResult(RESULT_OK, i1);
				finish();
			}
		});
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

}
