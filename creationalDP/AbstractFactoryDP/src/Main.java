public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        UIFactory uiFactory = UIFactory.getThemeFactory("Dark");
        uiFactory.createButton().render();
        uiFactory.createTextField().render();

        uiFactory = UIFactory.getThemeFactory("Light");
        uiFactory.createButton().render();
        uiFactory.createTextField().render();
    }
}


