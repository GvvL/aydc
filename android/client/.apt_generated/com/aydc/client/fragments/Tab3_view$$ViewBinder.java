// Generated code from Butter Knife. Do not modify!
package com.aydc.client.fragments;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class Tab3_view$$ViewBinder<T extends com.aydc.client.fragments.Tab3_view> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131427405, "field 'scrollView'");
    target.scrollView = finder.castView(view, 2131427405, "field 'scrollView'");
    view = finder.findRequiredView(source, 2131427404, "field 'mPtrFrame'");
    target.mPtrFrame = finder.castView(view, 2131427404, "field 'mPtrFrame'");
    view = finder.findRequiredView(source, 2131427406, "field 'rcv_order'");
    target.rcv_order = finder.castView(view, 2131427406, "field 'rcv_order'");
  }

  @Override public void unbind(T target) {
    target.scrollView = null;
    target.mPtrFrame = null;
    target.rcv_order = null;
  }
}
