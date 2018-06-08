package com.project.steapx.common.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

public class ObjectUtil {

    @SuppressWarnings("rawtypes")
	public static boolean isEmpty(Object object) {
        if (object == null) {
            return true;
        }

        boolean empty = false;
        if (object instanceof CharSequence) {
            if (object instanceof String) {
                empty = ((String) object).trim().length() == 0;
            } else {
                empty = ((CharSequence) object).length() == 0;
            }
        } else if (object instanceof Map) {
            empty = ((Map) object).isEmpty();
        } else if (object instanceof Iterable) {
            if (object instanceof Collection) {
                empty = ((Collection) object).isEmpty();
            } else {
                empty = !((Iterable) object).iterator().hasNext();
            }
        } else if (object.getClass().isArray()) {
            empty = Array.getLength(object) == 0;
        }
        return empty;
    }

    public static boolean hasEmptyElement(Object... objects) {
        if (objects == null || objects.length == 0) {
            return true;
        }

        for (Object object : objects) {
            if (isEmpty(object)) {
                return true;
            }
        }
        return false;
    }
}
