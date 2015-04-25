package main;

import main.core.Base;
import main.core.Server;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionListener;

/**
 * TODO Add model classes
 * TODO Add mustache for views
 */
public class ControlPanel {
    
    public static void main(String[] args) {
        setTrayIcon(Base.path + "/assets/img/icon.png");
    }

    private static void setTrayIcon(String imagePath) {
        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().getImage(imagePath);
            ActionListener al = e -> new Server("0.0.0.0", 9999);
            PopupMenu popup = new PopupMenu();
            MenuItem defaultItem = new MenuItem();
            defaultItem.addActionListener(al);
            popup.add(defaultItem);
            TrayIcon trayIcon = new TrayIcon(image, "Control Panel", popup);
            trayIcon.addActionListener(al);

            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }
    }
    
}