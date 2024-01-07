# otomation-test
API and UI test

# API
http://www.omdbapi.com/ 

"By Search" başlığı altındaki parametrelerle "Harry Potter" araması yapıp, gelen sonuçlardan "Harry Potter and the Sorcerer's Stone" filminin imdbId'sini alınır.
Bu id ile "By ID or Title" başlığı altındaki metodlarda film araması yapılır.
“By Search” ile “BY ID or Title” parametreleri ile ilgili film ismi veya imdbId ile istek atılır. 
Atılan isteklerin response’larındaki title alanlarının 2. adımda gelen response’taki aynı imdbId’ye sahip olduğunu ve title değerinin “Harry Potter and the 
Sorcerer’s Stone” olarak aynı geldiğini kontrol edilir.

Gelen response içinde, datanın title, year, released alanlarının gelip gelmediğini ve http status'unu kontrol eden program.

## UI
Trendyol.com anasayfası açılır.
Herhangi bir keyword ile arama yapılır. Bu iki işlem sonrasında, arama fonksiyonun doğru çalışıp çalışmadığı kontrol edilir. 

