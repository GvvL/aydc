// Generated code from Butter Knife. Do not modify!
package com.aydc.client.fragments;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class Tab2_view$$ViewBinder<T extends com.aydc.client.fragments.Tab2_view> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131427401, "field 'ptrFrameLayout'");
    target.ptrFrameLayout = finder.castView(view, 2131427401, "field 'ptrFrameLayout'");
    view = finder.findRequiredView(source, 2131427403, "field 'rev_recommend'");
    target.rev_recommend = finder.castView(view, 2131427403, "field 'rev_recommend'");
    view = finder.findRequiredView(source, 2131427402, "field 'scrollView'");
    target.scrollView = finder.castView(view, 2131427402, "field 'scrollView'");
  }

  @Override public void unbind(T target) {
    target.ptrFrameLayout = null;
    target.rev_recommend = null;
    target.scrollView = null;
  }
}
