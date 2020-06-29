package net.kamersolution.qrbar.utility;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;


/**
 * Created by Ashiq on 5/11/16.
 */
public class ActivityUtils {

    private static ActivityUtils sActivityUtils = null;

    public static ActivityUtils getInstance() {
        if (sActivityUtils == null) {
            sActivityUtils = new ActivityUtils();
        }
        return sActivityUtils;
    }

    public void invokeActivity(AppCompatActivity activity, Class<?> tClass, boolean shouldFinish) {
        Intent intent = new Intent(activity, tClass);
        activity.startActivity(intent);
        if (shouldFinish) {
            activity.finish();
        }
    }


}
