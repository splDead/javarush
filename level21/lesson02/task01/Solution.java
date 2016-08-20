package com.javarush.test.level21.lesson02.task01;

/* Определяем адрес сети
1) Даны IP-адрес и маска подсети, необходимо вычислить адрес сети - метод getNetAddress.
Используйте операцию поразрядной конъюнкции (логическое И).
Пример:
IP-адрес:       11000000 10101000 00000001 00000010 (192.168.1.2)
Маска подсети:  11111111 11111111 11111110 00000000 (255.255.254.0)
Адрес сети:     11000000 10101000 00000000 00000000 (192.168.0.0)
2) Реализовать метод print, который выведет в консоль данные в двоичном коде
3) Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    /**
     * Метод вычисляет адрес сети, используя IP-адрес и маску подсети.
     * Используется операция поразрядной конъюнкции (сравниваются ячейки из массивов).
     * @param ip
     * @param mask
     * @return Результатом является массив значений, представляющий собой адрес сети.
     */
    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] netAddress = new byte[4];
        for (int i = 0; i < ip.length; i++) {
            netAddress[i] = (byte) (ip[i] & mask[i]);
        }
        return netAddress;
    }

    /**
     * Метод получает массив байт, переводит значение из байт в бинарный вид.
     * Для этого значение ячейки массива прелставляется в бинарном виде и сохраняется в строковую переменную.
     * Из полученной строки берем последние 8 символов.
     * Результат собираем в объект класса StringBuilder.
     * Перед выводом на консоль, отсекаются лишние пробелы.
     * @param bytes
     */
    public static void print(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (Byte b : bytes) {
            String s = Integer.toBinaryString(256 + b);
            if (s.length() > 8)
                s = s.substring(s.length() - 8);
            sb.append(s).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
