package com.it;

import com.google.common.io.FileBackedOutputStream;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
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
import org.apache.commons.codec.digest.DigestUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;

public class Test {
    public static void main(String[] args) throws BadHanyuPinyinOutputFormatCombination, WriterException, IOException {
         System.out.println(DigestUtils.md5Hex("123123"));
//        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
//        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);//让拼音小写
//        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);//不要音调
//        format.setVCharType(HanyuPinyinVCharType.WITH_V);//让u使用v来表示
//        String result = PinyinHelper.toHanYuPinyinString("驴", format, ",", true);
//        System.out.println(result);
        //生成二维码
       // BitMatrix bitMatrix =new MultiFormatWriter().encode("Hello", BarcodeFormat.QR_CODE,
      //  200,200);
       // String mecard = "MECARD:N:樊凯;ORG:凯盛软件;TEL:15138041672;EMAIL:fankai@kaishengit.com;ADR:中国;;";
//        String mecard = "哈哈，没问题,我们会把你吃穷的额~~~;";
//        Hashtable hints =new Hashtable();
//        hints.put(EncodeHintType.CHARACTER_SET,"UTF-8");
//        BitMatrix bitMatrix =new MultiFormatWriter().encode(mecard,BarcodeFormat.QR_CODE,400,400,hints);
//        MatrixToImageWriter.writeToStream(bitMatrix,"png",new FileOutputStream("D:/qr.png"));




    }
}



