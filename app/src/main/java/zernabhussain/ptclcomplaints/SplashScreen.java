package zernabhussain.ptclcomplaints;

import android.app.Activity;

import com.badoo.mobile.util.WeakHandler;
import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

import zernabhussain.ptclcomplaints.helpers.ChangeActivityHelper;
import zernabhussain.ptclcomplaints.util.Constants;

public class SplashScreen extends AwesomeSplash {

    @Override
    public void initSplash(ConfigSplash configSplash) {

        /* you don't have to override every property */
        //Customize Circular Reveal
        configSplash.setBackgroundColor(R.color.LimeGreen); //any color you want form colors.xml
        configSplash.setAnimCircularRevealDuration(2000); //int ms
        configSplash.setRevealFlagX(Flags.REVEAL_RIGHT);  //or Flags.REVEAL_LEFT
        configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM); //or Flags.REVEAL_TOP
        //Choose LOGO OR PATH; if you don't provide String value for path it's logo by default
        //Customize Logo
        configSplash.setLogoSplash(R.drawable.logo_ptcl); //or any other drawable
        configSplash.setAnimLogoSplashDuration(2000); //int ms
        configSplash.setAnimLogoSplashTechnique(Techniques.RollIn); //choose one form Techniques (ref: https://github.com/daimajia/AndroidViewAnimations)
        //Customize Title
        configSplash.setTitleSplash("PTCL Complaint");
        configSplash.setTitleTextColor(R.color.icons);
        configSplash.setTitleTextSize(40f); //float value
        configSplash.setAnimTitleDuration(3000);
        configSplash.setAnimTitleTechnique(Techniques.FlipInX);
        configSplash.setTitleFont(Constants.SLIMJIM_FONT); //provide string to your font located in assets/fonts/

    }

    @Override
    public void animationsFinished() {


        final Activity a = this;
        WeakHandler handler = new WeakHandler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ChangeActivityHelper.changeActivity(a, MainActivity.class, true);
            }
        }, Constants.SPLASH_DELAY);
    }
}
