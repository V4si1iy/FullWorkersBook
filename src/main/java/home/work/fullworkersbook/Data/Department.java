package home.work.fullworkersbook.Data;

public enum Department {

    JAVADEVELOP,
    ANALYST,
    FULLSTACKDEVELOP,
    PYTHONDEVELOP,
    DESIGNER;

    public static String nameList() {
        String nameList = "";
        for (Department organized : values()) {
            nameList += organized.name() + ", ";
        }
        return nameList.substring(0, nameList.length() - 2);
    }
}
