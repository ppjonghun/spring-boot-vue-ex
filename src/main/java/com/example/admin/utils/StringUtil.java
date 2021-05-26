package com.example.admin.utils;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

public class StringUtil {

    public static boolean empty(Object obj) {
        if(obj == null) return true;

        if(obj instanceof String) {
            return ((String)obj).equals("");
        } else if(obj instanceof List) {
            return ((List)obj).isEmpty();
        } else if(obj instanceof Map) {
            return ((Map)obj).isEmpty();
        } else if(obj instanceof Object[]) {
            return Array.getLength(obj) == 0;
        } else {
            return obj == null;
        }
    }

}
