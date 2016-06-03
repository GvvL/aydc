// Generated code from Butter Knife. Do not modify!
package com.aydc.client.ui;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class MainActivity$$ViewBinder<T extends com.aydc.client.ui.MainActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131427361, "field 'rb2' and method 'onClick'");
    target.rb2 = finder.castView(view, 2131427361, "field 'rb2'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131427359, "field 'radioGroup'");
    target.radioGroup = finder.castView(view, 2131427359, "field 'radioGroup'");
    view = finder.findRequiredView(source, 2131427356, "field 'viewpager'");
    target.viewpager = finder.castView(view, 2131427356, "field 'viewpager'");
    view = finder.findRequiredView(source, 2131427363, "field 'rb4' and method 'onClick'");
    target.rb4 = finder.castView(view, 2131427363, "field 'rb4'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131427360, "field 'rb1' and method 'onClick'");
    target.rb1 = finder.castView(view, 2131427360, "field 'rb1'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131427362, "field 'rb3' and method 'onClick'");
    target.rb3 = finder.castView(view, 2131427362, "field 'rb3'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
  }

  @Override public void unbind(T target) {
    target.rb2 = null;
    target.radioGroup = null;
    target.viewpager = null;
    target.rb4 = null;
    target.rb1 = null;
    target.rb3 = null;
  }
}
