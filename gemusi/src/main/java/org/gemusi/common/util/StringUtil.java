package org.gemusi.common.util;

import java.text.NumberFormat;

public class StringUtil {

    /**
     * Double 转string 去除科学记数法显示
     *
     * @param d
     * @return
     */
    public static String double2Str(Double d) {
        if (d == null) {
            return "";
        }
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        return (nf.format(d));
    }

}
