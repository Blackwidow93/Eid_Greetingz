package hanantus.example.hanan.stupidapp;

import java.util.Random;

/**
 * Created by Hanan on 15/07/15.
 */

public class ColorWheel {

    String[] mColors = {
            "#39add1", // light blue
            "#3079ab", // dark blue
            "#c25975", // mauve
            "#e15258", // red
            "#f9845b", // orange
            "#838cc7", // lavender
            "#7d669e", // purple
            "#53bbb4", // aqua
            "#51b46d", // green
            "#e0ab18", // mustard
            "#637a91", // dark gray
            "#f092b0", // pink
            "#b7c0c7"  // light gray
             };

    public String getColor(){


        // the button once clicked will update the fact
        String color = "";//"Ostriches can run faster than horses.";
        // randomly select a fact
        Random rgenerator = new Random();

        int randomNumber = rgenerator.nextInt(mColors.length) ;


        // fact = randomNumber + "";
        // update the label with a dynamicly changed fact

        color = mColors[randomNumber];

        return color;
    }
}

