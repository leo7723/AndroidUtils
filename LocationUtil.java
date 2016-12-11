package coschat.wecanstudio.coschat.utils;


import android.content.Context;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.orhanobut.logger.Logger;

/**
 * 利用高德地图api做定位
 * Created by jss on 2016/11/25.
 */

public class LocationUtil {

    // 定位
    private static AMapLocationClientOption mLocationOption = null;
    private static AMapLocationClient mlocationClient;

    private LocationUtil(){
        /**cannot be instantiated **/
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static void startLocation(Context context, AMapLocationListener aMapLocationListener){
        //声明mLocationOption对象
        mlocationClient = (mlocationClient == null) ? new AMapLocationClient(context) : mlocationClient;
        //初始化定位参数
        mLocationOption = (mLocationOption == null) ?  new AMapLocationClientOption() : mLocationOption;
        //设置定位监听
        mlocationClient.setLocationListener(aMapLocationListener);
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(2000);
        //设置定位参数
        mlocationClient.setLocationOption(mLocationOption);
        // 此方法为每隔固定时间会发起一次定位请求，为了减少电量消耗或网络流量消耗，
        // 注意设置合适的定位时间的间隔（最小间隔支持为2000ms），并且在合适时间调用stopLocation()方法来取消定位请求
        // 在定位结束后，在合适的生命周期调用onDestroy()方法
        // 在单次定位情况下，定位无论成功与否，都无需调用stopLocation()方法移除请求，定位sdk内部会移除
        //启动定位
        mlocationClient.startLocation();
    }

    public static boolean stopLocation() {
        if (mlocationClient == null) {
            Logger.e("mlocationClient is null");
            return false;
        } else {
            mlocationClient.stopLocation();
            return true;
        }
    }
}
