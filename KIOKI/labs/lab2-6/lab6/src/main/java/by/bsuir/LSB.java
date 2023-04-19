package by.bsuir;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LSB {
        private static final int HEADER_SIZE = 54; // размер заголовка BMP файла
        private static final int OFFSET_SIZE = 10; // смещение данных счетчика в заголовке BMP файла
        private static final int BYTE_SIZE = 8; // количество бит в байте

        public static void writeLSB(String inputFileName, String message, String modifiedFileName) throws IOException {
            File file = new File(inputFileName);
            FileInputStream inputStream = new FileInputStream(file);
            byte[] header = new byte[HEADER_SIZE];
            byte[] data = new byte[(int)file.length() - HEADER_SIZE];
            int offset = 0;
            int length = message.length();

            try {
                inputStream.read(header); // чтение заголовка
                offset = byteArrayToInt(header, OFFSET_SIZE); // получение смещения
                inputStream.read(data); // чтение данных
            } finally {
                inputStream.close();
            }
           for (int i = 0; i < length; i++) {
                byte[] bytes = Integer.toBinaryString(message.charAt(i)).getBytes();
                for (int j = 0; j < bytes.length; j++) { // бежим по всем битам каждой буквы и записываем их в 1 младший бит каждого байта исходных данных
                    if (offset < data.length) {
                        data[offset] = (byte)((data[offset] & 0xFE) | (bytes[j] - 48)); // запись LSB, 48 - код симовла 0 в ASCI
                        offset++; //                         0xFE = 1111 1110
                    } else {
                        break;
                    }
                }
            }
            File modifiedFile = new File(modifiedFileName);
            FileOutputStream outputStream = new FileOutputStream(modifiedFileName);
            try {
                outputStream.write(header);
                outputStream.write(data);
            } finally {
                outputStream.close();
            }
        }

        // Метод для конвертирования четырехбайтового массива в целое число
        private static int byteArrayToInt(byte[] bytes, int offset) {
            int value = 0;
            for (int i = 0; i < 4; i++) {
                value |= (bytes[offset + i] & 0xFF) << (i * BYTE_SIZE);
            }
            return value;
        }

    public static void main(String[] args) throws IOException {
        String input = "C:\\Univer\\FKP\\6sem\\KIOKI\\labs\\lab2-6\\lab6\\src\\main\\resources\\sample1.bmp";
        String output = "C:\\Univer\\FKP\\6sem\\KIOKI\\labs\\lab2-6\\lab6\\src\\main\\resources\\sample2.bmp";
        String message = "Она пришла под утро.\n" +
                "Вошла осторожно, тихо, бесшумно ступая, плывя по комнате, словно призрак, привидение, а единственным звуком,\n" +
                "выдававшим ее движение, был шорох накидки, прикасавшейся к голому телу. Однако именно этот исчезающе тихий,\n" +
                "едва уловимый шелест разбудил ведьмака, а может, только вырвал из полусна, в котором он мерно колыхался,\n" +
                "словно погруженный в бездонную топь, висящий между дном и поверхностью спокойного моря, среди легонько извивающихся нитей водорослей.\n" +
                "Он не пошевелился, даже не дрогнул. Девушка подпорхнула ближе, сбросила накидку, медленно, нерешительно оперлась коленом о край ложа.\n" +
                "Он наблюдал за ней из-под опущенных ресниц, не выдавая себя. Девушка осторожно поднялась на постель, легла на него, обхватила бедрами.\n" +
                "Опираясь на напряженные руки, скользнула по его лицу волосами. Волосы пахли ромашкой. Решительно и как бы нетерпеливо наклонилась,\n" +
                "коснулась сосочком его века, щеки, губ. Он улыбнулся, медленно, осторожно, нежно взял ее руки в свои.\n" +
                "Она выпрямилась, ускользая от его пальцев, лучистая, подсвеченная и от этого света нечеткая в туманном отблеске зари.\n" +
                "Он пошевелился, но она решительным нажимом обеих рук остановила его и легкими, но настойчивыми движениями бедер добилась ответа.\n" +
                "Он ответил. Она уже не избегала его рук, откинула голову, встряхнула волосами. Ее кожа была холодной и поразительно гладкой.\n" +
                "Глаза, которые он увидел, когда она приблизила свое лицо к его лицу, были огромными и темными, как глаза русалки.\n" +
                "Покачиваясь, он утонул в ромашковом море, а оно взбурлило и зашумело, потеряв покой. ";
        writeLSB(input, message, output);

    }
}
