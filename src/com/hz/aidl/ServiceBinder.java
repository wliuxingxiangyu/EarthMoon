package com.hz.aidl;

import android.os.RemoteException;
import android.util.Log;

public class ServiceBinder extends IDownloadService.Stub{

	@Override
	public void download(String path) throws RemoteException {
		Log.i("ServiceBinder",path);
	}

}
