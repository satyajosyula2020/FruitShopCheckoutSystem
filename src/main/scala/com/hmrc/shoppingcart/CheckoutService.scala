package com.hmrc.shoppingcart

object CheckoutService {

  def checkOut(cart: ShoppingCart): BigDecimal = {
    cart.fruits.map(_.price).sum
  }
}

case class ShoppingCart(fruits: List[Fruit])
