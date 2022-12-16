#!/bin/bash

# 1) download assets from Figma/Zepplin into the Downloads folder (iOS: .pdf / Android: .svg)
# 2) run script from tools folder: ./convert_assets
# 3) final files are found in folders: /Downloads/Assets/[iOS|android] (iOS and android respectively)

source=~/Downloads/Assets

# apply naming conventions and save new file in output
# param1 ($1): file to process
# param2 ($2): output folder
function rename_asset {

    # cut -d'/' -f6-                               ==> remove leading $source folders from path
    # tr "/-. " "_"                                ==> replace all "/", "-", "." and " " with "_" in path
    # sed 's/\(.*\)_/\1./'                         ==> replace last "_" with "." (proper file extension)
    # tr "[:upper:]" "[:lower:]"                   ==> to lower case
    # xargs -I@ cp $f ${target}/@.                 ==> copy file into $target folder with new name

    echo "$1" | cut -d'/' -f6- | tr -s "\\/\\-\\. " "_" | sed 's/\(.*\)_/\1./' | tr "[:upper:]" "[:lower:]" | xargs -I@ cp "$1" "$2"/@;
}


# Android
target=${source}/android  # ==> define output folder for android
mkdir -p ${target}        # ==> create android output folder if not exists already

# process all .svg files including whitespaces in name
find ${source} -name "*.svg" ! -path "${target}/*" -print0 | while read -r -d '' file
do
  rename_asset "${file}" "${target}"
done
echo "android finished: see ${target}"


# iOS
target=${source}/ios      # ==> define output folder for android
mkdir -p ${target}        # ==> create android output folder if not exists already

# process all .pdf files including whitespaces in name
find ${source} -name "*.pdf" ! -path "${target}/*" -print0 | while read -r -d '' file
do
  rename_asset "${file}" "${target}"
done
echo "ios finished: see ${target}"