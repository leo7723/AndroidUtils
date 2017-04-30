package com.willplus.leo.stronger.Utills;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.willplus.leo.stronger.R;

/**
 * Created by changliliao on 2017/4/30.
 */

public class NotificationUtils {
    public static void sendNotification(Context context,String msg){
        final NotificationManager notifyManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                //设置小图标
                .setSmallIcon(R.drawable.user_icon)
                //设置通知标题
                .setContentTitle("Stronger")
                //设置通知内容
                .setContentText("这是来自Stronger的通知")
                //设置为默认铃声
                .setDefaults(Notification.DEFAULT_SOUND)
                //设置默认震动
                .setDefaults(Notification.DEFAULT_VIBRATE|Notification.DEFAULT_SOUND)
                .setLights(0x1F2A4C,3000,3000);
        final Notification notification=builder.build();
        notification.flags|=Notification.FLAG_ONLY_ALERT_ONCE;
        notification.flags|=Notification.FLAG_SHOW_LIGHTS;
        notifyManager.notify(4, notification);
    }
}
