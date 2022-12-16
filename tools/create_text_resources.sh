#!/bin/bash

sourceDir=~/Downloads/TranslationStrings/values
sourceFile=${sourceDir}/strings.xml
yourCompanyDir=br/com/progdeelite/kmmprogdeelite/ # replace with your own
resourcePackageDir=br.com.progdeelite.kmmprogdeelite # replace with your own
resourceDir=${yourCompanyDir}resources/
#relativeDestinationDir=../shared/src/commonMain/kotlin/${resourceDir} # on mac / linux
relativeDestinationDir=./shared/src/commonMain/kotlin/${resourceDir} # on windows
relativeDestinationFile=${relativeDestinationDir}/StringResources.kt

# +------------------------------------------- HOW TO USE IT ----------------------------------------------+
#
# 1) https://app.lokalise.com > Tab Download > Select "Android Resources (.xml)" > hit "Build and Download"
# 2) unzip "TranslationStrings.zip" in your Download folder
# 3) make sure strings.xml from Lokalise is located at "Downloads/TranslationStrings/values/strings.xml"
# 4) run the script under tools folder by calling: ./create_text_object.sh
# 5) generated object will be create at "$relativeDestinationDir"
#
# +--------------------------------------------------------------------------------------------------------+

# template for the generated object (HERE DOCUMENT)
# <<- ignores leading tabs in the output
template=$(cat <<-EOF
package ${resourcePackageDir}.resources

/** Generated object! Do not change it manually! Use the script located at \"../tools/generate_text_resources.sh\" instead.*/
object StringResources {
    CONTENT

}
EOF
)

# creates an object to be used in StringResources
function create_text_object() {

    defineSourceDirErrorMsg="Define source file dir and file first."
    defineSourceFileErrorMsg="does not exist."

    # Check source dir exists and is not empty
    [ -d "$sourceDir" ] || { echo "$defineSourceDirErrorMsg" && exit 1; }
    [ -z "$(find "$sourceDir" -prune -empty)" ] || { echo "$defineSourceFileErrorMsg" && exit 1; }

    # create destination if not exists
    mkdir -p "$relativeDestinationDir"

    # Parse strings.xml values
    content=""
    while read -r line;
    do
      result=$(grep -o '=".*">' <<< "$line" | sed 's/=//g' | sed 's/>//g' | sed 's/"//g')
      if test -n "$result"
      then
          content="$content\n    val $result = TextResource(\"$result\")"
      fi
    done < $sourceFile

    # replace the CONTENT of the template
    echo -e "${template/CONTENT/$content}" > "$relativeDestinationFile"

    echo "File created successfully at: $relativeDestinationDir"
}

create_text_object