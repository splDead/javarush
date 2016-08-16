package com.javarush.test.level20.lesson02.task05;

import java.io.*;

/* И еще раз о синхронизации
Разберитесь почему не работает метод main()
Реализуйте логику записи в файл и чтения из файла для класса Object
Метод load должен инициализировать объект данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution
{
    public static void main(java.lang.String[] args)
    {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try
        {
            File your_file_name = new File("c:/Java/test.txt"); // тестовый файл
//            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Object object = new Object();
            object.string1 = new String();   //string #1
            object.string2 = new String();   //string #2
            object.save(outputStream);
            outputStream.flush();

            Object loadedObject = new Object();
            loadedObject.string1 = new String(); //string #3
            loadedObject.string2 = new String(); //string #4

            loadedObject.load(inputStream);
            //check here that the object variable equals to loadedObject - проверьте тут, что object и loadedObject равны
            object.string1.print();
            object.string2.print();
            System.out.println("--");
            loadedObject.string1.print();
            loadedObject.string2.print();

            outputStream.close();
            inputStream.close();

        }
        catch (IOException e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        }
        catch (Exception e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Object
    {
        public String string1;
        public String string2;

        public void save(OutputStream outputStream) throws Exception
        {
            //implement this method - реализуйте этот метод
            PrintStream consoleStream = System.out;                             // сохраняем консоль
            ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();  // массив для перехвата
            PrintStream stream = new PrintStream(outputStream1);                // создаем свою консоль
            System.setOut(stream);                                              // назначаем ее
            string1.print();                                                    // заполняем ее
            string2.print();
            System.setOut(consoleStream);                                       // возвращаем все как было

            java.lang.String strings = outputStream1.toString().trim();         // получаем строку из массива
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(strings);                                       // сохраняем строку в файл

            printWriter.flush();
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception
        {
            //implement this method - реализуйте этот метод
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            int cSo = countStrings;                                             // сохраняем состояние счетчика

            countStrings = Integer.parseInt(bufferedReader.readLine().replace("string #", "")) - 1; // устнавливаем новое значение счетчика из файла
            string1 = new String();                                             // инициализируем переменные данными из файла
            string2 = new String();

            countStrings = cSo;                                                 // возвращаем значение счетчика на место
            bufferedReader.close();
        }
    }

    public static int countStrings;

    public static class String
    {
        private final int number;

        public String()
        {
            number = ++countStrings;
        }

        public void print()
        {
            System.out.println("string #" + number);
        }
    }
}
