/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ic.uabc.juego;

/**
 *
 * @author VOM
 */

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelImage extends JLabel {
    private int x;
    private int y;
    private final String path;

    public JPanelImage(JPanel panel, String path) {
        this.path = path;
        this.x = panel.getWidth();
        this.y = panel.getHeight();
        this.setSize(this.x, this.y);
    }

    public void paint(Graphics g) {
        ImageIcon img = new ImageIcon(this.getClass().getResource(this.path));
        g.drawImage(img.getImage(), 0, 0, this.x, this.y, (ImageObserver)null);
    }
}