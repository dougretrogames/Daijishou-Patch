package org.apache.commons.codec.language;

import androidx.exifinterface.media.ExifInterface;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class Caverphone2 extends AbstractCaverphone {
    private static final String TEN_1 = "1111111111";

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        if (SoundexUtils.isEmpty(str)) {
            return TEN_1;
        }
        return (str.toLowerCase(Locale.ENGLISH).replaceAll("[^a-z]", "").replaceAll("e$", "").replaceAll("^cough", "cou2f").replaceAll("^rough", "rou2f").replaceAll("^tough", "tou2f").replaceAll("^enough", "enou2f").replaceAll("^trough", "trou2f").replaceAll("^gn", "2n").replaceAll("mb$", "m2").replace("cq", "2q").replace("ci", "si").replace("ce", "se").replace("cy", "sy").replace("tch", "2ch").replace("c", "k").replace("q", "k").replace("x", "k").replace("v", "f").replace("dg", "2g").replace("tio", "sio").replace("tia", "sia").replace("d", "t").replace("ph", "fh").replace("b", "p").replace("sh", "s2").replace("z", "s").replaceAll("^[aeiou]", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS).replaceAll("[aeiou]", ExifInterface.GPS_MEASUREMENT_3D).replace("j", "y").replaceAll("^y3", "Y3").replaceAll("^y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS).replace("y", ExifInterface.GPS_MEASUREMENT_3D).replace("3gh3", "3kh3").replace("gh", "22").replace("g", "k").replaceAll("s+", ExifInterface.LATITUDE_SOUTH).replaceAll("t+", ExifInterface.GPS_DIRECTION_TRUE).replaceAll("p+", "P").replaceAll("k+", "K").replaceAll("f+", "F").replaceAll("m+", "M").replaceAll("n+", "N").replace("w3", "W3").replace("wh3", "Wh3").replaceAll("w$", ExifInterface.GPS_MEASUREMENT_3D).replace("w", ExifInterface.GPS_MEASUREMENT_2D).replaceAll("^h", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS).replace("h", ExifInterface.GPS_MEASUREMENT_2D).replace("r3", "R3").replaceAll("r$", ExifInterface.GPS_MEASUREMENT_3D).replace("r", ExifInterface.GPS_MEASUREMENT_2D).replace("l3", "L3").replaceAll("l$", ExifInterface.GPS_MEASUREMENT_3D).replace("l", ExifInterface.GPS_MEASUREMENT_2D).replace(ExifInterface.GPS_MEASUREMENT_2D, "").replaceAll("3$", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS).replace(ExifInterface.GPS_MEASUREMENT_3D, "") + TEN_1).substring(0, TEN_1.length());
    }
}
