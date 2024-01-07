package TrendyolSearch;

import org.example.SearchKeywordControl;
import org.example.SearchKeywordNoFoundControl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class UITest {
    @Test
    public void Found(){
        //Aranan kelimenin bulunma testi
        SearchKeywordControl.targetKeyword = "Kalem";
        SearchKeywordControl.SearchKeyword();
        Assertions.assertTrue(SearchKeywordControl.response);
    }
    @Test
    public void NotFound(){
        //Aranan kelimenin bulunamadı testi
        SearchKeywordNoFoundControl.targetKeyword = "qweqweqweqweqweqweqwe";
        SearchKeywordNoFoundControl.SearchKeyword();
        Assertions.assertTrue(SearchKeywordNoFoundControl.response);
    }
    @Test
    public void MultiSearch(){
        //Birden fazla kelime ile aranan kelimenin bulunma testi
        SearchKeywordControl.targetKeyword = "Kırmızı Kalem";
        SearchKeywordControl.SearchKeyword();
        Assertions.assertTrue(SearchKeywordControl.response);
    }

    @Test
    public void NoFoundMultiSearch(){
        ////Birden fazla kelime ile aranan kelimenin bulunamama testi
        SearchKeywordNoFoundControl.targetKeyword = "qweqweqwe qweqweqweqwe";
        SearchKeywordNoFoundControl.SearchKeyword();
        Assertions.assertTrue(SearchKeywordNoFoundControl.response);
    }

    @Test
    public void InvalidSearch(){
        //Geçersiz format ile arama testi
        SearchKeywordNoFoundControl.targetKeyword = "'!^!'^!'^";
        SearchKeywordNoFoundControl.SearchKeyword();
        Assertions.assertTrue(SearchKeywordNoFoundControl.response);
    }

    @Test
    public void SpaceSearch(){
        //Aranan kelimenin başında ve sonunda boşluk varken arama testi
        SearchKeywordControl.targetKeyword = "    Kalem     ";
        SearchKeywordControl.SearchKeyword();
        Assertions.assertTrue(SearchKeywordControl.response);

}
    @Test
    public void FirstSpaceSearch(){
        //Aranan kelimenin başında boşluk varken arama testi
        SearchKeywordControl.targetKeyword = "     Kalem";
        SearchKeywordControl.SearchKeyword();
        Assertions.assertTrue(SearchKeywordControl.response);

    }
    @Test
    public void LastSpaceSearch(){
        //Aranan kelimenin sonunda boşluk varken arama testi
        SearchKeywordControl.targetKeyword = "Kalem            ";
        SearchKeywordControl.SearchKeyword();
        Assertions.assertTrue(SearchKeywordControl.response);

    }

    @Test
    public void UpperSearch(){
        //Büyük harflerle kelime arama testi
        SearchKeywordControl.targetKeyword = "KALEM";
        SearchKeywordControl.SearchKeyword();
        Assertions.assertTrue(SearchKeywordControl.response);

    }
    @Test
    public void LowerSearch(){
        //Kücük harflerle kelime arama testi
        SearchKeywordControl.targetKeyword = "kalem";
        SearchKeywordControl.SearchKeyword();
        Assertions.assertTrue(SearchKeywordControl.response);

    }
    @Test
    public void MixerSearch(){
        //Hem büyük hem kücük harfli kelimeyle arama testi
        SearchKeywordControl.targetKeyword = "KALem";
        SearchKeywordControl.SearchKeyword();
        Assertions.assertTrue(SearchKeywordControl.response);

    }
    @Test
    public void MixerSpaceSearch(){
        //Bosluk,büyük ve kücük harflerle olusan kelimenin arama testi
        SearchKeywordControl.targetKeyword = "K   Ale m";
        SearchKeywordControl.SearchKeyword();
        Assertions.assertTrue(SearchKeywordControl.response);
    }
}
