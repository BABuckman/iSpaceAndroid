# iSpaceAndroid RecyclerView Project
 Repository for demonstrating how to construct a recycler view project

Public repository
![TheMaster](https://github.com/BABuckman/iSpaceAndroid/blob/main/CustomAdapterApplication/Screenshot%202022-02-02%20at%2015.58.42.png)

Project uses a *Glide*
You can use gradle: 
repositories {
  google()
  mavenCentral()
}

dependencies {
  implementation 'com.github.bumptech.glide:glide:4.12.0'
  annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'
}

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