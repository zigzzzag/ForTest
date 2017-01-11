package com.mnikiforov.core.initialize.static_initialize;

/**
 * Created by zigzzzag on 16.02.16.
 */
public class StaticInitialize {

    public static void main(String[] args) {
        System.err.println("Создание нового объекта Cupboard в main()");
        new CupBoard();
        System.err.println("Создание нового объекта Cupboard в main()");
        new CupBoard();
        table.f2(1);
        cupBoard.f3(1);
    }

    static Table table = new Table();
    static CupBoard cupBoard = new CupBoard();
}
