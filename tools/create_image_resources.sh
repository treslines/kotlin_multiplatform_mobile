#!/bin/bash

sourceDir=~/Downloads/Assets/android
yourCompanyDir=br/com/progdeelite/kmmprogdeelite/ # replace with your own
resourcePackageDir=br.com.progdeelite.kmmprogdeelite # replace with your own
resourceDir=${yourCompanyDir}resources/
# relativeDestinationDir=../shared/src/commonMain/kotlin/${resourceDir} // on mac / linux
relativeDestinationDir=./shared/src/commonMain/kotlin/${resourceDir} # on windows
relativeDestinationFile=${relativeDestinationDir}ImageResources.kt

# +------------------------------------------- HOW TO USE IT ----------------------------------------------+
#
# 1) run script convert_assets.sh first
# 2) create an initial empty object called ImageResources.kt in relativeDestinationDir
# 3) make sure "~Downloads/Assets/android" exits after running "convert_assets.sh"
# 4) run script from tools folder: ./create_image_resources.sh
# 5) generated object will be create at "$relativeDestinationDir"
#
# +--------------------------------------------------------------------------------------------------------+


# template for the generated object (CONTENT)
# <<- ignores leading tabs in the output
template=$(cat <<-EOF
package ${resourcePackageDir}.resources

/** Generated object! Do not change it manually! Use the script located at \"../tools/create_image_resources.sh\" instead. */
object ImageResources {
   CONTENT

}
EOF
)

# creates an object to be used by in ImageResources
function create_images_object() {

    defineSourceDirErrorMsg="Source dir ($sourceDir) does not exist. Run script ./convert_assets.sh first."
    defineSourceFileErrorMsg="Source dir ($sourceDir) is empty. Run script ./convert_assets.sh first."

    # Check source dir exists and is not empty
    [ -d "$sourceDir" ] || { echo "$defineSourceDirErrorMsg" && exit 1; }
    [ -z "$(find "$sourceDir" -prune -empty)" ] || { echo "$defineSourceFileErrorMsg" && exit 1; }

    # create destination if not exists
    mkdir -p "$relativeDestinationDir"

    # Parse image names
    content=""
    for file in "$sourceDir"/*.*; do
        # get filename without extension
        filename=$(basename "$file")
        filename="${filename%.*}"

        content="$content\n    val $filename = ImageResource(\"$filename\")"
    done

    # replace the CONTENT of the template
    echo -e "${template/CONTENT/$content}" > "$relativeDestinationFile"

    echo "File created successfully at: $relativeDestinationDir"
}

create_images_object