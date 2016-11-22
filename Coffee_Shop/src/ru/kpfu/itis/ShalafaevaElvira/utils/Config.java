package ru.kpfu.itis.ShalafaevaElvira.utils;

import ru.kpfu.itis.ShalafaevaElvira.repositories.CoffeeList;
import ru.kpfu.itis.ShalafaevaElvira.repositories.CoffeeRepositories;
import ru.kpfu.itis.ShalafaevaElvira.repositories.PSQLUserRep;
import ru.kpfu.itis.ShalafaevaElvira.repositories.UserRepositories;

/**
 * Created by Elvira on 12.11.2016.
 */
public class Config {
    private static CoffeeRepositories coffeeRepositories;
    private static UserRepositories userRepository;


    public static CoffeeRepositories getCoffeeRepository() {
        if (coffeeRepositories != null){
            return coffeeRepositories;
        } else {
            coffeeRepositories = new CoffeeList();
            return coffeeRepositories;
        }
    }

    public static UserRepositories getUserRepository() {
        if (userRepository != null){
            return userRepository;
        } else {
            userRepository = new PSQLUserRep();
            return userRepository;
        }
    }
}