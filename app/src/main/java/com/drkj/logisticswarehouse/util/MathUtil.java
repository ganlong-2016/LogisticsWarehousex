package com.drkj.logisticswarehouse.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by ganlong on 2018/1/29.
 */

public class MathUtil {

    public static double saveTwo(double value){
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
