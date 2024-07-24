package com.loinguyen1905.realestate.util;

import java.lang.reflect.Field;
import java.util.Arrays;

public class OverwriteUtil {
    /**
     * @param T dataToBeWritten
     * @param F beOverwritten
     * @return T beOverwritten Object after be over written 
     * T and F can be same type
     */
    public static <T, F> F overwrireObject(T dataToBeWritten, F beOverwritten) {
        Field[] fields = dataToBeWritten.getClass().getDeclaredFields();
            Arrays.asList(fields).forEach(field -> {
                String fieldName = field.getName();
                try {
                    Field fieldOfMotifiedObject = beOverwritten.getClass().getDeclaredField(fieldName);
                    field.setAccessible(true);
                    fieldOfMotifiedObject.setAccessible(true);
                    if(field.get(dataToBeWritten) != null) fieldOfMotifiedObject.set(beOverwritten, field.get(dataToBeWritten));
                } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
        return beOverwritten;
    }
}