package org.example;

import javax.swing.*;

public class Applauncher {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Display weather app GIU

                new WeatherAppgui().setVisible(true);



                System.out.println();

                //    System.out.println(WeatherAppgui.getLocalData("Tokyo"));
                // System.out.println(WeatherAppgui.);

            }
        });

    }
}