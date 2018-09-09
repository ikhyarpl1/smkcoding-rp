package ikhyarpl1.smkcoding.com.roompersistance;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {SiswaModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{

    public abstract SiswaDAO userDao();

}
