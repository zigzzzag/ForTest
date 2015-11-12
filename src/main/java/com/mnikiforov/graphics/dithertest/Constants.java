/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.graphics.dithertest;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**Palette
 *
 * @author mnikiforov
 */
public class Constants {

    private static final Logger log = LoggerFactory.getLogger(Constants.class);

    public static final String QUEUE_NODE_TITLE = "queueNodeTitle";
    public static final String PUT_ASIDE_TIME = "putAsideTime";
    public static final String PUT_ASIDE_TIME_ALL = "putAsideTimeAll";
    public static final String WHO_REDIRECT_USERNAME = "whoRedirectUsername";
    public static final String WHO_PUT_ASIDE_USERNAME = "whoPutAsideUsername";
    public static final String WAIT_TIME = "waitTime";
    public static final String REG_TIME = "regTime";
    public static final String CLIENT_NUM = "clientNum";
    public static final String SID = "SID";
    public static final String LID = "LID";
    public static final String CAB_NUM = "cabNum";
    public static final String USER_FIO = "userFIO";
    public static final String Arial_BOLD_14 = "Arial-BOLD-14";
    public static final Color alphaBlack50 = new Color(0, 0, 0, 50);
    public static final String BUFFIMAGE_CLIENT_LABEL = "BUFFIMAGE_CLIENT_LABEL";
    public static final String BUFFIMAGE_CLIENT = "BUFFIMAGE_CLIENT";
    public static final String BUFFIMAGE_CAB_NUMBER_LABEL = "BUFFIMAGE_CAB_NUMBER_LABEL";
    public static final String BUFFIMAGE_CAB_NUMBER = "BUFFIMAGE_CAB_NUMBER";
    public static final Color HIGHESTCOLOR = new Color(0xdd, 0, 0);
    public static final Color HIGHCOLOR = new Color(0xa0, 0, 0);
    public static final Color LOWCOLOR = new Color(0x0, 0x60, 0);
    public static final Color LOWESTCOLOR = new Color(0x0, 0xa0, 0);
    public static final SimpleDateFormat DATE_FORMAT_yyyy_MM_dd = new SimpleDateFormat("yyyy.MM.dd");
    public static final SimpleDateFormat REMOTE_REG_DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
    public static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");
    public static final int AUTO_CALL_PERIOD_DEFAULT = 10000;

    public static final float receiptWidth = 560;
    public static final String PRINTER_VKP80 = "VKP80";

    public static ImageIcon searchIcon;
    public static ImageIcon clearIcon;

    static {
	try {
	    Image img = ImageIO.read(Constants.class.getResourceAsStream("/search_icon.png"));
	    searchIcon = new ImageIcon(img);

	    img = ImageIO.read(Constants.class.getResourceAsStream("/clearIcon.png"));
	    clearIcon = new ImageIcon(img);
	} catch (IOException ex) {
	    log.error(ex.getMessage(), ex);
	}
    }
}
