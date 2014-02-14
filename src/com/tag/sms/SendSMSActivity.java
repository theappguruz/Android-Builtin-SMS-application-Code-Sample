package com.tag.sms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendSMSActivity extends Activity {

	Button buttonSend;
	EditText edtTextSMS, edtNumber;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		buttonSend = (Button) findViewById(R.id.buttonSend);
		edtTextSMS = (EditText) findViewById(R.id.editTextSMS);
		edtNumber = (EditText) findViewById(R.id.edtNumber);

		buttonSend.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				try {

					Intent sendIntent = new Intent(Intent.ACTION_VIEW);
					sendIntent.putExtra("sms_body", edtTextSMS.getText()
							.toString());
					sendIntent.putExtra("address", edtNumber.getText()
							.toString());
					sendIntent.setType("vnd.android-dir/mms-sms");
					startActivity(sendIntent);

				} catch (Exception e) {
					Toast.makeText(getApplicationContext(),
							"SMS faild, please try again later!",
							Toast.LENGTH_LONG).show();
					e.printStackTrace();
				}

			}
		});

	}
}