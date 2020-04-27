package test.administrator.example.com.mobileshop.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;

import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import test.administrator.example.com.mobileshop.R;
import test.administrator.example.com.mobileshop.activity.GoodsActivity;
import test.administrator.example.com.mobileshop.activity.LoginActivity;
import test.administrator.example.com.mobileshop.activity.MainActivity;
import test.administrator.example.com.mobileshop.common.ImageLoaderManager;
import test.administrator.example.com.mobileshop.utils.NetworkUtils;
import test.administrator.example.com.mobileshop.view.MyWebView;

//        ImageView imageView = view.findViewById(R.id.testLoadImg);
//        //三个参数:图片地址、显示的控件、图片加载设置
//        ImageLoader.getInstance().displayImage("https://caiping520.top/ico.jpg",
//                imageView,
//                ImageLoaderManager.product_options);
//
//        /**
//         * 图片成功加载时用的展位图
//         * 加载成功后显示了图片,且加载速度很快
//         * 之前在写设置时把缓存设成了false,如果设置成true
//         * 则我们在退出程序时或者需要预留手动清理缓存的接口,这里把清理缓存的功能加上
//         */
public class HomeFragment extends BaseFragment {
    /**
     * 优化MainActivity
     * 由于商品用于显示商品列表和刷新,这连个功能需要网络支持,为此需要一个公共的判断网络的方法
     */
    private static final String TAG = "HomeFragment";
    private MainActivity mainActivity;
    private final int SEARCH_ACTIVITY=1;
    private MyWebView mWebView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private TextView searchTV;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frament_home,null);

        mainActivity= (MainActivity) getActivity();
        //搜索按钮功能
        searchTV = view.findViewById(R.id.home_search);
        searchTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mainActivity,"待开发...",Toast.LENGTH_SHORT).show();
            }
        });
        mWebView = view.findViewById(R.id.webView);
        mSwipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout);

        initMyWebView(view);
        initSwiperRefreshLayout();
        return view;
    }

    /**
     * 初始化webview
     * @param view
     */
    @SuppressLint("JavascriptInterface")
    private void initMyWebView(View view){
        /**
         * 这边需要创建一个连接对象WebViewClient
         * */
        mWebView.setWebViewClient(new JWebViewClient());
        //注解代码
        mWebView.addJavascriptInterface(this,"app");
        mWebView.setVerticalScrollBarEnabled(false);//设置无垂直方向的滚动条(Scrollbar)
        mWebView.setHorizontalScrollBarEnabled(false);
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);//设置启用js脚本
        settings.setSupportZoom(false);//设置不支持缩放
        settings.setBuiltInZoomControls(false);//设置不启用内置缩放装置

        /**
         * 设置滚动
         */
        mWebView.setOnCustomScrollChanged(new MyWebView.IWebViewScroll() {
            @Override
            public void onTop() {
                mSwipeRefreshLayout.setEnabled(true);
            }

            @Override
            public void notOnTop() {
                mSwipeRefreshLayout.setEnabled(false);
            }
        });
        /**
         * 点击后退按钮,让webview 后退
         */
        mWebView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                {
                    if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()){
                        mWebView.goBack();
                        return true;
                    }
                }
                        return false;
            }
        });
        mWebView.setWebViewClient(new WebViewClient(){
            //当点击连接时,希望覆盖而不是打开新的浏览器窗口
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
               view.loadUrl(url);
               return true;
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                //用系统定义404错误界面显示
                mWebView.loadUrl("file//android_asset/error.html");
                mSwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                mSwipeRefreshLayout.setRefreshing(true);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });

        mWebView.loadUrl("http://www.apple.com/cn-k12/shop");
    }
    private void initSwiperRefreshLayout(){
        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,android.R.color.holo_green_light
        ,android.R.color.holo_orange_light,android.R.color.holo_red_light);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //这边是刷新功能,刷新功能是否能用,需要判断网络是否正常
                if (NetworkUtils.isNetworkAvailable(mainActivity)){
                    mWebView.reload();
                }else {
                    mSwipeRefreshLayout.setRefreshing(false);
                    Toast.makeText(mainActivity,"网络不可用",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //预留功能
        if(resultCode == SEARCH_ACTIVITY){

        }
    }

    /**
     * 内部类
     */
    private class JWebViewClient extends WebViewClient {
        //以下方法继承重写的
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
           return true;
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            view.getSettings().setDefaultTextEncodingName("UTF-8");
            super.onReceivedError(view, request, error);
            view.loadDataWithBaseURL("","<div style='padding-top:200px;text-align:center;color:#666;'>未打开无线网络</div>","text/html","UTF-8", "");

        }
    }
    //通过注解实现js中的方法
    @JavascriptInterface
    public void changeTab(final int index){
        mainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mainActivity.changeTab(index);
            }
        });
    }
    @JavascriptInterface
    public void showGoods(final int goodsId){
        mainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                /**
                 * 该方法为实现显示商品详情方法,此方法几乎在所有activity都会被使用为了简化代码
                 * 我们将该方法进行优化和实现。通过父类中实现该方法
                 */
                mainActivity.showGoods(goodsId);
            }
        });
    }

    /**
     *
     * @param goodsId
     * @param groupbuy_id
     */
    @JavascriptInterface
    public void showGroupbuy(final int goodsId,final int groupbuy_id){
        mainActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //这边是跳转到商品界面,这边先临时创建一个
                Intent intent = new Intent(mainActivity, GoodsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent.putExtra("goods_id",goodsId);
                intent.putExtra("groupbuy_id",groupbuy_id);
                startActivity(intent);
            }
        });
    }

    @JavascriptInterface
    public void myorder(){
        //缺少登录
        startActivity(new Intent(mainActivity, LoginActivity.class));
        Toast.makeText(mainActivity,"请先登录后再进行操作",Toast.LENGTH_SHORT).show();
    }
}
