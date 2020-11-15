package com.hmrc.shoppingcart

import com.hmrc.shoppingcart.CheckoutService.{checkOut => checkoutPrice}
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

}
