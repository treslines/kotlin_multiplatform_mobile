#!/bin/sh

# PRE-REQUISITO:
# COMO CRIAR BUILD TYPES EM KMM - https://www.youtube.com/watch?v=Wa3YaWRPlh8

# STEPS
# 1) check if openssl is installed already by running this command on your terminal:
#   - openssl version -> it should output something like this on mac LibreSSL x.x.x (ex: 2.8.3) or OpenSSL x.x.x on windows
# 1.1) otherwise install it by running(on mac): brew install openssl@3 (for windows: https://stackoverflow.com/questions/50625283/how-to-install-openssl-in-windows-10)
#   - (if brew is not installed see: https://mac.install.guide/homebrew/3.html)
# 2) update your .gitignore first
# 3) create your keystore.properties file
# 4) create a folder called tools > create to file decrypt_secrets.sh and encrypt_secrets.sh
# 5) on your terminal locate tools and run:
#   - chmod +x decrypt_secrets.sh (make it executable)
#   - chmod +x encrypt_secrets.sh (make it executable)
# 6) install Shellcheck on your IDE to check shall script when asked by android studio
# 7) create your decrypt/encrypt content
# 8) either pass or $SECRET_FILES_PASSWORD as a parameter to this script or store it locally in your .bashrc or .zshrc
#   8.1) if you don't have it, create one by running this command in your terminal:
#     - move to your user directory
#       - in your terminal type > cd ~
#       - type > pwd > you should see something like this on windows: /c/Users/your_name
#     - touch .bash_profile > copy this inside of it
#         test -f ~/.profile && . ~/.profile
#         test -f ~/.bashrc && . ~/.bashrc
#     - touch .bashrc or touch .zshrc
#         create an entry like this: export SECRET_FILES_PASSWORD=your_pass_word_only_your_company_knows > save it
#     - close and re-open your terminal or run > source .bashrc (to make it available to the terminal)
#     - run in terminal > printenv > to see if your key is available
# 9) run this script to encrypt your keys locally like this:
#     - in your terminal type > ./tools/encrypt_secrets.sh
#     - a file keystore.properties.encrypted should be generated
#
# EXTRA - openssl commando details
#   - https://askubuntu.com/questions/1093591/how-should-i-change-encryption-according-to-warning-deprecated-key-derivat
#
# Main advantages:
#   - all keys are stored in its corresponding project securely
#   - by checking out the repo, every developer has everything needed to run the project
#   - more flexibility while developing, maintaining and testing the project locally
#   - no dependency to managers or build agent owners, less bureaucracy
#   - commonly used in private repositories
# Disadvantages:
#   - a malicious developer could leak the keys (make sure developers have encrypted disks)
#

# Encrypt Google Services File
# openssl enc -aes256 -md sha256 -pbkdf2 -iter 100000 -salt -k $SECRET_FILES_PASSWORD -in androidApp/google-services.json -out androidApp/google-services.json.encrypted
# openssl enc -aes256 -md sha256 -pbkdf2 -iter 100000 -salt -k $SECRET_FILES_PASSWORD -in iosApp/your_project_name\ DEV/GoogleService-Info.plist -out iosApp/your_project_name\ DEV/GoogleService-Info.plist.encrypted
# openssl enc -aes256 -md sha256 -pbkdf2 -iter 100000 -salt -k $SECRET_FILES_PASSWORD -in iosApp/your_project_name\ INT/GoogleService-Info.plist -out iosApp/your_project_name\ INT/GoogleService-Info.plist.encrypted
# openssl enc -aes256 -md sha256 -pbkdf2 -iter 100000 -salt -k $SECRET_FILES_PASSWORD -in iosApp/your_project_name\ PRD/GoogleService-Info.plist -out iosApp/your_project_name\ PRD/GoogleService-Info.plist.encrypted

# Encrypt KeyStore Properties
openssl enc -aes256 -md sha256 -pbkdf2 -iter 100000 -salt -k $SECRET_FILES_PASSWORD -in androidApp/src/development/res/keystore.properties -out androidApp/src/development/res/keystore.properties.encrypted
openssl enc -aes256 -md sha256 -pbkdf2 -iter 100000 -salt -k $SECRET_FILES_PASSWORD -in androidApp/src/integration/res/keystore.properties -out androidApp/src/integration/res/keystore.properties.encrypted
openssl enc -aes256 -md sha256 -pbkdf2 -iter 100000 -salt -k $SECRET_FILES_PASSWORD -in androidApp/src/production/res/keystore.properties -out androidApp/src/production/res/keystore.properties.encrypted

# Encrypt Playstore Keystore (jks)
openssl enc -aes256 -md sha256 -pbkdf2 -iter 100000 -salt -k $SECRET_FILES_PASSWORD -in androidApp/src/development/res/keystore.jks -out androidApp/src/development/res/keystore.jks.encrypted
openssl enc -aes256 -md sha256 -pbkdf2 -iter 100000 -salt -k $SECRET_FILES_PASSWORD -in androidApp/src/integration/res/keystore.jks -out androidApp/src/integration/res/keystore.jks.encrypted
openssl enc -aes256 -md sha256 -pbkdf2 -iter 100000 -salt -k $SECRET_FILES_PASSWORD -in androidApp/src/production/res/keystore.jks -out androidApp/src/production/res/keystore.jks.encrypted