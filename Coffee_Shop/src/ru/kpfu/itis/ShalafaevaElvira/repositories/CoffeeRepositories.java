package ru.kpfu.itis.ShalafaevaElvira.repositories;


import ru.kpfu.itis.ShalafaevaElvira.objects.Coffee;

/**
 * Created by Elvira on 12.11.2016.
 */
public interface CoffeeRepositories {
    boolean delete(Coffee coffee);
    Coffee get(String name);
}
