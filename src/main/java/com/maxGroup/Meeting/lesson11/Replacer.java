package com.maxGroup.Meeting.lesson11;

public class Replacer {
    private IRead reader;
    private IPrint printer;

    public Replacer(IRead reader, IPrint printer) {
        this.reader = reader;
        this.printer = printer;
    }

    public void replace(){
        String readLine = reader.read();
        String repLine = readLine.replace("a", "w");
        printer.print(repLine);
    }

    public static void main(String[] args) {
        IRead reader = new ConsoleRead();
        IPrint printer = new ConsolePrint();
        Replacer replacer = new Replacer(reader,printer);
        replacer.replace();
    }
}
