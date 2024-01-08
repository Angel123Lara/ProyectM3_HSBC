package lara.pers.ProjectM2.controller.handlers;

public class DbException extends RuntimeException{
    private String fieldName;

    public DbException(String fieldName, String message) {
        super(message);
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return super.getMessage();
    }
}
