package com.magneticchen.daijishou.audio;

import android.content.Context;
import java.util.Locale;

public final class MusicStrings {

    private MusicStrings() {
    }

    public static String getLanguageCode() {
        Locale locale = Locale.getDefault();
        String lang = locale.getLanguage().toLowerCase(Locale.ROOT);
        String country = locale.getCountry().toUpperCase(Locale.ROOT);
        if ("zh".equals(lang)) {
            if ("TW".equals(country) || "HK".equals(country) || "MO".equals(country)) {
                return "zh-rTW";
            }
            return "zh";
        }
        if ("pt".equals(lang)) {
            return "pt";
        }
        return lang;
    }

    public static String getCategoryTitle(Context context) {
        String lang = getLanguageCode();
        switch (lang) {
            case "pt":
                return "Músicas";
            case "es":
                return "Música";
            case "de":
                return "Musik";
            case "fr":
                return "Musique";
            case "it":
                return "Musica";
            case "ja":
                return "音楽";
            case "ko":
                return "음악";
            case "zh":
                return "音乐";
            case "zh-rTW":
                return "音樂";
            case "hi":
                return "संगीत";
            default:
                return "Music";
        }
    }

    public static String getPlayMusicTitle(Context context) {
        String lang = getLanguageCode();
        switch (lang) {
            case "pt":
                return "Reproduzir músicas";
            case "es":
                return "Reproducir música";
            case "de":
                return "Musik abspielen";
            case "fr":
                return "Lire la musique";
            case "it":
                return "Riproduci musica";
            case "ja":
                return "音楽を再生";
            case "ko":
                return "음악 재생";
            case "zh":
                return "播放音乐";
            case "zh-rTW":
                return "播放音樂";
            case "hi":
                return "संगीत चलाएं";
            default:
                return "Play music";
        }
    }

    public static String getPlayMusicSummary(Context context) {
        String lang = getLanguageCode();
        switch (lang) {
            case "pt":
                return "Reproduzir músicas de fundo encontradas na pasta 'music' de onde as roms estão localizadas.";
            case "es":
                return "Reproducir música de fondo que se encuentre en la carpeta 'music' donde están las roms.";
            case "de":
                return "Hintergrundmusik aus dem Ordner 'music' am Speicherort der ROMs abspielen.";
            case "fr":
                return "Lire la musique de fond trouvée dans le dossier 'music' où se trouvent les ROM.";
            case "it":
                return "Riproduci la musica di sottofondo trovata nella cartella 'music' in cui si trovano le ROM.";
            case "ja":
                return "ROMがある場所の「music」フォルダー内のBGMを再生します。";
            case "ko":
                return "ROM이 있는 위치의 'music' 폴더에 있는 배경 음악을 재생합니다。";
            case "zh":
                return "播放ROM所在目录中'music'文件夹下的背景音乐。";
            case "zh-rTW":
                return "播放ROM所在目錄中'music'資料夾下的背景音樂。";
            case "hi":
                return "जहां ROM स्थित हैं वहां 'music' फ़ोल्डर में मिलने वाला बैकग्राउंड संगीत चलाएं।";
            default:
                return "Play background music found in the 'music' folder where the ROMs are located.";
        }
    }
}
