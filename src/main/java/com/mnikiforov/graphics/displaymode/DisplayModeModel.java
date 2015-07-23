package com.mnikiforov.graphics.displaymode;

import javax.swing.table.DefaultTableModel;
import java.awt.DisplayMode;

class DisplayModeModel extends DefaultTableModel {
    private DisplayMode[] modes;

    public DisplayModeModel(DisplayMode[] modes) {
        this.modes = modes;
    }

    public DisplayMode getDisplayMode(int r) {
        return modes[r];
    }

    public String getColumnName(int c) {
        return DisplayModeTest.COLUMN_NAMES[c];
    }

    public int getColumnCount() {
        return DisplayModeTest.COLUMN_WIDTHS.length;
    }

    public boolean isCellEditable(int r, int c) {
        return false;
    }

    public int getRowCount() {
        if (modes == null) {
            return 0;
        }
        return modes.length;
    }

    public Object getValueAt(int rowIndex, int colIndex) {
        DisplayMode dm = modes[rowIndex];
        switch (colIndex) {
            case DisplayModeTest.INDEX_WIDTH :
                return Integer.toString(dm.getWidth());
            case DisplayModeTest.INDEX_HEIGHT :
                return Integer.toString(dm.getHeight());
            case DisplayModeTest.INDEX_BITDEPTH : {
                int bitDepth = dm.getBitDepth();
                String ret;
                if (bitDepth == DisplayMode.BIT_DEPTH_MULTI) {
                    ret = "Multi";
                } else {
                    ret = Integer.toString(bitDepth);
                }
                return ret;
            }
            case DisplayModeTest.INDEX_REFRESHRATE : {
                int refreshRate = dm.getRefreshRate();
                String ret;
                if (refreshRate == DisplayMode.REFRESH_RATE_UNKNOWN) {
                    ret = "Unknown";
                } else {
                    ret = Integer.toString(refreshRate);
                }
                return ret;
            }
        }
        throw new ArrayIndexOutOfBoundsException("Invalid column value");
    }

}
