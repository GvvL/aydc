// Generated code from Butter Knife. Do not modify!
package com.aydc.client.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class StoreView$$ViewBinder<T extends com.aydc.client.ui.StoreView> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131427358, "field 'foodListView'");
    target.foodListView = finder.castView(view, 2131427358, "field 'foodListView'");
  }

  @Override public void unbind(T target) {
    target.foodListView = null;
  }
}
