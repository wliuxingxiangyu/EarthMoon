package com.bn.Sample7_4;

import com.hz.downloadclient.AIDLDownloadClientActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SimpleAdapter.ViewBinder;

public class MainActivity extends Activity implements View.OnClickListener {
	private Button mRoundBtn, mDownloadBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select);
		mRoundBtn = (Button) findViewById(R.id.round_btn);
		mRoundBtn.setOnClickListener(this);
		mDownloadBtn = (Button) findViewById(R.id.download_btn);
		mDownloadBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.round_btn:
			Intent inSurface = new Intent(this, MySurfaceActivity.class);
			startActivity(inSurface);
			break;

		case R.id.download_btn:
			Intent in = new Intent(this, AIDLDownloadClientActivity.class);
			startActivity(in);
			break;

		default:
			break;
		}
	}

}
