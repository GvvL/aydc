// Generated code from Butter Knife. Do not modify!
package com.aydc.client.fragments;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class Tab1_view$$ViewBinder<T extends com.aydc.client.fragments.Tab1_view> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131427378, "field 'tv_address'");
    target.tv_address = finder.castView(view, 2131427378, "field 'tv_address'");
    view = finder.findRequiredView(source, 2131427381, "field 'scrollView'");
    target.scrollView = finder.castView(view, 2131427381, "field 'scrollView'");
    view = finder.findRequiredView(source, 2131427385, "field 'condition_s'");
    target.condition_s = finder.castView(view, 2131427385, "field 'condition_s'");
    view = finder.findRequiredView(source, 2131427389, "field 'imagecycle'");
    target.imagecycle = finder.castView(view, 2131427389, "field 'imagecycle'");
    view = finder.findRequiredView(source, 2131427390, "field 'indicator'");
    target.indicator = finder.castView(view, 2131427390, "field 'indicator'");
    view = finder.findRequiredView(source, 2131427382, "field 'linearlayout'");
    target.linearlayout = finder.castView(view, 2131427382, "field 'linearlayout'");
    view = finder.findRequiredView(source, 2131427383, "field 'condition'");
    target.condition = finder.castView(view, 2131427383, "field 'condition'");
    view = finder.findRequiredView(source, 2131427380, "field 'mPtrFrame'");
    target.mPtrFrame = finder.castView(view, 2131427380, "field 'mPtrFrame'");
    view = finder.findRequiredView(source, 2131427384, "field 'lv_store'");
    target.lv_store = finder.castView(view, 2131427384, "field 'lv_store'");
    view = finder.findRequiredView(source, 2131427379, "method 'onclick'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onclick();
        }
      });
  }

  @Override public void unbind(T target) {
    target.tv_address = null;
    target.scrollView = null;
    target.condition_s = null;
    target.imagecycle = null;
    target.indicator = null;
    target.linearlayout = null;
    target.condition = null;
    target.mPtrFrame = null;
    target.lv_store = null;
  }
}
