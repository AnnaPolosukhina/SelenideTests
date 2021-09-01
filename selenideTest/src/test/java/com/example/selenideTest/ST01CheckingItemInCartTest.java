package com.example.selenideTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ST01CheckingItemInCartTest {
   private final MainPage mp = new MainPage();
   private final BeautyPage bp = new BeautyPage();
   private final CartPage cp = new CartPage();

   String itemName;     //здесь будем хранить название товара
   int num = 3;         //добавляем например 3й товар
   String count = "1";       //количество товара
   String price;           //здесь будем хранить цену товара

   @BeforeAll
   public static void setUpAllure() {
      SelenideLogger.addListener("allure", new AllureSelenide());
   }

   @BeforeEach
   public void setUp() {
      Configuration.startMaximized = true;
      Configuration.browser = "chrome";
      Configuration.timeout = 20000;
      open(mp.mainURL);
   }

   @Test
   void selenideTest01CheckingItemInCart(){

      mp.closePopUpWindow.shouldBe(visible).click();                    // закрыть всплывающее информационное окошко
      mp.beautyCategory.click();                                        // Зайти в категорию Красота
      itemName = bp.getItemName(num).getText();                         // Выбрать некий товар, вернуть название
      price = bp.getItemPrice(num).getText();                              // Запомнить цену
      bp.buttonPutInCart(itemName).hover().click();                     // Добавить выбранный товар в корзину
      bp.goToCart.click();                                              // Перейти в корзину
      //проверки в корзине
      cp.nameInCart.shouldHave(text(itemName));                         // Проверить имя товара в листе товаров
      cp.countInCart.shouldHave(value(count));                          //проверка что совпадает количество
      cp.itemPriceInCart.shouldHave(text(price));                       // проверка что совпадает цена
      //проверки - общая цена и количество
      cp.totalCountInCart.shouldHave(text(count));                      //проверка общего количества товаров
      cp.totalPriceInCart.shouldHave(text(price));                      // проверка значения поля "Итого к оплате"



   }





}
