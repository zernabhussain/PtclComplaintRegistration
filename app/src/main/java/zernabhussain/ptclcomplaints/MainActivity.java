package zernabhussain.ptclcomplaints;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import im.delight.android.webview.AdvancedWebView;
import zernabhussain.ptclcomplaints.helpers.ChangeActivityHelper;
import zernabhussain.ptclcomplaints.util.Constants;

public class MainActivity extends AppCompatActivity implements AdvancedWebView.Listener {

    AdvancedWebView myWebView;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final BooVariable isPageLoaded = new BooVariable();
        setContentView(R.layout.activity_whatsapp_web);
        String url = "https://www.ptcl.com.pk/ComplaintRegister";
        myWebView = findViewById(R.id.webview);
        myWebView.setVisibility(View.INVISIBLE);
        myWebView.setListener(this, this);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                myWebView.loadUrl("javascript:(function() { " +
                        "document.getElementsByClassName('main-header')[0].style.display='none'; " +
                        "document.getElementsByClassName('breadcrumbs')[0].style.display='none'; " +
                        "document.getElementsByClassName('inner-sidebar')[0].style.display='none'; " +
                        "document.getElementsByClassName('main-footer')[0].style.display='none'; " +
                        "var con= document.getElementById('kayako_sitebadgebg').style.display='none'; " +
                        "var con= document.getElementById('kayako_sitebadgeindicator').style.display='none'; " +
                        "})()");
                isPageLoaded.setBoo(true);
            }
        });
        myWebView.loadUrl(url);
        isPageLoaded.setListener(new BooVariable.ChangeListener() {
            @Override
            public void onChange() {
                myWebView.setVisibility(View.VISIBLE);
            }
        });
        if (!Constants.IsOnceCalled) {
            Constants.IsOnceCalled = true;
            Bundle b = new Bundle();
            ChangeActivityHelper.changeActivity(this, SplashScreen.class, false, b);
        }

    }


    public static class BooVariable {
        private boolean boo = false;
        private ChangeListener listener;

        public boolean isBoo() {
            return boo;
        }

        public void setBoo(boolean boo) {
            this.boo = boo;
            if (listener != null) listener.onChange();
        }

        public void setListener(ChangeListener listener) {
            this.listener = listener;
        }

        public interface ChangeListener {
            void onChange();
        }
    }

    @SuppressLint("NewApi")
    @Override
    protected void onResume() {
        super.onResume();
        myWebView.onResume();
        // ...
    }

    @SuppressLint("NewApi")
    @Override
    protected void onPause() {
        myWebView.onPause();
        // ...
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        myWebView.onDestroy();
        // ...
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        myWebView.onActivityResult(requestCode, resultCode, intent);
        // ...
    }

    @Override
    public void onBackPressed() {
        if (!myWebView.onBackPressed()) {
            return;
        }
        // ...
        super.onBackPressed();
    }

    @Override
    public void onPageStarted(String url, Bitmap favicon) {
    }

    @Override
    public void onPageFinished(String url) {
    }

    @Override
    public void onPageError(int errorCode, String description, String failingUrl) {

    }

    @Override
    public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) {
    }

    @Override
    public void onExternalPageRequest(String url) {
    }


}
