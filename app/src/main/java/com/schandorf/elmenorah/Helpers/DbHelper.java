package com.schandorf.elmenorah.Helpers;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Schandorf on 5/30/2018.
 */

public class DbHelper {

    private String DBName;
    private Context context;

    public DbHelper(String DBName, Context context) {
        this.DBName = DBName;
        this.context = context;
        Realm.init(context);
    }

    public Realm startRealm()
    {

        RealmConfiguration realmConfig = new RealmConfiguration.Builder()
                .name(DBName)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();
        return Realm.getInstance(realmConfig);
    }

    public void closeRealm(Realm realm)
    {
        if(realm != null)
        {
            realm.close();
        }
    }
}
