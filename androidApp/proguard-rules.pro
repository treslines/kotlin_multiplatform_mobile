# Add project specific ProGuard rules here.
# https://developer.android.com/studio/build/shrink-code

# Enable this while debugging
#-keepnames class **

-dontwarn org.bouncycastle.jsse.BCSSLParameters
-dontwarn org.bouncycastle.jsse.BCSSLSocket
-dontwarn org.bouncycastle.jsse.provider.BouncyCastleJsseProvider
-dontwarn org.conscrypt.Conscrypt$Version
-dontwarn org.conscrypt.Conscrypt
-dontwarn org.conscrypt.ConscryptHostnameVerifier
-dontwarn org.openjsse.javax.net.ssl.SSLParameters
-dontwarn org.openjsse.javax.net.ssl.SSLSocket
-dontwarn org.openjsse.net.ssl.OpenJSSE
-dontwarn org.slf4j.impl.StaticLoggerBinder

# https://developer.android.com/studio/build/shrink-code#usage
# -printusage "~/temp/r8_usage.txt"
# -printconfiguration "~/temp/r8_config.txt"


# -keepattributes LineNumberTable,SourceFile
# -renamesourcefileattribute SourceFile

# -keep class com.seu_pacote_projeto.** { *; }