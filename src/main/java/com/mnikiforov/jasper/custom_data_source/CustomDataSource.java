/*
 * JasperReports - Free Java Reporting Library.
 * Copyright (C) 2001 - 2014 TIBCO Software Inc. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of JasperReports.
 *
 * JasperReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JasperReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with JasperReports. If not, see <http://www.gnu.org/licenses/>.
 */

package com.mnikiforov.jasper.custom_data_source;

import com.mnikiforov.util.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import net.sf.jasperreports.engine.DefaultJasperReportsContext;
//import net.sf.jasperreports.engine.JRDataSource;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JRField;
//import net.sf.jasperreports.engine.JRPropertiesUtil;
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperExportManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 */
public class CustomDataSource /*implements JRDataSource*/ {

//    static int COUNT_ROW = 10_000;
//    static int COUNT_PEOPLE_IN_CITY = 10;
//    Object[][] data;
//    private int index = -1;
//
//    public CustomDataSource() {
////        long start = System.currentTimeMillis();
////        System.err.println("init data...");
//        initData();
////        System.err.println("init time: " + (System.currentTimeMillis() - start));
//    }
//
//    private void initData() {
//        List<PeopleData> peopleDatas = new ArrayList<>();
//        for (int i = 0; i < COUNT_ROW; i++) {
//            for (int j = 0; j < COUNT_PEOPLE_IN_CITY; j++) {
//                peopleDatas.add(new PeopleData("CITY_" + i, i, "NAME_" + (i + j), "STREET_" + (i + j)));
//            }
//        }
//        this.data = new Object[peopleDatas.size()][4];
//        for (int i = 0; i < peopleDatas.size(); i++) {
//            PeopleData peopleData = peopleDatas.get(i);
//            data[i][0] = peopleData.city;
//            data[i][1] = peopleData.id; //id
//            data[i][2] = peopleData.name; //name
//            data[i][3] = peopleData.street; //street
//        }
//    }
//
//    private class PeopleData {
//        String city;
//        Integer id;
//        String name;
//        String street;
//
//        public PeopleData(String city, Integer id, String name, String street) {
//            this.city = city;
//            this.id = id;
//            this.name = name;
//            this.street = street;
//        }
//    }
//
//    /**
//     *
//     */
//    public boolean next() throws JRException {
//        index++;
//
//        return (index < data.length);
//    }
//
//
//    /**
//     *
//     */
//    public Object getFieldValue(JRField field) throws JRException {
//        Object value = null;
//
//        String fieldName = field.getName();
//
//        if ("the_city".equals(fieldName)) {
//            value = data[index][0];
//        } else if ("id".equals(fieldName)) {
//            value = data[index][1];
//        } else if ("name".equals(fieldName)) {
//            value = data[index][2];
//        } else if ("street".equals(fieldName)) {
//            value = data[index][3];
//        }
//
//        return value;
//    }
//
//    public static void main(String[] args) throws JRException {
//
//
//
//        DefaultJasperReportsContext context = DefaultJasperReportsContext.getInstance();
//            JRPropertiesUtil.getInstance(context).setProperty("net.sf.jasperreports.xpath.executer.factory",
//                    "net.sf.jasperreports.engine.util.xml.JaxenXPathExecuterFactory");
//
//        System.out.println("Generating PDF...");
//        JasperReport jasperReport = JasperCompileManager.compileReport(Constants.RESOURCES_PATH + "jrxml/DataSourceReport.jrxml");
//
//        //Preparing parameters
//        Map<String, Object> parameters = new HashMap<String, Object>();
//        parameters.put("ReportTitle", "Address Report");
//        parameters.put("DataFile", "CustomDataSource.java");
//
//        for (int i = 0; i < 10; i++) {
//            long start = System.currentTimeMillis();
//            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new CustomDataSource());
//            long fillingTime = System.currentTimeMillis() - start;
//
//            start = System.currentTimeMillis();
//            JasperExportManager.exportReportToPdfFile(jasperPrint, Constants.OUT_PATH + "621_DataSourceReport_" + i + ".pdf");
//            long exportTime = System.currentTimeMillis() - start;
//
//            System.err.println("fillingTime: " + fillingTime + ",    exportTime: " + exportTime);
//        }
//    }
}
