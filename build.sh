#!/bin/bash

TARGET="target"
VERSION=$(cat VERSION)
RELEASE="tunkki-release-$VERSION"

echo "=== $RELEASE BUILD SCRIPT ==="
echo ""
echo "Building project with maven..."

# Run build
mvn clean compile assembly:single

MAVEN_SUCCESS=$?
if [ $MAVEN_SUCCESS -ne 0 ]; then
    echo "Maven build failed. Aborting..."
    exit 1
fi

echo "Maven build done."
echo "Starting creating package..."

cd "$TARGET"
JARNAME=$(find . -name tunkki*dependencies.jar)

echo "JAR file: $JARNAME"

echo "Creating directories..."
mkdir "$RELEASE" 2>/dev/null
mkdir "$RELEASE/share"
mkdir "$RELEASE/bin"

echo "Copying JAR to installation directory..."
cp "$JARNAME" "$RELEASE/share/tunkki.jar"
cp "../VERSION" "$RELEASE/share/"
cd "$RELEASE"

echo "Creating launcher script..."
echo "#!/bin/bash" > "bin/tunkki"
echo 'DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"' >> "bin/tunkki"
echo 'cd $DIR/../share' >> "bin/tunkki"
echo 'java -jar tunkki.jar $@' >> "bin/tunkki"

chmod +x "bin/tunkki"

# Create tarball
TARBALL="$RELEASE.tar.gz"
cd ..
echo "Creating tarball..."
tar zcvf "$TARBALL" "$RELEASE"

echo "Done."
echo "Installation directory: $TARGET/$RELEASE"
echo "Installation package: $TARGET/$TARBALL"
cd ..
