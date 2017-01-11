package com.mnikiforov.jasper.helloworld;

import com.mnikiforov.util.Constants;
import java.util.HashMap;
//import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JRPropertiesUtil;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.xml.JRXPathExecuterFactory;
import net.sf.jasperreports.engine.util.xml.JRXPathExecuterUtils;

/**
 * Created by zigzzzag on 30.03.16.
 */
public class HelloWorldRunner {

    public static void main(String[] args) {
        try {

//            DefaultJasperReportsContext context = DefaultJasperReportsContext.getInstance();
//            JRPropertiesUtil.getInstance(context).setProperty("net.sf.jasperreports.xpath.executer.factory",
//                    "net.sf.jasperreports.engine.util.xml.JaxenXPathExecuterFactory");

            JRXPathExecuterFactory factory = JRXPathExecuterUtils.getXPathExecuterFactory();
            System.out.println(factory.getXPathExecuter().getClass().getName());

            System.out.println("Generating PDF...");
            JasperReport jasperReport = JasperCompileManager.compileReport(Constants.RESOURCES_PATH + "jrxml/hellojasper.jrxml");

            long start = System.currentTimeMillis();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap(), new JREmptyDataSource());
            System.out.println("filling time: " + (System.currentTimeMillis() - start));
            JasperExportManager.exportReportToPdfFile(jasperPrint, Constants.OUT_PATH + "HelloJasper.pdf");

            System.out.println("HelloJasper.pdf has been generated!");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}
