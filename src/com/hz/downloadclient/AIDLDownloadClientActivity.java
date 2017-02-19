package com.hz.downloadclient;

import com.bn.Sample7_4.R;
import com.hz.aidl.IDownloadService;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AIDLDownloadClientActivity extends Activity implements
		View.OnClickListener {
	private final static String TAG = "AIDLDownloadClientActivity";
	private IDownloadService mDownloadService;
	private Button mDownloadClientBtn,mBindClientBtn;
	private MyServiceConnection mServiceConnection;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aidl_download_client);
		Log.d(TAG, "---���ò���"); // com.hz.process.aidl.DownloadService
		mServiceConnection = new MyServiceConnection();

		mDownloadClientBtn = (Button) findViewById(R.id.download_client_btn);
		mDownloadClientBtn.setOnClickListener(this);
		
		mBindClientBtn = (Button) findViewById(R.id.bind_client_btn);
		mBindClientBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bind_client_btn:
			Log.d(TAG, "---mServiceConnection==null"+ (mServiceConnection == null));
			this.bindService(new Intent("com.hz.process.aidl.DownloadService"),
					mServiceConnection, BIND_AUTO_CREATE);// �󶨵�����
			Log.d(TAG, "---�󶨵�����");
			break;

		case R.id.download_client_btn:
			try {
				Log.d(TAG, "onServiceConnected---���ذٶ� ǰ");
				mDownloadService.download("http://www.baidu.com");
				Log.d(TAG, "onServiceConnected---���ذٶ�  ��");
			} catch (RemoteException e) {
				Log.e(TAG, e.toString());
			}
			break;
		default:
			break;
		}

	}

	private class MyServiceConnection implements ServiceConnection {
		@Override
		public void onServiceConnected(ComponentName name, IBinder iBinder) {
			Log.d(TAG, "onServiceConnected---asInterface" + (iBinder == null));
			mDownloadService = IDownloadService.Stub.asInterface(iBinder);
			Log.d(TAG, "---mDownloadService==null" + (mDownloadService == null));
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.d(TAG, "onServiceDisconnected ȡ�����ذٶ�");
			mDownloadService = null;
		}
	};

	@Override
	protected void onDestroy() {
		super.onDestroy();
		this.unbindService(mServiceConnection);// �������
	}
}
