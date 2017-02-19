package com.hz.aidl;

import android.os.RemoteException;
import android.util.Log;
/**
 * ServiceBinder为客户端的Binder。通过
 */
public class ServiceBinder extends IDownloadService.Stub{

	@Override
	public void download(String path) throws RemoteException {
		Log.i("ServiceBinder下载真正的实现---客户端的Binder",path);
	}

}
