package com.hz.aidl;

import android.os.RemoteException;
import android.util.Log;
/**
 * ServiceBinderΪ�ͻ��˵�Binder��ͨ��
 */
public class ServiceBinder extends IDownloadService.Stub{

	@Override
	public void download(String path) throws RemoteException {
		Log.i("ServiceBinder����������ʵ��---�ͻ��˵�Binder",path);
	}

}
