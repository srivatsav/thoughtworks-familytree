## CLASSES

1) ```Person.java``` - This is an entity of every person in a family. This contains all the relations of a Person.

2) ```Family.java``` - This is an entity of every Family. This contains all the information of a family. All the operations to modify a family are contained in this.

3) ```FamilyTreeBuilder.java``` - This  is the main entry point of the application. This first constructs the Family Tree of persons provided with given data.

## ASSUMPTIONS

1) Only two Genders are considered - Male, Female
2) Assuming that a child can be added to a single mother.

## PACKAGING

```mvn package``` generates an executable jar with name geektrust.jar

## INPUT FILE LOCATION

For convenience the location of input file is in the classpath i.e test-data/input.txt.

```java -jar target/geektrust.jar ./test-data/input.txt``` will execute the jar by reading the input from the input file.

## SAMPLE INPUT

```
GET_RELATIONSHIP Laki Maternal-Uncle
GET_RELATIONSHIP Yodhan Maternal-Aunt
ADD_CHILD Chitra Aria Female
```

## SMAPLE OUTPUT

```
Ahit 
Tritha 
CHILD_ADDITION_SUCCEEDED
```
