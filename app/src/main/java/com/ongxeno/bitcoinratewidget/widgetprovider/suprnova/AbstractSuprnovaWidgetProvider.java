package com.ongxeno.bitcoinratewidget.widgetprovider.suprnova;

import android.content.Context;

import com.ongxeno.bitcoinratewidget.common.preference.Preference;
import com.ongxeno.bitcoinratewidget.common.preference.SuprnovaPref;
import com.ongxeno.bitcoinratewidget.widgetprovider.common.AbstractGenericPoolWidgetProvider;

/**
 * @author Xenocide93 on 8/4/17.
 */

public abstract class AbstractSuprnovaWidgetProvider extends AbstractGenericPoolWidgetProvider {

	private static final String HTTP = "https://";

	private static final String SUPRNOVA_BASE_URL = ".suprnova.cc/";

	@Override
	protected String getBaseUrl() {
		return HTTP + getCoinmineCoinType() + SUPRNOVA_BASE_URL;
	}

	@Override
	protected String initToken(Context context) {
		return Preference.getInstance(context).getSuprnovaApiToken();
	}

	@Override
	public void onSetThreshold(Context context, double threshold) {
		onSetThreshold(SuprnovaPref.getInstance(context), threshold);
	}

	protected abstract void onSetThreshold(SuprnovaPref pref, double threshold);
}