create database jshcart;
use jshcart;
CREATE TABLE jshcart.`Admin` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) NOT NULL DEFAULT '',
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
insert into jshcart.Admin(userName,password) values('111','111');
insert into jshcart.Admin(userName,password) values('smita','smita');
insert into jshcart.Admin(userName,password) values('admin','admin');

select * from jshcart.Admin;
CREATE TABLE jshcart.`Customer` (
  `customerId` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL DEFAULT '',
  `password` varchar(20) DEFAULT NULL,
  `customerName` varchar(40) NOT NULL DEFAULT '',
   `customerDob` varchar(20) NOT NULL DEFAULT '',
   `phoneNo` varchar(20) NOT NULL DEFAULT '',
   `address` varchar(65) NOT NULL DEFAULT '',
   `customerEmail` varchar(25) NOT NULL DEFAULT '',
  PRIMARY KEY (`customerId`)
);

drop table jshcart.Customer;
insert into jshcart.Customer(username,password,customerName,customerDob,phoneNo,address,customerEmail) 
values('smita','smita','Smita Kumar','1979/11/11','7045651571','Mumbai','smita@gmail.com');
insert into jshcart.Customer(username,password,customerName,customerDob,phoneNo,address,customerEmail) 
values('111','111','Smita Kumar','1979/11/11','7045651571','Mumbai','smita@gmail.com');
select * from jshcart.Customer;

drop table jshcart.`Category`;
CREATE TABLE jshcart.`Category` (
  `categoryId` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `categoryName` varchar(20) NOT NULL,
  PRIMARY KEY (`categoryId`)
);
insert into jshcart.Category(categoryName) values('New Arrival');
insert into jshcart.Category(categoryName) values('Best Seller');
select * from jshcart.Category;
drop table jshcart.Category;

drop table jshcart.Item;
CREATE TABLE jshcart.`Item` (
  `itemId` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `itemName` varchar(20) NOT NULL DEFAULT '',
  `itemImage` longblob DEFAULT NULL,
  `itemSize` varchar(40) NOT NULL DEFAULT '',
   `itemColour` varchar(20) NOT NULL DEFAULT '',
   `itemPrice` double NOT NULL,
   `itemQuantity` varchar(65) NOT NULL DEFAULT '',
   `itemDescription` varchar(25) NOT NULL DEFAULT '',
   categoryId int references Category(categoryId),
  PRIMARY KEY (`itemId`)

);

drop table jshcart.Item;
insert into jshcart.Item(itemName,itemImage,itemSize,itemColour,itemPrice,itemQuantity,itemDescription,categoryId) 
values('product1','01.jpg','small','black','1700',4,'Reeboks Best','3');
select * from jshcart.Item;
insert into jshcart.Item(itemName,itemImage,itemSize,itemColour,itemPrice,itemQuantity,itemDescription,categoryId) 
values('product2','02.jpg','small','red','8700',4,'Reeboks Best','3');
select * from jshcart.Item;
insert into jshcart.Item(itemName,itemImage,itemSize,itemColour,itemPrice,itemQuantity,itemDescription,categoryId) 
values('product3','03.jpg','small','white','3600',4,'Reeboks Best','3');
insert into jshcart.Item(itemName,itemImage,itemSize,itemColour,itemPrice,itemQuantity,itemDescription,categoryId) 
values('product4','04.jpg','small','red','1900',4,'Reeboks Best','3');
insert into jshcart.Item(itemName,itemImage,itemSize,itemColour,itemPrice,itemQuantity,itemDescription,categoryId) 
values('product5','05.jpg','large','brown','1000',4,'Reeboks Best','3');
insert into jshcart.Item(itemName,itemImage,itemSize,itemColour,itemPrice,itemQuantity,itemDescription,categoryId) 
values('product6','06.jpg','large','brown-white','8000',4,'Reeboks Best','3');
insert into jshcart.Item(itemName,itemImage,itemSize,itemColour,itemPrice,itemQuantity,itemDescription,categoryId) 
values('product7','07.jpg','large','brown','5000',4,'Reeboks Best','3');
insert into jshcart.Item(itemName,itemImage,itemSize,itemColour,itemPrice,itemQuantity,itemDescription,categoryId) 
values('product8','08.jpg','large','multi','2400',4,'Reeboks Best','3');
insert into jshcart.Item(itemName,itemImage,itemSize,itemColour,itemPrice,itemQuantity,itemDescription,categoryId) 
values('product9','09.jpg','medium','teal','1500',4,'Reeboks Best','3');
insert into jshcart.Item(itemName,itemImage,itemSize,itemColour,itemPrice,itemQuantity,itemDescription,categoryId) 
values('product10','10_l.jpg','large','white','2500',4,'Reeboks Best','3');
insert into jshcart.Item(itemName,itemImage,itemSize,itemColour,itemPrice,itemQuantity,itemDescription,categoryId) 
values('product11','10.jpg','small','white','4000',4,'Reeboks Best','3');

