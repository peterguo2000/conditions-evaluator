# conditions-evaluator
This is a JAVA8 JAR for logical conditions evaluation.

Procedure to import the JAR into Gradle projects:
Step 1: in build.gradle file:
repositories {
    ...
    maven { url "https://jitpack.io" }
}
...
dependencies {
    ...
    compile 'com.github.peterguo2000:conditions-evaluator:1.0.1-RELEASE'
}

Step 2: in project root, run ./gradlew build.
Step 3: in IDE (e.g. STS), right click the project and run gradle update.
Step 4. import com.conditionsevaluator.ConditionsEvaluator and call its API.

