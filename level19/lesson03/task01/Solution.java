package com.javarush.test.level19.lesson03.task01;

/* TableAdapter
Измените класс TableAdapter так, чтобы он адаптировал ATable к BTable.
Метод getHeaderText должен возвращать такую строку "[username] : tablename".
Пример, "[Amigo] : DashboardTable"
*/

public class Solution {
    public static void main(String[] args) {
        //это пример вывода
        ATable aTable = new ATable() {
            @Override
            public String getCurrentUserName() {
                return "Amigo";
            }

            @Override
            public String getTableName() {
                return "DashboardTable";
            }
        };

        BTable table = new TableAdapter(aTable);
        System.out.println(table.getHeaderText());
    }
    //в адаптере реализуем второй интерфейс BTable
    public static class TableAdapter implements BTable {
        //сохраняем переменную первого интерфейса ATable
        private ATable aTable;
        //в конструктор адаптора передаем первую таблицу
        public TableAdapter(ATable aTable) {
            this.aTable = aTable;
        }
        //перегружаем метод второй таблицы с использованием методов первой таблицы
        @Override
        public String getHeaderText()
        {   //вывод в консоль данных из первой таблицы через объект второй таблицы согласно условию
            String s = "[" + this.aTable.getCurrentUserName() + "] : " + this.aTable.getTableName();
            return s;
        }
    }

    public interface ATable {
        String getCurrentUserName();
        String getTableName();
    }

    public interface BTable {
        String getHeaderText();
    }
}