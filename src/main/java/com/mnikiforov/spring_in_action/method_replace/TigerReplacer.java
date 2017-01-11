package com.mnikiforov.spring_in_action.method_replace;

import java.lang.reflect.Method;
import org.springframework.beans.factory.support.MethodReplacer;

/**
 * Created by zigzzzag on 14.03.16.
 */
public class TigerReplacer implements MethodReplacer {

    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        return "A ferocious tiger";
    }
}
