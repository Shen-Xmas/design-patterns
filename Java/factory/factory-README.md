Scenario: Message needs to be carried out, and there are many ways of message notification.

<br />

The factory pattern includes the following core roles:

- Abstract Product: Defines the common interface or abstract class of products. 
It can be the parent class or interface of a specific product class, 
which specifies the common methods of product objects.
- Concrete Product: specific products which implemented and defines the specific behaviors and attributes.
- Abstract Factory: Declares an abstract method to create a product, which can be an interface or an abstract class. 
It can have multiple methods for creating different types of products.
- Concrete Factory: Implements the abstract factory interface, 
which is responsible for actually creating objects of specific products.

<br />
<br />
<br />
<br />

场景: 需要进行消息通知, 而消息通知有多种方式。

<br />

工厂模式包含以下几个核心角色：

- 抽象产品（Abstract Product）：定义了产品的共同接口或抽象类。它可以是具体产品类的父类或接口，规定了产品对象的共同方法。
- 具体产品（Concrete Product）：实现了抽象产品接口，定义了具体产品的特定行为和属性。
- 抽象工厂（Abstract Factory）：声明了创建产品的抽象方法，可以是接口或抽象类。它可以有多个方法用于创建不同类型的产品。
- 具体工厂（Concrete Factory）：实现了抽象工厂接口，负责实际创建具体产品的对象。