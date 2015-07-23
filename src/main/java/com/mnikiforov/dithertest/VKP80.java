/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.dithertest;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dandreev
 */
public class VKP80 implements PrinterDriverInterface {

    private static final Logger log = LoggerFactory.getLogger(VKP80.class);
    private static BufferedImage src;

    public VKP80() {
    }

    private static ArrayList<Integer> colorspace = new ArrayList<Integer>();
    private static HashMap<Integer, ColorComponent> grayH = new LinkedHashMap<Integer, ColorComponent>();
    private static HashMap<Integer, Integer> redH = new LinkedHashMap<Integer, Integer>();
    private static HashMap<Integer, Integer> greenH = new LinkedHashMap<Integer, Integer>();
    private static HashMap<Integer, Integer> blueH = new LinkedHashMap<Integer, Integer>();
    private static HashMap<ColorComponent, Integer> space = new LinkedHashMap<ColorComponent, Integer>();
    private static ArrayList<ColorComponent> colors = new ArrayList<ColorComponent>();

    public static final byte[] CMD_GRBEGINDOC = {0};
    public static final byte[] CMD_GRPPAGESIZEB = {27, 38, 108};
    public static final byte[] CMD_GRPPAGESIZEEP = {80};
    public static final byte[] CMD_GRPCMP2BEGIN = {27, 42, 98, 50, 77};
    public static final byte[] CMD_GRPCMPEND = {27, 42, 98, 48, 77};
    public static final byte[] CMD_GRPPRINTPAGE = {27, 42, 114, 66};
    public static final byte[] CMD_GRPCMR2LINEB = {27, 42, 98};
    public static final byte[] CMD_GRPCMR2LINEE = {87};
    public static final byte[] CMD_GRPPOSAB = {27, 42, 112};
    public static final byte[] CMD_GRPPOSREL = {27, 42, 112, 43};
    public static final byte[] CMD_GRPPOSAXE = {88};
    public static final byte[] CMD_GRPPOSAYE = {89};
    public static final byte[] CMD_GREMPTYLINE = {27, 42, 98, 48, 87};
    public static final byte[] INIT = {27, 64};
    public static byte[] FEED_LINE = {10};
    public static byte[] SELECT_FONT_A = {27, 33, 0};
    public static byte[] SET_BAR_CODE_HEIGHT = {29, 104, 100};
    public static byte[] PRINT_BAR_CODE_1 = {29, 107, 2};
    public static byte[] SEND_NULL_BYTE = {0x00};
    public static byte[] SELECT_PRINT_SHEET = {0x1B, 0x63, 0x30, 0x02};
    public static byte[] FEED_PAPER_AND_CUT = {0x1D, 0x56, 65, 120};
    public static byte[] EJECT = {0x1D, 0x65, 3, 100};
    public static byte[] TOTAL_CUT = {0x1B, 0x69};
    public static byte[] SELECT_CYRILLIC_CHARACTER_CODE_TABLE = {0x1B, 0x74, 0x11};
    public static byte[] SELECT_BIT_IMAGE_MODE = {0x1B, 0x2A, 33};
    public static byte[] PRINTING_AREA = {0x1D, 0x57, 0x40, 2};
    public static byte[] SET_LINE_SPACING_24 = {0x1B, 0x33, 24};
    public static byte[] SET_LINE_SPACING_30 = {0x1B, 0x33, 30};
    public static byte[] TRANSMIT_DLE_PRINTER_STATUS = {0x10, 0x04, 0x01};
    public static byte[] TRANSMIT_DLE_OFFLINE_PRINTER_STATUS = {0x10, 0x04, 0x02};
    public static byte[] TRANSMIT_DLE_ERROR_STATUS = {0x10, 0x04, 0x03};
    public static byte[] TRANSMIT_DLE_ROLL_PAPER_SENSOR_STATUS = {0x10, 0x04, 0x04};
    public static byte[] MARGIN = {0x1d, 0x4c, 0x30, 0x00};

    public static final float receiptWidth = 560;

    @Override
    public void printCheck(BufferedImage img) throws Exception {
//	src = img;
//
//	ByteArrayOutputStream baos = new ByteArrayOutputStream();
//
//	CUSTOM_PrintDataByteArray pb = GraphicFunctions.CreateGraphicPrnFromBWBufferedImage_FERLE(src, 0, (int) receiptWidth);
//
//	baos.write(INIT);
//	baos.write(PRINTING_AREA);
//	baos.write(MARGIN);
//
//	baos.write(pb.getBytes());
//
//	baos.write(FEED_PAPER_AND_CUT);
//	baos.write(EJECT);
//	ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
//
//	baos.close();
//
//	String printerName = Connector.getSettings().get("printCheck");
//
//	DocFlavor dc = new DocFlavor.INPUT_STREAM("application/octet-stream");
//	PrintService[] printService = PrintServiceLookup.lookupPrintServices(dc, null);
//	int index = -1;
//	for (int i = 0; i < printService.length; i++) {
//	    if (printService[i].getName().contains(Constants.PRINTER_VKP80)) {
//		index = i;
//	    }
//	}
//
//	if (index == -1) {
//	    throw new Exception("Printer \"" + printerName + "\" not found");
//	}
//	DocPrintJob job = printService[index].createPrintJob();
//
//	Doc doc = new SimpleDoc(bais, dc, null);
//
//	if (job.getClass().getSimpleName().equals("UnixPrintJob")) {
//	    Field hack = job.getClass().getDeclaredField("mOptions");
//
//	    hack.setAccessible(true);
//	    hack.set(job, "raw");
//	}
//
//	job.print(doc, null);
//
//	bais.close();
    }
}
