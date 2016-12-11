package coschat.wecanstudio.coschat.utils;

import coschat.wecanstudio.coschat.base.CCApplication;

/**
 * Created by jss on 2016/11/20.
 */

public class ExceptionUtil {
    public static boolean filterException(Exception e) {
        if (e != null) {
            e.printStackTrace();
            ToastUtil.showShort(CCApplication.getCCApplication(), e.getMessage());
            return false;
        } else {
            return true;
        }
    }
}
