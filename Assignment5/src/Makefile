all:
	find . -name "*.java" > sources.txt
	javac -cp ".:/usr/share/java/junit4.jar" -Xlint:unchecked @sources.txt
	rm sources.txt

clean:
	find . -name "*.class" -exec rm -rf {} \;
