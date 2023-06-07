compile:
	javac Main.java
execute:
	java Main
clean:
	rm *.class
install:compile
	sudo mkdir /opt/sl
	sudo cp Main.class /opt/sl
	sudo cp sl /usr/bin
run:compile execute clean
