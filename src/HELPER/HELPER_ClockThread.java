/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HELPER;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JMenu;

/**
 *
 * @author CherryCe
 */
public class HELPER_ClockThread extends Thread {

    public JMenu lblClock;

    public HELPER_ClockThread(JMenu lblClock) {
        this.lblClock = lblClock;
    }

    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        while (true) {
            Date now = new Date();
            String st = sdf.format(now);
            lblClock.setText(st);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
