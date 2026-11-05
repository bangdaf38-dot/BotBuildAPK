#!/bin/bash
set -e
mkdir -p build/gen build/classes
aapt2 compile --dir app/src/main/res -o build/res.zip
aapt2 link -o build/app-unsigned.apk -I $ANDROID_HOME/platforms/android-33/android.jar \
  --manifest app/src/main/AndroidManifest.xml --java build/gen \
  --min-sdk-version 21 --target-sdk-version 33 build/res.zip --auto-add-overlay
javac --release 8 -classpath "$ANDROID_HOME/platforms/android-33/android.jar:build/gen" \
  -d build/classes app/src/main/java/com/k/silentpic/*.java build/gen/com/k/silentpic/R.java
cd build
d8 --lib $ANDROID_HOME/platforms/android-33/android.jar --min-api 21 --output ./ $(find classes -name "*.class")
cp app-unsigned.apk app-with-dex.apk
zip -uj app-with-dex.apk classes.dex
zipalign -f -p 4 app-with-dex.apk app-aligned.apk
keytool -genkey -v -keystore mykey.jks -keyalg RSA -keysize 2048 -validity 10000 -alias mykey -storepass 123456 -keypass 123456 -dname "CN=K" > /dev/null 2>&1
apksigner sign --ks mykey.jks --ks-pass pass:123456 --key-pass pass:123456 --out ../silentpic.apk app-aligned.apk
