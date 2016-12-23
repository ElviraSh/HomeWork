package ru.kpfu.itis.ShalafaevaElvira.repositories;

import ru.kpfu.itis.ShalafaevaElvira.database.DBException;
import ru.kpfu.itis.ShalafaevaElvira.objects.Users;

/**
 * Created by Elvira on 12.11.2016.
 */
public interface UserRepositories {
    public Users add(Users obj) throws DBException;
    public Users get(String email) throws DBException;
    public Users get(int id) throws DBException;
}
