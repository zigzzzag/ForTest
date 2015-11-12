/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.graphics.dithertest;

import java.awt.image.BufferedImage;

/**
 *
 * @author mnikiforov
 */
public interface PrinterDriverInterface {

    public void printCheck(BufferedImage receipt) throws Exception;
}
