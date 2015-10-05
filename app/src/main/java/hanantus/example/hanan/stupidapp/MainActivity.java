package hanantus.example.hanan.stupidapp;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button; // this appeared after i declared lines 21 & 20
import android.widget.RelativeLayout;
import android.widget.TextView; // this appeared after i declared lines 21 & 20
import android.widget.Toast;

import android.graphics.Typeface;

import com.example.hanan.stupidapp.R;

import java.util.Random;


public class MainActivity extends ActionBarActivity {

    public TextView arabictext;

    private FunFactBook mfactBook = new FunFactBook();
    private ColorWheel mColorWheel = new ColorWheel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*
       // to display Logo
       getSupportActionBar().setDisplayShowHomeEnabled(true);
       getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        */
        ////////////////////////////////////ARABIC///////////////////////////
        // Give path to the Font location
        String Path2font = "DroidNaskh-Regular.ttf";

        // Give label to TextView object defined in layout
        arabictext = (TextView) findViewById(R.id.TextV);

        // Load the Font and define typeface accordingly
        Typeface tf = Typeface.createFromAsset(getAssets(), Path2font);

        // Apply the font to your TextView object
        arabictext.setTypeface(tf);


        arabictext.setText("كل عام و أنت بخير");

        /////////////////////////////////////////////////////////////////////


        // Declare our Textview varibles then assign them views from the layout file

        final TextView funFactLable = (TextView) findViewById(R.id.FunTextView); // Text view is the data type here :) // casting of (TextView) is required because the return value is not TextView
        final Button funButton = (Button) findViewById(R.id.ShowFactButton);
        final RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rLayout);

        // Apply the font to your TextView object
        funFactLable.setTypeface(tf);
        funFactLable.setText("وأنت بخير وصحة وسلامة يارب");

        funButton.setTypeface(tf);
        funButton.setText("وحدة ثانية");

        final String[] mFacts = {"وأنت بخير وصحة وسلامة يارب",
       "ينعاد علينا وعليكم بالخير" ,
       "منا و منك صالح الأعمال" ,
              "من الفايزين"  ,
 "من السالمين والغانمين",
               "علينا وعليكم يارب" ,
        };



        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String fact = mfactBook.getFact();

                Random rgenerator = new Random();

                int randomNumber = rgenerator.nextInt(mFacts.length) ;

                if (randomNumber == 0){
                    arabictext.setText("كل عام و أنت بخير");
                }
                else if (randomNumber == 1) {
                    arabictext.setText("عساكم من عواده");
                }
                else if (randomNumber == 2) {
                    arabictext.setText("تقبل الله منا و منكم");
                }
                else if (randomNumber == 3) {
                    arabictext.setText("من العايدين");
                }
                else if (randomNumber == 4) {
                    arabictext.setText("من العايدين والفايزين");
                }
                else {
                    arabictext.setText("عيدكم مبارك");
                }


                funFactLable.setText(mFacts[randomNumber]);

                String color = mColorWheel.getColor();
                relativeLayout.setBackgroundColor(Color.parseColor(color));

                funButton.setTextColor(Color.parseColor(color));
            }
        };
        funButton.setOnClickListener(listener); // must create a listener above it
        //String msg = "Welcome!"; // toast
        Toast welcome = Toast.makeText(this,"Welcome! :)",Toast.LENGTH_LONG);
        welcome.show();

        //Log.d("FunFact Activity", "Log from onCreate() method!");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
