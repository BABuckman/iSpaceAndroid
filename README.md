# iSpaceAndroid
 Repository for all iSpace Android projects

Public repository
![TheMaster](https://github.com/BABuckman/iSpaceAndroid/blob/main/DiceRollerWithImage/Screenshot%202022-01-19%20at%2011.11.32.png)

It uses a BitmapShader and *does not*:
* create a copy of the original bitmap
* use a clipPath (which is neither hardware accelerated nor anti-aliased)
* use setXfermode to clip the bitmap (which means drawing twice to the canvas)

Gradle
------




Usage
-----	


License
-------

    Copyright 2021 - 2023 Buckman

    Licensed under the ispace fundation, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at iSpace Foundation