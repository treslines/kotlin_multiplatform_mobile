#!/bin/sh

# Decrypt Google Services File
# openssl enc -d -aes256 -md sha256 -pbkdf2 -iter 100000 -k $SECRET_FILES_PASSWORD -in androidApp/google-services.json.encrypted -out androidApp/google-services.json
# openssl enc -d -aes256 -md sha256 -pbkdf2 -iter 100000 -k $SECRET_FILES_PASSWORD -in iosApp/your_project_name\ DEV/GoogleService-Info.plist.encrypted -out iosApp/your_project_name\ DEV/GoogleService-Info.plist
# openssl enc -d -aes256 -md sha256 -pbkdf2 -iter 100000 -k $SECRET_FILES_PASSWORD -in iosApp/your_project_name\ INT/GoogleService-Info.plist.encrypted -out iosApp/your_project_name\ INT/GoogleService-Info.plist
# openssl enc -d -aes256 -md sha256 -pbkdf2 -iter 100000 -k $SECRET_FILES_PASSWORD -in iosApp/your_project_name\ PRD/GoogleService-Info.plist.encrypted -out iosApp/your_project_name\ PRD/GoogleService-Info.plist

# Decrypt KeyStore Properties
openssl enc -d -aes256 -md sha256 -pbkdf2 -iter 100000 -k $SECRET_FILES_PASSWORD -in androidApp/src/development/res/keystore.properties.encrypted -out androidApp/src/development/res/keystore.properties
openssl enc -d -aes256 -md sha256 -pbkdf2 -iter 100000 -k $SECRET_FILES_PASSWORD -in androidApp/src/integration/res/keystore.properties.encrypted -out androidApp/src/integration/res/keystore.properties
openssl enc -d -aes256 -md sha256 -pbkdf2 -iter 100000 -k $SECRET_FILES_PASSWORD -in androidApp/src/production/res/keystore.properties.encrypted -out androidApp/src/production/res/keystore.properties

# Decrypt Playstore keystore (jks)
openssl enc -d -aes256 -md sha256 -pbkdf2 -iter 100000 -k $SECRET_FILES_PASSWORD -in androidApp/src/development/res/keystore.jks.encrypted -out androidApp/src/development/res/keystore.jks
openssl enc -d -aes256 -md sha256 -pbkdf2 -iter 100000 -k $SECRET_FILES_PASSWORD -in androidApp/src/integration/res/keystore.jks.encrypted -out androidApp/src/integration/res/keystore.jks
openssl enc -d -aes256 -md sha256 -pbkdf2 -iter 100000 -k $SECRET_FILES_PASSWORD -in androidApp/src/production/res/keystore.jks.encrypted -out androidApp/src/production/res/keystore.jks