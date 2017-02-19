package com.hz.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class DownloadService extends Service{
	private ServiceBinder serviceBinder = new ServiceBinder();

	@Override
	public IBinder onBind(Intent intent) {
		// TODO 自动生成的方法存根
		return serviceBinder;
	}

	public class  ServiceBinder extends IDownloadService.Stub{

		@Override
		public void download(String path) throws RemoteException {
			// TODO 自动生成的方法存根
			Log.i("DownloadService",path);
		}
		
	}
}
