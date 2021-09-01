package com.example.selenideTest;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
   public static String mainURL = "https://ru.siberianhealth.com/ru/";
   public static String mainURL2 = "file:///C:/Users/Anna/Desktop/new5.html";

   public SelenideElement beautyCategory = $x("//a[@href='/ru/shop/catalog/category/3/'][contains(.,'Красота')]");    //каталог Красота
   public SelenideElement closePopUpWindow = $("button.digi-search-highlight__close");












}
