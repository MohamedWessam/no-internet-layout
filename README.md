# No Internet Layout Library
Library to check internet connection and change layout to no internet layout if there is no internet.

![](https://i.postimg.cc/cJv329Hq/Hnet-image.gif)

**Gradle:**
```
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}

dependencies {
     implementation 'com.github.MohamedWessam:no-internet-layout:0.1.0'
}
```

**Usage:**

*In Kotlin*
```
NoInternetLayout.Builder(activity, R.layout.activity_main) //change activity_main with your layout
```

*In Java*
```
new NoInternetLayout.Builder(activity, R.layout.activity_main); //change activity_main with your layout
```

*All available options*
```
NoInternetLayout.Builder(activity, R.layout.activity_main) //change activity_main with your layout
            .mainTitle("your title") //you can add title as a String or as Int from string.xml
            .secondaryText("your text") //you can add text as a String or as Int from string.xml
            .buttonText("your text")
```

**_Check internet connection only_**

You can check internet connection easly without changing the layout by the help of `isNetworkConnected()` which returns boolean.
```
NetworkChecker.isNetworkConnected(context)
```

**_License_**
```
   Copyright 2019 Mohamed Wessam.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
