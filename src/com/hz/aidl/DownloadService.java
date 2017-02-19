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
		// TODO �Զ����ɵķ������
		return serviceBinder;
	}

	public class  ServiceBinder extends IDownloadService.Stub{

		@Override
		public void download(String path) throws RemoteException {
			// TODO �Զ����ɵķ������
			Log.i("DownloadService",path);
		}
		
	}
}
