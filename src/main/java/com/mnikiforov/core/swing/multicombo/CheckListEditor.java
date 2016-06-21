/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.core.swing.multicombo;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * @author mnikiforov
 */

/*
 * A table cell editor that pops up a JList of checkboxes.
 */
@SuppressWarnings("unchecked")
public class CheckListEditor extends DefaultCellEditor implements Runnable {

    private PopupDialog popup;
    private JButton editorComp;
    private String currentText = "";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new CheckListEditor());
    }

    public void run() {
        String[] columnNames = {"Item", "Selections"};
        Object[][] data = {{"Item 1", "A"},
                {"Item 2", "B"},
                {"Item 3", "C"}};

        JTable table = new JTable(data, columnNames);
        table.getColumnModel().getColumn(1).setPreferredWidth(300);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());

        CheckListEditor popupEditor = new CheckListEditor();
        popupEditor.setList(Arrays.asList(new String[]{"A", "B", "C"}));
        table.getColumnModel().getColumn(1).setCellEditor(popupEditor);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JFrame frame = new JFrame("Multi-Select Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public CheckListEditor() {
        super(new JTextField());
        setClickCountToStart(2);

        // Use a JButton as the editor component
        editorComp = new JButton();
        editorComp.setFont(editorComp.getFont().deriveFont(Font.PLAIN));
        editorComp.setBackground(Color.WHITE);
        editorComp.setBorderPainted(false);
        editorComp.setContentAreaFilled(false);
        editorComp.setHorizontalAlignment(SwingConstants.LEFT);

        // Set up the dialog where we do the actual editing
        popup = new PopupDialog();
    }

    @Override
    public Object getCellEditorValue() {
        return currentText;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                popup.setValue(currentText);
                Point p = editorComp.getLocationOnScreen();
                popup.setLocation(p.x, p.y + editorComp.getSize().height);
                popup.setVisible(true);
                fireEditingStopped();
            }
        });

        currentText = value.toString();
        editorComp.setText(currentText);
        return editorComp;
    }

    public <T> void setList(List<T> items) {
        popup.setList(items);
    }

    /*
     * Dialog that contains the "editor" panel
     */
    class PopupDialog extends JDialog {

        private final String delimiter = ",";
        private JList jlist;

        public PopupDialog() {
            super((Frame) null, "Select", true);

            setUndecorated(true);
            getRootPane().setWindowDecorationStyle(JRootPane.NONE);

            jlist = new JList();
            jlist.setCellRenderer(new CheckBoxListRenderer());
            jlist.setPrototypeCellValue(new CheckListItem("12345678901234567890"));
            jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jlist.setVisibleRowCount(5);
            jlist.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent event) {
                    selectItem(event.getPoint());
                }
            });

            JScrollPane scrollPane = new JScrollPane(jlist);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            JButton selectAll = new JButton("Select All");
            selectAll.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    selectAllItems();
                }
            });

            JButton ok = new JButton("OK");
            ok.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    closeDialog(true);
                }
            });

            JButton cancel = new JButton("Cancel");
            cancel.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    closeDialog(false);
                }
            });

            JPanel buttons = new JPanel();
            buttons.add(selectAll);
            buttons.add(ok);
            buttons.add(cancel);

            JPanel panel = new JPanel(new BorderLayout());
            panel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
            panel.add(scrollPane, BorderLayout.CENTER);
            panel.add(buttons, BorderLayout.SOUTH);
            setContentPane(panel);
            pack();

            getRootPane().setDefaultButton(ok);
        }

        private void selectAllItems() {
            ListModel model = jlist.getModel();
            for (int index = 0; index < model.getSize(); index++) {
                CheckListItem item = (CheckListItem) model.getElementAt(index);
                item.setSelected(true);
            }
            jlist.repaint();
        }

        /*
         * Save the changed text before hiding the popup
         */
        public void closeDialog(boolean commit) {
            if (commit) {
                currentText = getSelectedItems();
            }

            jlist.requestFocusInWindow();
            setVisible(false);
        }

        private void selectItem(Point point) {
            int index = jlist.locationToIndex(point);

            if (index >= 0) {
                CheckListItem item = (CheckListItem) jlist.getModel().getElementAt(index);
                item.setSelected(!item.isSelected());
                jlist.repaint(jlist.getCellBounds(index, index));
            }
        }

        private <T> void setList(List<T> items) {
            Vector<CheckListItem> listData = new Vector<CheckListItem>();
            for (T item : items) {
                listData.add(new CheckListItem(item));
            }
            jlist.setListData(listData);
        }

        public String getSelectedItems() {
            String text = "";
            ListModel model = jlist.getModel();

            for (int i = 0; i < model.getSize(); i++) {
                CheckListItem item = (CheckListItem) model.getElementAt(i);
                if (item.isSelected()) {
                    text += item.toString();
                    text += delimiter;
                }
            }

            if (text.endsWith(delimiter)) {
                text = text.substring(0, text.lastIndexOf(delimiter));
            }

            return text;
        }

        public void setValue(String value) {
            ListModel model = jlist.getModel();

            for (int i = 0; i < model.getSize(); i++) {
                ((CheckListItem) model.getElementAt(i)).setSelected(false);
            }

            String text = value == null ? "" : value.toString();
            String[] tokens = text.split(delimiter);

            for (String token : tokens) {
                for (int i = 0; i < model.getSize(); i++) {
                    if (model.getElementAt(i).toString().equals(token)) {
                        ((CheckListItem) model.getElementAt(i)).setSelected(true);
                    }
                }
            }

            jlist.clearSelection();
            jlist.ensureIndexIsVisible(0);
        }
    }

    private class CheckBoxListRenderer extends JCheckBox implements ListCellRenderer {

        public Component getListCellRendererComponent(JList comp, Object value, int index,
                                                      boolean isSelected, boolean hasFocus) {
            setEnabled(comp.isEnabled());
            setSelected(((CheckListItem) value).isSelected());
            setFont(comp.getFont());
            setText(value.toString());

            if (isSelected) {
                setBackground(comp.getSelectionBackground());
                setForeground(comp.getSelectionForeground());
            } else {
                setBackground(comp.getBackground());
                setForeground(comp.getForeground());
            }

            return this;
        }
    }

    private class CheckListItem {

        private Object item;
        private boolean selected;

        public CheckListItem(Object item) {
            this.item = item;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean isSelected) {
            this.selected = isSelected;
        }

        @Override
        public String toString() {
            return item.toString();
        }
    }
}
