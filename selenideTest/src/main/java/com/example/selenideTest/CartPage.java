package com.example.selenideTest;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage {

   //проверка имени товара в корзине
   public SelenideElement  nameInCart = $x("(//div[@class=\"cart-package__content\"]//div[contains(@class, \"column _name\")])[1]" +
           "//a[contains(@class, 'os-product-card__title')]");
   //цена товара в корзине
   public SelenideElement  itemPriceInCart = $x("(//div[@class=\"cart-package__content\"]//div[contains(@class, \"cart-package__item__price\")])[1]");
   //количество товара в корзине
   public SelenideElement  countInCart = $x("(//div[@class=\"cart-package__content\"]//div[contains(@class, \"column _count\")])[1]//input");
   //количество всех товаров в корзине
   public SelenideElement  totalCountInCart = $x("//div[@ng-bind-html=\"userService.cart.amount\"]");
   //общая цена за все товары в корзине
   public SelenideElement  totalPriceInCart = $("div.total-cart-block__price");
}
