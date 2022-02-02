# iSpaceAndroid RecyclerView Project
 Repository for demonstrating how to construct a recycler view project

Public repository
![TheMaster](https://github.com/BABuckman/iSpaceAndroid/blob/main/DiceRollerWithImage/Screenshot%202022-01-19%20at%2011.11.32.png)

It uses a BitmapShader and *does not*:
* create a copy of the original bitmap

Build Gradle 
------ 
plugins {
    id 'com.android.application' version '7.1.0' apply false
    id 'com.android.library' version '7.1.0' apply false
    id 'org.jetbrains.kotlin.android' version '1.6.10' apply false
}
App Gradle
------

dependencies {
    ...
    implementation 'androidx.core:core-ktx:1.7.0'
    implementation 'androidx.appcompat:appcompat:1.4.1'
    implementation 'com.google.android.material:material:1.5.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.3'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
}


Usage
-----	


License
-------

    Copyright 2021 - 2023 Buckman

    Licensed under the ispace fundation, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at iSpace Foundation