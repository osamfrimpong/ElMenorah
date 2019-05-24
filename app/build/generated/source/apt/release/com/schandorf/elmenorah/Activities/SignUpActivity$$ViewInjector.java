// Generated code from Butter Knife. Do not modify!
package com.schandorf.elmenorah.Activities;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class SignUpActivity$$ViewInjector {
  public static void inject(Finder finder, final com.schandorf.elmenorah.Activities.SignUpActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131624113, "field 'name'");
    target.name = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131624105, "field 'username'");
    target.username = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131624120, "field 'email'");
    target.email = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131624121, "field 'sigupGender' and method 'onClick'");
    target.sigupGender = (android.widget.EditText) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624122, "field 'dateOfBirth' and method 'onClick'");
    target.dateOfBirth = (android.widget.EditText) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
    view = finder.findRequiredView(source, 2131624123, "field 'password'");
    target.password = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131624124, "field 'signup' and method 'onClick'");
    target.signup = (android.widget.Button) view;
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onClick(p0);
        }
      });
  }

  public static void reset(com.schandorf.elmenorah.Activities.SignUpActivity target) {
    target.name = null;
    target.username = null;
    target.email = null;
    target.sigupGender = null;
    target.dateOfBirth = null;
    target.password = null;
    target.signup = null;
  }
}
