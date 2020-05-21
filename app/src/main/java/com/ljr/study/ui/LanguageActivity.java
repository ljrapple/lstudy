package com.ljr.study.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.ljr.study.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Locale;

public class LanguageActivity extends Activity {
    @Override
    protected void attachBaseContext(Context newBase) {
        MContext context = new MContext(newBase, getResource(newBase));
        super.attachBaseContext(context);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        MContext context = new MContext(getBaseContext(), getResource(getApplicationContext()));

        LayoutInflater inflater = LayoutInflater.from(context);
        invokeLayoutInflate(inflater, context);
        super.onCreate(savedInstanceState);
        setContentView(inflater.inflate(R.layout.languae_choose_layer, null));
        TextView chinaV = findViewById(R.id.china_lg);
        chinaV.setText(R.string.china);
        findViewById(R.id.china_lg).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLanguage(Locale.CHINA);
            }
        });

        findViewById(R.id.en_lg).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                changeLanguage(Locale.ENGLISH);
                Log.d("changeLanguage",
                        "changeLanguage  en  " + getResources().getString(R.string.english));
                v.invalidate();
            }
        });
    }

    private void changeLanguage(Locale locale) {
        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();
        Locale.setDefault(locale);
        if (VERSION.SDK_INT < VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.locale = locale;
        } else {
            configuration.setLocale(locale);
        }
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }

    /**
     * @param cxt
     * @return
     */
    public static Resources getResource(Context cxt) {
        Resources rs = null;
        copyAssetAndWrite("en.res", cxt);
        File path = new File(cxt.getCacheDir() + "/en.res");
        if (!path.isFile()) {
        }
        MResources resources = null;
        try {
            AssetManager am = (AssetManager) AssetManager.class.newInstance();
            am.getClass().getMethod("addAssetPath", String.class)
                    .invoke(am, path.getAbsolutePath());
            Resources superRes = cxt.getResources();
            rs = new Resources(am, superRes.getDisplayMetrics(),
                    superRes.getConfiguration());
            resources = new MResources(cxt.getAssets(), superRes.getDisplayMetrics(),
                    superRes.getConfiguration(), superRes, rs);
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                throw (RuntimeException) e;
            }
        }
        return cxt.getResources();
    }

    /**
     * 将asset文件写入缓存
     */
    private static boolean copyAssetAndWrite(String fileName, Context context) {
        try {
            File cacheDir = context.getCacheDir();
            if (!cacheDir.exists()) {
                cacheDir.mkdirs();
            }
            File outFile = new File(cacheDir, fileName);
            if (!outFile.exists()) {
                boolean res = outFile.createNewFile();
                if (!res) {
                    return false;
                }
            } else {
                if (outFile.length() > 10) {//表示已经写入一次
                    return true;
                }
            }
            InputStream is = context.getAssets().open(fileName);
            FileOutputStream fos = new FileOutputStream(outFile);
            byte[] buffer = new byte[1024];
            int byteCount;
            while ((byteCount = is.read(buffer)) != -1) {
                fos.write(buffer, 0, byteCount);
            }
            fos.flush();
            is.close();
            fos.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    private static class MResources extends Resources {

        private Resources mStrResources;
        private Resources mResources;

        /**
         * Create a new Resources object on top of an existing set of assets in an
         * AssetManager.
         * @param assets  Previously created AssetManager.
         * @param metrics Current display metrics to consider when
         *                selecting/computing resource values.
         * @param config  Desired device configuration to consider when
         * @deprecated Resources should not be constructed by apps.
         * See {@link Context#createConfigurationContext(Configuration)}.
         */
        public MResources(AssetManager assets, DisplayMetrics metrics,
                Configuration config, Resources resources, Resources strResources) {
            super(assets, metrics, config);
            mStrResources = strResources;
            mResources = resources;
        }

        @NonNull
        @Override
        public String getString(int id) throws NotFoundException {
            Log.d("getResourceName", "getResourceName  =  " + mResources.getResourceName(id)
                    + "  id  =  " + getIdentifier("english"));
            return mStrResources != null ? mStrResources.getString(getIdentifier(mResources.getResourceName(id))) :
                    mResources.getString(id);
        }

        @NonNull
        @Override
        public CharSequence getText(int id) throws NotFoundException {
            return mStrResources != null ?
                    mStrResources.getString(getIdentifier(mResources.getResourceName(id))) :
                    mResources.getText(id);
        }

        @NonNull
        @Override
        public String getString(int id, Object... formatArgs) throws NotFoundException {
            return mStrResources != null ? mStrResources
                    .getString(getIdentifier(mResources.getResourceName(id)), formatArgs)
                    : mResources.getString(id, formatArgs);
        }

        @Override
        public CharSequence getText(int id, CharSequence def) {
            return mStrResources.getText(getIdentifier(mResources.getResourceName(id)), def);
        }

        @NonNull
        @Override
        public CharSequence getQuantityText(int id, int quantity) throws NotFoundException {
            return mStrResources
                    .getQuantityText(getIdentifier(mResources.getResourceName(id)), quantity);
        }

        @NonNull
        @Override
        public String getQuantityString(int id, int quantity) throws NotFoundException {
            return mStrResources
                    .getQuantityString(getIdentifier(mResources.getResourceName(id)), quantity);
        }

        @NonNull
        @Override
        public CharSequence[] getTextArray(int id) throws NotFoundException {
            return mStrResources.getTextArray(getIdentifier(mResources.getResourceName(id)));
        }

        @NonNull
        @Override
        public String[] getStringArray(int id) throws NotFoundException {
            return mStrResources.getStringArray(getIdentifier(mResources.getResourceName(id)));
        }

        public int getIdentifier(String name) {
            return getIdentifier(name, null, null);
        }

        public int getIdentifier(String name, String deftype, String defpkg) {
            Log.d("getResourceName", "getResourceName getIdentifier =  " + getName(name));
            return mStrResources.getIdentifier(getName(name), "string", defpkg);
        }

        private String getName(String name) {
            if (name.indexOf(":") > -1) {
                if(name.startsWith("android")){
                    return name;
                } else {
                    return "com.ljr.com.englishstringresoucre" + name.substring(name.indexOf(":"));
                }
            }
            return "";
        }

        @NonNull
        @Override
        public TypedArray obtainTypedArray(int id) throws NotFoundException {
            Log.d("getResourceName", "getResourceName obtainTypedArray =  " + getResourceEntryName(id));
            return super.obtainTypedArray(id);
        }

    }

    public static class MContext extends ContextThemeWrapper {

        private Resources mResources;

        public MContext(Context base, Resources resources) {
            super(base, 0);
            mResources = resources;
        }

        @Override
        public Resources getResources() {
            return mResources;
        }

        @Override
        public Theme getTheme() {
            Log.d("getResourceName", "getResourceName getTheme =  ");
            return mResources.newTheme();
        }
    }

    public static void invokeLayoutInflate(LayoutInflater inflater, Context context){
        Class clazz = inflater.getClass();
        try {
            Field field = clazz.getDeclaredField("");
            field.setAccessible(true);
            field.set(inflater, context);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
