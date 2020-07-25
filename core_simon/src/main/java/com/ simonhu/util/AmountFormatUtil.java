package com.simonhu.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2015/12/16.
 */
public class AmountFormatUtil {
    static NumberFormat nf = new DecimalFormat("#.00");

    /**
     * 金额格式化
     * @param list  list
     * @param formatColumns  格式化的key    以逗号隔开
     */
    public static void formatAmount(List<Map> list, String formatColumns){
        String str[] =  formatColumns.split(",");
        for(String key : str){
            for(Map item :list ){
                item.put(key,formatAmount(item.get(key)));
            }
        }
    }

    /**
     *
     * @param map
     * @param formatColumns
     */
    public static void formatAmount(Map map, String formatColumns){
        String str[] =  formatColumns.split(",");
        for(String key : str){
            map.put(key,formatAmount(map.get(key)));
        }
    }

    public static String formatAmount(Object obj){
        BigDecimal bd   =   new BigDecimal(String.valueOf(obj));
        bd   =   bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd.toString();
    }

    public static void main(String args[]){
    }

}
