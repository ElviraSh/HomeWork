package ru.kpfu.itis.ShalafaevaElvira.database;

/**
 * Created by Elvira on 12.11.2016.
 */
public class DBException extends Exception{

    public DBException(String cant_find_DB_driver) {
        super(cant_find_DB_driver);
    }

}
