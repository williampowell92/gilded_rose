[Motivation](#motivation) | [Specification](#specification) | [Approach](#approach) | [Features](#features) | [Installation](#installation) | [How to use?](#how-to-use) | [Tests](#tests) | [Further work](#further-work) | [Technologies](#technologies)

# Gilded Rose Tech Test

An application for managing a mystical shops inventory.

### Motivation

This project has been created as part of my journey as a junior developer at Makers Academy.

### Specification

#### Requirements

This tech test is based on Terry Hughes' which can be found [here](https://github.com/NotMyself/GildedRose). This was translated into Java by Emily Bache, the translated version can be found [here](https://github.com/emilybache/GildedRose-Refactoring-Kata).

* All items have a SellIn value which denotes the number of days to sell the item.
* All items have a Quality value which denotes how valuable the item is.
* At the end of each day SellIn and Quality are reduced by one.
* Once the sell by date has passed, Quality degrades twice as fast.
* The Quality of an item is never negative.
* "Aged Brie" increases in Quality the older it gets, rather than decreasing.
* The Quality of an item is never more than 50.
* "Sulfuras", a legendary item, SellIn and Quality values never change.
* "Backstage passes", like "Aged Brie", increase in Quality as it's SellIn approaches, as follows:
  * More than 10 days from the show, increases by one per day.
  * 10 or less days from the show, increases by two per day.
  * 5 or less days from the show, increases by three per day.
  * Reduces to zero after the show.
* "Conjured Items" degrade in Quality twice as fast as normal items.

#### Acceptance Criteria

* Given the legacy code refactor it in such a way that adding the "Conjured Item" is easy.
* The aim is to practice good design.
* Anything may be changed apart from the "Item" class.

### Approach

![class diagram](https://i.imgur.com/QrIEavz.png)

The class diagram above was created at the start of the project to give an overarching plan. A suite of feature tests was developed as a first step to ensure that the functionality of the program did not change through the refactoring process. A test driven approach was then followed in the creation of the new item types. Once these were completed, the old functionality was switched out for the new functionality before deleting the old functionality. The new design was then tested against the old feature tests to ensure the program still worked in the desired way.

Once the above had been completed, a new item type "Conjured Item" was created to add the additional functionality.

### Installation

This application has been designed to be built with Maven to simplify the build process and
include all necessary dependencies. If you do not have Maven installed it is recommended you
do so by following the guidelines [here](http://maven.apache.org/). To get started please follow the
subsequent steps.

* Clone the repository ```$ git clone https://github.com/williampowell92/gilded_rose```
* Navigate to the top level of the directory using the command line  ```$ cd <repo name>```

### How to use?

The app does not have a command line interface so the source code must be changed between runs to alter the output.

An example use of the application can be found in the TexttestFixture.java file.

![TexttestFixture](https://i.imgur.com/0N2ieBM.png)

Once you are ready to run the app then:
* Compile the app ```$ mvn package```
* Run the app ```$ java -cp target/gilded-rose-kata-0.0.1-SNAPSHOT.jar com.gildedrose.Features.TexttestFixture.java```

If you are using an IDE such as Intellij then you can open the repository in the IDE and use the
inbuilt run commands.


### Tests

Testing was carried out using the Jasmine Node.js module. It will be downloaded when the program is installed. Tests can be run from the project home directory as follows:

```
node node_modules/jasmine/bin/jasmine
```

### Further work

- Errors for checking if the client withdraws below 0 balance.
- Overdraft limits allowing the client to withdraw a certain amount below 0 balance.
- Filtering of transaction history by date.

### Technologies

This application was built using Javascript, Node.js and Jasmine.
