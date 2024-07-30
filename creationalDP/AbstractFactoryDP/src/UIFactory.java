public interface UIFactory {
    public Button createButton();
    public TextField createTextField();
    public static UIFactory getThemeFactory(String theme){
        switch(theme){
            case "Light":
                return new LightThemeFactory();
            case "Dark":
                return new DarkThemeFactory();
            default:
                throw new IllegalArgumentException("Default Theme is not supported");
        }

    }
}
