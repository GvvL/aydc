// Generated code from Butter Knife. Do not modify!
package com.aydc.client.fragments;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class Tab4_view$$ViewBinder<T extends com.aydc.client.fragments.Tab4_view> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131427408, "field 'mPtrFrame'");
    target.mPtrFrame = finder.castView(view, 2131427408, "field 'mPtrFrame'");
    view = finder.findRequiredView(source, 2131427409, "field 'scrollView'");
    target.scrollView = finder.castView(view, 2131427409, "field 'scrollView'");
  }

  @Override public void unbind(T target) {
    target.mPtrFrame = null;
    target.scrollView = null;
  }
}
