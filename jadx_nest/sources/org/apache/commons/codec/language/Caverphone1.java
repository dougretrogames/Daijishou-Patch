package org.apache.commons.codec.language;

import androidx.exifinterface.media.ExifInterface;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class Caverphone1 extends AbstractCaverphone {
    private static final String SIX_1 = "111111";

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        if (str == null || str.isEmpty()) {
            return SIX_1;
        }
        return (str.toLowerCase(Locale.ENGLISH).replaceAll("[^a-z]", "").replaceAll("^cough", "cou2f").replaceAll("^rough", "rou2f").replaceAll("^tough", "tou2f").replaceAll("^enough", "enou2f").replaceAll("^gn", "2n").replaceAll("mb$", "m2").replace("cq", "2q").replace("ci", "si").replace("ce", "se").replace("cy", "sy").replace("tch", "2ch").replace("c", "k").replace("q", "k").replace("x", "k").replace("v", "f").replace("dg", "2g").replace("tio", "sio").replace("tia", "sia").replace("d", "t").replace("ph", "fh").replace("b", "p").replace("sh", "s2").replace("z", "s").replaceAll("^[aeiou]", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS).replaceAll("[aeiou]", ExifInterface.GPS_MEASUREMENT_3D).replace("3gh3", "3kh3").replace("gh", "22").replace("g", "k").replaceAll("s+", ExifInterface.LATITUDE_SOUTH).replaceAll("t+", ExifInterface.GPS_DIRECTION_TRUE).replaceAll("p+", "P").replaceAll("k+", "K").replaceAll("f+", "F").replaceAll("m+", "M").replaceAll("n+", "N").replace("w3", "W3").replace("wy", "Wy").replace("wh3", "Wh3").replace("why", "Why").replace("w", ExifInterface.GPS_MEASUREMENT_2D).replaceAll("^h", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS).replace("h", ExifInterface.GPS_MEASUREMENT_2D).replace("r3", "R3").replace("ry", "Ry").replace("r", ExifInterface.GPS_MEASUREMENT_2D).replace("l3", "L3").replace("ly", "Ly").replace("l", ExifInterface.GPS_MEASUREMENT_2D).replace("j", "y").replace("y3", "Y3").replace("y", ExifInterface.GPS_MEASUREMENT_2D).replace(ExifInterface.GPS_MEASUREMENT_2D, "").replace(ExifInterface.GPS_MEASUREMENT_3D, "") + SIX_1).substring(0, SIX_1.length());
    }
}
