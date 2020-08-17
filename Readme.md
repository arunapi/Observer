# Observer

This is a sample application that implements `Observer` design pattern from the [GoF book](https://www.amazon.com/gp/product/0201633612/ref=as_li_tl)

## Observer Design Pattern

```Define a one to many relationship between objects, so that when one object changes state all its dependents are notified```

The key objects in this pattern are `Subject` and `Observer`

In this example application the Subject is a `FoodTruck` and Observer is a `Customer`

At a carnival you will see a number of food trucks and people hanging around order food and picking them up whenever their names are called.
I am using this as an example to demo the Observer pattern.

Customer places an order at the FoodTruck. [See the test](../master/src/test/java/com/arunapi/observer/FoodTruckTest.java)

When the food is ready FoodTruck notifies the customers. [See the test](../master/src/test/java/com/arunapi/observer/FoodTruckTest.java)

### Change Manager

A cashier at the food truck can act as a `Change Manager`, which implements the `Mediator` design pattern.
The purpose of ChangeManager is to encapsulate the complexities of managing observers.


### Aspect

When the pizza is ready, FoodTruck need to notify only the customers who has ordered Pizza. [See the test](../master/src/test/java/com/arunapi/observer/FoodTruckTest.java)
You can use an Aspect, when an observer attach itself to the Subject.
Subject will notify when the observers based on the aspect.
Alternatively this complexity can be encapsulated in the `ChangeManager`
