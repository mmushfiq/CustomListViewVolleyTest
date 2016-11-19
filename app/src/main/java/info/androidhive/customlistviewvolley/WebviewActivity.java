package info.androidhive.customlistviewvolley;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class WebviewActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);

        Intent intent = getIntent();
        String link = intent.getStringExtra("link");

        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
//        webView.loadUrl(link);

//        String customHtml = "<html><body><h1>Hello, WebView</h1></body></html>";
        String customHtml = "<!DOCTYPE html><html><head><meta charset=\"utf-8\" /><style>dt {font-weight:bold;}</style></head><body><div class=\"main-highlight\">\n" +
                " <div class=\"post-cols\">\n" +
                "  <div class=\"post-col\">\n" +
                "   <ul class=\"params\">\n" +
                "    <li class=\"params-i\">\n" +
                "     <div class=\"region params-i-label\">\n" +
                "      Şəhər\n" +
                "     </div>\n" +
                "     <div class=\"region params-i-val\">\n" +
                "      Bakı\n" +
                "     </div></li>\n" +
                "    <li class=\"params-i\">\n" +
                "     <div class=\"age params-i-label\">\n" +
                "      Yaş\n" +
                "     </div>\n" +
                "     <div class=\"age params-i-val\">\n" +
                "      21 - 35 yaş\n" +
                "     </div></li>\n" +
                "    <li class=\"params-i\">\n" +
                "     <div class=\"education params-i-label\">\n" +
                "      Təhsil\n" +
                "     </div>\n" +
                "     <div class=\"education params-i-val\">\n" +
                "      Ali\n" +
                "     </div></li>\n" +
                "    <li class=\"params-i\">\n" +
                "     <div class=\"experience params-i-label\">\n" +
                "      İş təcrübəsi\n" +
                "     </div>\n" +
                "     <div class=\"experience params-i-val\">\n" +
                "      3 ildən 5 ilə qədər\n" +
                "     </div></li>\n" +
                "    <li class=\"params-i\">\n" +
                "     <div class=\"bumped_on params-i-label\">\n" +
                "      Elanın tarixi\n" +
                "     </div>\n" +
                "     <div class=\"bumped_on params-i-val\">\n" +
                "      Noyabr 11, 2016\n" +
                "     </div></li>\n" +
                "    <li class=\"params-i\">\n" +
                "     <div class=\"expires_on params-i-label\">\n" +
                "      Bitmə tarixi\n" +
                "     </div>\n" +
                "     <div class=\"expires_on params-i-val\">\n" +
                "      Dekabr 11, 2016\n" +
                "     </div></li>\n" +
                "    <li class=\"params-i\">\n" +
                "     <div class=\"contact params-i-label\">\n" +
                "      Əlaqədar şəxs\n" +
                "     </div>\n" +
                "     <div class=\"contact params-i-val\">\n" +
                "      Elmar\n" +
                "     </div></li>\n" +
                "   </ul>\n" +
                "  </div>\n" +
                "  <div class=\"post-col\">\n" +
                "   <ul class=\"params params_contacts\">\n" +
                "    <li class=\"params-i\">\n" +
                "     <div class=\"phone params-i-label\">\n" +
                "      Telefon\n" +
                "     </div>\n" +
                "     <div class=\"phone params-i-val\">\n" +
                "      <a class=\"phone\" href=\"tel:(012) 497-06-10\">(012) 497-06-10</a>\n" +
                "     </div></li>\n" +
                "    <li class=\"params-i\">\n" +
                "     <div class=\"email params-i-label\">\n" +
                "      E-mail\n" +
                "     </div>\n" +
                "     <div class=\"email params-i-val\">\n" +
                "      <a encode=\"javascript\" href=\"mailto:hr@simberg.az\">hr@simberg.az</a>\n" +
                "     </div></li>\n" +
                "   </ul>\n" +
                "  </div>\n" +
                " </div>\n" +
                "</div><div class=\"post-cols post-info\">\n" +
                " <div class=\"post-col\">\n" +
                "  <dt class=\"job_description params-i-label\">\n" +
                "   İş barədə məlumat\n" +
                "  </dt>\n" +
                "  <dd class=\"job_description params-i-val\">\n" +
                "   <p>- İş qrafiki: 1-ci 5ci günlər saat 09:00-dan 18:00-dək <br>İşçinin vəzifələri: <br>- Layihələrin dizayn mərhələsində iştirak etmək <br>- Veb layihələrin hazırlanması və texniki dəstəyi <br>- Texniki sənədlərin hazırlanması <br>- Komandada işləməyi bacarmaq <br>- İşində məsuliyyətli olmaq</p>\n" +
                "  </dd>\n" +
                " </div>\n" +
                " <div class=\"post-col\">\n" +
                "  <dt class=\"requirements params-i-label\">\n" +
                "   Namizədə tələblər\n" +
                "  </dt>\n" +
                "  <dd class=\"requirements params-i-val\">\n" +
                "   <p>- REST servislərlə işləməyi bacarmaq <br>- Real-time işləyən web səhifələr hazırlamaq (NodeJS*, Socket IO*) <br>- Javascript, HTML(5), CSS(3) mükəmməl bilmək <br>- EcmaScript 6 (ES6) sintaksisini orta səviyyədə bilmək <br>- Single-page web səhifələrin hazırlanması və uyğun texnologiyaları bilmək (Məs: AngularJS*, React, Backbone) <br>- Javascript kitabxanalarını Angular-da tətbiq etməyi bilmək (Angular Material *, Kendo UI *, Bootstrap) <br>- Javascript task runner-lərdən istifadə etmək (Grunt*, Gulp və s.) <br>- UI prototipləri hazırlamaq (Moqups, Balsamiq və s.) <br>9. VCS-lə işləmək (SVN və ya git)</p> \n" +
                "   <p>*-la qeyd edilən texnologiya və alətləri bilmək vacibdir.</p>\n" +
                "  </dd>\n" +
                " </div>\n" +
                "</div></body></html>";
        webView.loadData(customHtml, "text/html", "UTF-8");
    }
}
