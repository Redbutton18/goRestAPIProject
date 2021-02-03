package restAPI.properties;

public enum PropertySource {
    TOKEN_VARIABLE("token.properties");

    public String sourceFile;

    PropertySource(String sourceFile){
        this.sourceFile = sourceFile;
    }
}
