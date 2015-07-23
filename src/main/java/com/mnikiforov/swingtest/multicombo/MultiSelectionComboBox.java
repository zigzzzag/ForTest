/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.swingtest.multicombo;

/**
 *
 * @author mnikiforov
 */
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class MultiSelectionComboBox {

    private DefaultComboBoxModel model;

    private JPanel getContent() {
	Object[] items = {"Select article(s)", "No article", "a", "the"};

	model = new DefaultComboBoxModel(items);
	JComboBox combo = new JComboBox(model);

	SelectionManager manager = new SelectionManager();
	manager.setNonSelectable(items[0]);

	Renderer renderer = new Renderer(manager);
	combo.addActionListener(manager);
	combo.setRenderer(renderer);

	JPanel panel = new JPanel();
	panel.add(combo);
	return panel;
    }

    class SelectionManager implements ActionListener {

	JComboBox combo = null;
	private List<Object> selectedItems = new ArrayList<Object>();
	private Object nonSelectable;

	public void setNonSelectable(Object val) {
	    nonSelectable = val;
	}

	public void actionPerformed(ActionEvent e) {
	    if (combo == null) {
		combo = (JComboBox) e.getSource();
	    }
	    Object item = combo.getSelectedItem();
	    // Toggle the selection state for item.  
	    if (selectedItems.contains(item)) {
		selectedItems.remove(item);
	    } else if (!item.equals(nonSelectable)) {
		selectedItems.add(item);
	    }

	    combo.setSelectedIndex(0);
	}

	public List<Object> getSelectedItems() {
	    return selectedItems;
	}
    }

    class Renderer extends BasicComboBoxRenderer {

	SelectionManager selectionManager;

	public Renderer(SelectionManager sm) {
	    selectionManager = sm;
	}

	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
	    setFont(list.getFont());

	    if (index == -1 && selectionManager.getSelectedItems().size() > 0) {
		StringBuffer firstItem = new StringBuffer();
		for (Object sel : selectionManager.getSelectedItems()) {
		    firstItem.append(sel + "; ");
		}
		if (firstItem.toString().endsWith("; ")) {
		    firstItem.deleteCharAt(firstItem.length() - 2);
		}
		setText((value == null) ? "" : firstItem.toString());
	    } else {// other items
		setText((value == null) ? "" : value.toString());
	    }

	    return this;
	}
    }

    public static void main(String[] args) {
	JFrame f = new JFrame();
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.getContentPane().add(new MultiSelectionComboBox().getContent());
	f.setSize(300, 145);
	f.setLocation(200, 200);
	f.setVisible(true);
    }
}
