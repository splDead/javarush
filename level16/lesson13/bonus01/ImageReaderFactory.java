package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Применяем паттерн Фабрика, который создает нужный ридер, в зависимости от контента
 * Created by splD on 23.08.2016.
 */
public class ImageReaderFactory
{
    public static ImageReader getReader(ImageTypes types) {
        if (types == ImageTypes.BMP)
            return new BmpReader();
        else if (types == ImageTypes.JPG)
            return new JpgReader();
        else if (types == ImageTypes.PNG)
            return new PngReader();
        else if (types == null)
            throw new IllegalArgumentException("Неизвестный тип картинки");
        else
            throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
