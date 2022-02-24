package main.java.ru.serioussem.se.money.constants;

public enum TypeCategory {

    TRANSFER(0, "Перевод между счетами"),
    INCOME(1, "Доход"),
    EXPENSE(2, "Расход");


    private final int code;
    private final String name;

    TypeCategory(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static TypeCategory getByCode(int code) {
        for (TypeCategory typeCategory :
                TypeCategory.values()) {
            if (typeCategory.code == code) {
                return typeCategory;
            }
        }
        throw new IllegalArgumentException("Неизвестный TypeOperation code=" + code);
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
