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
	private IDownloadService downloadService;
	private Button mDownloadClientBtn;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aidl_download_client);
		Log.d(TAG, "���ò���");       //com.hz.process.aidl.DownloadService
		this.bindService(new Intent("com.hz.process.aidl.DownloadService"),
				this.serviceConnection, BIND_AUTO_CREATE);// �󶨵�����
		Log.d(TAG, "�󶨵�����");

		mDownloadClientBtn = (Button) findViewById(R.id.download_client_btn);
		mDownloadClientBtn.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		try {
			Log.d(TAG, "onServiceConnected ���ذٶ� ǰ");
			downloadService.download("http://www.baidu.com");
			Log.d(TAG, "onServiceConnected ���ذٶ�  ��");
		} catch (RemoteException e) {
			Log.e(TAG, e.toString());
		}
	}
	
	private ServiceConnection serviceConnection = new ServiceConnection() {
		@Override
		public void onServiceConnected(ComponentName name, IBinder iBinder) {
			downloadService = IDownloadService.Stub.asInterface(iBinder);
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.d(TAG, "onServiceDisconnected ȡ�����ذٶ�");
			downloadService = null;
		}
	};

	@Override
	protected void onDestroy() {
		super.onDestroy();
		this.unbindService(serviceConnection);// �������
	}
}
