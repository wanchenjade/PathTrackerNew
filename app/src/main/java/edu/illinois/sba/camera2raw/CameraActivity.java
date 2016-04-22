package edu.illinois.sba.camera2raw;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

public class CameraActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        if (null == savedInstanceState) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.container, CameraActivityFragment.newInstance())
                    .commit();
        }
    }
}
