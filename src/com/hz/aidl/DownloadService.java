package com.hz.aidl;

import android.R.string;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class DownloadService extends Service{
	private final static String TAG="DownloadService";
	private ServiceBinder serviceBinder = new ServiceBinder();

	@Override
	public IBinder onBind(Intent intent) {
		return serviceBinder;
	}

	public class  ServiceBinder extends IDownloadService.Stub{

		@Override
		public void download(String path) throws RemoteException {
			Log.i(TAG,"ServiceBinder---"+path);
		}
		
	}
	
	@Override
	public void onCreate() {
		Log.i(TAG,"onCreate---");
		super.onCreate();
	}
	
	@Override
	public void onDestroy() {
		Log.i(TAG,"onDestroy---");
		super.onDestroy();
	}
}
