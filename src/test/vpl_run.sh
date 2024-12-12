#!/bin/bash
#load common script and check programs

echo "Preparando execução da prática de programação. "

. common_script.sh
check_program javac
check_program java
get_source_files java

#compile all .java files

export CLASSPATH=$CLASSPATH:/usr/share/java/junit4.jar

echo "  Compilando o seu programa. Preste atenção às mensagens seguintes:"
SOURCE_FILES=$(ls *.java 2> /dev/null)
TEST_FILES=$(ls Test*.java 2> /dev/null)
CANCIAN_FILES=$(ls *Cancian*.java 2> /dev/null)
for SOURCE in $SOURCE_FILES
do
    if [[ $SOURCE != Test* ]]; 
    then
        if [[ $SOURCE != *Cancian* ]]; 
        then
            echo "    Compilando o arquivo "$SOURCE"..."
            javac -J-Xmx16m -Xlint:deprecation -g $SOURCE
        fi
    fi
done  

echo "  Compilando arquivos de gabarito do professor:"
for SOURCE in $CANCIAN_FILES
do
    echo "    Compilando o arquivo "$SOURCE"..."
    javac -J-Xmx16m -Xlint:deprecation -g $SOURCE
done  

echo "  Compilando framework de teste do professor:"
for SOURCE in $TEST_FILES
do
    echo "    Compilando o arquivo "$SOURCE"..."
    javac -J-Xmx16m -Xlint:deprecation -g $SOURCE
done  


if [ "$?" -ne "0" ] ; then
  echo "Not compiled"
  exit 0
fi

echo "  Criando o ambiente de execução..."
cat common_script.sh > vpl_execution
#echo "java -enableassertions -cp $CLASSPATH:/usr/share/java/junit4.jar org.junit.runner.JUnitCore Main" >> vpl_execution
echo "java -enableassertions -cp $CLASSPATH:/usr/share/java/junit4.jar  TestMain" >> vpl_execution
chmod +x vpl_execution