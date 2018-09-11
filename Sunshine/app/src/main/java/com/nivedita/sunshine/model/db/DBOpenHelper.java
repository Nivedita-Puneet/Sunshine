package com.nivedita.sunshine.model.db;

import android.content.Context;

import com.nivedita.sunshine.di.scope.ApplicationContext;
import com.nivedita.sunshine.di.scope.DatabaseInfo;
import com.nivedita.sunshine.model.pojo.DaoMaster;

import org.greenrobot.greendao.database.Database;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by PUNEETU on 08-09-2018.
 */

@Singleton
public class DBOpenHelper extends DaoMaster.OpenHelper {

    @Inject
    public DBOpenHelper(@ApplicationContext  Context context,@DatabaseInfo  String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        switch (oldVersion) {
            case 1:
            case 2:
                //db.execSQL("ALTER TABLE " + UserDao.TABLENAME + " ADD COLUMN "
                // + UserDao.Properties.Name.columnName + " TEXT DEFAULT 'DEFAULT_VAL'");
        }
    }

}
