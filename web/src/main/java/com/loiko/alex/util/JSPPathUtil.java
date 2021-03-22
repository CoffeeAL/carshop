package com.loiko.alex.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@UtilityClass
public class JSPPathUtil {

    private static final String FORMAT = "/WEB-INF/jsp/%s.jsp";

    public static String getPath(String jspName) {
        return String.format(FORMAT, jspName);
    }
}