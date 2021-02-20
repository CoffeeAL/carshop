package com.loiko.alex.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class JSPPathUtil {

    private static final String FORMAT = "/WEB-INF/jsp/%s.jsp";

    public static String get(String jspName) {
        return String.format(FORMAT, jspName);
    }
}