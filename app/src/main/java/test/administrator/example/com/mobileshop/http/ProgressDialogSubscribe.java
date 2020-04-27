package test.administrator.example.com.mobileshop.http;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.Toast;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import rx.Subscriber;

public  abstract class ProgressDialogSubscribe<T> extends Subscriber<T> {
    private Context mcontext;
    private ProgressDialog mDialog;
    public ProgressDialogSubscribe(Context context){
        this.mcontext = context;
    }
    @Override
    public void onCompleted() {
        dismissProgressDialog();
    }

    @Override
    public void onError(Throwable e) {
        if(e instanceof SocketTimeoutException){
            Toast.makeText(mcontext,"网络中断,请检查您的网络状态",Toast.LENGTH_SHORT).show();
        }else if(e instanceof ConnectException){
            Toast.makeText(mcontext,"网络中断,请检查您的网络状态",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(mcontext,"error:"+e.getMessage(),Toast.LENGTH_SHORT).show();
            Log.v("==========","error:======"+e.getMessage());
        }
        dismissProgressDialog();
    }

    @Override
    public void onStart(){
       showProgressDialog();
    }
    private void showProgressDialog(){
        if (mDialog != null){
            mDialog = new ProgressDialog(mcontext);
            mDialog.setCancelable(true);
            mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    //取消订阅，取消请求
                    ProgressDialogSubscribe.this.unsubscribe();
                }
            });

        }
        if (mDialog != null && !mDialog.isShowing()){
            mDialog.show();
        }
    }
    public void dismissProgressDialog(){
        if (mDialog != null && mDialog.isShowing()){
            mDialog.dismiss();
            mDialog = null;
        }
    }
}
