package com.mnikiforov.spring_in_action.systemprops;

import java.util.Map;

/**
 * Created by zigzzzag on 01.09.2015.
 */
public class SystemPropsSpring {

    private Map<String, String> systemEnvironment;
    private Map<String, String> systemProperties;

    public SystemPropsSpring() {
    }

    public void setSystemEnvironment(Map<String, String> systemEnvironment) {
        this.systemEnvironment = systemEnvironment;
    }

    public void setSystemProperties(Map<String, String> systemProperties) {
        this.systemProperties = systemProperties;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("systemEnvironment: ");
        for (Map.Entry<String, String> entry : systemEnvironment.entrySet()) {
            sb.append(entry.getKey()).append("").append(entry.getValue()).append(",");
        }

        sb.append("; systemProperties: ");
        for (Map.Entry<String, String> entry : systemProperties.entrySet()) {
            sb.append(entry.getKey()).append("").append(entry.getValue()).append(",");
        }
        return sb.toString();
    }
}
