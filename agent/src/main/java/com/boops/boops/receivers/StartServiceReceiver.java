package com.boops.boops.receivers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public class StartServiceReceiver extends BroadcastReceiver {
	
	public static final String PWN_INTENT = "com.boops.boops.PWN";

	@Override
	public void onReceive(Context context, Intent intent) {
		Intent start_service = new Intent();
		start_service.putExtras(intent);
		
		if(intent.getCategories().contains("com.boops.boops.START_EMBEDDED")) {
			start_service.addCategory("com.boops.boops.START_EMBEDDED");
			start_service.setComponent(new ComponentName("com.boops.boops", "com.boops.boops.services.ServerService"));
		}
		else {
			if(intent.getCategories().contains("com.boops.boops.CREATE_ENDPOINT"))
				start_service.addCategory("com.boops.boops.CREATE_ENDPOINT");
			if(intent.getCategories().contains("com.boops.boops.START_ENDPOINT"))
				start_service.addCategory("com.boops.boops.START_ENDPOINT");
			
			start_service.setComponent(new ComponentName("com.boops.boops", "com.boops.boops.services.ClientService"));
		}

		context.startService(start_service);
	}

}
