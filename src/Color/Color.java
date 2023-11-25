package Color;

public class Color {

    public static final int BLACK = 30;
    public static final int RED = 31;
    public static final int GREEN = 32;
    public static final int YELLOW = 33;
    public static final int BLUE = 34;
    public static final int PURPLE = 35;
    public static final int CYAN = 36;
    public static final int WHITE = 37;


    private static final String RESET = "\u001B[0m";

    public static void PrintLn(String content, int foreground, int background) {

        String foregroundStr = GetAnsiCode(foreground, false);

        String backgroundStr = GetAnsiCode(background, true);

        System.out.println(backgroundStr + foregroundStr + content + RESET);

    }

    public static void PrintLn(String content, int foreground) {

        String foregroundStr = GetAnsiCode(foreground, false);

        System.out.println(foregroundStr + content + RESET);

    }

    public static void Print(String content, int foreground, int background) {

        String foregroundStr = GetAnsiCode(foreground, false);

        String backgroundStr = GetAnsiCode(background, true);

        System.out.print(backgroundStr + foregroundStr + content + RESET);

    }

    public static void Print(String content, int foreground) {

        String foregroundStr = GetAnsiCode(foreground, false);

        System.out.print(foregroundStr + content + RESET);

    }

    private static String GetAnsiCode(int color, boolean isBackground) {

        int colorNum = isBackground ? color + 10 : color;

        return "\u001B[" + colorNum + "m";
    }
}
