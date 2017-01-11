package com.mnikiforov.core.swing.action;

import javax.swing.JComponent;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Компонент для операций мышью по добавлению и удалению квадратов
 * <p>
 * Created by zigzzzag on 28.06.16.
 */
public class MouseComponent extends JComponent {

    public static final int SIDE_LENGTH = 10;
    private ArrayList<Rectangle2D> squares;
    private Rectangle2D current;

    public MouseComponent() {
        squares = new ArrayList<>();
        current = null;

        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        for (Rectangle2D r : squares) {
            g2d.draw(r);
        }
    }

    /**
     * Обнаруживает первый квадрат, содержащий заданную точку
     *
     * @param p Точка
     * @return Первый квадрат, содержащий точку p
     */
    public Rectangle2D find(Point2D p) {
        for (Rectangle2D r : squares) {
            if (r.contains(p)) {
                return r;
            }
        }
        return null;
    }

    /**
     * Добавляет квадрат в коллекцию
     *
     * @param p Центр квадрата
     */
    public void add(Point2D p) {
        double x = p.getX();
        double y = p.getY();

        current = new Rectangle2D.Double(x - SIDE_LENGTH / 2, y - SIDE_LENGTH / 2, SIDE_LENGTH, SIDE_LENGTH);
        squares.add(current);
        repaint();
    }

    /**
     * Удаляет квадрат из коллекции
     *
     * @param s Удаляемый квадрат
     */
    public void remove(Rectangle2D s) {
        if (s == null) return;
        if (s == current) current = null;
        squares.remove(s);
        repaint();
    }

    /**
     * Класс, сожержащий указатель мыши
     */
    private class MouseHandler extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            // добавить новый квадрат, если курсор находится вне квадрата
            current = find(e.getPoint());
            if (current == null) {
                add(e.getPoint());
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // удалить текущий квадрат, если на нем произведен двойной щелчок
            current = find(e.getPoint());
            if (current != null && e.getClickCount() >= 2) {
                remove(current);
            }
        }
    }

    private class MouseMotionHandler implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
            if (current != null) {
                double x = e.getX();
                double y = e.getY();

                // перетащить текущий квадрат, чтобы отцентровать его в точке с координатами (x, y)
                current.setFrame(x - SIDE_LENGTH / 2, y - SIDE_LENGTH / 2, SIDE_LENGTH, SIDE_LENGTH);
                repaint();
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            // задать курсор в виде перекрестья, если он находится внутри квадрата
            if (find(e.getPoint()) == null) {
                setCursor(Cursor.getDefaultCursor());
            } else {
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
            }
        }
    }
}
