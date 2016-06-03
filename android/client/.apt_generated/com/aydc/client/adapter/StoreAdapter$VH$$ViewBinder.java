// Generated code from Butter Knife. Do not modify!
package com.aydc.client.adapter;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class StoreAdapter$VH$$ViewBinder<T extends com.aydc.client.adapter.StoreAdapter.VH> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131427370, "field 'tv_act_detail_str'");
    target.tv_act_detail_str = finder.castView(view, 2131427370, "field 'tv_act_detail_str'");
    view = finder.findRequiredView(source, 2131427369, "field 'tv_distribution_fee'");
    target.tv_distribution_fee = finder.castView(view, 2131427369, "field 'tv_distribution_fee'");
    view = finder.findRequiredView(source, 2131427367, "field 'tv_month_sales'");
    target.tv_month_sales = finder.castView(view, 2131427367, "field 'tv_month_sales'");
    view = finder.findRequiredView(source, 2131427368, "field 'tv_start_distribution_fee'");
    target.tv_start_distribution_fee = finder.castView(view, 2131427368, "field 'tv_start_distribution_fee'");
    view = finder.findRequiredView(source, 2131427364, "field 'img_store'");
    target.img_store = finder.castView(view, 2131427364, "field 'img_store'");
    view = finder.findRequiredView(source, 2131427365, "field 'tv_title'");
    target.tv_title = finder.castView(view, 2131427365, "field 'tv_title'");
  }

  @Override public void unbind(T target) {
    target.tv_act_detail_str = null;
    target.tv_distribution_fee = null;
    target.tv_month_sales = null;
    target.tv_start_distribution_fee = null;
    target.img_store = null;
    target.tv_title = null;
  }
}
