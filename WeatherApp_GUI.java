package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;


public class WeatherAppgui extends JFrame {

    public WeatherAppgui() {
        //setup GUI and add title
        super("WeatherApp");

        // configure gui  to end the program's process once it has been closed

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //set the size of GUI(in pixels)
        setSize(450, 650);

        //load GUI at center of the screen
        setLocationRelativeTo(null);

        // make layout manager null to manually position the component.

        setLayout(null);

        // Prevent any resize of GUI

        setResizable(false);


        addGUIComponents();


    }

    private void addGUIComponents() {

        //  Search field

        JTextField searchTextField = new JTextField();

        // Set location and size of the component

        searchTextField.setBounds(15, 15, 351, 45);

        // change the font style and size

        searchTextField.setFont(new Font("Dialog", Font.PLAIN, 24));
        add(searchTextField);



        JButton searchButton = new JButton(loadImage("src/weatherapp_images (2)/search.png"));

        // change curser hand when hovering over the button

        searchButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        searchButton.setBounds(375, 13, 47, 45);
        add(searchButton);

        // weather Image
        JLabel weatherConditionImage = new JLabel(loadImage("src/weatherapp_images (2)/cloudy.png"));
        weatherConditionImage.setBounds(0, 13, 125, 217);
        add(weatherConditionImage);


        // humidity image


        JLabel humidityImage = new JLabel(loadImage("src/weatherapp_images (2)/humidity.png"));
        humidityImage.setBounds(15, 500, 74, 66);
        add(humidityImage);

        // Humidity Text

        JLabel humidityText = new JLabel("<html><b>Humidity</b></html>");
        humidityText.setBounds(90,500,85,55);
        humidityText.setFont(new Font("Dialog",Font.PLAIN,16));
        add(humidityText);


        // Windspeed Image

        JLabel WindspeedImage = new JLabel(loadImage("src/weatherapp_images (2)/windspeed.png"));
        WindspeedImage.setBounds(220,500,74,66);
        add(WindspeedImage);

        // Windspeed text

        JLabel windspeedtext = new JLabel("<html><b>Windspeed</b></html>");
        windspeedtext.setBounds(310,500,85,55);
        add(windspeedtext);


        // Temparature Text

        JLabel temparatureText = new JLabel("10 C");
        temparatureText.setBounds(0,350,450,54);
        temparatureText.setFont(new Font("Dialog",Font.BOLD,48));


        // Center the text

        temparatureText.setHorizontalAlignment(SwingConstants.CENTER);
        add(temparatureText);


        // weather condition decription

        JLabel weatherConditionDesc = new JLabel("cloudy");
        weatherConditionDesc.setBounds(0,405,450,36);
        weatherConditionDesc.setFont(new Font("Dialog",Font.PLAIN,32));
        temparatureText.setHorizontalAlignment(SwingConstants.CENTER);
        add(weatherConditionDesc);

    }


    //used  to  create image in GUI component
    private ImageIcon loadImage(String resourcePath) {

        try {
            // read  the image file from the path given

            BufferedImage image = ImageIO.read(new File(resourcePath));
            // return an image icon so that component can render it

            return new ImageIcon(image);

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("could not find resource");
        return null;

    }



}
