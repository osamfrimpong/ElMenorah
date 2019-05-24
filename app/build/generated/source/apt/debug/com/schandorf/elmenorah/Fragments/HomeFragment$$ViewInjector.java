// Generated code from Butter Knife. Do not modify!
package com.schandorf.elmenorah.Fragments;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class HomeFragment$$ViewInjector {
  public static void inject(Finder finder, final com.schandorf.elmenorah.Fragments.HomeFragment target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624121, "field 'homeTopImage'");
    target.homeTopImage = (android.widget.ImageView) view;
    view = finder.findRequiredView(source, 2131624122, "field 'homeRecyclerView'");
    target.homeRecyclerView = (android.support.v7.widget.RecyclerView) view;
  }

  public static void reset(com.schandorf.elmenorah.Fragments.HomeFragment target) {
    target.homeTopImage = null;
    target.homeRecyclerView = null;
  }
}
