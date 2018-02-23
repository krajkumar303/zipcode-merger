This Zip code parser will parse the range of Zip codes and merge them if there are any over lap. 

**Build**
You can build this program using:

    $ mvn package

**To Run:** 

    java -cp target/zipcode-parser-0.0.1-SNAPSHOT.jar com.raj.sampleprogram.zipcode.ZipCodeAnalyser

**Sample OutPut:** 

    Please input the total number of ZipCode range:
    4

> Please Enter Start ZipCode and End ZipCode Range one per line

    94133
    94133 
    94200
    94299
    94600
    94699
    94670
    94899

Original ZipCode Range

    [94133,94133]
    [94200,94299]
    [94600,94699]
    [94670,94899]

Final ZipCode Range

    [94133,94133]
    [94200,94299]

