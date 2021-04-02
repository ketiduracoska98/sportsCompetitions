JFLAGS = -g
JC = javac
JVM=java
.SUFFIXES: .java .class
build:
	$(JC) $(JFLAGS) *.java
run:
	$(JVM) Main $(COMANDA) $(IN1) $(IN2) $(OUT)
clean:
	$(RM) *.class
