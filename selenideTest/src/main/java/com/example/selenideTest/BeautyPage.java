package com.example.selenideTest;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.$;

public class BeautyPage {

   //перейти в корзину
   public SelenideElement goToCart = $("div.nvb-cart");

   //положить в корзину по названию товара
   public SelenideElement buttonPutInCart(String itemName){
      return  $x("//div[@class=\"products-catalog__info-container\"]/a[contains(.,'" + itemName + "')]" +
              "/parent::*/parent::*//button[@ng-click=\"addToCart()\"]");
   }

   //цена на товар в каталоге Красота
   public SelenideElement getItemPrice(int num){
      return $x("//div[@ec-product='product']["+num+"]//span[contains(@ng-bind-html, \"product.price.current\")]/span[1]");  }

   //название товара в каталоге красота (по номеру num)
   public SelenideElement  getItemName (int num){
      return $x("//div[@ec-product=\"product\"][" + num + "]//a[@itemprop=\"name\"]");
   }

}
