package com.hmrc.shoppingcart

trait Offer {
  def discount(items: List[Fruit]): BigDecimal
}

//Offer1: Buy one, get one free on Apple
case class BuyOneGetOne(item: Fruit) extends Offer {
  def discount(items: List[Fruit]): BigDecimal = (items.filter(_ == item).length / 2) * item.price
}

//Offer2: 3 for the price of 2 on Oranges
case class ThreeForTwo(item: Fruit) extends Offer {
  def discount(items: List[Fruit]): BigDecimal = (items.filter(_ == item).length / 3) * item.price
}

