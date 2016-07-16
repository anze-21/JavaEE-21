package com.it;

import com.google.common.io.FileBackedOutputStream;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws BadHanyuPinyinOutputFormatCombination, WriterException, IOException {
        // System.out.println(DigestUtils.md5Hex("000000"));
//        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
//        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);//让拼音小写
//        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);//不要音调
//        format.setVCharType(HanyuPinyinVCharType.WITH_V);//让u使用v来表示
//        String result = PinyinHelper.toHanYuPinyinString("驴", format, ",", true);
//        System.out.println(result);

        BitMatrix bitMatrix =new MultiFormatWriter().encode("Hello", BarcodeFormat.QR_CODE,
        200,200);
        MatrixToImageWriter.writeToStream(bitMatrix,"png",new FileOutputStream("D:/qr.png"));




    }
}



