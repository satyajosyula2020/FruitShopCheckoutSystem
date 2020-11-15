package com.hmrc.shoppingcart

import com.hmrc.shoppingcart.CheckoutService.{checkout => checkoutPrice}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CheckoutServiceSpec extends AnyFlatSpec with Matchers {

  "The service" should "return 0 if nothing in the cart" in {
    val cart = ShoppingCart(List())

    checkoutPrice(cart) should be(0)
  }

  it should "return 0.60 for one Apple" in {
    val cart = ShoppingCart(List(Apple))

    checkoutPrice(cart) should be(0.60)
  }

  it should "return 0.25 for one Orange" in {
    val cart = ShoppingCart(List(Orange))

    checkoutPrice(cart) should be(0.25)
  }

  it should "return 2.05 for 3 apples and one orange" in {
    val cart = ShoppingCart(List(Apple, Apple, Orange, Apple))

    checkoutPrice(cart) should be(2.05)
  }

  it should "return 0.60 for 2 Apples with the offer BuyOneGetOne on Apples" in {
    val cart = ShoppingCart(List(Apple, Apple))
    val offers = Offers(List(BuyOneGetOne(Apple)))

    checkoutPrice(cart, offers) should be(0.60)
  }

  it should "return 0.50 for 3 Oranges with the offer ThreeForTwo on Oranges" in {
    val cart = ShoppingCart(List(Orange, Orange, Orange))
    val offers = Offers(List(ThreeForTwo(Orange)))

    checkoutPrice(cart, offers) should be(0.50)
  }

  it should "return 2.20 for 5 Oranges and 3 Apples with the offers on Apples and Oranges" in {
    val cart = ShoppingCart(List(Orange, Orange, Orange, Orange, Orange, Apple, Apple, Apple))
    val offers = Offers(List(BuyOneGetOne(Apple), ThreeForTwo(Orange)))

    checkoutPrice(cart, offers) should be(2.20)
  }

}
