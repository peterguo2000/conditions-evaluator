# conditions-evaluator
This is a JAVA8 JAR for logical conditions evaluation.

The aim of this lib is to reduce the if-else statements during developmennt by abstractinng conditions to sufficient conditions or necessary conditions. 

Hope it would be helpful in refactoring existing project to make it easy to understand and maintain.

Coding guild:

Please follow below test cases.

https://github.com/peterguo2000/conditions-evaluator/tree/master/conditions-evaluator/src/test/java/com/conditionsevaluator

Procedure to import the JAR into Gradle projects:

(jitpack is a morden tool for open source lib publishing. Go to https://jitpack.io if confused.)

Step 1: in build.gradle file:

repositories {

    ...
    
    maven { url "https://jitpack.io" }
    
}

...

dependencies {

    ...
    
    compile 'com.conditionsevaluator:conditions-evaluator:1.0.3-RELEASE'
//or	compile 'com.github.peterguo2000:conditions-evaluator:1.0.3-RELEASE'
    
}

Step 2: in project root, run ./gradlew build.

Step 3: in IDE (e.g. STS), right click the project and run gradle -> Refresh Gradle Project.

Step 4. import com.conditionsevaluator.ConditionsEvaluator and call its API.

Procedure to import the JAR into Maven projects: TBD.
