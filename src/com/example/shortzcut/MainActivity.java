package com.example.shortzcut;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.createShortCut).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				createShortCut();
			}
		});
	}

	public void createShortCut(){     
	    //������ݷ�ʽ��Intent                     
	    Intent shortcutintent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");                     
	    //�������ظ�����                     
	    shortcutintent.putExtra("duplicate", false);                     
	    //��Ҫ��ʵ������                     
	    shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "custom");     
	    //���ͼƬ                    
	    Parcelable icon = Intent.ShortcutIconResource.fromContext(getApplicationContext(), R.drawable.ic_launcher);     
	    shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, icon);     
	    //������ͼƬ�����еĳ��������                     
	    shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, new Intent(getApplicationContext() , TestActivity.class));                     
	    //���͹㲥��OK                     
	    sendBroadcast(shortcutintent);     
	}  
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
