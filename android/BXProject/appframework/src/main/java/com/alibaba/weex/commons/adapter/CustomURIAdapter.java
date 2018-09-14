package com.alibaba.weex.commons.adapter;


import android.net.Uri;
import android.support.annotation.NonNull;

import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.adapter.URIAdapter;
import com.taobao.weex.common.Constants;

import java.util.List;

/**
 * Created with Android Studio2.0.
 * Project:android
 * Title:CustomURIAdapter
 * Description:
 * Copyright:Copyright (c) 2016
 * Company:宝信软件
 * Author:kalicy
 * Date:17/5/12
 * Time:下午2:07
 * Version 1.0
 */
public class CustomURIAdapter implements URIAdapter {

    @NonNull
    @Override
    public Uri rewrite(WXSDKInstance instance, String type, Uri uri) {
        Uri base = Uri.parse(instance.getBundleUrl());
        Uri.Builder resultBuilder = uri.buildUpon();

        if (uri.isRelative()) {
            resultBuilder = buildRelativeURI(resultBuilder, base, uri);
            return resultBuilder.build();
        }
        if (Constants.Scheme.LOCAL.equals(uri.getScheme()) ) {
            String src = uri.toString().substring(0, uri.toString().lastIndexOf("."));
            src = src.replaceFirst("local://", "local:///");
            uri = Uri.parse(src);

        }
        return uri;


    }

    private Uri.Builder buildRelativeURI(Uri.Builder resultBuilder, Uri base, Uri uri) {
        if (uri.getAuthority() != null) {
            return resultBuilder.scheme(base.getScheme());
        } else {
            resultBuilder
                    .encodedAuthority(base.getEncodedAuthority())
                    .scheme(base.getScheme())
                    .path(null);

            if (uri.getPath().startsWith("/")) {
                //relative to root
                resultBuilder.appendEncodedPath(uri.getEncodedPath().substring(1));
            } else {
                List<String> segments = base.getPathSegments();
                //ignore last segment if not end with /
                int ignoreLast = 1;
                if (base.getPath().endsWith("/")) {
                    ignoreLast = 0;
                }
                for (int i = 0, len = segments.size() - ignoreLast; i < len; i++) {
                    resultBuilder.appendEncodedPath(segments.get(i));
                }
                resultBuilder.appendEncodedPath(uri.getEncodedPath());
            }
            return resultBuilder;
        }
    }

}