select * from jshcart.Item;select * from jshcart.Item;
drop table jshcart.Order;
CREATE TABLE jshcart.`Order` (
  `orderId` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `orderDate` varchar(20) NOT NULL,
  `orderShippingDate` varchar(20),
    `deliveryDate` varchar(20),
      `amountpayable` varchar(20),
        `discount` varchar(20),
        `status` varchar(20),
        `customerId` int(11),
        `itemId` int(11),
          PRIMARY KEY(`orderId`)
  );
  
  
insert into jshcart.Order(orderDate,orderShippingDate,deliveryDate,
amountpayable,discount,status,customerId,itemId) 
values('2015/12/21','2015/12/22','2015/12/22',1200,10,'Pending',1,2);
insert into jshcart.Order(orderDate,orderShippingDate,deliveryDate,
amountpayable,discount,status,customerId,itemId) 
values('2015/12/21','2015/12/22','2015/12/22',124,11,'Done',1,2);
insert into jshcart.Order(orderDate,orderShippingDate,deliveryDate,
amountpayable,discount,status,customerId,itemId) 
values('2015/12/21','2015/12/22','2015/12/22',14520,12,'Pending',1,2);
insert into jshcart.Order(orderDate,orderShippingDate,deliveryDate,
amountpayable,discount,status,customerId,itemId) 
values('2015/12/21','2015/12/22','2015/12/22',450,13,'Done',1,2);
insert into jshcart.Order(orderDate,orderShippingDate,deliveryDate,
amountpayable,discount,status,customerId,itemId) 
values('2015/12/21','2015/12/22','2015/12/22',450,13,'Done',1,2);

select * from jshcart.Order;
drop table jshcart.Order;

drop table jshcart.`Feedback`;
CREATE TABLE jshcart.`Feedback` (
  `customerId` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL DEFAULT '',
  `password` varchar(20) DEFAULT NULL,
  `customerName` varchar(40) NOT NULL DEFAULT '',
   `customerDob` varchar(20) NOT NULL DEFAULT '',
   `phoneNo` varchar(20) NOT NULL DEFAULT '',
   `address` varchar(65) NOT NULL DEFAULT '',
   `customerEmail` varchar(25) NOT NULL DEFAULT '',
  PRIMARY KEY (`customerId`)
);

select * from jshcart.Feedback;
insert into jshcart.Feedback(username,password,customerName,customerDob,phoneNo,address,customerEmail) values('priyam','priyam','Priyam Chauhan','1992/12/12','7045651571','Mumbai','priyam@gmail.com');
drop database jshcart;


drop table jshcart.Contact;
CREATE TABLE jshcart.Contact(
name varchar(30) NOT NULL,
 email varchar(30) NOT NULL ,
  phoneNo varchar(12) NOT NULL
);

insert into jshcart.Contact(name,email,phoneNo) values("Vishakha","vish@gmail.com","7654345678");
select * from jshcart.Order_Details;

CREATE TABLE jshcart.Order_Details(
orderId int(11)NOT NULL,
  itemId int(11) NOT NULL
);
