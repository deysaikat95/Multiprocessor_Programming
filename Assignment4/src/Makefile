all:
	find . -name "*.java" > sources.txt
	javac @sources.txt
	rm sources.txt

clean:
	find . -name "*.class" -exec rm -rf {} \;
