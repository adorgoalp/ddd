package com.iftalab.designdimentiondirection.lib;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import com.iftalab.designdimentiondirection.R;

import java.lang.ref.WeakReference;

/**
 * @author Ifta
 *
 */

public class I {
    private static I hereIam;
    private static IftaLabBuilder iftaLabBuilder = null;
    private static String LOG_TAG;
    private static LogLevel LOG_LEVEL;
    private static WeakReference<Context> contextWeakReference;
    //==================================BUILDER CODES===============================================
    public static IftaLabBuilder getBuilder(Activity context) {
        if (I.iftaLabBuilder == null) {
            iftaLabBuilder = new IftaLabBuilder(context);
        }
        return iftaLabBuilder;
    }
    public static IftaLabBuilder getBuilder(Context context) {
        if (I.iftaLabBuilder == null) {
            iftaLabBuilder = new IftaLabBuilder(context);
        }
        return iftaLabBuilder;
    }
    public static IftaLabBuilder getBuilder(Fragment context) {
        return getBuilder(context.getActivity());
    }
    public static void destroy()
    {
        iftaLabBuilder = null;
        contextWeakReference = null;
        hereIam = null;
    }

    public static class IftaLabBuilder {
        private String logTag = "IftaLog";
        private LogLevel logLevel = LogLevel.DEBUG;
        private Context context;

        public IftaLabBuilder(Context context) {
            this.context = context;
        }

        public IftaLabBuilder logLevel(LogLevel logLevel) {
            this.logLevel = logLevel;
            return this;
        }

        public IftaLabBuilder logTag(String logTag) {
            this.logTag = logTag;
            return this;
        }

        public void build() {
            hereIam = new I(context, logTag, logLevel);
        }
    }

    private I(Context context, String logTag, LogLevel loglevel) {
        I.contextWeakReference = new WeakReference<Context>(context);
        LOG_TAG = logTag;
        LOG_LEVEL = loglevel;
    }
    //==================================BUILDER CODES END===========================================


    //==================================VARIABLES===================================================


    public enum LogLevel {
        VERBOSE, DEBUG, INFO, WARN, ERROR
    }
    //==================================VARIABLES END===============================================


    //==================================TOAST=======================================================
    public static void toast(boolean bool) {
        Toast.makeText(contextWeakReference.get(), Boolean.toString(bool), Toast.LENGTH_SHORT).show();
    }

    public static void toast(int integer) {
        Toast.makeText(contextWeakReference.get(), Integer.toString(integer), Toast.LENGTH_SHORT).show();
    }

    public static void toast(String message) {
        Toast.makeText(contextWeakReference.get(), message, Toast.LENGTH_SHORT).show();
    }


    public static void toast(String message, boolean isLong) {
        if (isLong) {
            Toast.makeText(contextWeakReference.get(), message, Toast.LENGTH_LONG).show();
        } else {
            I.toast(message);
        }
    }
    //==================================TOAST CODE END =============================================


    //==================================LOG CODE ===================================================
    public static void log(int integer) {
        log(Integer.toString(integer));
    }

    public static void log(boolean bool) {
        log(Boolean.toString(bool));
    }

    public static void log(String message) {
        switch (LOG_LEVEL) {
            case VERBOSE:
                Log.v(LOG_TAG, message);
                break;
            case DEBUG:
                Log.d(LOG_TAG, message);
                break;
            case INFO:
                Log.i(LOG_TAG, message);
                break;
            case WARN:
                Log.w(LOG_TAG, message);
                break;
            case ERROR:
                Log.e(LOG_TAG, message);
                break;
            default:
                Log.d(LOG_TAG, message);
                break;
        }
    }
    //==================================LOG CODE END================================================

    //======================================DIALOG==================================================
    public static void messageDialog(String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(contextWeakReference.get());
        builder.setTitle("Info");
        builder.setMessage(message);
        builder.setIcon(R.drawable.ic_help);
        builder.setPositiveButton("Got It", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setCancelable(false);
        builder.create().show();
    }
}
