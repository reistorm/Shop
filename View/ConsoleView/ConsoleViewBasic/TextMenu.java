package View.ConsoleView.ConsoleViewBasic;

public class TextMenu {
    public String mainMenu = "__________________________\n"
                            + "Введите пункт меню\n"
                            + "1 - Показать все игрушки\n"
                            + "2 - Игра\n"
                            + "3 - Добавить игрушку\n"
                            + "4 - Поиск игрушек\n"
                            + "5 - Изменение данных игрушки\n"
                            + "6 - Удаление игрушек\n"
                            + "0 - Выход из программы\n";

    public String addMenu = "__________________________\n"
                            + "Введите пункт меню\n"
                            + "1 - Ввод названия игрушки\n"
                            + "2 - Ввод количества игрушек\n"
                            + "3 - Ввод веса вероятности выподания игрушки\n"
                            + "4 - Предварительный просмотр и сохранение\n"
                            + "0 - Назад в меню\n";

    public String gameMenu = "__________________________\n"
                                + "Введите пункт меню\n"
                                + "1 - Играть\n"
                                + "2 - Добавить элемент в список призов\n"
                                + "3 - Посмотреть список разыгрываемых элементов\n"
                                + "4 - Выбрать разыгрываемый элемент по id\n"
                                + "5 - Выбрать разыгрываемый элемент по индексу в списке\n"
                                + "6 - Удалить элемент из списка по id\n"
                                + "7 - Удалить все элементы из списка\n"
                                + "0 - Назад в меню\n";

    public String removeMenu = "__________________________\n"
                            + "Введите пункт меню\n"
                            + "1 - Удалить по Id\n"
                            + "2 - Удалить все игрушки\n"
                            + "0 - Назад в меню\n";

    public String selectMenu = "__________________________\n"
                            + "Введите пункт меню\n"
                            + "1 - Выбор по Id\n"
                            + "2 - Выбор по названию\n"
                            + "0 - Назад в меню\n";

    public String updateMenu = "__________________________\n"
                            + "Введите пункт меню\n"
                            + "1 - Изменить названия игрушки\n"
                            + "2 - Изменить количества игрушек\n"
                            + "3 - Изменить вес вероятности выподания игрушки\n"
                            + "4 - Предварительный просмотр и сохранение\n"
                            + "0 - Назад в меню\n";

    public String checkMenu = "__________________________\n"
                                + "Введите пункт меню\n"
                                + "1 - Подтведить действие\n"
                                + "0 - Назад в меню\n";

    public String requestId = "Введите Id игрушки или 0 для возврата в меню\n";

    public String requestIndex = "Введите Index игрушки или 0 для возврата в меню\n";

    public String errorText = "Вы ввели некорректное значение\n";

    public String requestToContinue = "для продолжения введите любое значение\n";

    public String requestData = "Введите данные:\n";

    public String previewText = "Предварительный просмотр:\n";

    public String notFound = "Данные соответствующие запросу не найдены:\n";
    public String thereIsNoStuff = "Недостаточное колличество:\n";
    public String thereIsNoAward = "В списке нет призов для розыгрыша\n";
    public String loserText = "Увы приз остается у нас\n";
    public String winText = "Вы выиграли\n";
    public String success = "Действие успешно выполнено";
}