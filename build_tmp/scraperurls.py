import re, os

root = r'C:\Users\Douglas\Documents\Daijishou\jadx_nest\sources\com\magneticchen\daijishou'
files = {
    'DSESS': 'scraper/v2/impl/dsess/DSESS.java',
    'IGDB': 'scraper/v2/impl/IGDBScraper.java',
    'LibRetro': 'scraper/v2/impl/LibRetroScraper.java',
    'ArcadeItalia': 'scraper/v2/impl/ArcadeItaliaScraper.java',
    'Google': 'scraper/v2/impl/google/GoogleScraper.java',
    'Bing': 'scraper/v2/impl/BingScraper.java',
    'RawPico8': 'scraper/v2/impl/RawPico8Scraper.java',
}
for name, rel in files.items():
    p = os.path.join(root, rel.replace('/', os.sep))
    s = open(p, encoding='utf-8', errors='replace').read()
    urls = re.findall(r'"(https?://[^"]+)"', s)
    print(name, urls[:6])
