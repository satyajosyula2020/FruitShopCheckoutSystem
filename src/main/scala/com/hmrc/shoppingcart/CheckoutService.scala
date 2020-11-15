package com.hmrc.shoppingcart

object CheckoutService {

  def checkout(cart: ShoppingCart): BigDecimal = {
    cart.fruits.map(_.price).sum
  }

  def checkout(cart: ShoppingCart, offers: Offers): BigDecimal = {
    offers.offers.foldLeft(checkout(cart)) { (x, y) => x - y.discount(cart.fruits) }
  }
}

case class ShoppingCart(fruits: List[Fruit])

case class Offers(offers: List[Offer])