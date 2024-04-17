# Essential design patterns
Covers essential design patterns handy for building clean test automation framework using Java

## The problem domains
- The Builder Pattern and SLA principle are around a Vet clinic, where you can take your pets to be treated when they are sick. Example activities include visiting the clinic, feeding pets, vaccinating pets
- The Basic Strategy Pattern, and Strategy Pattern with Factories is around a Player who plays different games
- The Strategy Pattern w/ Functions is around a Sales Tax System
- For Strategy Pattern w/ Lambdas and Function Interface, go back to the Vet Clinic again
<br>

## Work is distributed...
..under several branches of the vet-clinic repo, each branch containing some strater code that's refactored and improvised on via the design pattern
Some work is also within the java-for-testers repo
<br> 
<br>
## Builder pattern: 
- WhenWeCreateANewDog.java 
  https://github.com/ashwiniraokarai/vet-clinic/commits/kata/builder/start/
  
- and under
  builderpattern package in java-for-testers repo, master
  https://github.com/ashwiniraokarai/java-for-testers/commits/master/
  
- WhenWeCreateANewDogWithExternalBuilder.java under the dedicated builderpattern package
  https://github.com/ashwiniraokarai/java-for-testers/commits/master/
<br>

## Hamcrest Matchers - for Collections and Lists
https://github.com/ashwiniraokarai/vet-clinic/tree/tutorial-2/start/src/test/java/serenitylabs/tutorials/vetclinic/domain
<br> 
<br>

## Single Level Of Abstraction Principle (SLA)
https://github.com/ashwiniraokarai/vet-clinic/tree/kata/sla/repeat-2

Refactored to "Domain Specific Language"
https://github.com/ashwiniraokarai/vet-clinic/blob/144c92f60774069ddfe5a8af0eae94e4fe036c44/src/main/java/serenitylabs/tutorials/vetclinic/model/FoodDispenser.java#L54
<br> 

## Polymorphism 
### Polymorphism using Inheritance
See test file: WhenCollectingAnimals.java in vet-clinic repo, branch kata/sla/start
https://github.com/serenity-dojo/vet-clinic/blob/d0db6d841dd1b00fdcc269a4679a5e198281e0e3/src/test/java/serenitylabs/tutorials/vetclinic/domain/WhenCollectingAnimals.java

Then: WhenVisitingTheClinic.java in vet-clinic repo, branch kata/sla/start
https://github.com/serenity-dojo/vet-clinic/blob/ea41d30fd52c7c65d235dca0497c0d917b1fcbb2/src/test/java/serenitylabs/tutorials/vetclinic/domain/WhenVisitingTheClinic.java
<br>
<br>

### Polymorphism using Interface
See test file: WhenVaccinatingAnimals.java in vet-clinic repo, branch kata/sla/start
https://github.com/serenity-dojo/vet-clinic/blob/d0db6d841dd1b00fdcc269a4679a5e198281e0e3/src/test/java/serenitylabs/tutorials/vetclinic/domain/WhenVaccinatingAnimals.java
<br> 
<br>

## Strategy Pattern

### Basic strategy pattern
See test file WhenToldToPlayBall in vet-clinic repo, branch kata/strategy-pattern/ start
https://github.com/ashwiniraokarai/vet-clinic/blob/1b3be61e9c5566ae9eb11f15b8a50832b4a8b54d/src/test/java/serenitylabs/tutorials/vetclinic/playingball/WhenToldToPlayBall.java

### Strategy pattern with Factories
See the same branch as before kata/strategy-pattern/start with newer commits
The new file for Factory Class is FetchGame.java
https://github.com/serenity-dojo/vet-clinic/commit/7ac6f5f83b49dcaa4d987f5b5cf4efac34a0da85

### Strategy pattern with Functions
See WhenApplyingSalesTax.java
https://github.com/ashwiniraokarai/vet-clinic/commits/kata/strategy-pattern/step-4-start
See WhenApplyingSalesTaxUsingParameterizedTest.java for parameterized version of this test

### Strategy pattern with Lambdas and Functional Interface
See kata/strategy-pattern/step-4-start in vet-clinic repo
https://github.com/ashwiniraokarai/vet-clinic/commit/06161d6acbf390725943dd3bbb96b3c8358c435d#diff-3b8a66ebc1b784ab3eb9738c003c41d402ec5aa335a16ae3367972200745427e
<br>

##

Walkthro document
https://docs.google.com/document/d/1B24o2XXGGgEr804nR8MfZlX01ZxVWxy0vovqisnT6Og/edit?usp=sharing

Repo originally forked from https://github.com/serenity-dojo/vet-clinic
