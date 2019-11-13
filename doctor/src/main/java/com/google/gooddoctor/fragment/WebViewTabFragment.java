package com.google.gooddoctor.fragment;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.google.gooddoctor.R;
import com.google.gooddoctor.util.DisplayUtil;
import com.google.gooddoctor.view.SpringScrollView;

import java.util.ArrayList;
import java.util.List;

public class WebViewTabFragment extends Fragment {

    class WebViewTimeLine {
        public String beacon;
        public String hashcode;
        public String tag;
        public String time;
    }

    public final static String KEY_DOMAIN = "domain";
    public final static String KEY_IS_SHOW_H5TOPBAR = "is_show_h5topbar";
    public final static String KEY_TAB_TYPE = "tab_type";
    public final static String KEY_TITLE = "title";
    public final static String KEY_TYPE = "type";
    public final static String KEY_URL = "web_url";

    private List<WebViewTimeLine> J = new ArrayList<>();
    protected String a;
    protected String c;
    private String r;
    private String s;
    private boolean t = false;
    private boolean u = false;
    public boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private boolean y = false;
    private boolean z = false;

    private WebView webview;


    public static WebViewTabFragment a(String str, String str2, int i, boolean z2, String str3, String str4, boolean z3) {
        WebViewTabFragment webViewTabFragment = new WebViewTabFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_URL, str);
        bundle.putString(KEY_TITLE, str2);
        bundle.putString(KEY_DOMAIN, str3);
        bundle.putInt(KEY_TYPE, i);
        bundle.putString(KEY_TAB_TYPE, str4);
        bundle.putBoolean(KEY_IS_SHOW_H5TOPBAR, z3);
        bundle.putBoolean("is_sync_cookie", z2);
        webViewTabFragment.setArguments(bundle);
        return webViewTabFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.activity_webview, null);
        webview = inflate.findViewById(R.id.webview);

        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        layoutParams.topMargin = DisplayUtil.a(getActivity(), 46) + getResources().getDimensionPixelSize(getResources().getIdentifier("status_bar_height", "dimen", "android"));
        webview.setLayoutParams(layoutParams);

        webview.setWebViewClient(webViewClient);
        webview.setWebChromeClient(webChromeClient);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);//把html中的内容放大webview等宽的一列中
        //设置不缓存
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        //缩放操作
        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(false); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件
        //其他细节操作
        webSettings.setAllowFileAccess(true); //设置可以访问文件
//        webSettings.setAllowUniversalAccessFromFileURLs(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
        webSettings.setAppCacheEnabled(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);

        Bundle arguments = getArguments();
        if (arguments != null) {
            if(!TextUtils.isEmpty(arguments.getString(KEY_URL))){
                webview.loadUrl(arguments.getString(KEY_URL));
                Log.i("hel->",  arguments.getString(KEY_URL));
            }
        }
        return inflate;
    }

    //WebViewClient主要帮助WebView处理各种通知、请求事件
    private WebViewClient webViewClient=new WebViewClient(){

        @Override
        public void onPageFinished(WebView view, String url) {//页面加载完成
            webview.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {//页面开始加载
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }

    };


    //WebChromeClient主要辅助WebView处理Javascript的对话框、网站图标、网站title、加载进度等
    private WebChromeClient webChromeClient = new WebChromeClient(){

        //不支持js的alert弹窗，需要自己监听然后通过dialog弹窗
        @Override
        public boolean onJsAlert(WebView webView, String url, String message, JsResult result) {
//            AlertDialog.Builder b2 = new AlertDialog.Builder(WebActivity.this)
////                    .setMessage(message)
////                    .setPositiveButton("确定", new AlertDialog.OnClickListener() {
////                        @Override
////                        public void onClick(DialogInterface dialog, int which) {
////                            result.confirm();
////                        }
////                    });
////                b2.setCancelable(false);
////                b2.create();
////                b2.show();
            return true;
        }

        //获取网页标题
        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
        }

        //加载进度回调
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
        }
    };

    public synchronized void b(String str) {
        WebViewTimeLine webViewTimeLine = new WebViewTimeLine();
        StringBuilder sb = new StringBuilder();
        sb.append(hashCode());
        sb.append("");
        webViewTimeLine.hashcode = sb.toString();
        webViewTimeLine.beacon = str;
        webViewTimeLine.tag = this.a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(SystemClock.elapsedRealtime());
        sb2.append("");
        webViewTimeLine.time = sb2.toString();
        this.J.add(webViewTimeLine);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(hashCode());
        sb3.append("|");
        sb3.append(SystemClock.elapsedRealtime());
        sb3.append("|");
        sb3.append(this.a);
        sb3.append("|");
        sb3.append(str);
        Log.d("WEBVIEW_LOAD", sb3.toString());
    }

    private void b() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.c = arguments.getString(KEY_URL);
            this.r = arguments.getString(KEY_TITLE);
            this.u = arguments.getBoolean("is_sync_cookie", true);
            this.z = arguments.getBoolean(KEY_IS_SHOW_H5TOPBAR, false);
            this.s = arguments.getString(KEY_DOMAIN);
            this.a = arguments.getString(KEY_TAB_TYPE);
            if (arguments.getInt(KEY_TYPE) == 0) {
                this.v = true;
            }
        }
    }

}
