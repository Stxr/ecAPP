package com.example.latte.ec.database;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

/**
 * Created by stxr .
 * Date: 18-2-5
 * Time: 下午11:55
 * note:
 */
public class DataBaseManager {
    private DaoSession mDaoSession;
    private UserProfileDao mDao;

    private DataBaseManager() {

    }

    private static final class Holder {
        private static final DataBaseManager INSTANCE = new DataBaseManager();
    }

    public static DataBaseManager getInstance() {
        return Holder.INSTANCE;
    }

    public final DataBaseManager init(Context context) {
        initDao(context);
        return this;
    }

    public final UserProfileDao getDao() {
        return mDao;
    }


    private void initDao(Context context) {

        final ReleaseOpenHelper helper = new ReleaseOpenHelper(context, "fast_ec.db");
        final Database db = helper.getReadableDb();
        mDaoSession = new DaoMaster(db).newSession();
        mDao = mDaoSession.getUserProfileDao();
    }
}
