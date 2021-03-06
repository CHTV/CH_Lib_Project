package com.changhong.watson.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.changhong.tvos.common.HotelManager;
import com.changhong.tvos.common.MiscManager;
import com.changhong.tvos.common.TVManager;
import com.changhong.tvos.common.exception.TVManagerNotInitException;

/**
 * Class for identify type
 * Created by Watson on 2017/4/20.
 */

public class TypeIdentify {

    private static TypeIdentify typeIdentify;
    Context mContext;

    private TypeIdentify(Context context) {
        this.mContext = context;
    }

    public static TypeIdentify getInstance(Context context) {
        if (typeIdentify == null) {
            typeIdentify = new TypeIdentify(context);
        }
        return typeIdentify;
    }

    public String getProductType() {
        TVManager tvM = TVManager.getInstance(mContext);
        String tmp = "";
        MiscManager miscManager;
        try {
            miscManager = tvM.getMiscManager();
            tmp = miscManager.getSWVersion();
        } catch (TVManagerNotInitException e) {
            e.printStackTrace();
        }
        return tmp;
    }

    public String getProductName() {
        TVManager tvM = TVManager.getInstance(mContext);
        String tmp = "";
        MiscManager miscManager;
        try {
            miscManager = tvM.getMiscManager();
            tmp = miscManager.getCurProductName();

        } catch (TVManagerNotInitException e) {
            e.printStackTrace();
        }
        // Logger.d("product_type===="+tmp);
        return tmp;
    }

    public boolean hasVirusScan() {
        return (is938OLED() || is838() || is551() || is5510() || is648CH());
    }

    public boolean hasSdcard() {
        if (is818Mstar() || isHis() || is5327() || is648CH() || is648Ali()) {
            return false;
        }
        return true;
    }

    public boolean isAli() {
        PackageInfo packageInfo;
        try {
            packageInfo = mContext.getPackageManager().getPackageInfo(VarDef.PACKAGE_NAME_LAUNCHER, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
            e.printStackTrace();
        }
        if (packageInfo == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean is5510() {
        boolean flag = false;
        if (getProductType().contains("ZLM75HiS")) {
            flag = true;
        }
        return flag;
    }

    public boolean is510() {
        boolean flag = false;
        if (getProductType().startsWith("ZLH66Gi")) {
            flag = true;
        }
        return flag;
    }

    public boolean is5507() {
        boolean flag = false;
        if (getProductType().startsWith("ZLM61")) {
            flag = true;
        }
        return flag;
    }

    /**
     * 四川广电定制机
     *
     * @return
     */
    public boolean is5507Hotel() {
        boolean flag = false;
        if (getProductType().startsWith("ZLM61H")) {
            flag = true;
        }
        return flag;
    }

    public boolean is5327() {
        boolean flag = false;
        if (getProductType().startsWith("ZLM50HiS")) {
            flag = true;
        }
        return flag;
    }

    public boolean is638Home() {
        boolean is638 = false;
        if (getProductType().contains("ZLS58")) {
            is638 = true;
        }
//        if (getProductType().contains("ZLS58Gi-") || getProductType().contains("ZLS58Gi4X") || getProductType().contains("ZLS58GiH")) {
//            flag = true;
//        }
        return is638 && !is638Old();
    }

    /**
     * 老年机
     *
     * @return
     */
    public boolean is638Old() {
        boolean flag = false;
        if (getProductType().contains("ZLS58GiPJ2")) {
            flag = true;
        }
        return flag;
    }

    /**
     * 判断是否处于酒店模式
     *
     * @return
     */
    public boolean isHotelMode() {
        HotelManager hotelM = null;
        TVManager manager = TVManager.getInstance(mContext);
        try {
            hotelM = manager.getHotelManager();
        } catch (TVManagerNotInitException e) {
            e.printStackTrace();
        }
        return hotelM.getHotelMode();
    }

    public boolean is818Mstar() {
        boolean flag = false;
        if (getProductType().startsWith("ZLS47")) {
            flag = true;
        }
        return flag;
    }

    public boolean is5505() {
        boolean flag = false;
        if (getProductType().contains("41")) {
            flag = true;
        }
        return flag;
    }

    public boolean is638() {
        boolean flag = false;
        if (getProductType().contains("ZLS58")) {
            flag = true;
        }
        return flag;
    }

    public boolean is638Laser() {
        boolean flag = false;
        if (getProductType().contains("ZLS58Gi4XLZ")) {
            flag = true;
        }
        return flag;
    }

    public boolean is628() {
        boolean flag = false;
        if (getProductType().contains("ZLS59")) {
            flag = true;
        }
        return flag;
    }

    public boolean isHis() {
        boolean flag = false;
        if (getProductType().contains("ZLM66")) {
            flag = true;
        }
        return flag;
    }

    public boolean is938() {
        boolean flag = false;
        if (getProductType().contains("ZLS69")) {
            flag = true;
        }
        return flag;
    }

    /**
     * 938OLED
     *
     * @return
     */
    public boolean is938OLED() {
        boolean flag = false;
        if (getProductType().contains("ZLS69Hi1")) {
            flag = true;
        }
        return flag;
    }

    /**
     * 938分体机
     *
     * @return
     */
    public boolean is938F() {
        boolean flag = false;
        if (getProductType().contains("ZLS69HiF")) {
            flag = true;
        }
        return flag;
    }

    public boolean is838() {
        boolean flag = false;
        if (getProductType().contains("ZLS70")) {
            flag = true;
        }
        return flag;
    }

    public boolean is551() {
        boolean flag = false;
        if (getProductType().contains("ZLH74Gi")) {
            flag = true;
        }
        return flag;
    }
	
	public boolean isV551() {
        boolean flag = false;
        if (getProductType().contains("ZLH74GiH")) {
            flag = true;
        }
        return flag;
    }

    public boolean is5508() {
        boolean flag = false;
        if (getProductType().contains("ZLM60")) {
            flag = true;
        }
        return flag;
    }

    public boolean is5520() {
        boolean flag = false;
        if (getProductType().contains("ZLM65")) {
            flag = true;
        }
        return flag;
    }

    public boolean is5520Laser() {
        boolean flag = false;
        if (getProductType().contains("ZLM65HiSLZ")) {
            flag = true;
        }
        return flag;
    }

    public boolean is638Edu() {
        boolean flag = false;
        if (getProductType().contains("ZLS58GiEJX05")) {
            flag = true;
        }
        return flag;
    }

    public boolean is648Ali() {
        boolean flag = false;
        if (getProductType().startsWith("ZLS73Gi")) {
            flag = true;
        }
        return flag;
    }

    public boolean is648CH() {
        boolean flag = false;
        if (getProductType().startsWith("ZLS73GiH")) {
            flag = true;
        }
        return flag;
    }
}
