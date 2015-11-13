package com.mnikiforov.core.maps.stringfile;

import com.mnikiforov.util.Constants;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sbt-nikiforov-mo on 13.11.15.
 */
public class MapStringFromFile {

    private static Map<String, String> testMap;

    static {
        testMap = new LinkedHashMap<>();

        testMap.put("ВерсияФормата", "1.02");
        testMap.put("Кодировка", "Windows");
        testMap.put("Отправитель", "Бухгалтерия предприятия, редакция 2.0");
        testMap.put("ДатаСоздания", "26.10.2015");
        testMap.put("ВремяСоздания", "13:44:00");
        testMap.put("ДатаНачала", "26.10.2015");
        testMap.put("ДатаКонца", "15.09.2016");
        testMap.put("РасчСчет", "40802810500000300000");
        testMap.put("Документ", "Платежное поручение");
        testMap.put("СекцияДокумент", "Платежное поручение");
        testMap.put("Номер", "123");
        testMap.put("Дата", "06.11.2015");
        testMap.put("Сумма", "17.18");
        testMap.put("ПоказательКБК", null);
        testMap.put("Очередность", "2");
    }

    public static void main(String[] args) throws IOException {
        String mapStrResult = mapToString(testMap, "\r\n", "=");
        System.out.println("---------------------------MapString---------------------------------");
        System.out.println(mapStrResult);
        System.out.println("--------------------------MapStringEnd-------------------------------");

        System.out.println();

        byte[] mapBytes = mapStrResult.getBytes("utf-8");

        File file = new File(Constants.DATA_PATH + "/string_map/dataFile.txt");
        byte[] fileBytes;
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(file))) {
            fileBytes = IOUtils.toByteArray(isr, "utf-8");
        }
        String fileStrResult;
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(file))) {
            fileStrResult = IOUtils.toString(isr);
        }

        System.out.println("---------------------------FileString---------------------------------");
        System.out.println(fileStrResult);
        System.out.println("--------------------------FileStringEnd-------------------------------");

        System.out.println();

        System.out.println("map :" + Arrays.toString(mapBytes));
        System.out.println("file:" + Arrays.toString(fileBytes));
        System.out.println(Arrays.equals(mapBytes, fileBytes));
    }

    public static String mapToString(Map<?, ?> map, String entryDelimiter, String keyValueDelimiter) {
        StringBuilder sb = new StringBuilder();

        int index = 0;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            sb.append(entry.getKey()).append(keyValueDelimiter).append(entry.getValue());
            if (index > 0 && index < (map.size() - 1)) {
                sb.append(entryDelimiter);
            }
            index++;
        }

        return sb.toString();
    }
}
